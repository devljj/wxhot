package com.yiye.wxhot.member;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.yiye.wxhot.util.Common;
import com.yiye.wxhot.util.Netdeal;
import com.yiye.wxhot.util.ReceiveDemo;
import com.linkage.netmsg.NetMsgclient;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

class RegisterActivity$1
  implements View.OnClickListener
{
  RegisterActivity$1(RegisterActivity paramRegisterActivity)
  {
  }

  public void onClick(View paramView)
  {
    String str1 = RegisterActivity.access$0(this.this$0).getText().toString();
    String str2;
    NetMsgclient localNetMsgclient2;
    String str3;
    String str4;
    if (Common.isMobileNO(str1))
    {
      RegisterActivity.access$1(this.this$0, new Netdeal());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new BasicNameValuePair("username", str1));
      str2 = RegisterActivity.access$2(this.this$0).commonGetData(localArrayList, "/index.php/Api/memberCheck");
      if (str2.equals("0"))
      {
        NetMsgclient localNetMsgclient1 = new NetMsgclient();
        ReceiveDemo localReceiveDemo = new ReceiveDemo();
        localNetMsgclient2 = localNetMsgclient1.initParameters(RegisterActivity.access$3(this.this$0), RegisterActivity.access$4(this.this$0).intValue(), RegisterActivity.access$5(this.this$0), RegisterActivity.access$6(this.this$0), localReceiveDemo);
        str3 = Common.generateCode();
        str4 = "您好，无锡热点注册验证码为：".concat(str3);
      }
    }
    while (true)
    {
      try
      {
        if (localNetMsgclient2.anthenMsg(localNetMsgclient2))
        {
          System.out.println("login sucess");
          System.out.println(localNetMsgclient2.sendMsg(localNetMsgclient2, 0, str1, str4, 1));
        }
        Intent localIntent = new Intent(this.this$0, RegisterEnterCodeActivity.class);
        localIntent.putExtra("code", str3);
        localIntent.putExtra("sendtoPhone", str1);
        this.this$0.startActivity(localIntent);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      if (str2.equals("1"))
      {
        Toast.makeText(this.this$0.getApplicationContext(), "手机号已存在！", 0).show();
        continue;
        Toast.makeText(this.this$0.getApplicationContext(), "请输入正确的手机号码！", 0).show();
      }
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.RegisterActivity.1
 * JD-Core Version:    0.6.2
 */