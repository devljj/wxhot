package com.yiye.wxhot.member;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yiye.wxhot.pointshop.CustomViewBinder;
import com.yiye.wxhot.pointshop.PointshopDetailActivity;
import com.yiye.wxhot.util.Netdeal;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CostlistActivity extends Activity
{
  private TextView checkinbtn = null;
  private FrameLayout container;
  private List<Map<String, Object>> listdata = null;
  private PullToRefreshListView mPullToRefreshListView;
  private Netdeal netdeal = null;
  private ListView pointshoplistview = null;
  private LinearLayout topwrap = null;

  private List<Map<String, Object>> getData()
  {
    String str1 = getSharedPreferences("WuxihotDB", 0).getString("USERNAME", "");
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    this.netdeal = new Netdeal();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new BasicNameValuePair("username", str1));
    String str2 = this.netdeal.commonGetData(localArrayList2, "/index.php/Api/getCostlist");
    try
    {
      localJSONArray = new JSONObject(str2).getJSONArray("costlist");
      Integer localInteger1 = Integer.valueOf(0);
      localObject1 = localInteger1;
      localObject2 = localHashMap1;
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        JSONArray localJSONArray;
        Object localObject1;
        while (((Integer)localObject1).intValue() < localJSONArray.length())
        {
          ((Map)localObject2).put("product_title", localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("product_title"));
          ((Map)localObject2).put("price", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("catFoodNums")));
          ((Map)localObject2).put("consumeTime", localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("consumeTime"));
          ((Map)localObject2).put("productid", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("product_id")));
          localArrayList1.add(localObject2);
          HashMap localHashMap2 = new HashMap();
          Integer localInteger2 = Integer.valueOf(1 + ((Integer)localObject1).intValue());
          localObject1 = localInteger2;
          localObject2 = localHashMap2;
          continue;
          localJSONException1 = localJSONException1;
          label281: localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
        Object localObject2;
        break label281;
      }
    }
    return localArrayList1;
  }

  public Bitmap getBitmap(String paramString)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(new URL(paramString).openStream());
      localObject = localBitmap;
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public Bitmap getHttpBitmap(String paramString)
  {
    Bitmap localBitmap = null;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.connect();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      Log.i("TAG", "*********inputstream**" + localInputStream);
      localBitmap = BitmapFactory.decodeStream(localInputStream);
      Log.i("TAG", "*********bitmap****" + localBitmap);
      localInputStream.close();
      localHttpURLConnection.disconnect();
      return localBitmap;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903078);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText(2131165311);
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.topwrap.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CostlistActivity.this.finish();
      }
    });
    this.listdata = getData();
    List localList = this.listdata;
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "product_title";
    arrayOfString[1] = "consumeTime";
    arrayOfString[2] = "price";
    arrayOfString[3] = "productid";
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = 2131034280;
    arrayOfInt[1] = 2131034284;
    arrayOfInt[2] = 2131034283;
    arrayOfInt[3] = 2131034251;
    SimpleAdapter localSimpleAdapter = new SimpleAdapter(this, localList, 2130903079, arrayOfString, arrayOfInt);
    localSimpleAdapter.setViewBinder(new CustomViewBinder());
    this.mPullToRefreshListView = ((PullToRefreshListView)findViewById(2131034245));
    this.pointshoplistview = ((ListView)this.mPullToRefreshListView.getRefreshableView());
    this.pointshoplistview.setAdapter(localSimpleAdapter);
    this.pointshoplistview.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        Intent localIntent = new Intent(CostlistActivity.this, PointshopDetailActivity.class);
        localIntent.putExtra("productid", Integer.valueOf(Integer.parseInt(((Map)CostlistActivity.this.listdata.get(paramAnonymousInt)).get("productid").toString())));
        localIntent.addFlags(67108864);
        CostlistActivity.this.startActivity(localIntent);
      }
    });
    this.mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
    this.mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener()
    {
      public void onRefresh(PullToRefreshBase<ListView> paramAnonymousPullToRefreshBase)
      {
        new CostlistActivity.GetDataTask(CostlistActivity.this, null).execute(new Void[0]);
      }
    });
  }

  private class GetDataTask extends AsyncTask<Void, Void, String[]>
  {
    private GetDataTask()
    {
    }

    protected String[] doInBackground(Void[] paramArrayOfVoid)
    {
      return null;
    }

    protected void onPostExecute(String[] paramArrayOfString)
    {
      CostlistActivity.this.mPullToRefreshListView.onRefreshComplete();
      super.onPostExecute(paramArrayOfString);
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.CostlistActivity
 * JD-Core Version:    0.6.2
 */