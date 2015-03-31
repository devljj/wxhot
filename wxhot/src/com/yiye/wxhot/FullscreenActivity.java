package com.yiye.wxhot;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.yiye.wxhot.util.Common;
import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FullscreenActivity extends Activity
{
  private Button gotohomepage;
  private Handler handler = new Handler();
  private Netdeal netdeal;
  private LinearLayout startfullpic;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903082);
    this.startfullpic = ((LinearLayout)findViewById(2131034288));
    this.netdeal = new Netdeal();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("adsclassid", "2"));
    String str = this.netdeal.commonGetData(localArrayList, "/index.php/Api/getFullscreenAds");
    this.startfullpic.setBackgroundDrawable(new BitmapDrawable(Common.getHttpBitmap(str)));
    this.gotohomepage = ((Button)findViewById(2131034289));
    this.gotohomepage.setOnClickListener(new FullscreenActivity$1(this));
  }
  
  class FullscreenActivity$1 implements View.OnClickListener
  {
     FullscreenActivity paramFullscreenActivity;
    FullscreenActivity$1(FullscreenActivity paramFullscreenActivity)
    {
  	  this.paramFullscreenActivity = paramFullscreenActivity;
    }

    public void onClick(View paramView)
    {
      Intent localIntent = new Intent(this.paramFullscreenActivity, MainActivity.class);
      this.paramFullscreenActivity.startActivity(localIntent);
    }
  }
  
}

