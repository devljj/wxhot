package com.yiye.wxhot.groupon;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class PaysuccessActivity$2
  implements View.OnClickListener
{
  PaysuccessActivity$2(PaysuccessActivity paramPaysuccessActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, GrouponActivity.class);
    localIntent.addFlags(67108864);
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.PaysuccessActivity.2
 * JD-Core Version:    0.6.2
 */