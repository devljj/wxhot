package com.yiye.wxhot;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class MainActivity$17
  implements View.OnClickListener
{
  MainActivity$17(MainActivity paramMainActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, HotActivity.class);
    localIntent.putExtra("title", "品质粤菜");
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.MainActivity.17
 * JD-Core Version:    0.6.2
 */