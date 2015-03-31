package com.yiye.wxhot;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class BigadsActivity extends ActivityGroup
  implements GestureDetector.OnGestureListener
{
  private static final String TAG = "BigadsActivity";
  private GestureDetector detector;
  Animation leftInAnimation;
  Animation leftOutAnimation;
  Animation rightInAnimation;
  Animation rightOutAnimation;
  private ViewFlipper viewFlipper;

  private ImageView getImageView(int paramInt)
  {
    ImageView localImageView = new ImageView(this);
    localImageView.setImageResource(paramInt);
    return localImageView;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903073);
    this.viewFlipper = ((ViewFlipper)findViewById(2131034272));
    this.detector = new GestureDetector(this);
    this.viewFlipper.addView(getImageView(2130837607));
    this.viewFlipper.addView(getImageView(2130837608));
    this.viewFlipper.addView(getImageView(2130837609));
    LocalActivityManager localLocalActivityManager = getLocalActivityManager();
    this.viewFlipper.addView(localLocalActivityManager.startActivity("", new Intent(this, ConnectbleActivity.class)).getDecorView());
    this.leftInAnimation = AnimationUtils.loadAnimation(this, 2130968583);
    this.leftOutAnimation = AnimationUtils.loadAnimation(this, 2130968584);
    this.rightInAnimation = AnimationUtils.loadAnimation(this, 2130968589);
    this.rightOutAnimation = AnimationUtils.loadAnimation(this, 2130968590);
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    Log.i("BigadsActivity", "e1=" + paramMotionEvent1.getX() + " e2=" + paramMotionEvent2.getX() + " e1-e2=" + (paramMotionEvent1.getX() - paramMotionEvent2.getX()));
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 120.0F)
    {
      this.viewFlipper.setInAnimation(this.leftInAnimation);
      this.viewFlipper.setOutAnimation(this.leftOutAnimation);
      this.viewFlipper.showNext();
    }
    while (true)
    {
    
      if (paramMotionEvent1.getX() - paramMotionEvent2.getY() < -120.0F)
      {
        this.viewFlipper.setInAnimation(this.rightInAnimation);
        this.viewFlipper.setOutAnimation(this.rightOutAnimation);
        this.viewFlipper.showPrevious();
      }
      else
      {
        bool = false;
      }
      return bool;
    }
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.detector.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.BigadsActivity
 * JD-Core Version:    0.6.2
 */