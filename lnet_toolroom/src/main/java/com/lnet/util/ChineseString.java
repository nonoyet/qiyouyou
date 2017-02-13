package com.lnet.util;

import java.util.*;
import java.text.*;

public class ChineseString {

  public ChineseString() {
  }

  //中文字符串转换
  public static String chineseStr(String str) {
    try {
      if (str == null)
        return "";
      String tempStr = str;
      byte[] tempArray = tempStr.getBytes("ISO8859-1");
     // byte[] tempArray = tempStr.getBytes("GBK");
      String temp = new String(tempArray);
      return temp;
    }catch (Exception ex) {
      System.out.println(
          "com.hsoft.business.common.CheckSession/chineseStr() 出错：" +
          ex.getMessage());
    }
    return "";
  }
  
  //Null字符串转换
  public static String nullToStr(String temp) {
    if (temp == null)
      temp = "";
    return temp;
  }

  //取得字符串长度(一个汉字为两个字符长度)
  public static long getStringLength(String sourceStr) {
    long returnValue = 0;
    if (sourceStr == null) {
      return (returnValue);
    }
    for (int i = 0; i < sourceStr.length(); i++) {
      char[] tempChar = sourceStr.substring(i, i + 1).toCharArray();
      if ( (int) tempChar[0] > 255)
        returnValue += 2;
      else
        returnValue++;
    }
    return (returnValue);
  }

  //取得重复次数的字符串
  public static String getRepeatString(String sourceStr, long repeatTimes) {
    StringBuffer returnStr = new StringBuffer();
    for (int i = 0; i < repeatTimes; i++) {
      returnStr.append(sourceStr);
    }
    return (returnStr.toString());
  }

  //取得指定长度的字符串,不足长度的以replaceString填充(一个汉字为两个字符长度)
  public static String getSpecifyLengthString(String sourceStr,
                                              long specityLength,
                                              String replaceString) {
    if (sourceStr == null) {
      return (getRepeatString(replaceString, specityLength));
    }
    long realLength = getStringLength(sourceStr);
    StringBuffer returnStr = new StringBuffer();
    if (realLength < specityLength) {
      returnStr.append(sourceStr);
      returnStr.append(getRepeatString(replaceString,
                                       specityLength - realLength));
    }
    else {
      returnStr.append(getLeftString(sourceStr, specityLength, replaceString));
    }
    return (returnStr.toString());
  }

  //取得其中包含字符串中从左边算起指定数量的字符(一个汉字为两个字符长度)
  public static String getLeftString(String sourceStr, long leftLength,
                                     String replaceString) {
    StringBuffer returnStr = new StringBuffer();
    long tempLength = 0;
    for (int i = 0; i < sourceStr.length(); i++) {
      String tempStr = sourceStr.substring(i, i + 1);
      char[] tempChar = tempStr.toCharArray();
      if ( (int) tempChar[0] > 255)
        tempLength += 2;
      else
        tempLength++;
      if (tempLength >= leftLength) {
        if (tempLength == leftLength)
          returnStr.append(tempStr);
        else
          returnStr.append(getRepeatString(replaceString,
                                           tempLength - leftLength));
        break;
      }
      returnStr.append(tempStr);
    }
    return (returnStr.toString());
  }

  //取得指定长度的字符串(一个汉字为两个字符长度,targetlength为汉字个数)
  public static String displayTitle(String sourceString, long targetlength) {
    String returnValue = "";
    if (sourceString != null) {
      if (getStringLength(sourceString) <= targetlength * 2)
        returnValue = sourceString;
      else
        returnValue = getLeftString(sourceString, (targetlength - 1) * 2,
                                    "") + "…";
    }
    return (returnValue);
  }

  //取得一个日期的(2004-12-24)
  public static String formatDate(Date convertDate) {
    String returnValue = "";
    if (convertDate != null) {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      returnValue = formatter.format(convertDate);
    }
    return (returnValue);
  }

  //取得一个日期的全名(2004-12-24 12:04:15)
  public static String fullDate(Date convertDate) {
    String returnValue = "";
    if (convertDate != null) {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      returnValue = formatter.format(convertDate);
    }
    return (returnValue);
  }

  //取得一个日期的中文名称(2004年12月24日)
  public static String chineseDate(Date convertDate) {
    String returnValue = "";
    if (convertDate != null) {
      DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
      returnValue = dateFormat.format(convertDate);
    }
    return (returnValue);
  }

