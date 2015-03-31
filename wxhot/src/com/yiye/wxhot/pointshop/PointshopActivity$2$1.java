package com.yiye.wxhot.pointshop;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.List;
import java.util.Map;

class PointshopActivity$2$1
  implements AdapterView.OnItemClickListener
{
  PointshopActivity$2$1(PointshopActivity.2 param2)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(PointshopActivity.2.access$0(this.this$1), PointshopDetailActivity.class);
    localIntent.putExtra("productid", Integer.valueOf(Integer.parseInt(((Map)PointshopActivity.access$3(PointshopActivity.2.access$0(this.this$1)).get(paramInt - 1)).get("productid").toString())));
    localIntent.addFlags(67108864);
    PointshopActivity.2.access$0(this.this$1).startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.pointshop.PointshopActivity.2.1
 * JD-Core Version:    0.6.2
 */