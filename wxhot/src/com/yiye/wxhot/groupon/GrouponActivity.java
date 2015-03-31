package com.yiye.wxhot.groupon;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yiye.wxhot.RegionAdapter;
import com.yiye.wxhot.SearchActivity;
import com.yiye.wxhot.common.Region;
import com.yiye.wxhot.pointshop.CustomViewBinder;
import com.yiye.wxhot.util.Common;
import com.yiye.wxhot.util.Netdeal;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GrouponActivity extends Activity
{
  private LinearLayout activityitem1 = null;
  private LinearLayout activityitem2 = null;
  private ArrayAdapter<String> adapter;
  private FrameLayout container;
  private ImageView gotomapmode1;
  private LinearLayout grouponclass11 = null;
  private LinearLayout grouponclass21 = null;
  private LinearLayout grouponclass31 = null;
  private LinearLayout grouponclass41 = null;
  private LinearLayout grouponclass51 = null;
  private LinearLayout grouponclass61 = null;
  private LinearLayout grouponclass71 = null;
  private LinearLayout grouponclass81 = null;
  private List<Region> list = new ArrayList();
  private List<Map<String, Object>> listdata = null;
  private ActivityLocationListener mActivityLocationListener;
  private LocationClient mLocationClient;
  private PullToRefreshListView mPullToRefreshListView;
  private Netdeal netdeal;
  private ListView pointshoplistview = null;
  private LatLng position1;
  private LatLng position2;
  private Double position2Latitude;
  private Double position2Longitude;
  private TextView searchkeyword;
  private Spinner spinner_region = null;
  private LocationClientOption.LocationMode tempMode = LocationClientOption.LocationMode.Hight_Accuracy;
  private String tempcoor = "gcj02";

  private void InitLocation()
  {
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setLocationMode(this.tempMode);
    localLocationClientOption.setCoorType(this.tempcoor);
    localLocationClientOption.setScanSpan(500);
    this.mLocationClient.setLocOption(localLocationClientOption);
  }

  private List<Map<String, Object>> getData(Double paramDouble1, Double paramDouble2)
  {
    ArrayList localArrayList1 = new ArrayList();
    Map localHashMap1 = new HashMap();
    Map localObject2 = null;
    Integer localObject1 = null;
    this.netdeal = new Netdeal();
    JSONArray localJSONArray = null;
    ArrayList localArrayList2 = new ArrayList();
    String str = this.netdeal.commonGetData(localArrayList2, "/index.php/Api/getHotGrouponList");
    try
    {
      JSONArray localJSONArray = new JSONObject(str).getJSONArray("grouponlist");
      Integer localInteger1 = Integer.valueOf(0);
      localObject1 = localInteger1;
      localObject2 = localHashMap1;
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        while (((Integer)localObject1).intValue() < localJSONArray.length())
        {
          ((Map)localObject2).put("groupon_title", localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("groupon_title"));
          ((Map)localObject2).put("groupon_price", Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("groupon_price")));
          ((Map)localObject2).put("groupon_primeprice", Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("groupon_primeprice")));
          ((Map)localObject2).put("groupon_id", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("groupon_id")));
          ((Map)localObject2).put("groupon_pic", Common.getHttpBitmap("http://58.215.80.12/Public/Uploads/".concat(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("groupon_pic"))));
          this.position1 = new LatLng(paramDouble2.doubleValue(), paramDouble1.doubleValue());
          this.position2Latitude = Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("latitude"));
          this.position2Longitude = Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("longitude"));
          this.position2 = new LatLng(this.position2Latitude.doubleValue(), this.position2Longitude.doubleValue());
          ((Map)localObject2).put("distance", new BigDecimal(Double.valueOf(Math.floor(Double.valueOf(DistanceUtil.getDistance(this.position1, this.position2)).doubleValue())).doubleValue()).toPlainString());
          localArrayList1.add(localObject2);
          HashMap localHashMap2 = new HashMap();
          Integer localInteger2 = Integer.valueOf(1 + ((Integer)localObject1).intValue());
          localObject1 = localInteger2;
          localObject2 = localHashMap2;
          continue;
          localJSONException1 = localJSONException1;
          label421: localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
       // Object localObject2;
        break label421;
      }
    }
    return localArrayList1;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903083);
    this.mLocationClient = new LocationClient(getApplicationContext());
    InitLocation();
    this.mActivityLocationListener = new ActivityLocationListener();
    this.mLocationClient.registerLocationListener(this.mActivityLocationListener);
    this.mLocationClient.start();
    this.searchkeyword = ((TextView)findViewById(2131034190));
    this.gotomapmode1 = ((ImageView)findViewById(2131034243));
    this.grouponclass11 = ((LinearLayout)findViewById(2131034196));
    this.grouponclass21 = ((LinearLayout)findViewById(2131034198));
    this.grouponclass31 = ((LinearLayout)findViewById(2131034200));
    this.grouponclass41 = ((LinearLayout)findViewById(2131034202));
    this.grouponclass51 = ((LinearLayout)findViewById(2131034205));
    this.grouponclass61 = ((LinearLayout)findViewById(2131034207));
    this.grouponclass71 = ((LinearLayout)findViewById(2131034209));
    this.grouponclass81 = ((LinearLayout)findViewById(2131034211));
    this.spinner_region = ((Spinner)findViewById(2131034188));
    this.list.add(new Region("全无锡市"));
    this.list.add(new Region("崇安区"));
    this.list.add(new Region("南长区"));
    this.list.add(new Region("北塘区"));
    this.list.add(new Region("惠山区"));
    this.list.add(new Region("锡山区"));
    this.list.add(new Region("滨湖区"));
    this.list.add(new Region("江阴市"));
    this.list.add(new Region("宜兴市"));
    RegionAdapter localRegionAdapter = new RegionAdapter(this, this.list);
    this.spinner_region.setAdapter(localRegionAdapter);
    this.gotomapmode1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(GrouponActivity.this, GrouponMapActivity.class);
        GrouponActivity.this.startActivity(localIntent);
      }
    });
    this.grouponclass11.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(GrouponActivity.this, GrouponListActivity.class);
        localIntent.addFlags(67108864);
        GrouponActivity.this.startActivity(localIntent);
      }
    });
    this.grouponclass21.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(GrouponActivity.this, GrouponListActivity.class);
        localIntent.addFlags(67108864);
        GrouponActivity.this.startActivity(localIntent);
      }
    });
    this.grouponclass31.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(GrouponActivity.this, GrouponListActivity.class);
        localIntent.addFlags(67108864);
        GrouponActivity.this.startActivity(localIntent);
      }
    });
    this.grouponclass41.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(GrouponActivity.this, GrouponListActivity.class);
        localIntent.addFlags(67108864);
        GrouponActivity.this.startActivity(localIntent);
      }
    });
    this.grouponclass51.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(GrouponActivity.this, GrouponListActivity.class);
        localIntent.addFlags(67108864);
        GrouponActivity.this.startActivity(localIntent);
      }
    });
    this.grouponclass61.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(GrouponActivity.this, GrouponListActivity.class);
        localIntent.addFlags(67108864);
        GrouponActivity.this.startActivity(localIntent);
      }
    });
    this.grouponclass71.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(GrouponActivity.this, GrouponListActivity.class);
        localIntent.addFlags(67108864);
        GrouponActivity.this.startActivity(localIntent);
      }
    });
    this.grouponclass81.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(GrouponActivity.this, GrouponListActivity.class);
        localIntent.addFlags(67108864);
        GrouponActivity.this.startActivity(localIntent);
      }
    });
    this.searchkeyword.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent(GrouponActivity.this, SearchActivity.class);
          localIntent.putExtra("activity", "groupon");
          GrouponActivity.this.startActivity(localIntent);
          GrouponActivity.this.overridePendingTransition(2130968587, 2130968586);
        }
      }
    });
  }

  protected void onStop()
  {
    this.mLocationClient.stop();
    super.onStop();
  }

  public class ActivityLocationListener
    implements BDLocationListener
  {
    public ActivityLocationListener()
    {
    }

    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      Double localDouble1 = Double.valueOf(paramBDLocation.getLongitude());
      Double localDouble2 = Double.valueOf(paramBDLocation.getLatitude());
      GrouponActivity.this.listdata = GrouponActivity.this.getData(localDouble1, localDouble2);
      GrouponActivity localGrouponActivity = GrouponActivity.this;
      List localList = GrouponActivity.this.listdata;
      String[] arrayOfString = new String[6];
      arrayOfString[0] = "groupon_title";
      arrayOfString[1] = "groupon_pic";
      arrayOfString[2] = "groupon_price";
      arrayOfString[3] = "groupon_primeprice";
      arrayOfString[4] = "groupon_id";
      arrayOfString[5] = "distance";
      int[] arrayOfInt = new int[6];
      arrayOfInt[0] = 2131034291;
      arrayOfInt[1] = 2131034295;
      arrayOfInt[2] = 2131034292;
      arrayOfInt[3] = 2131034297;
      arrayOfInt[4] = 2131034298;
      arrayOfInt[5] = 2131034252;
      SimpleAdapter localSimpleAdapter = new SimpleAdapter(localGrouponActivity, localList, 2130903086, arrayOfString, arrayOfInt);
      localSimpleAdapter.setViewBinder(new CustomViewBinder());
      GrouponActivity.this.mPullToRefreshListView = ((PullToRefreshListView)GrouponActivity.this.findViewById(2131034290));
      GrouponActivity.this.pointshoplistview = ((ListView)GrouponActivity.this.mPullToRefreshListView.getRefreshableView());
      GrouponActivity.this.pointshoplistview.setAdapter(localSimpleAdapter);
      GrouponActivity.this.mLocationClient.stop();
      GrouponActivity.this.pointshoplistview.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          Intent localIntent = new Intent(GrouponActivity.this, GroupondetailActivity.class);
          localIntent.putExtra("productid", Integer.valueOf(Integer.parseInt(((Map)GrouponActivity.this.listdata.get(paramAnonymousInt)).get("groupon_id").toString())));
          localIntent.addFlags(67108864);
          GrouponActivity.this.startActivity(localIntent);
        }
      });
      GrouponActivity.this.mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
      GrouponActivity.this.mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener()
      {
        public void onRefresh(PullToRefreshBase<ListView> paramAnonymousPullToRefreshBase)
        {
          new GrouponActivity.ActivityLocationListener.GetDataTask(GrouponActivity.ActivityLocationListener.this, null).execute(new Void[0]);
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
        GrouponActivity.this.mLocationClient.start();
        GrouponActivity.this.mPullToRefreshListView.onRefreshComplete();
        super.onPostExecute(paramArrayOfString);
      }
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.GrouponActivity
 * JD-Core Version:    0.6.2
 */