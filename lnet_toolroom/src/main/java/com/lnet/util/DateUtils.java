package com.lnet.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * 日期转换处理类<br>
 * @author lihp
 * 2015-10-12
 * 
 */

public class DateUtils implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LogManager.getLogger(DateUtils.class);

	private static SimpleDateFormat defaultYearFormatter = new SimpleDateFormat(
			"yyyy");

	private static SimpleDateFormat defaultDateFormatter = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static SimpleDateFormat defaultDateTimeFormatter = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static SimpleDateFormat defaultDateTimeCompactFormatter = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	private static SimpleDateFormat defaultDateTimeMillionCompactFormatter = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");

	/**
	 * 日期转换格式
	 */
	private static SimpleDateFormat dateFormatter01 = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static SimpleDateFormat dateFormatter02 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat dateFormatter03 = new SimpleDateFormat(
			"yyyyMMdd");
	private static SimpleDateFormat dateFormatter04 = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private static SimpleDateFormat dateFormatter05 = new SimpleDateFormat(
			"yyyy-MM-dd HH");
	private static SimpleDateFormat dateFormatter06 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	private static SimpleDateFormat dateFormatter07 = new SimpleDateFormat(
			"yyyyMMddHH");
	private static SimpleDateFormat dateFormatter08 = new SimpleDateFormat(
			"yyyyMMddHHmm");
	
	/**
	 * 时间转换格式
	 */
	private static SimpleDateFormat timeFormatter01 = new SimpleDateFormat(
		"HH:mm:ss");
	private static SimpleDateFormat timeFormatter02 = new SimpleDateFormat(
		"HH:mm");
	private static SimpleDateFormat timeFormatter03 = new SimpleDateFormat(
		"HH");
	
	public static String[] week = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
	
	/**
	 * 取得完整的时间格式,格式如:(13:59:07)
	 * @param date
	 * @return
	 */
	public static String getTimeFullString(Date date) {
		return timeFormatter01.format(date);
	}
	/**
	 * 取得简单的时间格式,格式如:(13:59)
	 * @param date
	 * @return
	 */
	public static String getTimeShortString(Date date) {
		return timeFormatter02.format(date);
	}
	/**
	 * 取得小时值,格式如(12)
	 * @param date
	 * @return
	 */
	public static String getHourString(Date date) {
		return timeFormatter03.format(date);
	}
	/**
	 * 取得系统当前的年份,格式如: (2008)<br>
	 * 
	 * @return String
	 */
	public static String getSystemYearString() {
		return defaultYearFormatter.format(new java.util.Date());
	}

	/**
	 * 取得系统当前的日期字符表达式,格式如: (2008-05-12)<br>
	 * 
	 * @return String
	 */
	public static String getSystemDateString() {
		return defaultDateFormatter.format(new java.util.Date());
	}

	/**
	 * 取得系统当前的日期时间字符表达式,格式如: (2008-05-12 14:28:36)<br>
	 * 
	 * @return String
	 */
	public static String getSystemDateTimeString() {
		return defaultDateTimeFormatter.format(new java.util.Date());
	}

	/**
	 * 取得系统当前的日期时间字符表达式,格式如: (20080512142836)<br>
	 * 
	 * @return String
	 */
	public static String getSystemDateTimeCompactString() {
		return defaultDateTimeCompactFormatter.format(new java.util.Date());
	}

	/**
	 * 取得系统当前的日期时间字符表达式(带毫秒数),格式如: (20080512142836326)<br>
	 * 
	 * @return String
	 */
	public static String getSystemDateTimeMillionCompactString() {
		return defaultDateTimeMillionCompactFormatter
				.format(new java.util.Date());
	}

	/**
	 * 取得一个日期的字符表达式,格式如: (2008-05-12)<br>
	 * 
	 * @param convertDate
	 *            需要转换的日期
	 * @return String
	 */
	public static String getShortString(Date convertDate) {
		String returnValue = "";
		if (convertDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			returnValue = formatter.format(convertDate);
		}
		return returnValue;
	}

	/**
	 * 取得一个日期时间的字符表达式,格式如: (2008-05-12 14:28:36)<br>
	 * 
	 * @param convertDate
	 *            需要转换的日期
	 * @return String
	 */
	public static String getFullString(Date convertDate) {
		String returnValue = "";
		if (convertDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			returnValue = formatter.format(convertDate);
		}
		return returnValue;
	}

	/**
	 * 取得一个日期的紧凑字符表达式,格式如: (20080512)<br>
	 * 
	 * @param convertDate
	 *            需要转换的日期
	 * @return String
	 */
	public static String getShortCompactString(Date convertDate) {
		String returnValue = "";
		if (convertDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			returnValue = formatter.format(convertDate);
		}
		return returnValue;
	}

	/**
	 * 取得一个日期时间的紧凑字符表达式,格式如: (20080512142836)<br>
	 * 
	 * @param convertDate
	 *            需要转换的日期
	 * @return String
	 */
	public static String getFullCompactString(Date convertDate) {
		String returnValue = "";
		if (convertDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			returnValue = formatter.format(convertDate);
		}
		return returnValue;
	}

	/**
	 * 取得一个日期的中文字符表达式,格式如: (2008年5月12日)<br>
	 * 
	 * @param convertDate
	 *            需要转换的日期
	 * @return String
	 */
	public static String getChineseShortString(Date convertDate) {
		String returnValue = "";
		if (convertDate != null) {
			//DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
			DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			returnValue = dateFormat.format(convertDate);
		}
		return returnValue;
	}

	/**
	 * 取得一个日期时间的中文字符表达式,格式如: (2008年05月12日14时)<br>
	 * 
	 * @param convertDate
	 *            需要转换的日期
	 * @return String
	 */
	public static String getChineseMidString(Date convertDate) {
		String returnValue = "";
		if (convertDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String temp = formatter.format(convertDate);
			returnValue = temp.substring(0, 4) + "年" + temp.substring(4, 6)
					+ "月" + temp.substring(6, 8) + "日" + temp.substring(8, 10)
					+ "时";
		}
		return returnValue;
	}

	/**
	 * 取得一个日期时间的中文字符表达式,格式如: (2008年05月12日14时28分)<br>
	 * 
	 * @param convertDate
	 *            需要转换的日期
	 * @return String
	 */
	public static String getChineseMiddleString(Date convertDate) {
		String returnValue = "";
		if (convertDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String temp = formatter.format(convertDate);
			returnValue = temp.substring(0, 4) + "年" + temp.substring(4, 6)
					+ "月" + temp.substring(6, 8) + "日" + temp.substring(8, 10)
					+ "时" + temp.substring(10, 12) + "分";
		}
		return returnValue;
	}

	/**
	 * 取得一个日期的中文字符表达式,包括星期,格式如: (2008年5月12日 星期一)<br>
	 * 
	 * @param convertDate
	 *            需要转换的日期
	 * @return String
	 */
	public static String getChineseFullString(Date convertDate) {
		String returnValue = "";
		if (convertDate != null) {
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
			returnValue = dateFormat.format(convertDate);
		}
		return returnValue;
	}

	/**
	 * 取得一个日期的纯中文字符表达式,格式如: (2008-05-12 转换后得到 二00八年五月十二日)<br>
	 * 
	 * @param dateString
	 *            需要转换的日期字符串
	 * @return String
	 */
	public static String getPureChineseString(String dateString)
			throws Exception {
		String returnValue = "";
		if (dateString != null && !"".equals(dateString)) {
			String[] chinaNumber = new String[10];
			chinaNumber[0] = "0";
			chinaNumber[1] = "一";
			chinaNumber[2] = "二";
			chinaNumber[3] = "三";
			chinaNumber[4] = "四";
			chinaNumber[5] = "五";
			chinaNumber[6] = "六";
			chinaNumber[7] = "七";
			chinaNumber[8] = "八";
			chinaNumber[9] = "九";
			String tempString = "";
			try {
				tempString = dateString.substring(0, 4);
				for (int i = 0; i < tempString.length(); i++) {
					int cn = Integer.parseInt(tempString.substring(i, i + 1));
					returnValue += chinaNumber[cn];
				}
				returnValue += "年";
				tempString = dateString.substring(5, 7);
				for (int i = 0; i < tempString.length(); i++) {
					int cn = Integer.parseInt(tempString.substring(i, i + 1));
					if (i == 0) {
						if (cn == 1) {
							returnValue += "十";
						}
					} else {
						if (cn > 0)
							returnValue += chinaNumber[cn];
					}
				}
				returnValue += "月";
				tempString = dateString.substring(8);
				for (int i = 0; i < tempString.length(); i++) {
					int cn = Integer.parseInt(tempString.substring(i, i + 1));
					if (i == 0) {
						switch (cn) {
						case 0:
							break;
						case 1:
							returnValue += "十";
							break;
						default:
							returnValue += chinaNumber[cn] + "十";
							break;
						}
					} else {
						if (cn > 0)
							returnValue += chinaNumber[cn];
					}

				}
				returnValue += "日";
			} catch (Exception ex) {
				returnValue = "";
				logger.error("日期转换错误: 转换字符串: " + dateString + "，"
						+ ex.getMessage(), ex);
				throw new Exception("日期转换错误: 转换字符串: " + dateString + "，"
						+ ex.getMessage());
			}
		}
		return returnValue;
	}

	/**
	 * 取得一个日期的纯中文字符表达式,格式如: (2008-05-12 转换后得到 二○○八年五月十二日)<br>
	 * 
	 * @param dateString
	 *            需要转换的日期字符串
	 * @return String
	 */
	public static String getPureChineseString2(String dateString)
			throws Exception {
		String returnValue = "";
		if (dateString != null && !"".equals(dateString)) {
			String[] chinaNumber = new String[10];
			chinaNumber[0] = "○";
			chinaNumber[1] = "一";
			chinaNumber[2] = "二";
			chinaNumber[3] = "三";
			chinaNumber[4] = "四";
			chinaNumber[5] = "五";
			chinaNumber[6] = "六";
			chinaNumber[7] = "七";
			chinaNumber[8] = "八";
			chinaNumber[9] = "九";
			String tempString = "";
			try {
				tempString = dateString.substring(0, 4);
				for (int i = 0; i < tempString.length(); i++) {
					int cn = Integer.parseInt(tempString.substring(i, i + 1));
					returnValue += chinaNumber[cn];
				}
				returnValue += "年";
				tempString = dateString.substring(5, 7);
				for (int i = 0; i < tempString.length(); i++) {
					int cn = Integer.parseInt(tempString.substring(i, i + 1));
					if (i == 0) {
						if (cn == 1) {
							returnValue += "十";
						}
					} else {
						if (cn > 0)
							returnValue += chinaNumber[cn];
					}
				}
				returnValue += "月";
				tempString = dateString.substring(8);
				for (int i = 0; i < tempString.length(); i++) {
					int cn = Integer.parseInt(tempString.substring(i, i + 1));
					if (i == 0) {
						switch (cn) {
						case 0:
							break;
						case 1:
							returnValue += "十";
							break;
						default:
							returnValue += chinaNumber[cn] + "十";
							break;
						}
					} else {
						if (cn > 0)
							returnValue += chinaNumber[cn];
					}

				}
				returnValue += "日";
			} catch (Exception ex) {
				returnValue = "";
				logger.error("日期转换错误: 转换字符串: " + dateString + ","
						+ ex.getMessage(), ex);
				throw new Exception("日期转换错误: 转换字符串: " + dateString + ","
						+ ex.getMessage());
			}
		}
		return returnValue;
	}

	/**
	 * 字符串转换成日期 (注意: dateString 与 formatString 要匹配)<br>
	 * 
	 * @param dateString
	 *            需要转换的日期字符串
	 * @param formatString
	 *            转换格式 yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd
	 * @return java.util.Date
	 */
	public static java.util.Date stringToDate(String dateString,
			String formatString) throws Exception {
		java.util.Date returnValue = null;
		try {
			if (dateString != null && !"".equals(dateString)) {
				SimpleDateFormat formatter = new SimpleDateFormat(formatString);
				formatter.setLenient(false); // 设置时间分析为严格的
				returnValue = formatter.parse(dateString);
			}
		} catch (Exception ex) {
			logger.error("日期转换错误: " + dateString + " 指定格式 [" + formatString
					+ "]，" + ex.getMessage(), ex);
			throw new Exception("日期转换错误: " + dateString + " 指定格式 ["
					+ formatString + "]，" + ex.getMessage());
		}
		return returnValue;
	}

	/**
	 * 取得指定的下一个日期<br>
	 * <p>
	 * 注意：按月运算时，如果运算后当月没有该日，则为当月的最后一天
	 * </p>
	 * 
	 * @param startDate
	 *            开始日期
	 * @param nextType
	 *            运算类型（Y=年数；M=月数；D=天数；H=小时数；m=分钟数；S=秒数）
	 * @param nextStep
	 *            运算长度（为负数指取以前的日期）
	 * @return java.util.Date
	 */
	public static java.util.Date getNextDate(Date startDate, String nextType,
			int nextStep) {
		Date endDate = startDate;
		if (startDate != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			if ("Y".equals(nextType)) {
				calendar.add(Calendar.YEAR, nextStep);
			} else if ("M".equals(nextType)) {
				calendar.add(Calendar.MONTH, nextStep);
			} else if ("D".equals(nextType)) {
				calendar.add(Calendar.DATE, nextStep);
			} else if ("H".equals(nextType)) {
				calendar.add(Calendar.HOUR, nextStep);
			} else if ("m".equals(nextType)) {
				calendar.add(Calendar.MINUTE, nextStep);
			} else if ("S".equals(nextType)) {
				calendar.add(Calendar.SECOND, nextStep);
			}
			endDate = calendar.getTime();
		}
		return endDate;
	}

	/**
	 * 组合查询列表日期字段做格式转换（已在数据库中作转换，暂时不用）<br>
	 * 
	 * @param convertDate
	 * @param dateType
	 * @return String
	 */
	public static String getQueryDateString(java.sql.Timestamp convertDate,
			String dateType) {
		String returnValue = "";
		if (convertDate != null) {
			java.util.Date date = new java.util.Date(convertDate.getTime());
			if ("01".equals(dateType)) {
				returnValue = dateFormatter01.format(date);
			} else if ("02".equals(dateType)) {
				returnValue = dateFormatter02.format(date);
			} else if ("03".equals(dateType)) {
				returnValue = dateFormatter03.format(date);
			} else if ("04".equals(dateType)) {
				returnValue = dateFormatter04.format(date);
			} else if ("05".equals(dateType)) {
				returnValue = dateFormatter05.format(date);
			} else if ("06".equals(dateType)) {
				returnValue = dateFormatter06.format(date);
			} else if ("07".equals(dateType)) {
				returnValue = dateFormatter07.format(date);
			} else if ("08".equals(dateType)) {
				returnValue = dateFormatter08.format(date);
			} else {
				returnValue = dateFormatter02.format(date);
			}
		}
		return returnValue;
	}
	
	/** 
	 * 取得当前日期是多少周 
	 * 
	 * @param date 
	 * @return 
	 */ 
	 public static int getWeekOfYear(Date date) { 
	 Calendar c = new GregorianCalendar(); 
	 c.setMinimalDaysInFirstWeek(7); 
	 c.setTime (date);

	 return c.get(Calendar.WEEK_OF_YEAR); 
	 }
	 /** 
	  * 得到某一年周的总数 
	  * 
	  * @param year 
	  * @return 
	  */ 
	  public static int getMaxWeekNumOfYear(int year) { 
	  Calendar c = new GregorianCalendar(); 
	  c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

	  return getWeekOfYear(c.getTime()); 
	  }
	  /** 
	   * 得到某年某周的第一天 
	   * 
	   * @param year 
	   * @param week 
	   * @return 
	   */ 
	   public static Date getFirstDayOfWeek(int year, int week) { 
	   Calendar c = new GregorianCalendar(); 
	   c.set(Calendar.YEAR, year); 
	   c.set (Calendar.MONTH, Calendar.JANUARY); 
	   c.set(Calendar.DATE, 1);

	   Calendar cal = (GregorianCalendar) c.clone(); 
	   cal.add(Calendar.DATE, week * 7);

	   return getFirstDayOfWeek(cal.getTime ()); 
	   }
	   /** 
	    * 得到某年某周的最后一天 
	    * 
	    * @param year 
	    * @param week 
	    * @return 
	    */ 
	    public static Date getLastDayOfWeek(int year, int week) { 
	    Calendar c = new GregorianCalendar(); 
	    c.set(Calendar.YEAR, year); 
	    c.set(Calendar.MONTH, Calendar.JANUARY); 
	    c.set(Calendar.DATE, 1);

	    Calendar cal = (GregorianCalendar) c.clone(); 
	    cal.add(Calendar.DATE , week * 7);

	    return getLastDayOfWeek(cal.getTime()); 
	    }
	    /** 
	     * 取得指定日期所在周的第一天 
	     * 
	     * @param date 
	     * @return 
	     */ 
	     public static Date getFirstDayOfWeek(Date date) { 
	     Calendar c = new GregorianCalendar(); 
	     c.setFirstDayOfWeek(Calendar.MONDAY); 
	     c.setTime(date); 
	     c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday 
	     return c.getTime (); 
	     }
	     
	     /** 
	      * 取得指定日期所在周的最后一天 
	      * 
	      * @param date 
	      * @return 
	      */ 
	      public static Date getLastDayOfWeek(Date date) { 
	      Calendar c = new GregorianCalendar(); 
	      c.setFirstDayOfWeek(Calendar.MONDAY); 
	      c.setTime(date); 
	      c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday 
	      return c.getTime(); 
	      } 
	      /** 
	       * 取得当前日期所在周的第一天 
	       * 
	       * @param date 
	       * @return 
	       */ 
	       public static Date getFirstDayOfWeek() { 
	       Calendar c = new GregorianCalendar(); 
	       c.setFirstDayOfWeek(Calendar.MONDAY); 
	       c.setTime(new Date()); 
	       c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday 
	       return c.getTime (); 
	       }

	       /** 
	       * 取得当前日期所在周的最后一天 
	       * 
	       * @param date 
	       * @return 
	       */ 
	       public static Date getLastDayOfWeek() { 
	       Calendar c = new GregorianCalendar(); 
	       c.setFirstDayOfWeek(Calendar.MONDAY); 
	       c.setTime(new Date()); 
	       c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday 
	       return c.getTime(); 
	       } 
	 
	       /**
	        * 根据字典代码返回一串开始时间和结束时间(中间逗号隔开)
	        * @param args
	        */
	       public static String  getStartAndStopDate(String dm){
	    	  
	    	   String returnValue="";
	    	   int curWeek= getWeekOfYear(new java.util.Date());//当前日期的周数
	    	   int curUpWeek=curWeek-1;//上周数
	    	   int year=Integer.parseInt(getSystemYearString()); //当前年份
	    	   int yearUp=year-1; //去年
	    	   String temp_mm=getSystemDateString().substring(5,7);//当前月份
	    	   int cur_mm=Integer.parseInt(temp_mm);
	    	   //字典为01,上周
	    	   if ("01".equals(dm)){
		    	   returnValue= getShortString(getFirstDayOfWeek(year,curUpWeek));
		    	   returnValue=returnValue+","+getShortString(getLastDayOfWeek(year,curUpWeek));
	    	   }
	    	   if ("02".equals(dm)){ //本周
	    		   returnValue= getShortString(getFirstDayOfWeek());
	    		   returnValue=returnValue+","+getShortString(getLastDayOfWeek());   
	    	   }
	    	   if ("03".equals(dm)){//上月	 
	    		   String temp_str="";
	    		   if ("01".equals(temp_mm)){
	    			    year=year-1;
	    			    temp_mm="12";
	    		   }else{
		    		   int temp_up_mm=cur_mm-1;
		    		   temp_str=temp_up_mm+"";
		    		   if (temp_str.length()<2){
		    			   temp_str="0"+temp_str;    			  
	    		        }
	    		   }  
	    		   returnValue= year+"-"+temp_str+"-01";
	    		   returnValue=returnValue+","+year+"-"+temp_str+"-31";   	    		    		  
	    	   }
	    	   if ("04".equals(dm)){//本月	    		  
	    		   returnValue= year+"-"+temp_mm+"-01";
	    		   returnValue=returnValue+","+year+"-"+temp_mm+"-31";   	   		       
	    	   }
	    	   if ("05".equals(dm)){//上季度
	    		   int jds=0;
	    		   if (cur_mm>=1&&cur_mm<=3){
            		  jds=1;
	    		   }
            	   if (cur_mm>=4&&cur_mm<=6){
            		  jds=2;           		   
            	   }
            	   if (cur_mm>=7&&cur_mm<=9){
            		  jds=3;       		   
            	   }
            	   if (cur_mm>=10&&cur_mm<=12){
            		  jds=4;       		   
            	   }
            	   if (jds==1){
            		   returnValue= yearUp+"-10-01";
    	    		   returnValue=returnValue+","+yearUp+"-12-31"; 
            	   }
            	   if (jds==2){
            		   returnValue= year+"-01-01";
    	    		   returnValue=returnValue+","+year+"-03-31";             		   
            	   }
            	   if (jds==3){
            		   returnValue= year+"-04-01";
    	    		   returnValue=returnValue+","+year+"-04-31";             		   
            	   }
            	   if (jds==4){
            		   returnValue= year+"-07-01";
    	    		   returnValue=returnValue+","+year+"-09-31";             		   
            	   }
	    	   }
               if ("06".equals(dm)){//本季度
            	  
            	   if (cur_mm>=1&&cur_mm<=3){
            		   returnValue= year+"-01-01";
    	    		   returnValue=returnValue+","+year+"-03-31";          		   
            	   }
            	   if (cur_mm>=4&&cur_mm<=6){
            		   returnValue= year+"-04-01";
    	    		   returnValue=returnValue+","+year+"-06-31";           		   
            	   }
            	   if (cur_mm>=7&&cur_mm<=9){
            		   returnValue= year+"-07-01";
    	    		   returnValue=returnValue+","+year+"-09-31";         		   
            	   }
            	   if (cur_mm>=10&&cur_mm<=12){
            		   returnValue= year+"-10-01";
    	    		   returnValue=returnValue+","+year+"-12-31";          		   
            	   }
            	             	   
	    	   }
               if ("07".equals(dm)){//上半年
            	   returnValue= year+"-01-01";
	    		   returnValue=returnValue+","+year+"-06-31";   
	    	   }
               if ("08".equals(dm)){//下半年
            	   returnValue= year+"-07-01";
	    		   returnValue=returnValue+","+year+"-12-31";   
	    	   }
               if ("09".equals(dm)){//去年	    		   
	    		   returnValue= yearUp+"-01-01";
	    		   returnValue=returnValue+","+yearUp+"-12-31";   
	    	   }
               if ("10".equals(dm)){//今年
            	   returnValue= year+"-01-01";
	    		   returnValue=returnValue+","+year+"-12-31"; 
	    	   }
	    	   
	    	   return returnValue;
	       }
	       /**
	        * 将Date转换为String类型
	        * @param date 时间类型
	        * @param formatString 格式"yyyy-MM-dd kk:mm:ss"
	        * @return
	        */
	   	public static String dateToString(Date date,String formatString){
	   	    String sdate = null;
	   		DateFormat df = new SimpleDateFormat(formatString);
	   		sdate = df.format(date);
	   		return sdate;
	   	}
	   	/**
		  * 计算两个日期相隔的天数  
		  * @param firstString
		  * @param secondString
		  * @return
		  */
	    public  static int   nDaysBetweenTwoDate(String   firstString,String   secondString)   {  
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
	        Date  firstDate = null;  
	        Date  secondDate = null;  
	        try {
				firstDate  = df.parse(firstString);
				secondDate = df.parse(secondString);  
			} catch (ParseException e) {
				e.printStackTrace();
			}  
	        int   nDay = (int)((secondDate.getTime()-firstDate.getTime())/(24*60*60*1000));  
	       // System.out.println(  nDay  );
	        return   nDay;  
	    } 
	    /**
		 * 取得系统当前的日期前几天或者后几天字符表达式,格式如: (2008-05-12)<br>
		 * 
		 * @return String
		 */
		public static String getforeAndAfterDateString(int dd) {
		    Date d = new Date();   
		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
		    String  time = df.format( new Date(d.getTime() + dd * 24 * 60 * 60 * 1000) );
		    //System.out.println( "日期是："+time );   
			return time;
			
		}
		/**
	     * 距离当前时间第n天String类型时间
	     * n正数是以后的时间，负数是以前时间
	     * 格式：yyyy-MM-dd
	     */
	    public static String stringDate(int n){
	    	
	    	Calendar c = Calendar.getInstance();   
	    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");   
	    	c.setTime(new Date());   
	    	c.add(Calendar.DATE,n);   
	    	Date d2 = c.getTime();   
	    	String time = df.format(d2);   
	    	//System.out.println( "日期是："+time );
	    	return time;  
	    	
	    }
	    
	    /** 
	     * 
	     * 两个时间相差距离多少天多少小时多少分多少秒 
	     * @param str1 时间参数 1 格式：1990-01-01 12:00:00 
	     * @param str2 时间参数 2 格式：2009-01-01 12:00:00 
	     * @param bz 得到时间返回值  1 天；2 时；3 分；其他  秒 
	     * @return long 
	     * 
	     */ 
	    public static long getDistanceTime(String str1, String str2,String bz) { 
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	        Date one; 
	        Date two; 
	        long day = 0; 
	        long hour = 0; 
	        long min = 0; 
	        long sec = 0; 
	        try { 
	            one = df.parse(str1); 
	            two = df.parse(str2); 
	            long time1 = one.getTime(); 
	            long time2 = two.getTime(); 
	            long diff ; 
	            if(time1<time2) { 
	                diff = time2 - time1; 
	            } else { 
	                diff = time1 - time2; 
	            } 
	            day = diff / (24 * 60 * 60 * 1000); 
	            hour = (diff / (60 * 60 * 1000) - day * 24); 
	            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60); 
	            sec = (diff/1000-day*24*60*60-hour*60*60-min*60); 
	        } catch (ParseException e) { 
	            e.printStackTrace(); 
	        } 
	        //System.out.println( day + "天" + hour + "小时" + min + "分" + sec + "秒");
	        
	        if ("1".equals(bz)){
	        	return day*60;
	        }else if ("2".equals(bz)){
	        	return day*60+hour;
	        }else if ("3".equals(bz)){
	        	return day*60*60+hour*60+min;
	        }else{
	        	return day*60*60*60+hour*60*60+min*60+sec; 
	        }
	       
	    } 
	    /**
		  * 计算两个日期相隔的天数  
		  * @param firstString
		  * @param secondString
		  * @return
		  */
		public static int dateTs2(String firstString,String secondString) throws Exception{
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
	         Date  firstDate = null;  
	         Date  secondDate = null;  
	         try {
				 firstDate  = df.parse(firstString);
				 secondDate = df.parse(secondString);  
			 } catch (ParseException e) {
				e.printStackTrace();
			 }  
	         int   nDay = (int)((secondDate.getTime()-firstDate.getTime())/(24*60*60*1000));  
	         //System.out.println(  nDay  );
	         return   nDay; 
			
		}
		
		/**
		 * 返回该日期所在月的第一天时间
		 * @param date
		 * @return
		 */
		public static Date getMonthDate(Date date){
			Calendar c = Calendar.getInstance(Locale.CHINA);
			c.setTime(date);
			c.set(Calendar.DAY_OF_MONTH, 1);
			return c.getTime();
		}
		
		/**
		 * 得到该日的上一天
		 * @param date
		 * @return
		 */
		public static Date getPreDay(Date date){
			Calendar c = Calendar.getInstance(Locale.CHINA);
			c.setTime(date);
			long timeMillis = c.getTimeInMillis();
			timeMillis = timeMillis-24*60*60*1000;
			c.setTimeInMillis(timeMillis);
			return c.getTime();
		}
		/**
		 * 得到该日的下一天
		 * @param date
		 * @return
		 */
		public static Date getNextDay(Date date){
			Calendar c = Calendar.getInstance(Locale.CHINA);
			c.setTime(date);
			long timeMillis = c.getTimeInMillis();
			timeMillis = timeMillis+24*60*60*1000;
			c.setTimeInMillis(timeMillis);
			return c.getTime();
		}
		/**
		 * 返回该月有多少天
		 * @param date
		 * @return
		 */
		public static int getDaysOfMonth(Date date){
			if(date == null){
				throw new NullPointerException("Exception: date can not be null;");
			}
			Calendar c = Calendar.getInstance(Locale.CHINA);
			c.setTime(date);
			int month = c.get(Calendar.MONTH);
			int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
			if(month != 1){
				return days[month];
			}else{
				if(isLeapYear(date)){
					return 29;
				}else{
					return 28;
				}
			}
		}
		/**
		 * 返回该年是否是闰年
		 * @param date
		 * @return
		 */
		public static boolean isLeapYear(Date date){
			if(date == null){
				throw new NullPointerException("Exception: date can not be null;");
			}
			Calendar c = Calendar.getInstance(Locale.CHINA);
			c.setTime(date);
			int year = c.get(Calendar.YEAR);
			return isLeapYear(year);
		}
		
		/**
		 * 返回该年是否是闰年
		 * @param year
		 * @return
		 */
		public static boolean isLeapYear(int year){
			if(year%400==0) return true;
			if(year%100 == 0) return false;
			if(year%4 == 0) return true;
			return false;
		}
		
		/**
		 * 得到该日期之后相隔offset天的日期<br>
		 * 当offset<0时候，为得到该日期之前的日期
		 * @param date
		 * @param offset
		 * @return
		 */
		public static Date getDateAfter(Date date,int offset){
			Calendar c = Calendar.getInstance(Locale.CHINA);
			c.setTime(date);
			c.add(Calendar.DATE, offset);
			return c.getTime();
		}
		/**
		 * 得到该日期之前相隔offset天的日期<br>
		 * 当offset<0时候，为得到该日期之后的日期
		 * @param date
		 * @param offset
		 * @return
		 */
		public static Date getDateBefore(Date date,int offset){
			Calendar c = Calendar.getInstance(Locale.CHINA);
			c.setTime(date);
			c.add(Calendar.DATE, -offset);
			return c.getTime();
		}
		
		/**
		 * 比较第一个日期是否在第二个之前
		 * @param srcDate
		 * 		第一个日期
		 * @param descDate
		 * 		第二个日期
		 * @return
		 */
		public static boolean isDateBefore(Date srcDate,Date descDate){
			if(srcDate == null || descDate == null) throw new NullPointerException("Exception: date can not be null;");
			if(srcDate.getTime()<descDate.getTime()) return true;
			return false;
		}
		/**
		 * 根据指定的格式比较第一个日期是否在第二个日期之前
		 * @param srcDate
		 * @param descDate
		 * @param format
		 * @return
		 */
		public static boolean isDateBefore(Date srcDate,Date descDate, String format){
			String t1 = dateToString(srcDate, format);
			String t2 = dateToString(descDate, format);
			int result = t1.compareTo(t2);
			if(result<0){
				return true;
			}else{
				return false;
			}
		}
		/**
		 * 根据指定的格式判断两个日期是否相等
		 * @param srcDate
		 * @param descDate
		 * @param format
		 * @return
		 */
		public static boolean isDateEqual(Date srcDate,Date descDate, String format){
			String t1 = dateToString(srcDate, format);
			String t2 = dateToString(descDate, format);
			int result = t1.compareTo(t2);
			if(result==0){
				return true;
			}else{
				return false;
			}
		}
		/**
		 * 根据指定的格式或符号将第一个和第二个进行比较并且返回是否符合条件
		 * @param srcDate
		 * 		第一个日期
		 * @param descDate
		 * 		第二个日期
		 * @param format
		 * 		指定日期格式
		 * @param symbol
		 * 		比较符号</br>
		 * 		>,	大于</br>
		 * 		<,	小于</br>
		 * 		=,	等于</br>
		 * 		>=,	大于等于</br>
		 * 		<=,	小于等于</br>
		 * 		!=	不等于</br>
		 * @return
		 */
		public static boolean dateCompare(Date srcDate,Date descDate, String format, String symbol){
			String t1 = dateToString(srcDate, format);
			String t2 = dateToString(descDate, format);
			int result = t1.compareTo(t2);
			if(">".equals(symbol)){
				if(result>0) return true;
			}
			if("<".equals(symbol)){
				if(result<0) return true;
			}
			if("=".equals(symbol)){
				if(result==0) return true;
			}
			if(">=".equals(symbol)){
				if(result>0 || result==0) return true;
			}
			if("<=".equals(symbol)){
				if(result<0 || result==0) return true;
			}
			if("!=".equals(symbol)){
				if(result != 0) return true;
			}
			return false;
		}
		/**
		 * 返回该日期是该周的第几天;<br>
		 * 如星期一为第一天，星期二为第二天，以此类推
		 * @param date
		 * @return
		 */
		public static int dayOfWeek(Date date){
			Calendar c = Calendar.getInstance(Locale.CHINA);
			c.setTime(date);
			c.setFirstDayOfWeek(Calendar.MONDAY);
			int result = c.get(Calendar.DAY_OF_WEEK);
			if(result == 1){
				return 7;
			}else{
				return result-1;
			}
		}
		/**
		 * 
		 * 得到日期每月的最后一天
		 *
		 */
		public   static   Date   getLastDayOfMonth(Date   sDate1)   {  
	        Calendar   cDay1   =   Calendar.getInstance();  
	        cDay1.setTime(sDate1);  
	        final   int   lastDay   =   cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);  
	        Date   lastDate   =   cDay1.getTime();  
	        lastDate.setDate(lastDay);  
	        return   lastDate;  
		}  
		
		public static void main(String[] args) {
			Long ts = DateUtils.getDistanceTime(DateUtils.getSystemDateTimeString(), DateUtils.getFullString(DateUtils.getLastDayOfMonth(new Date()) ),"1" );
			System.out.println("天数："+ ts );
		}
		 /** 
	     * 获取当年的第一天 
	     * @param year 
	     * @return 
	     */  
	    public static Date getCurrYearFirst(){  
	        Calendar currCal=Calendar.getInstance();    
	        int currentYear = currCal.get(Calendar.YEAR);  
	        return getYearFirst(currentYear);  
	    }  
	      
	    /** 
	     * 获取当年的最后一天 
	     * @param year 
	     * @return 
	     */  
	    public static Date getCurrYearLast(){  
	        Calendar currCal=Calendar.getInstance();    
	        int currentYear = currCal.get(Calendar.YEAR);  
	        return getYearLast(currentYear);  
	    }  
	      
	    /** 
	     * 获取某年第一天日期 
	     * @param year 年份 
	     * @return Date 
	     */  
	    public static Date getYearFirst(int year){  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.clear();  
	        calendar.set(Calendar.YEAR, year);  
	        Date currYearFirst = calendar.getTime();  
	        return currYearFirst;  
	    }  
	      
	    /** 
	     * 获取某年最后一天日期 
	     * @param year 年份 
	     * @return Date 
	     */  
	    public static Date getYearLast(int year){  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.clear();  
	        calendar.set(Calendar.YEAR, year);  
	        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
	        Date currYearLast = calendar.getTime();  
	          
	        return currYearLast;  
	    } 
		
		
		
}
