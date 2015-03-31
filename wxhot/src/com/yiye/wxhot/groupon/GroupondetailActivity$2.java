package com.yiye.wxhot.groupon;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class GroupondetailActivity$2
  implements View.OnClickListener
{
  GroupondetailActivity$2(GroupondetailActivity paramGroupondetailActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, PlaceorderActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("groupon_id", GroupondetailActivity.access$1(this.this$0));
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.GroupondetailActivity.2
 * JD-Core Version:    0.6.2
 */