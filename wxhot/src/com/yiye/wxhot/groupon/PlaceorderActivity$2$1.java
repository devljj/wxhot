package com.yiye.wxhot.groupon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.widget.EditText;
import com.yiye.wxhot.util.Common;
import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

class PlaceorderActivity$2$1
  implements Runnable
{
  PlaceorderActivity$2$1(PlaceorderActivity.2 param2)
  {
  }

  public void run()
  {
    String str1 = PlaceorderActivity.2.access$0(this.this$1).getSharedPreferences("WuxihotDB", 0).getString("USERNAME", "");
    String str2 = PlaceorderActivity.access$5(PlaceorderActivity.2.access$0(this.this$1)).getText().toString().trim();
    String str3 = Common.generateOrderNo();
    PlaceorderActivity.access$0(PlaceorderActivity.2.access$0(this.this$1), new Netdeal());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("groupon_id", String.valueOf(PlaceorderActivity.access$1(PlaceorderActivity.2.access$0(this.this$1)))));
    localArrayList.add(new BasicNameValuePair("member_name", str1));
    localArrayList.add(new BasicNameValuePair("totalNums", str2));
    localArrayList.add(new BasicNameValuePair("orderNo", str3));
    PlaceorderActivity.access$2(PlaceorderActivity.2.access$0(this.this$1)).commonGetData(localArrayList, "/index.php/Api/placeOrder");
    Intent localIntent = new Intent(PlaceorderActivity.2.access$0(this.this$1), ChoosePaywayActivity.class);
    localIntent.addFlags(67108864);
    PlaceorderActivity.2.access$0(this.this$1).startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.PlaceorderActivity.2.1
 * JD-Core Version:    0.6.2
 */