package com.yiye.wxhot.member;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class MemberActivity$2
  implements View.OnClickListener
{
  MemberActivity$2(MemberActivity paramMemberActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, MyAccountActivity.class);
    localIntent.addFlags(67108864);
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MemberActivity.2
 * JD-Core Version:    0.6.2
 */