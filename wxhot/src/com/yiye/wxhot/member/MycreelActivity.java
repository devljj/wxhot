package com.yiye.wxhot.member;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yiye.wxhot.util.Common;
import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MycreelActivity extends Activity
{
  private TextView checkinbtn = null;
  private FrameLayout container;
  private Handler handler = new Handler();
  private List<Map<String, Object>> listdata;
  private PullToRefreshListView mPullToRefreshListView;
  private Netdeal netdeal;
  private ListView pointshoplistview = null;
  private LinearLayout topwrap = null;

  private List<Map<String, Object>> getData()
  {
    ArrayList localArrayList1 = new ArrayList();
    String str1 = getSharedPreferences("WuxihotDB", 0).getString("USERNAME", "");
    HashMap localHashMap1 = new HashMap();
    this.netdeal = new Netdeal();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new BasicNameValuePair("member_name", str1));
    String str2 = this.netdeal.commonGetData(localArrayList2, "/index.php/Api/getCreelList");
    try
    {
      localJSONArray = new JSONObject(str2).getJSONArray("creellist");
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
          ((Map)localObject2).put("activity_title", localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("activity_title"));
          ((Map)localObject2).put("price", Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("price")));
          ((Map)localObject2).put("activity_id", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("activity_id")));
          ((Map)localObject2).put("buyTime", localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("buyTime"));
          ((Map)localObject2).put("couponcode", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("couponcode")));
          ((Map)localObject2).put("activitypic", Common.getHttpBitmap("http://58.215.80.12/Public/Uploads/".concat(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("activitypic"))));
          localArrayList1.add(localObject2);
          HashMap localHashMap2 = new HashMap();
          Integer localInteger2 = Integer.valueOf(1 + ((Integer)localObject1).intValue());
          localObject1 = localInteger2;
          localObject2 = localHashMap2;
          continue;
          localJSONException1 = localJSONException1;
          label342: localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
        Object localObject2;
        break label342;
      }
    }
    return localArrayList1;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903097);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("�ҵ���¨");
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.topwrap.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MycreelActivity.this.finish();
      }
    });
    new Thread(new Runnable()
    {
      public void run()
      {
        MycreelActivity.this.listdata = MycreelActivity.this.getData();
        MycreelActivity.MyAdapter localMyAdapter = new MycreelActivity.MyAdapter(MycreelActivity.this, MycreelActivity.this);
        MycreelActivity.this.updateList(localMyAdapter);
      }
    }).start();
  }

  public void updateList(final MyAdapter paramMyAdapter)
  {
    this.handler.post(new Runnable()
    {
      public void run()
      {
        MycreelActivity.this.mPullToRefreshListView = ((PullToRefreshListView)MycreelActivity.this.findViewById(2131034290));
        MycreelActivity.this.pointshoplistview = ((ListView)MycreelActivity.this.mPullToRefreshListView.getRefreshableView());
        MycreelActivity.this.pointshoplistview.setAdapter(paramMyAdapter);
        MycreelActivity.this.pointshoplistview.setOnItemClickListener(new MycreelActivity.3.1(this));
        MycreelActivity.this.mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        MycreelActivity.this.mPullToRefreshListView.setOnRefreshListener(new MycreelActivity.3.2(this));
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
      MycreelActivity.this.mPullToRefreshListView.onRefreshComplete();
      super.onPostExecute(paramArrayOfString);
    }
  }

  public class MyAdapter extends BaseAdapter
  {
    private LayoutInflater mInflater;

    public MyAdapter(Context arg2)
    {
      Context localContext;
      this.mInflater = LayoutInflater.from(localContext);
    }

    public int getCount()
    {
      return MycreelActivity.this.listdata.size();
    }

    public Object getItem(int paramInt)
    {
      return null;
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      MycreelActivity.ViewHolder localViewHolder;
      if (paramView == null)
      {
        localViewHolder = new MycreelActivity.ViewHolder(MycreelActivity.this);
        paramView = this.mInflater.inflate(2130903098, null);
        localViewHolder.activity_pic = ((ImageView)paramView.findViewById(2131034234));
        localViewHolder.activity_title = ((TextView)paramView.findViewById(2131034235));
        localViewHolder.price = ((TextView)paramView.findViewById(2131034283));
        localViewHolder.viewCouponCode = ((TextView)paramView.findViewById(2131034340));
        paramView.setTag(localViewHolder);
      }
      while (true)
      {
        localViewHolder.activity_pic.setImageBitmap((Bitmap)((Map)MycreelActivity.this.listdata.get(paramInt)).get("activitypic"));
        localViewHolder.activity_title.setText(((Map)MycreelActivity.this.listdata.get(paramInt)).get("activity_title").toString());
        localViewHolder.price.setText(String.valueOf(((Map)MycreelActivity.this.listdata.get(paramInt)).get("price")));
        String str1 = ((Map)MycreelActivity.this.listdata.get(paramInt)).get("couponcode").toString();
        String str2 = String.valueOf(((Map)MycreelActivity.this.listdata.get(paramInt)).get("activity_id"));
        localViewHolder.viewCouponCode.setOnClickListener(new MycreelActivity.MyAdapter.1(this, str1, str2));
        return paramView;
        localViewHolder = (MycreelActivity.ViewHolder)paramView.getTag();
      }
    }
  }

  public final class ViewHolder
  {
    public ImageView activity_pic;
    public TextView activity_title;
    public TextView price;
    public TextView viewCouponCode;

    public ViewHolder()
    {
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MycreelActivity
 * JD-Core Version:    0.6.2
 */