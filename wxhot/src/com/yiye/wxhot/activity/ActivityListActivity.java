package com.yiye.wxhot.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yiye.wxhot.RegionAdapter;
import com.yiye.wxhot.common.Region;
import com.yiye.wxhot.pointshop.CustomViewBinder;
import com.yiye.wxhot.util.Netdeal;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityListActivity extends Activity
{
  private AMap aMap;
  private ArrayAdapter<String> adapter;
  private TextView checkinbtn = null;
  private FrameLayout container;
  private TextView distance2;
  private ImageView gotomapmode1;
  private Handler handler = new Handler();
  private List<Region> list = new ArrayList();
  private List<Map<String, Object>> listdata = null;
  private ActivityLocationListener mActivityLocationListener;
  private LocationClient mLocationClient;
  private PullToRefreshListView mPullToRefreshListView;
  private MapView mapView;
  private Netdeal netdeal = null;
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
    HashMap localHashMap1 = new HashMap();
    this.netdeal = new Netdeal();
    JSONArray  localJSONArray = null;
    Integer localObject1 = null;
    Map localObject2 = null;
    ArrayList localArrayList2 = new ArrayList();
    String str = this.netdeal.commonGetData(localArrayList2, "/index.php/Api/getActivityList");
    try
    {
      localJSONArray = new JSONObject(str).getJSONArray("activity");
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
          ((Map)localObject2).put("product_title", localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("product_title"));
          ((Map)localObject2).put("price", Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("price")));
          ((Map)localObject2).put("productid", Integer.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getInt("product_id")));
          ((Map)localObject2).put("product_pic", getHttpBitmap("http://58.215.80.12/Public/Uploads/".concat(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getString("product_pic"))));
          this.position1 = new LatLng(paramDouble2.doubleValue(), paramDouble1.doubleValue());
          this.position2Latitude = Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("latitude"));
          this.position2Longitude = Double.valueOf(localJSONArray.getJSONObject(((Integer)localObject1).intValue()).getDouble("longitude"));
          this.position2 = new LatLng(this.position2Latitude.doubleValue(), this.position2Longitude.doubleValue());
          ((Map)localObject2).put("distance", new BigDecimal(Double.valueOf(Math.floor(Double.valueOf(AMapUtils.calculateLineDistance(this.position1, this.position2)).doubleValue())).doubleValue()).toPlainString());
          localArrayList1.add(localObject2);
          HashMap localHashMap2 = new HashMap();
          Integer localInteger2 = Integer.valueOf(1 + ((Integer)localObject1).intValue());
          localObject1 = localInteger2;
          localObject2 = localHashMap2;
          continue;
         // localJSONException1 = localJSONException1;
         // label393: localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
        //Object localObject2;
       // break label393;
      }
    }
    return localArrayList1;
  }

  private void init()
  {
    if (this.aMap == null)
      this.aMap = this.mapView.getMap();
  }

  public Bitmap getBitmap(String paramString)
  {
	  Bitmap localObject = null;
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
    setContentView(2130903066);
    this.mapView = ((MapView)findViewById(2131034244));
    this.mapView.onCreate(paramBundle);
    this.mLocationClient = new LocationClient(getApplicationContext());
    InitLocation();
    this.mActivityLocationListener = new ActivityLocationListener();
    this.mLocationClient.registerLocationListener(this.mActivityLocationListener);
    this.mLocationClient.start();
    this.gotomapmode1 = ((ImageView)findViewById(2131034243));
    this.mPullToRefreshListView = ((PullToRefreshListView)findViewById(2131034245));
    this.pointshoplistview = ((ListView)this.mPullToRefreshListView.getRefreshableView());
    this.searchkeyword = ((TextView)findViewById(2131034190));
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
        Intent localIntent = new Intent(ActivityListActivity.this, ActivityMapActivity.class);
        ActivityListActivity.this.startActivity(localIntent);
      }
    });
    this.searchkeyword.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(ActivityListActivity.this, ActivitySearchActivity.class);
        localIntent.putExtra("activity", "main");
        ActivityListActivity.this.startActivity(localIntent);
        ActivityListActivity.this.overridePendingTransition(2130968587, 2130968586);
      }
    });
  }

  protected void onStop()
  {
    this.mLocationClient.stop();
    super.onStop();
  }

  public void updateList(final SimpleAdapter paramSimpleAdapter)
  {
    this.handler.post(new Runnable()
    {
      public void run()
      {
        ActivityListActivity.this.pointshoplistview.setAdapter(paramSimpleAdapter);
       // ActivityListActivity.this.pointshoplistview.setOnItemClickListener(new ActivityListActivity.3.1(this));
        ActivityListActivity.this.mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
       // ActivityListActivity.this.mPullToRefreshListView.setOnRefreshListener(new ActivityListActivity.3.2(this));
      }
    });
  }

  public class ActivityLocationListener implements BDLocationListener
  {
    public ActivityLocationListener()
    {
    }

    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      Double localDouble1 = Double.valueOf(paramBDLocation.getLongitude());
      Double localDouble2 = Double.valueOf(paramBDLocation.getLatitude());
      ActivityListActivity.this.init();
      CameraUpdate localCameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(paramBDLocation.getLatitude(), paramBDLocation.getLongitude()), 15.0F);
      ActivityListActivity.this.aMap.animateCamera(localCameraUpdate);
     // new Thread(new ActivityListActivity.ActivityLocationListener.1(this, localDouble1, localDouble2)).start();
    }
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
      ActivityListActivity.this.mLocationClient.start();
      ActivityListActivity.this.mPullToRefreshListView.onRefreshComplete();
      super.onPostExecute(paramArrayOfString);
    }
  }
  
  
  class ActivityListActivity$3$1 implements AdapterView.OnItemClickListener
  {
	  ActivityListActivity  param;
    ActivityListActivity$3$1(ActivityListActivity param3)
    {
    	this.param  = param;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Intent localIntent = new Intent(ActivityListActivity.this, ActivityDetailActivity.class);
     // localIntent.putExtra("productid", Integer.valueOf(Integer.parseInt(((Map)ActivityListActivity.access$4(ActivityListActivity.3.access$0(this.this$1)).get(paramInt - 1)).get("productid").toString())));
      localIntent.addFlags(67108864);
      ActivityListActivity.this.startActivity(localIntent);
    }
  }
  
  
  class ActivityListActivity$3$2  implements PullToRefreshBase.OnRefreshListener<ListView>
  {
	  ActivityListActivity param;
    ActivityListActivity$3$2(ActivityListActivity param)
    {
    	this.param = param;
    }

    public void onRefresh(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
    	new ActivityListActivity.GetDataTask().execute();
    }
  }
  
  
  
  class ActivityListActivity$ActivityLocationListener$1 implements Runnable{
	  ActivityListActivity$ActivityLocationListener$1(ActivityListActivity.ActivityLocationListener paramActivityLocationListener, Double paramDouble1, Double paramDouble2)
	  {
	  }

	  public void run(){
	    try{
		      ActivityListActivity.access$3(ActivityListActivity.ActivityLocationListener.access$0(this.this$1), ActivityListActivity.access$2(ActivityListActivity.ActivityLocationListener.access$0(this.this$1), this.val$position1Longitude, this.val$position1Latitude));
		      ActivityListActivity localActivityListActivity = ActivityListActivity.ActivityLocationListener.access$0(this.this$1);
		      List localList = ActivityListActivity.access$4(ActivityListActivity.ActivityLocationListener.access$0(this.this$1));
		      String[] arrayOfString = new String[5];
		      arrayOfString[0] = "product_title";
		      arrayOfString[1] = "product_pic";
		      arrayOfString[2] = "price";
		      arrayOfString[3] = "productid";
		      arrayOfString[4] = "distance";
		      int[] arrayOfInt = new int[5];
		      arrayOfInt[0] = 2131034248;
		      arrayOfInt[1] = 2131034246;
		      arrayOfInt[2] = 2131034250;
		      arrayOfInt[3] = 2131034251;
		      arrayOfInt[4] = 2131034252;
		      SimpleAdapter localSimpleAdapter = new SimpleAdapter(localActivityListActivity, localList, 2130903067, arrayOfString, arrayOfInt);
		      localSimpleAdapter.setViewBinder(new CustomViewBinder());
		      ActivityListActivity.ActivityLocationListener.access$0(this.this$1).updateList(localSimpleAdapter);
		      return;
	    }
	    catch (Exception localException)
	    {
	    }
	  }
	}
  
  
  
}
