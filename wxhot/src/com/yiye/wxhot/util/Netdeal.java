package com.yiye.wxhot.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Netdeal
{
  // ERROR //
  public String commonGetData(List<NameValuePair> paramList, String paramString)
  {}

  // ERROR //
  public String executePost(List<NameValuePair> paramList)
  {}

  // ERROR //
  public String executePostIsAudit(List<NameValuePair> paramList)
  {}

  // ERROR //
  public String executePostReceipt(List<NameValuePair> paramList)
  {}

  // ERROR //
  public String executePostSubmitinfo(List<NameValuePair> paramList)
  {}

  // ERROR //
  public String getReceiptAmount(List<NameValuePair> paramList)
  {}

  // ERROR //
  public String getRechargerecord(List<NameValuePair> paramList)
  {}

  public String post(String[] paramArrayOfString, List<NameValuePair> paramList)
    throws ClientProtocolException, IOException, JSONException
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    localDefaultHttpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    String str1 = "http://58.215.80.12/".concat("index.php/Api/uploadFile");
    String str2 = "http://58.215.80.12/".concat("index.php/Api/submitInfo");
    HttpPost localHttpPost1 = new HttpPost(str1);
    HttpPost localHttpPost2 = new HttpPost(str2);
    File localFile1 = new File(paramArrayOfString[0]);
    File localFile2 = new File(paramArrayOfString[1]);
    File localFile3 = new File(paramArrayOfString[2]);
    MultipartEntity localMultipartEntity = new MultipartEntity();
    FileBody localFileBody1 = new FileBody(localFile1);
    FileBody localFileBody2 = new FileBody(localFile2);
    FileBody localFileBody3 = new FileBody(localFile3);
    localMultipartEntity.addPart("pic[]", localFileBody1);
    localMultipartEntity.addPart("pic[]", localFileBody2);
    localMultipartEntity.addPart("pic[]", localFileBody3);
    localHttpPost1.setEntity(localMultipartEntity);
    HttpEntity localHttpEntity = localDefaultHttpClient.execute(localHttpPost1).getEntity();
    String str3 = "";
    if (localHttpEntity != null)
    {
      JSONArray localJSONArray = new JSONObject(EntityUtils.toString(localHttpEntity, "utf-8")).getJSONArray("pics");
      paramList.add(new BasicNameValuePair("cardPicHead", localJSONArray.getString(0)));
      paramList.add(new BasicNameValuePair("cardPicTail", localJSONArray.getString(1)));
      paramList.add(new BasicNameValuePair("avatar", localJSONArray.getString(2)));
      localHttpPost2.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
      String str4 = EntityUtils.toString(localDefaultHttpClient.execute(localHttpPost2).getEntity(), "utf-8");
      JSONObject localJSONObject = new JSONObject(str4);
      str3 = localJSONObject.getString("result");
    }
    if (localHttpEntity != null)
      localHttpEntity.consumeContent();
    localDefaultHttpClient.getConnectionManager().shutdown();
    return str3;
  }

  public String uploadFile(String paramString1, String paramString2)
  {
    String str1 = "";
    String str2;
    try
    {
      URL localURL = new URL(paramString1);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
      localHttpURLConnection.setChunkedStreamingMode(131072);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
      localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + "******");
      DataOutputStream localDataOutputStream = new DataOutputStream(localHttpURLConnection.getOutputStream());
      localDataOutputStream.writeBytes("--" + "******" + "\r\n");
      localDataOutputStream.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\"; filename=\"" + paramString2.substring(1 + paramString2.lastIndexOf("/")) + "\"" + "\r\n");
      localDataOutputStream.writeBytes("\r\n");
      FileInputStream localFileInputStream = new FileInputStream(paramString2);
      byte[] arrayOfByte = new byte[8192];
      while (true)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1)
        {
          localFileInputStream.close();
          localDataOutputStream.writeBytes("\r\n");
          localDataOutputStream.writeBytes("--" + "******" + "--" + "\r\n");
          localDataOutputStream.flush();
          InputStream localInputStream = localHttpURLConnection.getInputStream();
          str1 = new BufferedReader(new InputStreamReader(localInputStream, "utf-8")).readLine();
          localDataOutputStream.close();
          localInputStream.close();
          str2 = str1;
          break;
        }
        localDataOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str2 = str1;
    }
    return str2;
  }

  // ERROR //
  public String withdrawPost(List<NameValuePair> paramList)
  {}
}

