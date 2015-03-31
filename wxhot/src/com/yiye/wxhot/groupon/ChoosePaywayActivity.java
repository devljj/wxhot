package com.yiye.wxhot.groupon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChoosePaywayActivity extends Activity {
	private TextView checkinbtn = null;
	private FrameLayout container;
	private Button gotopaysuccess;
	private LinearLayout topwrap = null;

	public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903075);
    this.gotopaysuccess = ((Button)findViewById(2131034273));
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("选择支付方式");
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.gotopaysuccess.setOnClickListener(new ChoosePaywayActivity$1(this));
    this.topwrap.setOnClickListener(new ChoosePaywayActivity$2(this));
  }

	class ChoosePaywayActivity$1 implements View.OnClickListener{
		ChoosePaywayActivity paramChoosePaywayActivity;
		ChoosePaywayActivity$1(ChoosePaywayActivity paramChoosePaywayActivity){
			this.paramChoosePaywayActivity = paramChoosePaywayActivity;
	   }
		public void onClick(View paramView) {
			Intent localIntent = new Intent(this.paramChoosePaywayActivity, PaysuccessActivity.class);
			localIntent.addFlags(67108864);
			this.paramChoosePaywayActivity.startActivity(localIntent);
		}
	}
	
	
	
	class ChoosePaywayActivity$2  implements View.OnClickListener {
		ChoosePaywayActivity paramChoosePaywayActivity;
	  ChoosePaywayActivity$2(ChoosePaywayActivity paramChoosePaywayActivity)
	  {
		  this.paramChoosePaywayActivity = paramChoosePaywayActivity;
	  }

	  public void onClick(View paramView)
	  {
	    this.paramChoosePaywayActivity.finish();
	  }
	}
}
