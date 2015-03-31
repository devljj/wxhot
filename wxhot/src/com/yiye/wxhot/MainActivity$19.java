package com.yiye.wxhot;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class MainActivity$19
  implements View.OnClickListener
{
  MainActivity$19(MainActivity paramMainActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, SearchActivity.class);
    localIntent.putExtra("activity", "main");
    this.this$0.startActivity(localIntent);
    this.this$0.overridePendingTransition(2130968587, 2130968586);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.MainActivity.19
 * JD-Core Version:    0.6.2
 */