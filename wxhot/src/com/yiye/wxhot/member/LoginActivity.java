package com.yiye.wxhot.member;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.yiye.wxhot.util.Netdeal;

public class LoginActivity extends Activity
{
  private TextView checkinbtn = null;
  private TextView findpwdbtn;
  private Button loginbtn;
  private EditText loginphone;
  private EditText loginpwd;
  private Netdeal netdeal;
  private TextView registerbtn;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903091);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("会员登录");
    this.loginbtn = ((Button)findViewById(2131034313));
    this.registerbtn = ((TextView)findViewById(2131034314));
    this.findpwdbtn = ((TextView)findViewById(2131034315));
    this.loginbtn.setOnClickListener(new LoginActivity.1(this));
    this.registerbtn.setOnClickListener(new LoginActivity.2(this));
    this.findpwdbtn.setOnClickListener(new LoginActivity.3(this));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.LoginActivity
 * JD-Core Version:    0.6.2
 */