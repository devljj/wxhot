package com.yiye.wxhot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConnectbleActivity extends Activity
{
  private Button connectbtn = null;
  private Button notconnectbtn = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903077);
    this.connectbtn = ((Button)findViewById(2131034275));
    this.connectbtn.setOnClickListener(new ConnectbleActivity$1(this));
  }
  
  
  class ConnectbleActivity$1 implements View.OnClickListener
  {
  	ConnectbleActivity paramConnectbleActivity;
    ConnectbleActivity$1(ConnectbleActivity paramConnectbleActivity)
    {
  	  this.paramConnectbleActivity = paramConnectbleActivity;
    }

    public void onClick(View paramView)
    {
      Intent localIntent = new Intent(this.paramConnectbleActivity, FullscreenActivity.class);
      this.paramConnectbleActivity.startActivity(localIntent);
    }
  }
  
}

