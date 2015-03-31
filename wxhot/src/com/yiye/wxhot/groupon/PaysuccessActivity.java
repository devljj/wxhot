package com.yiye.wxhot.groupon;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PaysuccessActivity extends Activity
{
  private TextView checkinbtn = null;
  private FrameLayout container;
  private LinearLayout topwrap = null;
  private Button viewGroupon;
  private Button viewMyOrder;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903104);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("支付成功");
    this.viewMyOrder = ((Button)findViewById(2131034351));
    this.viewGroupon = ((Button)findViewById(2131034352));
    this.viewMyOrder.setOnClickListener(new PaysuccessActivity.1(this));
    this.viewGroupon.setOnClickListener(new PaysuccessActivity.2(this));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.PaysuccessActivity
 * JD-Core Version:    0.6.2
 */