package com.yiye.wxhot.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.yiye.wxhot.member.LoginActivity;
import com.yiye.wxhot.util.Common;
import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityDetailActivity extends Activity
{
  private ImageView activity_pic;
  private TextView activity_title;
  private TextView addTime;
  private TextView checkinbtn = null;
  private FrameLayout container;
  private String contentUrl;
  private Intent frontIntent;
  private Handler handler = new Handler();
  private Netdeal netdeal;
  private TextView price1;
  private Integer productid;
  private WebView showActivityContent;
  private TextView topgrabcoupon = null;
  private LinearLayout topwrap = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903065);
    this.frontIntent = getIntent();
    this.productid = Integer.valueOf(this.frontIntent.getIntExtra("productid", 0));
    this.activity_pic = ((ImageView)findViewById(2131034234));
    this.activity_title = ((TextView)findViewById(2131034235));
    this.price1 = ((TextView)findViewById(2131034237));
    this.addTime = ((TextView)findViewById(2131034239));
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("活动详情");
    this.topgrabcoupon = ((TextView)findViewById(2131034240));
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.showActivityContent = ((WebView)findViewById(2131034241));
    this.showActivityContent.getSettings().setJavaScriptEnabled(true);
    String str1 = "activity_id=".concat(String.valueOf(this.productid));
    this.contentUrl = "http://58.215.80.12/".concat("/index.php/Api/showActivityContent?").concat(str1);
    this.showActivityContent.loadUrl(this.contentUrl);
    //this.showActivityContent.setWebViewClient(new HelloWebViewClient(null));
    this.netdeal = new Netdeal();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("activity_id", String.valueOf(this.productid)));
    String str2 = this.netdeal.commonGetData(localArrayList, "/index.php/Api/getActivityDetail");
    try
    {
      JSONObject localJSONObject = new JSONObject(str2);
      String str3 = localJSONObject.getString("activity_title");
      String str4 = localJSONObject.getString("addTime");
      Double localDouble = Double.valueOf(localJSONObject.getDouble("price"));
      String str5 = localJSONObject.getString("activitypic");
      this.activity_title.setText(str3);
      this.price1.setText(String.valueOf(localDouble));
      this.addTime.setText(str4);
      String str6 = "http://58.215.80.12/Public/Uploads/".concat(str5);
      this.activity_pic.setImageBitmap(Common.getHttpBitmap(str6));
      this.topgrabcoupon.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          String str1 = ActivityDetailActivity.this.getSharedPreferences("WuxihotDB", 0).getString("USERNAME", "");
          if (str1.length() == 0)
          {
            Intent localIntent1 = new Intent(ActivityDetailActivity.this, LoginActivity.class);
            ActivityDetailActivity.this.startActivity(localIntent1);
          }
          while (true)
          {
           
            String str2 = Common.generateCouponCode();
            ActivityDetailActivity.this.netdeal = new Netdeal();
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(new BasicNameValuePair("activity_id", String.valueOf(ActivityDetailActivity.this.productid)));
            localArrayList.add(new BasicNameValuePair("couponcode", str2));
            localArrayList.add(new BasicNameValuePair("member_name", str1));
            if (ActivityDetailActivity.this.netdeal.commonGetData(localArrayList, "/index.php/Api/addCreel").equals("1"))
            {
              Intent localIntent2 = new Intent(ActivityDetailActivity.this, CouponActivity.class);
              localIntent2.putExtra("couponcode", str2);
              localIntent2.putExtra("productid", String.valueOf(ActivityDetailActivity.this.productid));
              ActivityDetailActivity.this.startActivity(localIntent2);
            }
            return;
          }
        }
      });
      this.topwrap.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ActivityDetailActivity.this.finish();
        }
      });
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  public void updateView(final String paramString)
  {
    Toast.makeText(getApplicationContext(), paramString, 1).show();
    this.handler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          String str1 = localJSONObject.getString("activity_title");
          String str2 = localJSONObject.getString("addTime");
          Double localDouble = Double.valueOf(localJSONObject.getDouble("price"));
          localJSONObject.getString("activitypic");
          ActivityDetailActivity.this.activity_title.setText(str1);
          ActivityDetailActivity.this.price1.setText(String.valueOf(localDouble));
          ActivityDetailActivity.this.addTime.setText(str2);
          return;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            localJSONException.printStackTrace();
        }
      }
    });
  }

  private class HelloWebViewClient extends WebViewClient
  {
    private HelloWebViewClient()
    {
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}
