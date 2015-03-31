package com.yiye.wxhot.pointshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class PointshopDetailActivity extends Activity
{
  private Integer catFoodNums;
  private TextView checkinbtn = null;
  private FrameLayout container;
  private Netdeal netdeal = null;
  private TextView productcontent;
  private Integer productid;
  private TextView producttitle;
  private Button queryexchange;
  private LinearLayout topwrap = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903107);
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.producttitle = ((TextView)findViewById(2131034358));
    this.productcontent = ((TextView)findViewById(2131034359));
    this.queryexchange = ((Button)findViewById(2131034360));
    this.checkinbtn.setText("商品描述");
    this.topwrap = ((LinearLayout)findViewById(2131034187));
    this.netdeal = new Netdeal();
    ArrayList localArrayList = new ArrayList();
    this.productid = Integer.valueOf(getIntent().getIntExtra("productid", 0));
    localArrayList.add(new BasicNameValuePair("product_id", String.valueOf(this.productid)));
    String str1 = this.netdeal.commonGetData(localArrayList, "/index.php/Api/getPointShopDetail");
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      String str2 = localJSONObject.getString("product_title");
      String str3 = localJSONObject.getString("product_content");
      this.catFoodNums = Integer.valueOf(localJSONObject.getInt("catFoodNums"));
      this.producttitle.setText(str2);
      this.productcontent.setText(str3);
      this.topwrap.setOnClickListener(new PointshopDetailActivity$1(this));
      this.queryexchange.setOnClickListener(new PointshopDetailActivity.2(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }
  
  class PointshopDetailActivity$1  implements View.OnClickListener
  {
	  PointshopDetailActivity paramPointshopDetailActivity;
    PointshopDetailActivity$1(PointshopDetailActivity paramPointshopDetailActivity)
    {
    	this.paramPointshopDetailActivity = paramPointshopDetailActivity;
    }

    public void onClick(View paramView)
    {
      this.paramPointshopDetailActivity.finish();
    }
  }
}
