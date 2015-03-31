package com.yiye.wxhot;

import android.app.Application;
import android.os.Vibrator;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;
import com.baidu.location.GeofenceClient;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;

public class WuxihotApplication extends Application
{
  public TextView currentLatitude;
  public TextView currentLongitude;
  public TextView exit;
  public GeofenceClient mGeofenceClient;
  public LocationClient mLocationClient;
  public Vibrator mVibrator;
  public TextView trigger;

  public void onCreate()
  {
    super.onCreate();
    SDKInitializer.initialize(this);
    JPushInterface.setDebugMode(true);
    JPushInterface.init(this);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.WuxihotApplication
 * JD-Core Version:    0.6.2
 */