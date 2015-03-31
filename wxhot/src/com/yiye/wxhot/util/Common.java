package com.yiye.wxhot.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common
{
  private Context ctx;

  public Common(Context paramContext)
  {
    this.ctx = paramContext;
  }

  public static String MD5(String paramString)
  {
    String str;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer("");
      for (int i = 0; ; i++)
      {
        if (i >= arrayOfByte.length)
        {
          str = localStringBuffer.toString();
          break;
        }
        int j = arrayOfByte[i];
        if (j < 0)
          j += 256;
        if (j < 16)
          localStringBuffer.append("0");
        localStringBuffer.append(Integer.toHexString(j));
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      str = "";
    }
    return str;
  }

  public static String TimeStamp2Date(String paramString1, String paramString2)
  {
    Long localLong = Long.valueOf(1000L * Long.parseLong(paramString1));
    return new SimpleDateFormat(paramString2).format(new Date(localLong.longValue()));
  }

  public static Bitmap compressBmpFromBmp(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 100;
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    while (true)
    {
      if (localByteArrayOutputStream.toByteArray().length / 1024 <= 100)
        return BitmapFactory.decodeStream(new ByteArrayInputStream(localByteArrayOutputStream.toByteArray()), null, null);
      localByteArrayOutputStream.reset();
      i -= 10;
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
    }
  }

  public static void compressBmpToFile(Bitmap paramBitmap, File paramFile)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 90;
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
    while (true)
    {
      if (localByteArrayOutputStream.toByteArray().length / 1024 <= 100);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        localFileOutputStream.write(localByteArrayOutputStream.toByteArray());
        localFileOutputStream.flush();
        localFileOutputStream.close();
       // return;
        localByteArrayOutputStream.reset();
        i -= 10;
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
      }
      catch (Exception localException)
      {
        while (true)
          localException.printStackTrace();
      }
    }
  }

  public static String generateCode()
  {
    Random localRandom1 = new Random();
    Random localRandom2 = new Random();
    Random localRandom3 = new Random();
    Random localRandom4 = new Random();
    String str1 = String.valueOf(localRandom1.nextInt(10));
    String str2 = String.valueOf(localRandom2.nextInt(10));
    String str3 = String.valueOf(localRandom3.nextInt(10));
    String str4 = String.valueOf(localRandom4.nextInt(10));
    return str1.concat(str2).concat(str3).concat(str4);
  }

  public static String generateCouponCode()
  {
    Random localRandom1 = new Random();
    Random localRandom2 = new Random();
    Random localRandom3 = new Random();
    Random localRandom4 = new Random();
    Random localRandom5 = new Random();
    Random localRandom6 = new Random();
    Random localRandom7 = new Random();
    Random localRandom8 = new Random();
    Random localRandom9 = new Random();
    String str1 = String.valueOf(localRandom1.nextInt(10));
    String str2 = String.valueOf(localRandom2.nextInt(10));
    String str3 = String.valueOf(localRandom3.nextInt(10));
    String str4 = String.valueOf(localRandom4.nextInt(10));
    String str5 = String.valueOf(localRandom5.nextInt(10));
    String str6 = String.valueOf(localRandom6.nextInt(10));
    String str7 = String.valueOf(localRandom7.nextInt(10));
    String str8 = String.valueOf(localRandom8.nextInt(10));
    String str9 = String.valueOf(localRandom9.nextInt(10));
    return str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8 + str9;
  }

  public static String generateOrderNo()
  {
    Long localLong = Long.valueOf(new Date().getTime());
    Integer localInteger = Integer.valueOf(new Random().nextInt(10000));
    return "wx" + String.valueOf(localLong) + String.valueOf(localInteger);
  }

  public static Bitmap getBitmap(String paramString)
  {
	 Bitmap localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(new URL(paramString).openStream());
      localObject = localBitmap;
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public static Bitmap getHttpBitmap(String paramString)
  {
    Bitmap localBitmap = null;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.connect();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      Log.i("TAG", "*********inputstream**" + localInputStream);
      localBitmap = BitmapFactory.decodeStream(localInputStream);
      Log.i("TAG", "*********bitmap****" + localBitmap);
      localInputStream.close();
      localHttpURLConnection.disconnect();
      return localBitmap;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public static String getsysTime()
  {
    return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
  }

  public static boolean isLogined(Context paramContext)
  {
    boolean bool = false;
    if (paramContext.getSharedPreferences("SP", 0).getString("USERNAME_COOKIE", "") == null);
    while (true)
    {
     
      bool = true;
      return bool;
    }
  }

  public static boolean isMobileNO(String paramString)
  {
    return Pattern.compile("^[0-9]{11}$").matcher(paramString).matches();
  }

  public static boolean isNetworkAvailable(Context context) {  
      ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);  
      NetworkInfo[] info = mgr.getAllNetworkInfo();  
      if (info != null) {  
          for (int i = 0; i < info.length; i++) {  
              if (info[i].getState() == NetworkInfo.State.CONNECTED) {  
                  return true;  
              }  
          }  
      }  
      return false;  
  }  
}