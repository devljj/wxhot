package com.yiye.wxhot.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FindPwdEnterCodeActivity extends Activity
{
  private TextView checkinbtn = null;
  private String code;
  private FrameLayout container;
  private Button ensureverifycodebtn;
  private Intent intent;
  private String sendtoPhone;
  private EditText verifycodeET;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903114);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText(2131165305);
    this.intent = getIntent();
    this.code = this.intent.getStringExtra("code");
    this.sendtoPhone = this.intent.getStringExtra("sendtoPhone");
    this.verifycodeET = ((EditText)findViewById(2131034377));
    this.ensureverifycodebtn = ((Button)findViewById(2131034378));
    this.ensureverifycodebtn.setOnClickListener(new FindPwdEnterCodeActivity.1(this));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.FindPwdEnterCodeActivity
 * JD-Core Version:    0.6.2
 */