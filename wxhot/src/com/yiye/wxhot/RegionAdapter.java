package com.yiye.wxhot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.yiye.wxhot.common.Region;
import java.util.List;

public class RegionAdapter extends BaseAdapter
{
  private Context mContext;
  private List<Region> mList;

  public RegionAdapter(Context paramContext, List<Region> paramList)
  {
    this.mContext = paramContext;
    this.mList = paramList;
  }

  public int getCount()
  {
    return this.mList.size();
  }

  public Object getItem(int paramInt)
  {
    return this.mList.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2130903111, null);
    if (localView != null)
      ((TextView)localView.findViewById(2131034366)).setText(((Region)this.mList.get(paramInt)).getRegionName());
    return localView;
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.RegionAdapter
 * JD-Core Version:    0.6.2
 */