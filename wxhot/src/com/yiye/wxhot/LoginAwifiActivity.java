package com.yiye.wxhot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class LoginAwifiActivity extends Activity
{
  private Button loginawifi = null;
  private RelativeLayout topwrap = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903092);
    this.loginawifi = ((Button)findViewById(2131034316));
    this.loginawifi.setOnClickListener(new LoginAwifiActivity$1(this));
  }
  
  class LoginAwifiActivity$1 implements View.OnClickListener
  {
  	LoginAwifiActivity paramLoginAwifiActivity;
    LoginAwifiActivity$1(LoginAwifiActivity paramLoginAwifiActivity)
    {
  	  this.paramLoginAwifiActivity = paramLoginAwifiActivity;
    }

    public void onClick(View paramView)
    {
      Intent localIntent = new Intent(this.paramLoginAwifiActivity, ConnectbleActivity.class);
      this.paramLoginAwifiActivity.startActivity(localIntent);
    }
  }
  
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.LoginAwifiActivity
 * JD-Core Version:    0.6.2
 */