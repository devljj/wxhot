package com.yiye.wxhot.util;

import com.linkage.netmsg.server.AnswerBean;
import com.linkage.netmsg.server.ReceiveMsg;
import com.linkage.netmsg.server.ReturnMsgBean;
import com.linkage.netmsg.server.UpMsgBean;
import java.io.PrintStream;

public class ReceiveDemo extends ReceiveMsg
{
  public void getAnswer(AnswerBean paramAnswerBean)
  {
    super.getAnswer(paramAnswerBean);
    String str1 = paramAnswerBean.getSeqId();
    int i = paramAnswerBean.getStatus();
    String str2 = paramAnswerBean.getMsgId();
    System.out.println("AnswerBean seqIdString:" + str1);
    System.out.println("AnswerBean status:" + i);
    System.out.println("AnswerBean msgId:" + str2);
  }

  public void getReturnMsg(ReturnMsgBean paramReturnMsgBean)
  {
    super.getReturnMsg(paramReturnMsgBean);
    String str1 = paramReturnMsgBean.getSequenceId();
    String str2 = paramReturnMsgBean.getMsgId();
    String str3 = paramReturnMsgBean.getSendNum();
    String str4 = paramReturnMsgBean.getReceiveNum();
    String str5 = paramReturnMsgBean.getSubmitTime();
    String str6 = paramReturnMsgBean.getSendTime();
    String str7 = paramReturnMsgBean.getMsgStatus();
    int i = paramReturnMsgBean.getMsgErrStatus();
    System.out.println("ReturnMsgBean sequenceId: " + str1);
    System.out.println("ReturnMsgBean msgId: " + str2);
    System.out.println("ReturnMsgBean sendNum: " + str3);
    System.out.println("ReturnMsgBean receiveNum: " + str4);
    System.out.println("ReturnMsgBean submitTime: " + str5);
    System.out.println("ReturnMsgBean sendTime: " + str6);
    System.out.println("ReturnMsgBean msgStatus: " + str7);
    System.out.println("ReturnMsgBean msgErrStatus: " + i);
  }

  public void getUpMsg(UpMsgBean paramUpMsgBean)
  {
    super.getUpMsg(paramUpMsgBean);
  }
}

/* Location:           I:\re\wuxihot\classes_dex2jar.jar
 * Qualified Name:     com.yiye.wxhot.util.ReceiveDemo
 * JD-Core Version:    0.6.2
 */