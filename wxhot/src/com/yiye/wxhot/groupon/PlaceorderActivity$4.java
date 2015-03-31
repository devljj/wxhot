package com.yiye.wxhot.groupon;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

class PlaceorderActivity$4
  implements View.OnClickListener
{
  PlaceorderActivity$4(PlaceorderActivity paramPlaceorderActivity)
  {
  }

  public void onClick(View paramView)
  {
    Integer localInteger = Integer.valueOf(1 + Integer.valueOf(Integer.parseInt(PlaceorderActivity.access$5(this.this$0).getText().toString())).intValue());
    PlaceorderActivity.access$6(this.this$0, Double.valueOf(localInteger.intValue() * PlaceorderActivity.access$4(this.this$0).doubleValue()));
    PlaceorderActivity.access$5(this.this$0).setText(localInteger.toString());
    PlaceorderActivity.access$7(this.this$0).setText(String.valueOf(PlaceorderActivity.access$8(this.this$0)));
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.PlaceorderActivity.4
 * JD-Core Version:    0.6.2
 */