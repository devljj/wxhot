package com.yiye.wxhot.pointshop;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

class PointshopActivity$2$2 implements PullToRefreshBase.OnRefreshListener<ListView>
{
  PointshopActivity$2$2(PointshopActivity.2 param2)
  {
  }

  public void onRefresh(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    new PointshopActivity.GetDataTask(PointshopActivity.2.access$0(this.this$1), null).execute(new Void[0]);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.pointshop.PointshopActivity.2.2
 * JD-Core Version:    0.6.2
 */