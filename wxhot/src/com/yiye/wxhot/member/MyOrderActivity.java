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
import android.widget.RelativeLayout;
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

public class MyOrderActivity extends Activity
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
    HashMap localHashMap1 = new HashMap();
    this.netdeal = new Netdeal();
    String str1 = getSharedPreferences("WuxihotDB", 0).getString("USERNAME", "");
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new BasicNameValuePair("member_name", str1));
    String str2 = this.netdeal.commonGetData(localArrayList2, "/index.php/Api/getOrderlist");
    try
    {
      localJSONArray = new JSONObject(str2).getJSONArray("orderlist");
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
          ((Map)localObject2).put("groupon_title", localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("groupon_title"));
          ((Map)localObject2).put("price", Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("price")));
          ((Map)localObject2).put("totalNums", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("totalNums")));
          ((Map)localObject2).put("totalPrice", Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("totalPrice")));
          ((Map)localObject2).put("groupon_id", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("groupon_id")));
          ((Map)localObject2).put("addTime", localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("addTime"));
          ((Map)localObject2).put("orderNo", localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("orderNo"));
          ((Map)localObject2).put("orderState", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("orderState")));
          ((Map)localObject2).put("groupon_pic", Common.getHttpBitmap("http://58.215.80.12/Public/Uploads/".concat(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("groupon_pic"))));
          localArrayList1.add(localObject2);
          HashMap localHashMap2 = new HashMap();
          Integer localInteger2 = Integer.valueOf(1 + ((Integer)localObject1).intValue());
          localObject1 = localInteger2;
          localObject2 = localHashMap2;
          continue;
          localJSONException1 = localJSONException1;
          label423: localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
        Object localObject2;
        break label423;
      }
    }
    return localArrayList1;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903099);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("我的订单");
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.topwrap.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MyOrderActivity.this.finish();
      }
    });
    new Thread(new Runnable()
    {
      public void run()
      {
        MyOrderActivity.this.listdata = MyOrderActivity.this.getData();
        MyOrderActivity.MyAdapter localMyAdapter = new MyOrderActivity.MyAdapter(MyOrderActivity.this, MyOrderActivity.this);
        MyOrderActivity.this.updateList(localMyAdapter);
      }
    }).start();
  }

  public void updateList(final MyAdapter paramMyAdapter)
  {
    this.handler.post(new Runnable()
    {
      public void run()
      {
        MyOrderActivity.this.mPullToRefreshListView = ((PullToRefreshListView)MyOrderActivity.this.findViewById(2131034290));
        MyOrderActivity.this.pointshoplistview = ((ListView)MyOrderActivity.this.mPullToRefreshListView.getRefreshableView());
        MyOrderActivity.this.pointshoplistview.setAdapter(paramMyAdapter);
        MyOrderActivity.this.pointshoplistview.setOnItemClickListener(new MyOrderActivity.3.1(this));
        MyOrderActivity.this.mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        MyOrderActivity.this.mPullToRefreshListView.setOnRefreshListener(new MyOrderActivity.3.2(this));
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
      MyOrderActivity.this.mPullToRefreshListView.onRefreshComplete();
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
      return MyOrderActivity.this.listdata.size();
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
      MyOrderActivity.ViewHolder localViewHolder;
      if (paramView == null)
      {
        localViewHolder = new MyOrderActivity.ViewHolder(MyOrderActivity.this);
        paramView = this.mInflater.inflate(2130903103, null);
        localViewHolder.groupon_pic = ((ImageView)paramView.findViewById(2131034295));
        localViewHolder.groupon_title = ((TextView)paramView.findViewById(2131034291));
        localViewHolder.addTime = ((TextView)paramView.findViewById(2131034239));
        localViewHolder.totalPrice = ((TextView)paramView.findViewById(2131034344));
        localViewHolder.totalNums = ((TextView)paramView.findViewById(2131034345));
        localViewHolder.orderNo = ((TextView)paramView.findViewById(2131034347));
        localViewHolder.groupon_id = ((TextView)paramView.findViewById(2131034298));
        localViewHolder.orderState = ((TextView)paramView.findViewById(2131034349));
        localViewHolder.gotopayLayout = ((RelativeLayout)paramView.findViewById(2131034348));
        localViewHolder.instantpay = ((TextView)paramView.findViewById(2131034350));
        paramView.setTag(localViewHolder);
      }
      while (true)
      {
        localViewHolder.groupon_pic.setImageBitmap((Bitmap)((Map)MyOrderActivity.this.listdata.get(paramInt)).get("groupon_pic"));
        localViewHolder.groupon_title.setText(((Map)MyOrderActivity.this.listdata.get(paramInt)).get("groupon_title").toString());
        localViewHolder.addTime.setText((String)((Map)MyOrderActivity.this.listdata.get(paramInt)).get("addTime"));
        localViewHolder.totalPrice.setText(String.valueOf(((Map)MyOrderActivity.this.listdata.get(paramInt)).get("totalPrice")));
        localViewHolder.totalNums.setText(String.valueOf(((Map)MyOrderActivity.this.listdata.get(paramInt)).get("totalNums")));
        localViewHolder.orderNo.setText((String)((Map)MyOrderActivity.this.listdata.get(paramInt)).get("orderNo"));
        if (Integer.valueOf(Integer.parseInt(String.valueOf(((Map)MyOrderActivity.this.listdata.get(paramInt)).get("orderState")))).intValue() == 1)
          localViewHolder.gotopayLayout.setVisibility(8);
        String str = ((Map)MyOrderActivity.this.listdata.get(paramInt)).get("orderNo").toString();
        localViewHolder.instantpay.setOnClickListener(new MyOrderActivity.MyAdapter.1(this, str));
        return paramView;
        localViewHolder = (MyOrderActivity.ViewHolder)paramView.getTag();
      }
    }
  }

  public final class ViewHolder
  {
    public TextView addTime;
    public RelativeLayout gotopayLayout;
    public TextView groupon_id;
    public ImageView groupon_pic;
    public TextView groupon_title;
    public TextView instantpay;
    public TextView orderNo;
    public TextView orderState;
    public TextView totalNums;
    public TextView totalPrice;

    public ViewHolder()
    {
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MyOrderActivity
 * JD-Core Version:    0.6.2
 */