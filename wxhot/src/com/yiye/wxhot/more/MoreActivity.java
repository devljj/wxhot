package com.yiye.wxhot.more;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class MoreActivity extends Activity
{
  private TextView checkinbtn = null;
  private Context context;
  private ImageView return1 = null;
  private LinearLayout sharebtn;

  private void showShare()
  {
    ShareSDK.initSDK(this.context);
    OnekeyShare localOnekeyShare = new OnekeyShare();
    localOnekeyShare.setNotification(2130837642, getString(2131165286));
    localOnekeyShare.setText("我是分享文本");
    localOnekeyShare.setImageUrl("http://f1.sharesdk.cn/imgs/2014/05/21/oESpJ78_533x800.jpg");
    localOnekeyShare.show(this.context);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903095);
    this.context = this;
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText(2131165303);
    this.return1 = ((ImageView)findViewById(2131034270));
    this.return1.setVisibility(8);
    this.sharebtn = ((LinearLayout)findViewById(2131034338));
    this.sharebtn.setOnClickListener(new MoreActivity.1(this));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.more.MoreActivity
 * JD-Core Version:    0.6.2
 */