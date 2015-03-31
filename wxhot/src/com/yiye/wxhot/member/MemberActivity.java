package com.yiye.wxhot.member;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yiye.wxhot.util.Netdeal;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class MemberActivity extends Activity
{
  private String USERNAME;
  private TextView browsehistory = null;
  private TextView catFoodNums;
  private TextView checkinbtn = null;
  private RelativeLayout costlist;
  private TextView costlistWord = null;
  private TextView creelNums;
  private LinearLayout memberbox1;
  private LinearLayout memberbox2;
  private ImageView memberid;
  private TextView membername;
  private TextView mycreelbtn = null;
  private Netdeal netdeal;
  private RelativeLayout notice;
  private TextView noticebtn = null;
  private RelativeLayout orderlist;
  private ImageView return1 = null;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903094);
    this.membername = ((TextView)findViewById(2131034320));
    this.catFoodNums = ((TextView)findViewById(2131034321));
    this.creelNums = ((TextView)findViewById(2131034326));
    this.memberid = ((ImageView)findViewById(2131034318));
    this.return1 = ((ImageView)findViewById(2131034270));
    this.return1.setVisibility(8);
    this.costlistWord = ((TextView)findViewById(2131034332));
    this.browsehistory = ((TextView)findViewById(2131034329));
    this.mycreelbtn = ((TextView)findViewById(2131034325));
    this.noticebtn = ((TextView)findViewById(2131034337));
    this.memberbox1 = ((LinearLayout)findViewById(2131034323));
    this.memberbox2 = ((LinearLayout)findViewById(2131034327));
    this.costlist = ((RelativeLayout)findViewById(2131034330));
    this.orderlist = ((RelativeLayout)findViewById(2131034333));
    this.notice = ((RelativeLayout)findViewById(2131034335));
    this.checkinbtn = ((TextView)findViewById(2131034192));
    this.checkinbtn.setText("会员中心");
    this.USERNAME = getSharedPreferences("WuxihotDB", 0).getString("USERNAME", "");
    this.netdeal = new Netdeal();
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(new BasicNameValuePair("username", this.USERNAME));
    String str1 = this.netdeal.commonGetData(localArrayList1, "/index.php/Api/getMemberInfo");
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new BasicNameValuePair("member_name", this.USERNAME));
    String str2 = this.netdeal.commonGetData(localArrayList2, "/index.php/Api/getCreelNums");
    this.creelNums.setText(str2);
    try
    {
      Integer localInteger = Integer.valueOf(new JSONObject(str1).getInt("catFood"));
      this.membername.setText(this.USERNAME);
      this.catFoodNums.setText(String.valueOf(localInteger));
      this.costlist.setOnClickListener(new MemberActivity.1(this));
      this.memberid.setOnClickListener(new MemberActivity.2(this));
      this.memberbox2.setOnClickListener(new MemberActivity.3(this));
      this.memberbox1.setOnClickListener(new MemberActivity.4(this));
      this.orderlist.setOnClickListener(new MemberActivity.5(this));
      this.notice.setOnClickListener(new MemberActivity.6(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.member.MemberActivity
 * JD-Core Version:    0.6.2
 */