package com.yiye.wxhot.member;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MyAccountActivity extends Activity
{
  private FrameLayout container;
  private Button logoutbtn;
  private LinearLayout topwrap;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903096);
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.logoutbtn = ((Button)findViewById(2131034339));
    this.logoutbtn.setOnClickListener(new MyAccountActivity.1(this));
    this.topwrap.setOnClickListener(new MyAccountActivity.2(this));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MyAccountActivity
 * JD-Core Version:    0.6.2
 */