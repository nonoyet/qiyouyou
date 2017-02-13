package com.lnet.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * 字符串处理类<br>
 * 
 * @author redstorm
 * @version 2011-3-15
 * 
 */
@SuppressWarnings("restriction")
public class StringUtils {

	private static Logger logger = LogManager.getLogger(StringUtils.class);

	public static final String enterNewline = String.valueOf((char) 13)
			+ String.valueOf((char) 10);

	public StringUtils() {
	}

	/**
	 * null 转换为空字符串<br>
	 * 
	 * @param temp
	 *            需要转换的字符串
	 * @return String
	 */
	public static String nullToStr(String temp) {
		if (temp == null)
			temp = "";
		return temp;
	}

	/**
	 * 判断字符串是否为空，空格、回车符、换行符、Tab符默认为空<br>
	 * 
	 * @param str
	 *            判断的字符串
	 * @return boolean 返回是否为空(为null时返回true)
	 */
	public static boolean isBlank(String temp) {
		boolean returnValue = true;
		if (temp != null) {
			returnValue = temp.matches("\\s*");
		}
		return returnValue;
	}

	/**
	 * 两个字符串连接，null 按空字符串处理<br>
	 * 
	 * @param str1
	 *            字符串1
	 * @param str2
	 *            字符串2
	 * @return String
	 */
	public static String stringConcat(String str1, String str2) {
		String temp = "";
		if (str1 != null) {
			temp = str1;
		}
		if (str2 != null) {
			temp = temp.concat(str2);
		}
		return temp;
	}

	/**
	 * 返回字符串分割后的字符串数组,不同于 String.split() 方法,可以正确的得到特殊字符的分割结果<br>
	 * 
	 * @param str
	 *            被分割的字符串
	 * @param splitStr
	 *            分割符,可以是一个字符串
	 * @return String[]
	 */
	public static String[] split(String str, String splitStr) {
		List<String> coll = new ArrayList<String>();
		if (str != null && !"".equals(str) && splitStr != null
				&& !"".equals(splitStr)) {
			String tempStr = str;
			int at = tempStr.indexOf(splitStr);
			while (at != -1) {
				coll.add(tempStr.substring(0, at));
				tempStr = tempStr.substring(at + splitStr.length());
				at = tempStr.indexOf(splitStr);
			}
			coll.add(tempStr);
		}
		return (String[]) coll.toArray(new String[0]);
	}

