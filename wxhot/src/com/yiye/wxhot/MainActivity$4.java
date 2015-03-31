package com.yiye.wxhot;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.yiye.wxhot.groupon.GrouponActivity;

class MainActivity$4
  implements View.OnClickListener
{
  MainActivity$4(MainActivity paramMainActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, GrouponActivity.class);
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.MainActivity.4
 * JD-Core Version:    0.6.2
 */