package com.yiye.wxhot.member;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.yiye.wxhot.activity.ActivityDetailActivity;
import java.util.List;
import java.util.Map;

class MycreelActivity$3$1
  implements AdapterView.OnItemClickListener
{
  MycreelActivity$3$1(MycreelActivity.3 param3)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(MycreelActivity.3.access$0(this.this$1), ActivityDetailActivity.class);
    localIntent.putExtra("productid", Integer.valueOf(Integer.parseInt(((Map)MycreelActivity.access$1(MycreelActivity.3.access$0(this.this$1)).get(paramInt - 1)).get("activity_id").toString())));
    localIntent.addFlags(67108864);
    MycreelActivity.3.access$0(this.this$1).startActivity(localIntent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MycreelActivity.3.1
 * JD-Core Version:    0.6.2
 */