package com.yiye.wxhot.member;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

class MyOrderActivity$3$2
  implements PullToRefreshBase.OnRefreshListener<ListView>
{
  MyOrderActivity$3$2(MyOrderActivity.3 param3)
  {
  }

  public void onRefresh(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    new MyOrderActivity.GetDataTask(MyOrderActivity.3.access$0(this.this$1), null).execute(new Void[0]);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MyOrderActivity.3.2
 * JD-Core Version:    0.6.2
 */