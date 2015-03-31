package com.yiye.wxhot.member;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.yiye.wxhot.groupon.GroupondetailActivity;
import java.util.List;
import java.util.Map;

class MyOrderActivity$3$1
  implements AdapterView.OnItemClickListener
{
  MyOrderActivity$3$1(MyOrderActivity.3 param3)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(MyOrderActivity.3.access$0(this.this$1), GroupondetailActivity.class);
    localIntent.putExtra("productid", Integer.valueOf(Integer.parseInt(((Map)MyOrderActivity.access$1(MyOrderActivity.3.access$0(this.this$1)).get(paramInt)).get("groupon_id").toString())));
    localIntent.addFlags(67108864);
    MyOrderActivity.3.access$0(this.this$1).startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MyOrderActivity.3.1
 * JD-Core Version:    0.6.2
 */