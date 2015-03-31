package com.yiye.wxhot.pointshop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.yiye.wxhot.member.CostlistActivity;
import com.yiye.wxhot.member.LoginActivity;
import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

class PointshopDetailActivity$2
  implements View.OnClickListener
{
  PointshopDetailActivity$2(PointshopDetailActivity paramPointshopDetailActivity)
  {
  }

  public void onClick(View paramView)
  {
    String str = this.this$0.getSharedPreferences("WuxihotDB", 0).getString("USERNAME", "");
    if (str.length() > 0)
    {
      ArrayList localArrayList1 = new ArrayList();
      localArrayList1.add(new BasicNameValuePair("username", str));
      Integer localInteger = Integer.valueOf(Integer.parseInt(PointshopDetailActivity.access$0(this.this$0).commonGetData(localArrayList1, "/index.php/Api/getCatFood")));
      if (PointshopDetailActivity.access$1(this.this$0).intValue() > localInteger.intValue())
        Toast.makeText(this.this$0.getApplicationContext(), "猫粮不足", 0).show();
    }
    while (true)
    {
      return;
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(new BasicNameValuePair("username", str));
      localArrayList2.add(new BasicNameValuePair("product_id", String.valueOf(PointshopDetailActivity.access$2(this.this$0))));
      if (PointshopDetailActivity.access$0(this.this$0).commonGetData(localArrayList2, "/index.php/Api/exchangeSave").equals("1"))
      {
        Intent localIntent1 = new Intent(this.this$0, CostlistActivity.class);
        this.this$0.startActivity(localIntent1);
        continue;
        Intent localIntent2 = new Intent(this.this$0, LoginActivity.class);
        this.this$0.startActivity(localIntent2);
      }
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.pointshop.PointshopDetailActivity.2
 * JD-Core Version:    0.6.2
 */