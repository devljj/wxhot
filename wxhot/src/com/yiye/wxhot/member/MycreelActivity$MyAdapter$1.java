package com.yiye.wxhot.member;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.yiye.wxhot.activity.CouponActivity;

class MycreelActivity$MyAdapter$1
  implements View.OnClickListener
{
  MycreelActivity$MyAdapter$1(MycreelActivity.MyAdapter paramMyAdapter, String paramString1, String paramString2)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(MycreelActivity.MyAdapter.access$0(this.this$1), CouponActivity.class);
    localIntent.putExtra("couponcode", this.val$couponcode1);
    localIntent.putExtra("productid", String.valueOf(this.val$productid1));
    MycreelActivity.MyAdapter.access$0(this.this$1).startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MycreelActivity.MyAdapter.1
 * JD-Core Version:    0.6.2
 */