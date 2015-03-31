package com.yiye.wxhot.member;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.yiye.wxhot.MainActivity;

class MyAccountActivity$1
  implements View.OnClickListener
{
  MyAccountActivity$1(MyAccountActivity paramMyAccountActivity)
  {
  }

  public void onClick(View paramView)
  {
    SharedPreferences.Editor localEditor = this.this$0.getSharedPreferences("WuxihotDB", 0).edit();
    localEditor.putString("USERNAME", "");
    localEditor.commit();
    Intent localIntent = new Intent(this.this$0, MainActivity.class);
    this.this$0.startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MyAccountActivity.1
 * JD-Core Version:    0.6.2
 */