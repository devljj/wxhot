package com.yiye.wxhot.groupon;

import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

class GroupondetailActivity$1
  implements Runnable
{
  GroupondetailActivity$1(GroupondetailActivity paramGroupondetailActivity)
  {
  }

  public void run()
  {
    GroupondetailActivity.access$0(this.this$0, new Netdeal());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("groupon_id", String.valueOf(GroupondetailActivity.access$1(this.this$0))));
    String str1 = GroupondetailActivity.access$2(this.this$0).commonGetData(localArrayList, "/index.php/Api/getGrouponProduct");
    try
    {
      JSONObject localJSONObject = new JSONObject(str1).getJSONObject("grouponproduct");
      String str2 = localJSONObject.getString("groupon_title");
      Double localDouble = Double.valueOf(localJSONObject.getDouble("groupon_price"));
      this.this$0.updateView(str2, localDouble);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.groupon.GroupondetailActivity.1
 * JD-Core Version:    0.6.2
 */