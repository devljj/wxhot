package com.yiye.wxhot.groupon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yiye.wxhot.util.Netdeal;

public class GroupondetailActivity extends Activity
{
  private TextView checkinbtn = null;
  private FrameLayout container;
  private Integer groupon_id;
  private TextView groupon_price;
  private TextView groupon_title;
  private Handler handler = new Handler();
  private Netdeal netdeal;
  private TextView toplaceorder = null;
  private LinearLayout topwrap = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903084);
    this.toplaceorder = ((TextView)findViewById(2131034293));
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.groupon_title = ((TextView)findViewById(2131034291));
    this.groupon_price = ((TextView)findViewById(2131034292));
    this.checkinbtn.setText("优惠详情");
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.groupon_id = Integer.valueOf(getIntent().getIntExtra("groupon_id", 1));
    new Thread(new GroupondetailActivity.1(this)).start();
    this.toplaceorder.setOnClickListener(new GroupondetailActivity.2(this));
    this.topwrap.setOnClickListener(new GroupondetailActivity.3(this));
  }

  public void updateView(String paramString, Double paramDouble)
  {
    this.handler.post(new GroupondetailActivity.4(this, paramString, paramDouble));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.GroupondetailActivity
 * JD-Core Version:    0.6.2
 */