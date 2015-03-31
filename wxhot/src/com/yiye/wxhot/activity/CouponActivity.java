package com.yiye.wxhot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class CouponActivity extends Activity
{
  private TextView activity_title;
  private TextView addTime;
  private TextView checkinbtn = null;
  private TextView couponcode;
  private String couponcodeValue;
  private Netdeal netdeal;
  private String productid;
  private LinearLayout topwrap = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903080);
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.activity_title = ((TextView)findViewById(2131034235));
    this.addTime = ((TextView)findViewById(2131034239));
    this.couponcode = ((TextView)findViewById(2131034286));
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("优惠券码");
    Intent localIntent = getIntent();
    this.productid = localIntent.getStringExtra("productid");
    this.couponcodeValue = localIntent.getStringExtra("couponcode");
    this.netdeal = new Netdeal();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("activity_id", this.productid));
    String str1 = this.netdeal.commonGetData(localArrayList, "/index.php/Api/getActivityDetail");
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      String str2 = localJSONObject.getString("activity_title");
      String str3 = localJSONObject.getString("addTime");
      this.activity_title.setText(str2);
      this.addTime.setText(str3);
      this.couponcode.setText(this.couponcodeValue);
      this.topwrap.setOnClickListener(new CouponActivity$1(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }
  
  
  class CouponActivity$1 implements View.OnClickListener {
		CouponActivity paramCouponActivity;
		CouponActivity$1(CouponActivity paramCouponActivity) {
			this.paramCouponActivity = paramCouponActivity;
		}

		public void onClick(View paramView) {
			this.paramCouponActivity.finish();
		}
	}
  
}




