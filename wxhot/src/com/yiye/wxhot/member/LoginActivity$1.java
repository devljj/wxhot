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
import org.json.JSONException;
import org.json.JSONObject;

class LoginActivity$1
  implements View.OnClickListener
{
  LoginActivity$1(LoginActivity paramLoginActivity)
  {
  }

  public void onClick(View paramView)
  {
    LoginActivity.access$0(this.this$0, (EditText)this.this$0.findViewById(2131034311));
    LoginActivity.access$1(this.this$0, (EditText)this.this$0.findViewById(2131034312));
    LoginActivity.access$2(this.this$0, new Netdeal());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("username", LoginActivity.access$3(this.this$0).getText().toString()));
    localArrayList.add(new BasicNameValuePair("password", LoginActivity.access$4(this.this$0).getText().toString()));
    String str1 = LoginActivity.access$5(this.this$0).commonGetData(localArrayList, "/index.php/Api/loginCheck");
    String str2;
    try
    {
      str2 = new JSONObject(str1).getString("loginresult");
      if (str2.equals("1"))
        Toast.makeText(this.this$0.getApplicationContext(), "此手机号不存在！", 0).show();
      else if (str2.equals("2"))
        Toast.makeText(this.this$0.getApplicationContext(), "您输入的密码不正确！", 0).show();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (str2.equals("3"))
    {
      SharedPreferences.Editor localEditor = this.this$0.getSharedPreferences("WuxihotDB", 0).edit();
      localEditor.putString("USERNAME", LoginActivity.access$3(this.this$0).getText().toString());
      localEditor.commit();
      Intent localIntent = new Intent(this.this$0, MainActivity.class);
      this.this$0.startActivity(localIntent);
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.LoginActivity.1
 * JD-Core Version:    0.6.2
 */