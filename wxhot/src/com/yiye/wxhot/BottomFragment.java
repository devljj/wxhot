package com.yiye.wxhot;

import com.yiye.wxhot.member.MemberActivity;
import com.yiye.wxhot.more.MoreActivity;
import com.yiye.wxhot.pointshop.PointshopActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class BottomFragment extends Fragment
{
  private ImageView gotogroupon;
  private TextView gotogroupontv;
  private ImageView gotohome;
  private TextView gotohometv;
  private ImageView[] gotoimg = new ImageView[5];
  private ImageView gotomemberhome;
  private TextView gotomemberhometv;
  private ImageView gotomore;
  private TextView gotomoretv;
  private ImageView gotopointshop;
  private TextView gotopointshoptv;
  private TextView[] gototv = new TextView[5];
  private LinearLayout groupon;
  private LinearLayout homepage;
  private LinearLayout membercenter;
  private LinearLayout more;
  private LinearLayout pointshop;
  private Integer[] resblack = new Integer[5];
  private Integer[] resred = new Integer[5];
  private String state;

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903070, paramViewGroup, false);
    this.gotohome = ((ImageView)localView.findViewById(2131034258));
    this.gotopointshop = ((ImageView)localView.findViewById(2131034261));
    this.gotomemberhome = ((ImageView)localView.findViewById(2131034264));
    this.gotomore = ((ImageView)localView.findViewById(2131034267));
    this.homepage = ((LinearLayout)localView.findViewById(2131034257));
    this.pointshop = ((LinearLayout)localView.findViewById(2131034260));
    this.membercenter = ((LinearLayout)localView.findViewById(2131034263));
    this.more = ((LinearLayout)localView.findViewById(2131034266));
    this.gotohometv = ((TextView)localView.findViewById(2131034259));
    this.gotopointshoptv = ((TextView)localView.findViewById(2131034262));
    this.gotomemberhometv = ((TextView)localView.findViewById(2131034265));
    this.gotomoretv = ((TextView)localView.findViewById(2131034268));
    this.gotoimg[0] = this.gotohome;
    this.gotoimg[1] = this.gotopointshop;
    this.gotoimg[2] = this.gotogroupon;
    this.gotoimg[3] = this.gotomemberhome;
    this.gotoimg[4] = this.gotomore;
    this.gototv[0] = this.gotohometv;
    this.gototv[1] = this.gotopointshoptv;
    this.gototv[2] = this.gotogroupontv;
    this.gototv[3] = this.gotomemberhometv;
    this.gototv[4] = this.gotomoretv;
    this.resred[0] = Integer.valueOf(2130837636);
    this.resred[1] = Integer.valueOf(2130837707);
    this.resred[2] = Integer.valueOf(2130837634);
    this.resred[3] = Integer.valueOf(2130837696);
    this.resred[4] = Integer.valueOf(2130837697);
    this.resblack[0] = Integer.valueOf(2130837596);
    this.resblack[1] = Integer.valueOf(2130837599);
    this.resblack[2] = Integer.valueOf(2130837595);
    this.resblack[3] = Integer.valueOf(2130837597);
    this.resblack[4] = Integer.valueOf(2130837598);
    this.state = getActivity().getIntent().getStringExtra("state");
    if ((this.state != null) && (this.state.length() > 0))
    {
      Integer localInteger = Integer.valueOf(Integer.parseInt(this.state));
      this.gotoimg[localInteger.intValue()].setImageResource(this.resred[localInteger.intValue()].intValue());
      this.gototv[localInteger.intValue()].setTextColor(getResources().getColor(2131296406));
    }
    while (true)
    {
      this.homepage.setOnClickListener(new BottomFragment$1(this));
      this.pointshop.setOnClickListener(new BottomFragment$2(this));
      this.membercenter.setOnClickListener(new BottomFragment$3(this));
      this.more.setOnClickListener(new BottomFragment$4(this));
      
      this.gotoimg[0].setImageResource(this.resred[0].intValue());
      this.gototv[0].setTextColor(getResources().getColor(2131296406));
      return localView;
    }
  }
  
  @SuppressLint("NewApi")
class BottomFragment$1 implements View.OnClickListener{
	  BottomFragment paramBottomFragment;
	  BottomFragment$1(BottomFragment paramBottomFragment)
	  {
		  this.paramBottomFragment = paramBottomFragment;
	  }

	  public void onClick(View paramView)
	  {
	    Intent localIntent = new Intent(this.paramBottomFragment.getActivity(), MainActivity.class);
	    localIntent.putExtra("state", "0");
	    this.paramBottomFragment.startActivity(localIntent);
	    this.paramBottomFragment.getActivity().overridePendingTransition(2130968582, 2130968585);
	  }
	}
  
  
  @SuppressLint("NewApi")
class BottomFragment$2 implements View.OnClickListener{
	  BottomFragment paramBottomFragment;
	  BottomFragment$2(BottomFragment paramBottomFragment)
	  {
		  this.paramBottomFragment = paramBottomFragment;
	  }
	  public void onClick(View paramView)
	  {
	    Intent localIntent = new Intent(this.paramBottomFragment.getActivity(), PointshopActivity.class);
	    localIntent.putExtra("state", "1");
	    this.paramBottomFragment.startActivity(localIntent);
	    this.paramBottomFragment.getActivity().overridePendingTransition(2130968582, 2130968585);
	  }
	}
  
  
  @SuppressLint("NewApi")
  class BottomFragment$3 implements View.OnClickListener{
  	BottomFragment paramBottomFragment;
    BottomFragment$3(BottomFragment paramBottomFragment)
    {
  	  this.paramBottomFragment = paramBottomFragment;
    }

    public void onClick(View paramView)
    {
      Intent localIntent = new Intent(this.paramBottomFragment.getActivity(), MemberActivity.class);
      localIntent.putExtra("state", "3");
      this.paramBottomFragment.startActivity(localIntent);
      this.paramBottomFragment.getActivity().overridePendingTransition(2130968582, 2130968585);
    }
  }
  
  @SuppressLint("NewApi")
  class BottomFragment$4 implements View.OnClickListener{
  	BottomFragment paramBottomFragment;
    BottomFragment$4(BottomFragment paramBottomFragment){
  	   this.paramBottomFragment = paramBottomFragment;
    }

    public void onClick(View paramView)
    {
      Intent localIntent = new Intent(this.paramBottomFragment.getActivity(), MoreActivity.class);
      localIntent.putExtra("state", "4");
      this.paramBottomFragment.startActivity(localIntent);
      this.paramBottomFragment.getActivity().overridePendingTransition(2130968582, 2130968585);
    }
  }
  
  
}

