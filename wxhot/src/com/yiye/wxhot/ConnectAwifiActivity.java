package com.yiye.wxhot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConnectAwifiActivity extends Activity
{
  private Button connectbtn = null;
  private Button notconnectbtn = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903076);
    this.notconnectbtn = ((Button)findViewById(2131034276));
    this.connectbtn = ((Button)findViewById(2131034275));
    this.notconnectbtn.setOnClickListener(new ConnectAwifiActivity$1(this));
    this.connectbtn.setOnClickListener(new ConnectAwifiActivity$2(this));
  }
  
  
  class ConnectAwifiActivity$1 implements View.OnClickListener {
		ConnectAwifiActivity paramConnectAwifiActivity;
	  ConnectAwifiActivity$1(ConnectAwifiActivity paramConnectAwifiActivity)
	  {
		  this.paramConnectAwifiActivity = paramConnectAwifiActivity;
	  }

	  public void onClick(View paramView)
	  {
	    this.paramConnectAwifiActivity.finish();
	  }
	}
  
  class ConnectAwifiActivity$2 implements View.OnClickListener{
		ConnectAwifiActivity paramConnectAwifiActivity;
	  ConnectAwifiActivity$2(ConnectAwifiActivity paramConnectAwifiActivity)
	  {
		  this.paramConnectAwifiActivity = paramConnectAwifiActivity;
	  }

	  public void onClick(View paramView)
	  {
	    Intent localIntent = new Intent(this.paramConnectAwifiActivity, LoginAwifiActivity.class);
	    this.paramConnectAwifiActivity.startActivity(localIntent);
	  }
	}
  
  
}