  //取得一个日期的中文名称,包括星期(2004年12月24日 星期五)  Thursday, June 11, 2015    
  public static String chineseFullDate(Date convertDate) {
    String returnValue = "";
    if (convertDate != null) {
      DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
      returnValue = dateFormat.format(convertDate);
    }
    return (returnValue);
  }

  //返回一个字符串数组，str被splitStr分割后的结果
  public static String[] split(String str,String splitStr) {
    Collection coll = new ArrayList();
    if (str != null && !"".equals(str) && splitStr != null &&
        !"".equals(splitStr)) {
      String tempStr = str;
      int at = tempStr.indexOf(splitStr);
      while (at != -1) {
        coll.add(tempStr.substring(0, at));
        tempStr = tempStr.substring(at + splitStr.length());
        at = tempStr.indexOf(splitStr);
      }
      if (!"".equals(tempStr))
        coll.add(tempStr);
    }
    return (String[]) coll.toArray(new String[0]);
  }

  //当前字符转换成HTML格式
  public static String htmlFormat(String str) {
    String returnValue = "";
    if (str != null && !"".equals(str)) {
       returnValue = str.replaceAll("\n","<br>");
       returnValue=returnValue.replaceAll(" ","&nbsp;");
       
       
    }
    return (returnValue);
  }

  //当前字符的换行符转换成空格
  public static String newlineFormat(String str) {
    String returnValue = "";
    String enterNewline = String.valueOf( (char) 13) +
        String.valueOf( (char) 10);
    if (str != null && !"".equals(str)) {
      returnValue = str.replaceAll(enterNewline," ");
    }
    return (returnValue);
  }

  //字符串转换成日期 formatString可以是 yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd
  public static java.util.Date stringToDate(String dateString,
                                            String formatString) throws
      ParseException {
    java.util.Date returnValue = null;
    if (dateString != null && !"".equals(dateString)) {
      SimpleDateFormat formatter = new SimpleDateFormat(formatString);
      returnValue = formatter.parse(dateString);
    }

    return (returnValue);
  }
  public  static String extChinese(String str)
  {
      try
      {
          String temp_p=str;
          byte[] temp_t=temp_p.getBytes("ISO8859-1");
          String temp=new String(temp_t,"GBK");
          return temp;
      }
      catch(Exception e)
      {
          return "";
      }
  }
  public  static String extChinese2(String str)
  {
      try
      {
          String temp_p=str;
          byte[] temp_t=temp_p.getBytes("UTF-8");
          String temp=new String(temp_t,"GBK");
          return temp;
      }
      catch(Exception e)
      {
          return "";
      }
  }
  public static String getSubStr(String str, int cutCount) {
	  String resultStr = "";
	  char[] ch = str.toCharArray();
	  int count = ch.length;
	  for (int i = 0; i < count; i++) {
	   resultStr += ch[i];
	   if ( resultStr.getBytes().length >= cutCount-3 ) {
	    resultStr += "...";    
	    break;
	   }
	  }
	  return resultStr;
	 }
  /** 
   * 根据日期获得星期 
   * @param date 
   * @return 
   */ 
	public static String getWeekOfDate() { 
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE); 
		//int hour = c.get(Calendar.HOUR_OF_DAY); 
		//int minute = c.get(Calendar.MINUTE); 
		//int second = c.get(Calendar.SECOND); 
		String ss = year + "年" + month + "月" + date + "日"+"  "+getWeekOfDate(new Date() );
		
		
		
		return ss; 
	} 
	/** * 获取指定日期是星期几
	  * 参数为null时表示获取当前日期是星期几
	  * @param date
	  * @return
	*/
	public static String getWeekOfDate(Date date) {      
	    String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};        
	    Calendar calendar = Calendar.getInstance();      
	    if(date != null){        
	         calendar.setTime(date);      
	    }        
	    int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
	    if (w < 0){        
	        w = 0;      
	    }      
	    return weekOfDays[w];    
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
	    //今天是2014-12-25 星期四
	    String weekOfDate = null;
	    weekOfDate = getWeekOfDate(null);
	    System.out.println(weekOfDate);
	    //输出 星期四
	 
	    Date date = new Date();
	    date.setDate(24);
	    weekOfDate = getWeekOfDate(date);
	    System.out.println(weekOfDate);
	    //输出 星期三
	 }
	
}
