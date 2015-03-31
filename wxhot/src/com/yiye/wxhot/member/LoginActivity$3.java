package com.yiye.wxhot.member;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class LoginActivity$3
  implements View.OnClickListener
{
  LoginActivity$3(LoginActivity paramLoginActivity)
  {
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, FindPwdActivity.class);
    localIntent.addFlags(67108864);
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.LoginActivity.3
 * JD-Core Version:    0.6.2
 */