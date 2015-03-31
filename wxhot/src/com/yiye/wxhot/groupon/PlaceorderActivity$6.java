package com.yiye.wxhot.groupon;

import android.widget.TextView;

class PlaceorderActivity$6
  implements Runnable
{
  PlaceorderActivity$6(PlaceorderActivity paramPlaceorderActivity, String paramString, Double paramDouble)
  {
  }

  public void run()
  {
    PlaceorderActivity.access$9(this.this$0).setText(this.val$title);
    PlaceorderActivity.access$10(this.this$0).setText(String.valueOf(this.val$price));
    PlaceorderActivity.access$7(this.this$0).setText(String.valueOf(this.val$price));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.PlaceorderActivity.6
 * JD-Core Version:    0.6.2
 */