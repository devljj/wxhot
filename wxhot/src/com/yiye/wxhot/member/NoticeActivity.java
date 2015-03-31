package com.yiye.wxhot.member;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoticeActivity extends Activity
{
  private TextView checkinbtn = null;
  private FrameLayout container;
  private TextView noticeid1 = null;
  private TextView noticeid2 = null;
  private LinearLayout topwrap = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903101);
    this.noticeid1 = ((TextView)findViewById(2131034341));
    this.noticeid2 = ((TextView)findViewById(2131034342));
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("消息提醒");
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.noticeid1.setOnClickListener(new NoticeActivity.1(this));
    this.noticeid2.setOnClickListener(new NoticeActivity.2(this));
    this.topwrap.setOnClickListener(new NoticeActivity.3(this));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.NoticeActivity
 * JD-Core Version:    0.6.2
 */