	/**
	 * 去掉字符串的单引号与双引号<br>
	 * 
	 * @param str
	 * @return String
	 */
	public static String clearMark(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll("'", "");
			returnValue = returnValue.replaceAll("\"", "");
		}
		return returnValue;
	}

	/**
	 * 文本字符串转换成HTML格式<br>
	 * 
	 * @param str
	 *            需要转换的字符串 <li>& 转换成 ＆amp; <li>空格 转换成 ＆nbsp; <li>" 转换成 ＆quot;
	 *            <li>< 转换成 ＆lt; <li>>转换成 ＆gt; <li>\n 转换成 ＜br＞
	 * @return String
	 */
	public static String txtToHtml(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll("&", "&amp;");
			returnValue = returnValue.replaceAll(" ", "&nbsp;");
			returnValue = returnValue.replaceAll("\"", "&quot;");
			returnValue = returnValue.replaceAll("<", "&lt;");
			returnValue = returnValue.replaceAll(">", "&gt;");
			returnValue = returnValue.replaceAll("\n", "<br>");
		}
		return returnValue;
	}

	/**
	 * 文本字符串转换成HTML格式<br>
	 * （不替换 ＆符号）
	 * 
	 * @param str
	 *            需要转换的字符串 <li>空格 转换成 ＆nbsp; <li>" 转换成 ＆quot; <li>< 转换成 ＆lt; <li>>
	 *            转换成 ＆gt; <li>\n 转换成 ＜br＞
	 * @return String
	 */
	public static String txtToHtml2(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll(" ", "&nbsp;");
			returnValue = returnValue.replaceAll("\"", "&quot;");
			returnValue = returnValue.replaceAll("<", "&lt;");
			returnValue = returnValue.replaceAll(">", "&gt;");
			returnValue = returnValue.replaceAll("\n", "<br>");
		}
		return returnValue;
	}

	/**
	 * HTML格式的字符串转换成文本格式<br>
	 * 
	 * @param str
	 *            需要转换的字符串 <li>＆amp; 转换成 & <li>＆nbsp; 转换成 空格 <li>＆quot; 转换成 "
	 *            <li>＆lt; 转换成 < <li>＆gt; 转换成 > <li>＜br＞ 转换成 \n <li>＜br/＞ 转换成 \n
	 * @return String
	 */
	public static String htmlToTxt(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = returnValue.replaceAll("<br/>", "\n");
			returnValue = returnValue.replaceAll("<br>", "\n");
			returnValue = returnValue.replaceAll("&lt;", "<");
			returnValue = returnValue.replaceAll("&gt;", ">");
			returnValue = returnValue.replaceAll("&nbsp;", " ");
			returnValue = returnValue.replaceAll("&amp;", "&");
			returnValue = returnValue.replaceAll("&quot;", "\"");
		}
		return returnValue;
	}

	/**
	 * 当前字符转换行符转换成空格<br>
	 * 
	 * @param str
	 *            需要转换的字符串 (char)13 + (char)10 转换成 空格
	 * @return String
	 */
	public static String enterToSpace(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll("\n", " ");
			returnValue = returnValue.replaceAll(enterNewline, " ");
			returnValue = returnValue
					.replaceAll(String.valueOf((char) 13), " ");
		}
		return returnValue;
	}

	/**
	 * 当前字符转换行符转换成空格<br>
	 * 
	 * @param str
	 *            需要转换的字符串 (char)13 + (char)10 转换成 空字符串
	 * @return String
	 */
	public static String enterToEmpty(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll("\n", "");
			returnValue = returnValue.replaceAll(enterNewline, "");
			returnValue = returnValue.replaceAll(String.valueOf((char) 13), "");
		}
		return returnValue;
	}

	/**
	 * 取得SQL中的条件表达式<br>
	 * 
	 * @param str
	 *            需要转换的字符串 '（单引号） 转换成 ''（两个单引号，SQL中默认两个单引号为一个单引号字符）
	 * @return String
	 */
	public static String getSqlExpression(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll("'", "''");
		}
		return returnValue;
	}

	/**
	 * 当前字符转换行符转换成回车符<br>
	 * 
	 * @param str
	 *            需要转换的字符串 (char)13 + (char)10 转换成 (char)13 回车符
	 * @return String
	 */
	public static String enterConvert(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll(enterNewline, String
					.valueOf((char) 13));
		}
		return returnValue;
	}

	/**
	 * 取得JS的字符串（主要处理特殊字符）<br>
	 * 
	 * @param str
	 * @return String
	 */
	public static String getStringForJS(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str;
			returnValue = returnValue.replaceAll("\\\\", "\\\\\\\\");
			returnValue = returnValue.replaceAll("\"", "\\\\\"");
			returnValue = returnValue.replaceAll(enterNewline, "\\n");
			returnValue = returnValue.replaceAll(String.valueOf((char) 13),
					"\\n");
			returnValue = returnValue.replaceAll("\n", "\\n");
		}
		return returnValue;
	}

	/**
	 * 取得JS要替换的字符串正则表达式（主要处理特殊字符）<br>
	 * 
	 * @param str
	 * @return String
	 */
	public static String getStringForJSReplace(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str;
			returnValue = returnValue.replaceAll("\\\\", "\\\\\\\\\\\\\\\\");
			returnValue = returnValue.replaceAll("\"", "\\\\\\\\\"");
			returnValue = returnValue.replaceAll(enterNewline, "\\\\\\\\n");
			returnValue = returnValue.replaceAll(String.valueOf((char) 13),
					"\\\\\\\\n");
			returnValue = returnValue.replaceAll("\n", "\\\\\\\\n");
		}
		return returnValue;
	}

	/**
	 * 取得当前URL完整地址，包括参数字符串<br>
	 * 
	 * @param request
	 *            当前的 request 对象
	 * @return String
	 */
	public static String getCurURL(HttpServletRequest request) {
		String returnValue = request.getRequestURI();
		String queryString = request.getQueryString();
		if (queryString != null) {
			returnValue = returnValue + "?" + queryString;
		}
		return returnValue;
	}

	/**
	 * 取得当前URL替换后的完整地址<br>
	 * <br>
	 * （注意：如替换的参数名不存则增加，参数值为中文直接用URLEncode方法转换，queryString中如有多个相同的参数则同时替换）
	 * 
	 * @param request
	 *            当前的 request 对象
	 * @param parameterMap
	 *            替换的参数名与值的Map集合
	 * @return String
	 */
	public static String getCurURLReplaced(HttpServletRequest request,
			Map parameterMap) {
		String requestUri = request.getRequestURI();
		String queryString = request.getQueryString();
		return getCurURLReplaced(requestUri, queryString, parameterMap);
	}

	/**
	 * 取得当前URL替换后的完整地址<br>
	 * <br>
	 * （注意：如替换的参数名不存则增加，参数值为中文直接用URLEncode方法转换，queryString中如有多个相同的参数则同时替换）
	 * 
	 * @param requestUri
	 *            当前的请求地址
	 * @param queryString
	 *            当前请求地址中的get参数字符串
	 * @param parameterMap
	 *            替换的参数名与值的Map集合
	 * @return String
	 */
	public static String getCurURLReplaced(String requestUri,
			String queryString, Map parameterMap) {
		String returnValue = "";
		requestUri = nullToStr(requestUri);
		if (parameterMap == null || parameterMap.isEmpty()) { // 参数为空
			if (queryString == null || "".equals(queryString)) {
				returnValue = requestUri;
			} else {
				returnValue = requestUri + "?" + queryString;
			}
		} else {
			String key, value;
			if (queryString == null || "".equals(queryString)) { // 本身没有参数
				StringBuffer sb = new StringBuffer();
				Iterator iterator = parameterMap.keySet().iterator();
				while (iterator.hasNext()) { // 不存在的新增
					key = (String) iterator.next();
					value = (String) parameterMap.get(key);
					if (sb.length() == 0) {
						sb.append("?");
					} else {
						sb.append("&");
					}
					sb.append(key + "=" + URLEncode(value));
				}
				returnValue = requestUri + sb.toString();

			} else { // 本身有参数
				StringBuffer sb = new StringBuffer();
				String[] tempArray = queryString.split("&");
				Map addMap = new HashMap(parameterMap);
				for (int i = 0; i < tempArray.length; i++) {
					String[] keyArray = tempArray[i].split("=");
					key = keyArray[0];
					sb.append("&");
					if (parameterMap.containsKey(key)) {
						value = (String) parameterMap.get(key);
						sb.append(key + "=" + URLEncode(value));
						addMap.remove(key);
					} else {
						sb.append(tempArray[i]);
					}
				}
				Iterator iterator = addMap.keySet().iterator();
				while (iterator.hasNext()) { // 不存在的新增
					key = (String) iterator.next();
					value = (String) addMap.get(key);
					sb.append("&" + key + "=" + URLEncode(value));
				}
				returnValue = requestUri + "?" + sb.toString().substring(1);
			}
		}
		return returnValue;
	}

	/**
	 * 中文字符串转换，转成 ISO8859-1 编码格式<br>
	 * 
	 * @param str
	 * @return String
	 */
	public static String getCharSetISO8859(String str) {
		try {
			if (str == null)
				return "";
			String tempStr = str;
			byte[] tempArray = tempStr.getBytes("ISO8859-1");
			String temp = new String(tempArray);
			return temp;
		} catch (Exception ex) {
			logger.error("中文字符串转换出错: " + ex.getMessage(), ex);
		}
		return "";
	}

	/**
	 * 中文字符串转换，转成 UTF8 编码格式<br>
	 * 
	 * @param str
	 * @return String
	 */
	public static String getCharSetUTF8(String str) {
		try {
			if (str == null)
				return "";
			String tempStr = str;
			byte[] tempArray = tempStr.getBytes();
			String temp = new String(tempArray, "UTF8");
			return temp;
		} catch (Exception ex) {
			logger.error("中文字符串转换出错: " + ex.getMessage(), ex);
		}
		return "";
	}

	/**
	 * URL中的中文字符串转换<br>
	 * 
	 * <p>
	 * 说明：没有通过页面提交的，则用java.net.URLDecoder.decode(str, "UTF8")还原
	 * </p>
	 * 
	 * @param str
	 * @return String
	 */
	public static String URLEncode(String str) {
		String returnValue = "";
		try {
			if (str != null) {
				returnValue = java.net.URLEncoder.encode(str, "UTF8");
			}
		} catch (Exception ex) {
			logger.error("URL中的中文字符串转换出错: " + ex.getMessage(), ex);
		}
		return returnValue;
	}

	/**
	 * URL中的中文字符串还原<br>
	 * 
	 * <p>
	 * 说明：直接用URLEncode()的返回值调用该方法是无效的，必须是在请求页面中调用才能还原，因为页面请求是按 ISO8859-1 格式编码的
	 * </p>
	 * 
	 * @param str
	 * @return String
	 */
	public static String URLDecode(String str) {
		String returnValue = "";
		try {
			if (str != null) {
				byte[] tempArray = str.getBytes("ISO8859-1");
				returnValue = new String(tempArray, "UTF8");
			}
		} catch (Exception ex) {
			logger.error("URL中的中文字符串还原出错: " + ex.getMessage(), ex);
		}
		return returnValue;
	}

	/**
	 * 取得字符串长度(一个汉字为两个字符长度)<br>
	 * 
	 * @param sourceStr
	 *            需要处理的字符串
	 * @return long
	 */
	public static long getStringLength(String sourceStr) {
		long returnValue = 0;
		if (sourceStr == null) {
			return (returnValue);
		}
		for (int i = 0; i < sourceStr.length(); i++) {
			char[] tempChar = sourceStr.substring(i, i + 1).toCharArray();
			if ((int) tempChar[0] > 255)
				returnValue += 2;
			else
				returnValue++;
		}
		return returnValue;
	}

	/**
	 * 取得重复次数的字符串<br>
	 * 
	 * @param sourceStr
	 *            重复源
	 * @param repeatTimes
	 *            重复次数
	 * @return String
	 */
	public static String getRepeatString(String sourceStr, long repeatTimes) {
		if (repeatTimes == 0) {
			return "";
		}
		StringBuffer returnStr = new StringBuffer();
		for (int i = 0; i < repeatTimes; i++) {
			returnStr.append(sourceStr);
		}
		return returnStr.toString();
	}

	/**
	 * 取得指定长度的左字符串,不足长度的以 replaceString 右填充<br>
	 * 
	 * @param sourceStr
	 *            需要处理的字符串
	 * @param specityLength
	 *            指定长度(一个汉字为两个字符长度,如果截断地方为一个汉字,则可能长度小1)
	 * @param replaceString
	 *            不足长度时填充的字符
	 * @return String
	 */
	public static String getLeftSpecifyString(String sourceStr,
			long specityLength, String replaceString) {
		if (sourceStr == null) {
			return (getRepeatString(replaceString, specityLength));
		}
		long realLength = getStringLength(sourceStr);
		StringBuffer returnStr = new StringBuffer();
		if (realLength < specityLength) {
			returnStr.append(sourceStr);
			returnStr.append(getRepeatString(replaceString, specityLength
					- realLength));
		} else {
			returnStr.append(getLeftString(sourceStr, specityLength));
		}
		return returnStr.toString();
	}

	/**
	 * 取得字符串的左子串,长度由 leftLength 指定<br>
	 * 
	 * @param sourceStr
	 *            需要处理的字符串
	 * @param leftLength
	 *            指定长度,从左边取该长度(一个汉字为两个字符长度,如果截断地方为一个汉字,则可能长度小1)
	 * @return String
	 */
	public static String getLeftString(String sourceStr, long leftLength) {
		StringBuffer returnStr = new StringBuffer();
		long tempLength = 0;
		for (int i = 0; i < sourceStr.length(); i++) {
			String tempStr = sourceStr.substring(i, i + 1);
			char[] tempChar = tempStr.toCharArray();
			if ((int) tempChar[0] > 255)
				tempLength += 2;
			else
				tempLength++;
			if (tempLength < leftLength) {
				returnStr.append(tempStr);
			} else {
				if (tempLength == leftLength)
					returnStr.append(tempStr);
				break;
			}
		}
		return returnStr.toString();
	}

	/**
	 * 取得指定长度的右字符串,不足长度的以 replaceString 左填充<br>
	 * 
	 * @param sourceStr
	 *            需要处理的字符串
	 * @param specityLength
	 *            指定长度(一个汉字为两个字符长度,如果截断地方为一个汉字,则可能长度小1)
	 * @param replaceString
	 *            不足长度时填充的字符
	 * @return String
	 */
	public static String getRightSpecifyString(String sourceStr,
			long specityLength, String replaceString) {
		if (sourceStr == null) {
			return (getRepeatString(replaceString, specityLength));
		}
		long realLength = getStringLength(sourceStr);
		StringBuffer returnStr = new StringBuffer();
		if (realLength < specityLength) {
			returnStr.append(getRepeatString(replaceString, specityLength
					- realLength));
			returnStr.append(sourceStr);
		} else {
			returnStr.append(getRightString(sourceStr, specityLength));
		}
		return returnStr.toString();
	}

	/**
	 * 取得字符串的右子串,长度由 leftLength 指定<br>
	 * 
	 * @param sourceStr
	 *            需要处理的字符串
	 * @param rightLength
	 *            指定长度,从右边取该长度(一个汉字为两个字符长度,如果截断地方为一个汉字,则可能长度小1)
	 * @return String
	 */
	public static String getRightString(String sourceStr, long rightLength) {
		StringBuffer returnStr = new StringBuffer();
		long tempLength = 0;
		for (int i = sourceStr.length() - 1; i >= 0; i--) {
			String tempStr = sourceStr.substring(i, i + 1);
			char[] tempChar = tempStr.toCharArray();
			if ((int) tempChar[0] > 255)
				tempLength += 2;
			else
				tempLength++;
			if (tempLength < rightLength) {
				returnStr.insert(0, tempStr);
			} else {
				if (tempLength == rightLength)
					returnStr.insert(0, tempStr);
				break;
			}
		}
		return returnStr.toString();
	}

	/**
	 * 取得指定长度的字符串,长度由 targetlength 指定<br>
	 * 
	 * @param sourceString
	 *            需要处理的字符串
	 * @param targetlength
	 *            指定长度,从左边取该长度(一个汉字为两个字符长度)
	 * @return String
	 */
	public static String displayTitle(String sourceString, long targetlength) {
		String returnValue = "";
		if (sourceString != null) {
			if (getStringLength(sourceString) <= targetlength * 2)
				returnValue = sourceString;
			else
				returnValue = getLeftString(sourceString,
						(targetlength - 1) * 2)
						+ "…";
		}
		return returnValue;
	}

	/**
	 * 把格式化的日期转换为没有分隔符的字数日期
	 * 
	 * @param s
	 * @return
	 */
	public static String changeTime(String s) {
		String time = "";
		if (!"".equals(s)) {
			String[] ss = s.split(" ");

			if (ss.length == 2) {
				String[] sss = ss[0].split("-");
				String[] sss2 = ss[1].split(":");
				for (int i = 0; i < sss.length; i++) {
					time = time + sss[i];
				}
				for (int i = 0; i < sss2.length; i++) {
					time = time + sss2[i];
				}
			} else if (ss.length == 1) {
				String[] sss = ss[0].split("-");
				if (sss.length == 1) {
					time = sss[0];
				} else {
					for (int i = 0; i < sss.length; i++) {
						time = time + sss[i];
					}
				}
			}
		}
		return time;
	}
	/**
	 * 每perNum个字符就插入addStr
	 * @param str
	 * 		原字符串
	 * @param perNum
	 * 		每隔多少字符
	 * @param addStr
	 * 		待插入字符串
	 * @return
	 */
	public static String strInsert(String str,int perNum,String addStr){
		if(str == null) return null;
		int len = str.length();
		if(len<=perNum) return str+addStr;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<len/perNum;i++){
			if(i == len/perNum-1){
				sb.append(str.substring(i*perNum));
			}else{
				sb.append(str.substring(i*perNum, (i+1)*perNum));
			}
			sb.append(addStr);
		}
		return sb.toString();
	}
	/**
	 * 取得人民币大写金额<br>
	 * 
	 * @param money
	 * @return String
	 */
	public static String getChineseMoney(double money) {
		if (money > 999999999999999.99 || money < 0) { // 不符合的数值
			return "";
		}
		if (money == 0) {
			return "零元整";
		}
		StringBuffer returnValue = new StringBuffer();
		String chinaDigital[] = new String[] { "零", "壹", "贰", "叁", "肆", "伍",
				"陆", "柒", "捌", "玖" };
		String chinaUnit[] = new String[] { "仟", "佰", "拾", "万", "仟", "佰", "拾",
				"亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "", "元", "角", "分" };
		java.text.DecimalFormat fmt = new java.text.DecimalFormat(".00");
		String moneyStr = fmt.format(money);
		int moneyLength = moneyStr.length();
		String tempChar = "";
		int tempInt = 0;
		int tempAtArray = 0;
		int zeroCount = 0; // 记0个数
		boolean lastZero = false;
		for (int i = 0; i < moneyLength; i++) {
			tempChar = moneyStr.substring(i, i + 1);
			if (".".equals(tempChar)) {
				if (money >= 1) {
					returnValue.append("元");
				}
			} else {
				tempInt = Integer.parseInt(tempChar);
				tempAtArray = 19 - moneyLength + i;
				if (tempInt == 0) { // 为零的处理
					lastZero = true;
					zeroCount++;
					if (tempAtArray == 7
							|| (tempAtArray % 4 == 3 && zeroCount < 4)) { // 亿必需出现
						returnValue.append(chinaUnit[tempAtArray]);
						zeroCount = 0;
					}
				} else {
					zeroCount = 0;
					if (lastZero) {
						if (money >= 1) {
							returnValue.append(chinaDigital[0]);
						}
					}
					returnValue.append(chinaDigital[tempInt]);
					returnValue.append(chinaUnit[tempAtArray]);
					lastZero = false;
				}
			}
		}
		if (moneyStr.endsWith("0")) {
			returnValue.append("整");
		}
		return returnValue.toString();
	}

	/**
	 * 判断字符串是否为空，空格、回车符、换行符、Tab符默认为空<br>
	 * 
	 * @param str
	 *            判断的字符串
	 * @return boolean 返回是否为空(为null时返回true)
	 */
	public static boolean isBlank(Object temp) {
		boolean returnValue = true;
		if (temp != null) {
			if (temp instanceof String)
				returnValue = temp.toString().matches("\\s*");
			else
				returnValue = false;
		}
		return returnValue;
	}

	/**
	 * 取得用人民币大写金额表示的整数,格式如: (贰仟零捌万零伍佰壹拾贰)<br>
	 * 
	 * @param money
	 * @return String
	 */
	public static String getChineseNumberAsMoney(long money) {
		if (money > 999999999999999.99 || money < 0) { // 不符合的数值
			return "";
		}
		if (money == 0) {
			return "零";
		}
		StringBuffer returnValue = new StringBuffer();
		String chinaDigital[] = new String[] { "零", "壹", "贰", "叁", "肆", "伍",
				"陆", "柒", "捌", "玖" };
		String chinaUnit[] = new String[] { "仟", "佰", "拾", "万", "仟", "佰", "拾",
				"亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "", "", "", "" };
		java.text.DecimalFormat fmt = new java.text.DecimalFormat(".00");
		String moneyStr = fmt.format(money);
		int moneyLength = moneyStr.length();
		String tempChar = "";
		int tempInt = 0;
		int tempAtArray = 0;
		int zeroCount = 0; // 记0个数
		boolean lastZero = false;
		for (int i = 0; i < moneyLength; i++) {
			tempChar = moneyStr.substring(i, i + 1);
			if (".".equals(tempChar)) {
				if (money >= 1) {
					// returnValue.append("元");
				}
			} else {
				tempInt = Integer.parseInt(tempChar);
				tempAtArray = 19 - moneyLength + i;
				if (tempInt == 0) { // 为零的处理
					lastZero = true;
					zeroCount++;
					if (tempAtArray == 7
							|| (tempAtArray % 4 == 3 && zeroCount < 4)) { // 亿必需出现
						returnValue.append(chinaUnit[tempAtArray]);
						zeroCount = 0;
					}
				} else {
					zeroCount = 0;
					if (lastZero) {
						if (money >= 1) {
							returnValue.append(chinaDigital[0]);
						}
					}
					returnValue.append(chinaDigital[tempInt]);
					returnValue.append(chinaUnit[tempAtArray]);
					lastZero = false;
				}
			}
		}
		return returnValue.toString();
	}

	/**
	 * 取得 0 到 999999999 之间的数字中文字符串,格式如: (二千零八万零五百一十二)<br>
	 * 
	 * @param num
	 * @return String
	 */
	public static String getChineseNumber(long number) {
		if (number > 999999999 || number < 0) { // 不符合的数值
			return "";
		}
		if (number == 0) {
			return "零";
		}
		StringBuffer returnValue = new StringBuffer();
		String chinaDigital[] = new String[] { "零", "一", "二", "三", "四", "五",
				"六", "七", "八", "九" };
		String chinaUnit[] = new String[] { "亿", "千", "百", "十", "万", "千", "百",
				"十", "" };
		String tempStr = "" + number;
		int numberLength = tempStr.length();
		String tempChar = "";
		int tempInt = 0;
		int tempAtArray = 0;
		int zeroCount = 0;
		boolean lastZero = false;
		for (int i = 0; i < numberLength; i++) {
			tempChar = tempStr.substring(i, i + 1);
			tempInt = Integer.parseInt(tempChar);
			tempAtArray = 9 - numberLength + i;
			if (tempInt == 0) { // 为零的处理
				lastZero = true;
				zeroCount++;
				if (tempAtArray == 0 || (tempAtArray % 4 == 0 && zeroCount < 4)) { // 亿必需出现
					returnValue.append(chinaUnit[tempAtArray]);
					zeroCount = 0;
				}
			} else {
				zeroCount = 0;
				if (lastZero) {
					if (number >= 1) {
						returnValue.append(chinaDigital[0]);
					}
				}
				returnValue.append(chinaDigital[tempInt]);
				returnValue.append(chinaUnit[tempAtArray]);
				lastZero = false;
			}
		}
		return returnValue.toString();
	}

	/**
	 * 将 15 位身份证号码转换为 18 位身份证号码<br>
	 * 
	 * @param sfzh
	 * @return String
	 */
	public static String convertTo18Sfzh(String sfzh) {
		String returnValue = sfzh;
		try {
			if (sfzh.length() == 15) {
				String tempStr1 = sfzh.substring(0, 6);
				String tempStr2 = "19" + sfzh.substring(6);
				String tempStrAll = tempStr1 + tempStr2;
				int lastAt = 0;
				for (int i = 0; i < 17; i++) {
					int bitInt = Integer.parseInt(tempStrAll
							.substring(i, i + 1));
					int bitIntTemp = 1;
					for (int j = 0; j < 17 - i; j++) {
						bitIntTemp = (bitIntTemp * 2) % 11;
					}
					lastAt += bitInt * bitIntTemp;
				}
				lastAt = lastAt % 11;
				returnValue = tempStrAll
						+ "10X98765432".substring(lastAt, lastAt + 1);
			}
		} catch (Exception ex) {
			logger.error("转换成18位身份证号码出错: " + ex.getMessage(), ex);
		}
		return returnValue;
	}

	/**
	 * 是否为一个有效的 18 位身份证号码<br>
	 * 
	 * @param sfzh
	 * @return boolean
	 */
	public static boolean isValidSfzh(String sfzh) {
		boolean returnValue = false;
		try {
			if (!isBlank(sfzh)) {
				int length = sfzh.length();
				if (length == 18) {
					boolean bitValid = true;
					for (int i = 0; i < 17; i++) {
						String bitChar = sfzh.substring(i, i + 1);
						if ("1234567890".indexOf(bitChar) == -1) {
							bitValid = false;
							break;
						}
					}
					if (bitValid) {
						//java.util.Date csrq = DateUtils.stringToDate(sfzh.substring(6, 14), "yyyyMMdd");
						int lastAt = 0;
						for (int i = 0; i < 17; i++) {
							int bitInt = Integer.parseInt(sfzh.substring(i,
									i + 1));
							int bitIntTemp = 1;
							for (int j = 0; j < 17 - i; j++) {
								bitIntTemp = (bitIntTemp * 2) % 11;
							}
							lastAt += bitInt * bitIntTemp;
						}
						lastAt = lastAt % 11;
						String checkBit = "10X98765432".substring(lastAt,
								lastAt + 1);
						String lastBit = sfzh.substring(17);
						lastBit = lastBit.toUpperCase();
						if (checkBit.equals(lastBit)) {
							returnValue = true;
						}
					}
				}
			}
		} catch (Exception ex) {
			// logger.error("18 位身份证号码校验出错: " + ex.getMessage(), ex);
		}
		return returnValue;
	}

	/**
	 * 取得BASE64编码后的字符串<br>
	 * 
	 * @param str
	 * @return String
	 */
	public static String getBase64EncodeString(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			byte[] byteArray = str.getBytes();
			returnValue = new BASE64Encoder().encodeBuffer(byteArray);
			returnValue = returnValue.replaceAll(enterNewline, "");
		}
		return returnValue;
	}

	/**
	 * 取得BASE64编码后的字符串<br>
	 * 
	 * @param byteArray
	 * @return String
	 */
	public static String getBase64EncodeByte(byte[] byteArray) {
		String returnValue = "";
		if (byteArray != null && byteArray.length > 0) {
			returnValue = new BASE64Encoder().encodeBuffer(byteArray);
			returnValue = returnValue.replaceAll(enterNewline, "");
		}
		return returnValue;
	}

	/**
	 * 取得BASE64解码后的字符串<br>
	 * 
	 * @param str
	 * @return String
	 */
	public static String getBase64DecodeString(String str) {
		String returnValue = "";
		try {
			if (str != null && !"".equals(str)) {
				byte[] byteArray = new BASE64Decoder().decodeBuffer(str);
				returnValue = new String(byteArray);
			}
		} catch (Exception ex) {
			logger.error("取得BASE64解码后的字符串出错: " + ex.getMessage(), ex);
		}
		return returnValue;
	}

	/**
	 * 取得BASE64解码后的byte数组<br>
	 * 
	 * @param str
	 * @return byte[]
	 */
	public static byte[] getBase64DecodeByte(String str) {
		byte[] returnValue = null;
		try {
			if (str != null && !"".equals(str)) {
				returnValue = new BASE64Decoder().decodeBuffer(str);
			}
		} catch (Exception ex) {
			logger.error("取得BASE64解码后的byte数组出错: " + ex.getMessage(), ex);
		}
		return returnValue;
	}

	/**
	 * 取得HTML中某个结点替换后的字符串（流程定义保存HTML时用）<br>
	 * 说明：搜索到关键字后以<>为前后匹配截取
	 * 
	 * @param htmlString
	 *            HTML字符串
	 * @param searchKey
	 *            搜索关键字
	 * @param nodeString
	 *            新的结点字符串
	 * @return String
	 */
	public static String getHTMLNodeReplaceString(String htmlString,
			String searchKey, String nodeString) {
		String returnValue = htmlString;
		if (!StringUtils.isBlank(htmlString) && !StringUtils.isBlank(searchKey)) {
			int foundI = htmlString.indexOf(searchKey);
			if (foundI != -1) {
				int startI = htmlString.lastIndexOf("<", foundI);
				int endI = htmlString.indexOf(">", foundI);
				if (startI != -1 && endI != -1) {
					returnValue = htmlString.substring(0, startI)
							+ StringUtils.nullToStr(nodeString)
							+ htmlString.substring(endI + 1);
				}
			}
		}
		return returnValue;
	}

	/**
	 * 生成32位的UUID<br>
	 * 
	 * @return String
	 */
	public static String get32UUID() {
		UUID uuid = UUID.randomUUID();
		String returnValue = uuid.toString();
		returnValue = returnValue.replace("-", "");
		return returnValue;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(isBlank("\n\r \t\n\r"));
		String a = URLEncode("红色风暴&d\"\\./'");
		System.out.println(a);
		System.out.println(URLDecode(a));
		System.out.println(getChineseNumber(20080512));
		System.out.println(getChineseNumberAsMoney(20080512));

		Pattern pattern2 = Pattern
				.compile("(.*/error\\.jsp$)|(.*/ddd.jsp$)|(^kkk.*)|(.*fddd.*)|(.是是)");
		Matcher matcher2 = pattern2.matcher("dsklfjs/error.jsp");
		System.out.println(matcher2.matches());
		Matcher matcher3 = pattern2.matcher("dsklfjs/ddd.jsp");
		System.out.println(matcher3.matches());
		Matcher matcher4 = pattern2.matcher("kkksdfsp");
		System.out.println(matcher4.matches());
		Matcher matcher5 = pattern2.matcher("asdsfdddkas");
		System.out.println(matcher5.matches());
		Matcher matcher6 = pattern2.matcher(".是是");
		System.out.println(matcher6.matches());

		System.out.println("^***.SDFD*F*$".replace("*", ".*"));

		Pattern pattern = Pattern.compile("(.*[\\?|&])parameterName=(.*)");
		Matcher matcher = pattern
				.matcher("http://hong:7001/login.jsp?parameterName=mmm");
		if (matcher.find()) { // 有参数匹配
			String nextString = "";
			if (matcher.groupCount() == 2) {
				if (matcher.group(2).indexOf("&") != -1) {
					nextString = matcher.group(2);
					nextString = nextString.substring(nextString.indexOf("&"));
				}
			}
			String returnValue = matcher.group(1) + "parameterName="
					+ URLEncode("新值") + nextString;
			System.out.println(returnValue);
		}

		String requestUri = "http://hong:7001/login.jsp";
		String queryString = "userid=guest&userid&username=test&password=12345678&orgid=ddd&ooo";
		Map paraemterMap = new HashMap();
		paraemterMap.put("userid", "test");
		paraemterMap.put("username", "");
		paraemterMap.put("password", null);
		paraemterMap.put("orgid", "红色");
		paraemterMap.put("addParaemeter", "add");
		System.out.println(getCurURLReplaced(requestUri, queryString,
				paraemterMap));
		System.out.println(getSqlExpression("'sdfsd''sdfsd"));
		String bb = "sdfsdf'sdfjdsf'\"sdfdsf\"";
		System.out.println(clearMark(bb));

		System.out.println(getLeftSpecifyString("1234地5在城", 8, "0"));
		System.out.println(getRightSpecifyString("1234地地5在城", 8, "0"));

		System.out.println("32位的UUID = " + get32UUID());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(URLDecode("sds%E6%96%B0%E5%80%BCdf%25")); // 无效
		try {
			System.out.println(java.net.URLDecoder.decode(
					"sds%E6%96%B0%E5%80%BCdf%25", "UTF8")); // 正确
			String h = "3.早餐亭人气旺铺平价转让梨园北街丁字路口临中医学校";
			String h2 = h.replaceAll("[早|亭|平|转|北|字]", "<span>$0</span>");
			// $0 匹配中的字符串
			System.out.println(h2);

			// 多个字符完整匹配
			String k = "http://www.qq.com/action=12345123q";
			String k2 = k.replaceAll("(123|qq)", "<span>$0</span>");
			System.out.println(k2);
			
			// 在<a></a>之间的不替换
			String candidate = "<aqq></a>还是qq测<a sdfds>dddddddd</a>试学生<a href=\"http://www.qq.com?k=1&m=1\" target=\"_blank\">http://www.qq.com?k=1&m=1</a>另有学校qq网站<a>qq</a>";
			String replaceReg = "[qq|学生]";
			replaceReg = "qq";
			StringBuffer result = new StringBuffer();
			if (!StringUtils.isBlank(candidate)) {
				String[] tempArray = StringUtils.split(candidate, "</a>");
				for (int i = 0; i < tempArray.length; i++) {
					String tempString = tempArray[i];
					int atI = tempString.indexOf("<a");
					if (atI == -1) {
						result.append(tempString.replaceAll(replaceReg,
								"<span>$0</span>"));
					} else {
						String leftString = tempString.substring(0, atI + 2);
						leftString = leftString.replaceAll(replaceReg,
								"<span>$0</span>");
						result.append(leftString);
						result.append(tempString.substring(atI + 2));
						result.append("</a>");
					}
				}
			}
			System.out.println(result.toString());
		} catch (Exception ex) {
		}

		String relationExpression = " and b.CCC1=1 and a.DDD1=1 1=1 and a.DDD  = b.CCC";
		String sreachString = "b.CCC";
		String FK = "";
		while (relationExpression.indexOf(" =") != -1) {
			relationExpression = relationExpression.replaceAll(" =", "=");
		}
		while (relationExpression.indexOf("= ") != -1) {
			relationExpression = relationExpression.replaceAll("= ", "=");
		}
		int at_i = relationExpression.indexOf(" " + sreachString + "=");
		if (at_i != -1) {
			int at_i2 = relationExpression.indexOf(" ", at_i
					+ sreachString.length() + 2);
			if (at_i2 == -1) {
				FK = relationExpression.substring(at_i + sreachString.length()
						+ 2);
			} else {
				FK = relationExpression.substring(at_i + sreachString.length()
						+ 2, at_i2);
			}
		} else {
			at_i = relationExpression.indexOf(sreachString + "=");
			if (at_i != -1) {
				int at_i2 = relationExpression.indexOf(" ", at_i
						+ sreachString.length() + 2);
				if (at_i2 == -1) {
					FK = relationExpression.substring(at_i
							+ sreachString.length() + 1);
				} else {
					FK = relationExpression.substring(at_i
							+ sreachString.length() + 1, at_i2);
				}
			} else {
				at_i = relationExpression.indexOf("=" + sreachString + " ");
				if (at_i != -1) {
					int at_i2 = relationExpression.lastIndexOf(" ", at_i);
					if (at_i2 == -1) {
						FK = relationExpression.substring(0, at_i);
					} else {
						FK = relationExpression.substring(at_i2 + 1, at_i);
					}
				} else {
					at_i = relationExpression.indexOf("=" + sreachString);
					if (at_i != -1) {
						int at_i2 = relationExpression.lastIndexOf(" ", at_i);
						if (at_i2 == -1) {
							FK = relationExpression.substring(0, at_i);
						} else {
							FK = relationExpression.substring(at_i2 + 1, at_i);
						}
					}
				}
			}
		}
		System.out.println("FK = " + FK);
	}
	/**
	 * 判断字符串是否为空(null,"")
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(null == str) return true;
		if("".equals(str)) return true;
		return false;
	}
	/**
	 * 获取图片路径中fid的值
	 * @param str
	 * @return
	 */
	public static String getFid(String str){
		if(isEmpty(str)) return null;
		String[] spStr = str.split("fid=");
		if(spStr.length<2){
			return null;
		}
		return spStr[1].split("&")[0];
	}
	/**
	 * 将html文本转换成普通文本（直接将所有html标签置为空）
	 * @param htmlText
	 * @return
	 */
	public static String replaceHtml(String htmlText){
		if(htmlText == null) return null;
		return htmlText.replaceAll("\\&[a-zA-Z]{0,9};", "").replaceAll("<[^>]*>", "");
	}
	
	
	/**
	 * 生成数组与字母组合随机数默认15位
	 * Administrator
	 * 2016-10-21
	 */
	public static String createRandom(){
		String ID = "";
		Random random = new Random();
		String[] list = {"0","1","2","3","4","5","6","7","8","9",
				"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m",
				"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
		for(int i = 0;i<20;i++){
			ID+= list[random.nextInt(62)];
		}
		return ID;
	}
}

