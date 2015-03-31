package com.yiye.wxhot;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class MainActivity$18
  implements View.OnClickListener
{
  MainActivity$18(MainActivity paramMainActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, HotActivity.class);
    localIntent.putExtra("title", "1元看电影");
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.MainActivity.18
 * JD-Core Version:    0.6.2
 */