package com.yiye.wxhot.groupon;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.yiye.wxhot.member.MyOrderActivity;

class PaysuccessActivity$1
  implements View.OnClickListener
{
  PaysuccessActivity$1(PaysuccessActivity paramPaysuccessActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, MyOrderActivity.class);
    localIntent.addFlags(67108864);
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.PaysuccessActivity.1
 * JD-Core Version:    0.6.2
 */