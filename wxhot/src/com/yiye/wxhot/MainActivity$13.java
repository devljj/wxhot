package com.yiye.wxhot;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.yiye.wxhot.activity.ActivityListActivity;

class MainActivity$13
  implements View.OnClickListener
{
  MainActivity$13(MainActivity paramMainActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, ActivityListActivity.class);
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.MainActivity.13
 * JD-Core Version:    0.6.2
 */