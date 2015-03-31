package com.yiye.wxhot.member;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

class FindPwdEnterCodeActivity$1
  implements View.OnClickListener
{
  FindPwdEnterCodeActivity$1(FindPwdEnterCodeActivity paramFindPwdEnterCodeActivity)
  {
  }

  public void onClick(View paramView)
  {
    String str = FindPwdEnterCodeActivity.access$0(this.this$0).getText().toString();
    if (str.trim().length() == 0)
      Toast.makeText(this.this$0.getApplicationContext(), "请输入验证码！", 0).show();
    while (true)
    {
      return;
      if (!str.equals(FindPwdEnterCodeActivity.access$1(this.this$0)))
      {
        Toast.makeText(this.this$0.getApplicationContext(), "请输入正确的验证码", 0).show();
      }
      else
      {
        Intent localIntent = new Intent(this.this$0, FindPwdConfirmActivity.class);
        localIntent.putExtra("sendtoPhone", FindPwdEnterCodeActivity.access$2(this.this$0));
        this.this$0.startActivity(localIntent);
      }
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.FindPwdEnterCodeActivity.1
 * JD-Core Version:    0.6.2
 */