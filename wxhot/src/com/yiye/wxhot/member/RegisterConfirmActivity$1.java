package com.yiye.wxhot.member;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.yiye.wxhot.MainActivity;
import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

class RegisterConfirmActivity$1
  implements View.OnClickListener
{
  RegisterConfirmActivity$1(RegisterConfirmActivity paramRegisterConfirmActivity)
  {
  }

  public void onClick(View paramView)
  {
    RegisterConfirmActivity.access$1(this.this$0, RegisterConfirmActivity.access$0(this.this$0).getText().toString().trim());
    RegisterConfirmActivity.access$3(this.this$0, RegisterConfirmActivity.access$2(this.this$0).getText().toString().trim());
    if (RegisterConfirmActivity.access$4(this.this$0).length() == 0)
      Toast.makeText(this.this$0.getApplicationContext(), "密码不能为空！", 0).show();
    while (true)
    {
      return;
      if (RegisterConfirmActivity.access$5(this.this$0).length() == 0)
      {
        Toast.makeText(this.this$0.getApplicationContext(), "请输入确认密码", 0).show();
      }
      else if (!RegisterConfirmActivity.access$4(this.this$0).equals(RegisterConfirmActivity.access$5(this.this$0)))
      {
        Toast.makeText(this.this$0.getApplicationContext(), "两次输入的密码不一致！", 0).show();
      }
      else
      {
        RegisterConfirmActivity.access$6(this.this$0, new Netdeal());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("username", RegisterConfirmActivity.access$7(this.this$0)));
        localArrayList.add(new BasicNameValuePair("password", RegisterConfirmActivity.access$4(this.this$0)));
        if (RegisterConfirmActivity.access$8(this.this$0).commonGetData(localArrayList, "/index.php/Api/addMember").equals("1"))
        {
          Toast.makeText(this.this$0.getApplicationContext(), "恭喜您，注册成功！", 0).show();
          SharedPreferences.Editor localEditor = this.this$0.getSharedPreferences("WuxihotDB", 0).edit();
          localEditor.putString("USERNAME", RegisterConfirmActivity.access$4(this.this$0));
          localEditor.commit();
          Intent localIntent = new Intent(this.this$0, MainActivity.class);
          localIntent.addFlags(67108864);
          this.this$0.startActivity(localIntent);
        }
      }
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.RegisterConfirmActivity.1
 * JD-Core Version:    0.6.2
 */