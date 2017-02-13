package com.lnet.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * id自增
 * @author lihp
 *
 */
public class IdUtil {

	/**
	 * 时间形式id
	 * 适用于个体插入，精确到毫秒
	 * @return
	 */
	public static Long dateLongId(){
		Long intDate = null ;
		Date date = new Date();
		String sdate = null;
		DateFormat df = new SimpleDateFormat("yyyyMMddKKmmssSSS");
		sdate = df.format(date);
		intDate = Long.valueOf(sdate);
		return intDate;
	}
	
	/*public static void main(String[] args) {
		for (int i = 0; i <10; i++) {
			System.out.println( 	IdUtil.dateLongId()+i);	
		}
	
	}*/
}
