package com.yiye.wxhot.pointshop;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter.ViewBinder;

public class CustomViewBinder implements SimpleAdapter.ViewBinder
{
  public boolean setViewValue(View paramView, Object paramObject, String paramString)
  {
    if ((paramView instanceof ImageView & paramObject instanceof Bitmap))
      ((ImageView)paramView).setImageBitmap((Bitmap)paramObject);
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

