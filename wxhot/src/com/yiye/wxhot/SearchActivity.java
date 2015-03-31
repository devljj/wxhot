package com.yiye.wxhot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yiye.wxhot.groupon.GroupondetailActivity;
import com.yiye.wxhot.pointshop.CustomViewBinder;
import com.yiye.wxhot.util.Common;
import com.yiye.wxhot.util.Netdeal;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchActivity extends Activity
{
  private String activity;
  private TextView cancelbtn;
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
  private ImageView return1;
  private EditText searchKeyword;
  private LinearLayout searchlist;
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

  private List<Map<String, Object>> getData(Double paramDouble1, Double paramDouble2, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    this.netdeal = new Netdeal();
    ArrayList localArrayList2 = new ArrayList();
    BasicNameValuePair localBasicNameValuePair = new BasicNameValuePair("keyword", paramString);
    localArrayList2.add(localBasicNameValuePair);
    JSONArray localJSONArray = null;
    Integer localObject1 = 0;
    Map localObject2 = new HashMap();
    String str = this.netdeal.commonGetData(localArrayList2, "/index.php/Api/getGrouponList");
    try
    {
      localJSONArray = new JSONObject(str).getJSONArray("grouponlist");
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
         // continue;
         // localJSONException1 = localJSONException1;
        //  label442: localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
      //  Object localObject2 = null;
       // break label442;
      }
    }
    return localArrayList1;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903115);
    this.searchKeyword = ((EditText)findViewById(2131034379));
    this.searchlist = ((LinearLayout)findViewById(2131034381));
    this.return1 = ((ImageView)findViewById(2131034270));
    this.cancelbtn = ((TextView)findViewById(2131034380));
    this.return1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SearchActivity.this.finish();
      }
    });
    this.cancelbtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SearchActivity.this.searchKeyword.setText("");
        SearchActivity.this.searchlist.removeAllViews();
        View localView = SearchActivity.this.getWindow().peekDecorView();
        if (localView != null)
          ((InputMethodManager)SearchActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    });
    this.searchKeyword.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        String str = SearchActivity.this.searchKeyword.getText().toString().trim();
        if ((paramAnonymousInt == 3) || (paramAnonymousInt == 0))
        {/*
          if (str.length() <= 0)
            break label112;
          SearchActivity.this.mLocationClient = new LocationClient(SearchActivity.this.getApplicationContext());
          SearchActivity.this.InitLocation();
          SearchActivity.this.mActivityLocationListener = new SearchActivity.ActivityLocationListener(SearchActivity.this);
          SearchActivity.this.mLocationClient.registerLocationListener(SearchActivity.this.mActivityLocationListener);
          SearchActivity.this.mLocationClient.start();
        */}
    /*    while (true)
        {
          return false;
          label112: Toast.makeText(SearchActivity.this, "请输入关键字！", 0).show();
        }*/
        return false;
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
      String str = SearchActivity.this.searchKeyword.getText().toString().trim();
      SearchActivity.this.listdata = SearchActivity.this.getData(localDouble1, localDouble2, str);
      if (SearchActivity.this.listdata.size() == 0)
        Toast.makeText(SearchActivity.this.getApplicationContext(), "没有相关结果！", 0).show();
      SearchActivity localSearchActivity = SearchActivity.this;
      List localList = SearchActivity.this.listdata;
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
      SimpleAdapter localSimpleAdapter = new SimpleAdapter(localSearchActivity, localList, 2130903086, arrayOfString, arrayOfInt);
   //   localSimpleAdapter.setViewBinder(new CustomViewBinder());
      SearchActivity.this.pointshoplistview = new ListView(SearchActivity.this);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      SearchActivity.this.pointshoplistview.setLayoutParams(localLayoutParams);
      SearchActivity.this.pointshoplistview.setAdapter(localSimpleAdapter);
      SearchActivity.this.mLocationClient.stop();
     // SearchActivity.this.pointshoplistview.setOnItemClickListener(new SearchActivity.ActivityLocationListener.1(this));
      SearchActivity.this.searchlist.removeAllViews();
      SearchActivity.this.searchlist.addView(SearchActivity.this.pointshoplistview);
    }
  }
  
  
  
  class SearchActivity$ActivityLocationListener  implements AdapterView.OnItemClickListener
{
  SearchActivity$ActivityLocationListener(SearchActivity.ActivityLocationListener paramActivityLocationListener)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    //Intent localIntent = new Intent(SearchActivity.ActivityLocationListener.access$0(this.this$1), GroupondetailActivity.class);
	Intent localIntent = new Intent(SearchActivity.this, GroupondetailActivity.class);
   // localIntent.putExtra("productid", Integer.valueOf(Integer.parseInt(((Map)SearchActivity.access$3(SearchActivity.ActivityLocationListener.access$0(this.this$1)).get(paramInt)).get("groupon_id").toString())));
    //SearchActivity.ActivityLocationListener.access$0(this.this$1).startActivity(localIntent);
    startActivity(localIntent);
  }
}
  
}

