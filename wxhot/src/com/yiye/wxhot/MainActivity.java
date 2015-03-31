package com.yiye.wxhot;

import android.app.ActivityGroup;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.yiye.wxhot.activity.ActivityListActivity;
import com.yiye.wxhot.common.Region;
import com.yiye.wxhot.util.Netdeal;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActivityGroup
{
  private ArrayAdapter<String> adapter;
  private LinearLayout checkin;
  private ImageView closeLayerads;
  private FrameLayout container;
  private ImageView gotogroupon;
  private TextView gotogroupontv;
  private ImageView gotohome;
  private TextView gotohometv;
  private ImageView[] gotoimg = new ImageView[5];
  private ImageView gotomemberhome;
  private TextView gotomemberhometv;
  private ImageView gotomore;
  private TextView gotomoretv;
  private ImageView gotopointshop;
  private TextView gotopointshoptv;
  private TextView[] gototv = new TextView[5];
  private LinearLayout groupon;
  private LinearLayout grouponclass11;
  private LinearLayout grouponclass21;
  private LinearLayout grouponclass31;
  private LinearLayout grouponclass41;
  private LinearLayout grouponclass51;
  private LinearLayout grouponclass61;
  private LinearLayout grouponclass71;
  private LinearLayout grouponclass81;
  private Handler handler = new Handler();
  private RelativeLayout homebox3;
  private RelativeLayout homebox4;
  private LinearLayout homepage;
  private ImageView hometopads;
  private FrameLayout layerads;
  private List<Region> list = new ArrayList();
  private LinearLayout membercenter;
  private LinearLayout more;
  private Netdeal netdeal;
  private Button openBrowser = null;
  private LinearLayout pointshop;
  private ProgressDialog progressDialog = null;
  private Integer[] resblack = new Integer[5];
  private Integer[] resred = new Integer[5];
  private TextView searchkeyword;
  private Spinner spinner_region = null;
  private Integer state = Integer.valueOf(0);
  private RelativeLayout viewbtn1;
  private RelativeLayout viewbtn2;

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

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903064);
    this.hometopads = ((ImageView)findViewById(2131034194));
    this.checkin = ((LinearLayout)findViewById(2131034191));
    this.closeLayerads = ((ImageView)findViewById(2131034232));
    this.layerads = ((FrameLayout)findViewById(2131034231));
    new Thread(new MainActivity$1(this)).start();
    this.homebox3 = ((RelativeLayout)findViewById(2131034225));
    this.homebox4 = ((RelativeLayout)findViewById(2131034228));
    this.searchkeyword = ((TextView)findViewById(2131034190));
    this.grouponclass11 = ((LinearLayout)findViewById(2131034196));
    this.grouponclass21 = ((LinearLayout)findViewById(2131034198));
    this.grouponclass31 = ((LinearLayout)findViewById(2131034200));
    this.grouponclass41 = ((LinearLayout)findViewById(2131034202));
    this.grouponclass51 = ((LinearLayout)findViewById(2131034205));
    this.grouponclass61 = ((LinearLayout)findViewById(2131034207));
    this.grouponclass71 = ((LinearLayout)findViewById(2131034209));
    this.grouponclass81 = ((LinearLayout)findViewById(2131034211));
    this.homepage = ((LinearLayout)findViewById(2131034257));
    this.pointshop = ((LinearLayout)findViewById(2131034260));
    this.membercenter = ((LinearLayout)findViewById(2131034263));
    this.more = ((LinearLayout)findViewById(2131034266));
    this.container = ((FrameLayout)findViewById(2131034185));
    this.spinner_region = ((Spinner)findViewById(2131034188));
    this.gotohome = ((ImageView)findViewById(2131034258));
    this.gotopointshop = ((ImageView)findViewById(2131034261));
    this.viewbtn1 = ((RelativeLayout)findViewById(2131034214));
    this.viewbtn2 = ((RelativeLayout)findViewById(2131034219));
    this.gotomemberhome = ((ImageView)findViewById(2131034264));
    this.gotomore = ((ImageView)findViewById(2131034267));
    this.gotohometv = ((TextView)findViewById(2131034259));
    this.gotopointshoptv = ((TextView)findViewById(2131034262));
    this.gotomemberhometv = ((TextView)findViewById(2131034265));
    this.gotomoretv = ((TextView)findViewById(2131034268));
    this.gotoimg[0] = this.gotohome;
    this.gotoimg[1] = this.gotopointshop;
    this.gotoimg[2] = this.gotogroupon;
    this.gotoimg[3] = this.gotomemberhome;
    this.gotoimg[4] = this.gotomore;
    this.gototv[0] = this.gotohometv;
    this.gototv[1] = this.gotopointshoptv;
    this.gototv[2] = this.gotogroupontv;
    this.gototv[3] = this.gotomemberhometv;
    this.gototv[4] = this.gotomoretv;
    this.resred[0] = Integer.valueOf(2130837636);
    this.resred[1] = Integer.valueOf(2130837707);
    this.resred[2] = Integer.valueOf(2130837634);
    this.resred[3] = Integer.valueOf(2130837696);
    this.resred[4] = Integer.valueOf(2130837697);
    this.resblack[0] = Integer.valueOf(2130837596);
    this.resblack[1] = Integer.valueOf(2130837599);
    this.resblack[2] = Integer.valueOf(2130837595);
    this.resblack[3] = Integer.valueOf(2130837597);
    this.resblack[4] = Integer.valueOf(2130837598);
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
    this.checkin.setOnClickListener(new MainActivity.2(this));
    this.pointshop.setOnClickListener(new MainActivity.3(this));
    this.viewbtn1.setOnClickListener(new MainActivity.4(this));
    this.viewbtn2.setOnClickListener(new MainActivity.5(this));
    this.homepage.setOnClickListener(new MainActivity.6(this));
    this.membercenter.setOnClickListener(new MainActivity.7(this));
    this.more.setOnClickListener(new MainActivity.8(this));
    this.grouponclass11.setOnClickListener(new MainActivity.9(this));
    this.grouponclass21.setOnClickListener(new MainActivity.10(this));
    this.grouponclass31.setOnClickListener(new MainActivity.11(this));
    this.grouponclass41.setOnClickListener(new MainActivity.12(this));
    this.grouponclass51.setOnClickListener(new MainActivity.13(this));
    this.grouponclass61.setOnClickListener(new MainActivity.14(this));
    this.grouponclass71.setOnClickListener(new MainActivity.15(this));
    this.grouponclass81.setOnClickListener(new MainActivity.16(this));
    this.homebox3.setOnClickListener(new MainActivity.17(this));
    this.homebox4.setOnClickListener(new MainActivity.18(this));
    this.searchkeyword.setOnClickListener(new MainActivity.19(this));
    this.closeLayerads.setOnClickListener(new MainActivity.20(this));
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.HOME");
      localIntent.setFlags(268435456);
      startActivity(localIntent);
      System.exit(0);
    }
    return false;
  }

  public void setPicuture(String paramString)
  {
    this.handler.post(new MainActivity.21(this, paramString));
  }
  
  
  
  class MainActivity$1 implements Runnable
  {
    MainActivity paramMainActivity;
    MainActivity$1(MainActivity paramMainActivity)
    {
  	  this.paramMainActivity = paramMainActivity;
    }

    public void run()
    {
      try
      {
   /*     MainActivity.access$0(this.paramMainActivity, new Netdeal());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("adsclassid", "1"));
        String str = MainActivity.access$1(this.paramMainActivity).commonGetData(localArrayList, "/index.php/Api/getHomeTopAds");
        this.paramMainActivity.setPicuture(str);*/
        return;
      }
      catch (Exception localException)
      {
        while (true)
          localException.printStackTrace();
      }
    }
  }
  
  
  
  

class MainActivity$10 implements View.OnClickListener
{
  MainActivity paramMainActivity;
  MainActivity$10(MainActivity paramMainActivity)
  {
	  this.paramMainActivity = paramMainActivity;
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.paramMainActivity, ActivityListActivity.class);
    this.paramMainActivity.startActivity(localIntent);
  }
}
  
  
  
}









