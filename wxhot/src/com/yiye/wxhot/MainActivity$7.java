package com.yiye.wxhot;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.yiye.wxhot.member.LoginActivity;
import com.yiye.wxhot.member.MemberActivity;

class MainActivity$7
  implements View.OnClickListener
{
  MainActivity$7(MainActivity paramMainActivity)
  {
  }

  public void onClick(View paramView)
  {
    if (MainActivity.access$2(this.this$0).intValue() != 3)
    {
      MainActivity.access$3(this.this$0)[MainActivity.access$2(this.this$0).intValue()].setImageResource(MainActivity.access$4(this.this$0)[MainActivity.access$2(this.this$0).intValue()].intValue());
      MainActivity.access$5(this.this$0)[MainActivity.access$2(this.this$0).intValue()].setTextColor(this.this$0.getResources().getColor(2131296407));
      MainActivity.access$3(this.this$0)[3].setImageResource(MainActivity.access$6(this.this$0)[3].intValue());
      MainActivity.access$5(this.this$0)[3].setTextColor(this.this$0.getResources().getColor(2131296406));
      MainActivity.access$7(this.this$0, Integer.valueOf(3));
    }
    if (this.this$0.getSharedPreferences("WuxihotDB", 0).getString("USERNAME", "").length() > 0)
    {
      MainActivity.access$8(this.this$0).removeAllViews();
      MainActivity.access$8(this.this$0).addView(this.this$0.getLocalActivityManager().startActivity("Module1", new Intent(this.this$0, MemberActivity.class).addFlags(67108864)).getDecorView());
    }
    while (true)
    {
      return;
      Intent localIntent = new Intent(this.this$0, LoginActivity.class);
      this.this$0.startActivity(localIntent);
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.MainActivity.7
 * JD-Core Version:    0.6.2
 */