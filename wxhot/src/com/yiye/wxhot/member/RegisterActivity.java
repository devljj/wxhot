package com.yiye.wxhot.member;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yiye.wxhot.util.Netdeal;

public class RegisterActivity extends Activity
{
  private TextView checkinbtn = null;
  private Button getverifycodebtn;
  private String ipAddress = "202.102.41.101";
  private Netdeal netdeal;
  private String password = "123654";
  private Integer port = Integer.valueOf(9005);
  private LinearLayout registerContent;
  private EditText registerphoneET;
  private String username = "0510C00066828";

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903112);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("会员注册");
    this.registerphoneET = ((EditText)findViewById(2131034371));
    this.getverifycodebtn = ((Button)findViewById(2131034372));
    this.getverifycodebtn.setOnClickListener(new RegisterActivity.1(this));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.RegisterActivity
 * JD-Core Version:    0.6.2
 */