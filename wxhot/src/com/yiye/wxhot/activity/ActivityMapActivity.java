package com.yiye.wxhot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.yiye.wxhot.RegionAdapter;
import com.yiye.wxhot.SearchActivity;
import com.yiye.wxhot.common.Region;
import java.util.ArrayList;
import java.util.List;

public class ActivityMapActivity extends Activity
{
  private AMap aMap;
  private ArrayAdapter<String> adapter;
  private List<Region> list = new ArrayList();
  private LinearLayout listContent;
  private ActivityLocationListener mActivityLocationListener;
  private LocationClient mLocationClient;
  private MapView mapView;
  private EditText searchkeyword;
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

  private void init()
  {
    if (this.aMap == null)
      this.aMap = this.mapView.getMap();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903069);
    this.searchkeyword = ((EditText)findViewById(2131034190));
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
    this.searchkeyword.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent(ActivityMapActivity.this, SearchActivity.class);
          localIntent.putExtra("activity", "groupon");
          ActivityMapActivity.this.startActivity(localIntent);
          ActivityMapActivity.this.overridePendingTransition(2130968587, 2130968586);
        }
      }
    });
    this.mapView = ((MapView)findViewById(2131034244));
    this.mapView.onCreate(paramBundle);
    this.mLocationClient = new LocationClient(getApplicationContext());
    InitLocation();
    this.mActivityLocationListener = new ActivityLocationListener();
    this.mLocationClient.registerLocationListener(this.mActivityLocationListener);
    this.mLocationClient.start();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.mapView.onDestroy();
  }

  protected void onPause()
  {
    super.onPause();
    this.mapView.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    this.mapView.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mapView.onSaveInstanceState(paramBundle);
  }

  public class ActivityLocationListener
    implements BDLocationListener
  {
    public ActivityLocationListener()
    {
    }

    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      ActivityMapActivity.this.init();
      CameraUpdate localCameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(paramBDLocation.getLatitude(), paramBDLocation.getLongitude()), 15.0F);
      ActivityMapActivity.this.aMap.animateCamera(localCameraUpdate);
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.activity.ActivityMapActivity
 * JD-Core Version:    0.6.2
 */