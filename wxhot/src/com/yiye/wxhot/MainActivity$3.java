package com.yiye.wxhot;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.yiye.wxhot.pointshop.PointshopActivity;

class MainActivity$3
  implements View.OnClickListener
{
  MainActivity$3(MainActivity paramMainActivity)
  {
  }

  public void onClick(View paramView)
  {
    if (MainActivity.access$2(this.this$0).intValue() != 1)
    {
      MainActivity.access$3(this.this$0)[MainActivity.access$2(this.this$0).intValue()].setImageResource(MainActivity.access$4(this.this$0)[MainActivity.access$2(this.this$0).intValue()].intValue());
      MainActivity.access$5(this.this$0)[MainActivity.access$2(this.this$0).intValue()].setTextColor(this.this$0.getResources().getColor(2131296407));
      MainActivity.access$3(this.this$0)[1].setImageResource(MainActivity.access$6(this.this$0)[1].intValue());
      MainActivity.access$5(this.this$0)[1].setTextColor(this.this$0.getResources().getColor(2131296406));
      MainActivity.access$7(this.this$0, Integer.valueOf(1));
    }
    MainActivity.access$8(this.this$0).removeAllViews();
    MainActivity.access$8(this.this$0).addView(this.this$0.getLocalActivityManager().startActivity("Module1", new Intent(this.this$0, PointshopActivity.class).addFlags(67108864)).getDecorView());
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.MainActivity.3
 * JD-Core Version:    0.6.2
 */