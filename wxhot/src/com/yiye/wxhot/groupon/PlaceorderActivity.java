package com.yiye.wxhot.groupon;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yiye.wxhot.member.LoginActivity;
import com.yiye.wxhot.util.Netdeal;

public class PlaceorderActivity extends Activity
{
  private String USERNAME;
  private ImageView addbtn;
  private TextView checkinbtn = null;
  private Button gotochoosepayway;
  private Integer groupon_id;
  private TextView groupon_price;
  private TextView groupon_title;
  private Handler handler = new Handler();
  private Netdeal netdeal;
  private EditText orderquantity;
  private Double price;
  private ImageView reducebtn;
  private LinearLayout topwrap = null;
  private Double totalPrice;
  private TextView totalpriceTV;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903105);
    this.totalpriceTV = ((TextView)findViewById(2131034356));
    if (getSharedPreferences("WuxihotDB", 0).getString("USERNAME", "").length() == 0)
      startActivity(new Intent(this, LoginActivity.class));
    this.addbtn = ((ImageView)findViewById(2131034355));
    this.reducebtn = ((ImageView)findViewById(2131034353));
    this.orderquantity = ((EditText)findViewById(2131034354));
    this.gotochoosepayway = ((Button)findViewById(2131034357));
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("提交订单");
    this.groupon_id = Integer.valueOf(getIntent().getIntExtra("groupon_id", 1));
    this.groupon_title = ((TextView)findViewById(2131034291));
    this.groupon_price = ((TextView)findViewById(2131034292));
    new Thread(new PlaceorderActivity.1(this)).start();
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.gotochoosepayway.setOnClickListener(new PlaceorderActivity.2(this));
    this.topwrap.setOnClickListener(new PlaceorderActivity.3(this));
    this.addbtn.setOnClickListener(new PlaceorderActivity.4(this));
    this.reducebtn.setOnClickListener(new PlaceorderActivity.5(this));
  }

  public void updateview(String paramString, Double paramDouble)
  {
    this.handler.post(new PlaceorderActivity.6(this, paramString, paramDouble));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.PlaceorderActivity
 * JD-Core Version:    0.6.2
 */