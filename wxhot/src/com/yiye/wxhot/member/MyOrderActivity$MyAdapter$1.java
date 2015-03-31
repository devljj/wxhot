package com.yiye.wxhot.member;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.yiye.wxhot.groupon.ChoosePaywayActivity;

class MyOrderActivity$MyAdapter$1
  implements View.OnClickListener
{
  MyOrderActivity$MyAdapter$1(MyOrderActivity.MyAdapter paramMyAdapter, String paramString)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(MyOrderActivity.MyAdapter.access$0(this.this$1), ChoosePaywayActivity.class);
    localIntent.putExtra("orderNo", this.val$orderNoValue);
    MyOrderActivity.MyAdapter.access$0(this.this$1).startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MyOrderActivity.MyAdapter.1
 * JD-Core Version:    0.6.2
 */