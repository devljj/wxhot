package com.yiye.wxhot.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.yiye.wxhot.util.Netdeal;

public class RegisterConfirmActivity extends Activity
{
  private TextView checkinbtn = null;
  private FrameLayout container;
  private Button ensureregisterbtn;
  private EditText loginpwd;
  private EditText loginpwd2;
  private String loginpwd2Value;
  private String loginpwdValue;
  private Netdeal netdeal;
  private String sendtoPhone;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903113);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("会员注册");
    this.loginpwd = ((EditText)findViewById(2131034312));
    this.loginpwd2 = ((EditText)findViewById(2131034374));
    this.sendtoPhone = getIntent().getStringExtra("sendtoPhone");
    this.ensureregisterbtn = ((Button)findViewById(2131034375));
    this.ensureregisterbtn.setOnClickListener(new RegisterConfirmActivity.1(this));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.RegisterConfirmActivity
 * JD-Core Version:    0.6.2
 */