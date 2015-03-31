package com.yiye.wxhot.member;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoticedetailActivity extends Activity
{
  private TextView checkinbtn = null;
  private FrameLayout container;
  private LinearLayout topwrap = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903102);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("消息详情");
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.topwrap.setOnClickListener(new NoticedetailActivity.1(this));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.NoticedetailActivity
 * JD-Core Version:    0.6.2
 */