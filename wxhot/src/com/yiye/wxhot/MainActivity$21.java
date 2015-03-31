package com.yiye.wxhot;

import android.widget.ImageView;
import com.yiye.wxhot.util.Common;

class MainActivity$21
  implements Runnable
{
  MainActivity$21(MainActivity paramMainActivity, String paramString)
  {
  }

  public void run()
  {
    MainActivity.access$10(this.this$0).setImageBitmap(Common.getHttpBitmap(this.val$IMAGE_URL));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.MainActivity.21
 * JD-Core Version:    0.6.2
 */