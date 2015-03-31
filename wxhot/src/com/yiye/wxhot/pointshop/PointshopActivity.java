package com.yiye.wxhot.pointshop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yiye.wxhot.util.Netdeal;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PointshopActivity extends Activity
{
  private TextView checkinbtn = null;
  private FrameLayout container;
  private Context ctx = null;
  private Button exchangeBtn = null;
  private Handler handler = new Handler();
  private List<Map<String, Object>> listdata = null;
  private PullToRefreshListView mPullToRefreshListView;
  private Netdeal netdeal = null;
  private ListView pointshoplistview = null;
  private ImageView return1 = null;

  private List<Map<String, Object>> getData()
  {
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    this.netdeal = new Netdeal();
    ArrayList localArrayList2 = new ArrayList();
    String str = this.netdeal.commonGetData(localArrayList2, "/index.php/Api/getPointShop");
    try
    {
      localJSONArray = new JSONObject(str).getJSONArray("product");
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
          ((Map)localObject2).put("productid", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("product_id")));
          ((Map)localObject2).put("product_pic", getHttpBitmap("http://58.215.80.12/Public/Uploads/".concat(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("product_pic"))));
          localArrayList1.add(localObject2);
          HashMap localHashMap2 = new HashMap();
          Integer localInteger2 = Integer.valueOf(1 + ((Integer)localObject1).intValue());
          localObject1 = localInteger2;
          localObject2 = localHashMap2;
          continue;
          localJSONException1 = localJSONException1;
          label253: localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
        Object localObject2;
        break label253;
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
    setContentView(2130903106);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.return1 = ((ImageView)findViewById(2131034270));
    this.checkinbtn.setText("猫粮兑换");
    this.return1.setVisibility(8);
    this.mPullToRefreshListView = ((PullToRefreshListView)findViewById(2131034245));
    this.pointshoplistview = ((ListView)this.mPullToRefreshListView.getRefreshableView());
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          PointshopActivity.this.listdata = PointshopActivity.this.getData();
          PointshopActivity localPointshopActivity = PointshopActivity.this;
          List localList = PointshopActivity.this.listdata;
          String[] arrayOfString = new String[4];
          arrayOfString[0] = "product_title";
          arrayOfString[1] = "product_pic";
          arrayOfString[2] = "price";
          arrayOfString[3] = "productid";
          int[] arrayOfInt = new int[4];
          arrayOfInt[0] = 2131034248;
          arrayOfInt[1] = 2131034246;
          arrayOfInt[2] = 2131034250;
          arrayOfInt[3] = 2131034251;
          SimpleAdapter localSimpleAdapter = new SimpleAdapter(localPointshopActivity, localList, 2130903108, arrayOfString, arrayOfInt);
          localSimpleAdapter.setViewBinder(new CustomViewBinder());
          PointshopActivity.this.updateList(localSimpleAdapter);
          return;
        }
        catch (Exception localException)
        {
          while (true)
            localException.printStackTrace();
        }
      }
    }).start();
  }

  public void updateList(final SimpleAdapter paramSimpleAdapter)
  {
    this.handler.post(new Runnable()
    {
      public void run()
      {
        PointshopActivity.this.pointshoplistview.setAdapter(paramSimpleAdapter);
        PointshopActivity.this.pointshoplistview.setOnItemClickListener(new PointshopActivity.2.1(this));
        PointshopActivity.this.mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        PointshopActivity.this.mPullToRefreshListView.setOnRefreshListener(new PointshopActivity.2.2(this));
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
      PointshopActivity.this.mPullToRefreshListView.onRefreshComplete();
      super.onPostExecute(paramArrayOfString);
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.pointshop.PointshopActivity
 * JD-Core Version:    0.6.2
 */