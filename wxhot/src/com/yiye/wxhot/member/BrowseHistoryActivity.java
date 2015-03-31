package com.yiye.wxhot.member;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BrowseHistoryActivity extends Activity
{
  private TextView checkinbtn = null;
  private FrameLayout container;
  private LinearLayout topwrap = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903074);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText(2131165304);
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.topwrap.setOnClickListener(new BrowseHistoryActivity1(this));
  }
  
  class BrowseHistoryActivity1  implements View.OnClickListener{
	  BrowseHistoryActivity paramBrowseHistoryActivity;
	  BrowseHistoryActivity1(BrowseHistoryActivity paramBrowseHistoryActivity){
		  this.paramBrowseHistoryActivity = paramBrowseHistoryActivity;
	  }
	  public void onClick(View paramView)
	  {
	    this.paramBrowseHistoryActivity.finish();
	  }
}
}
