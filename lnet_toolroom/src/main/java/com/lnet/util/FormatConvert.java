/**
 * 
 */
package com.lnet.util;

import java.text.DecimalFormat;

/**
 * 转化所虚的格式工具
 * @author lihp
 * 2016-1-7
 */
public class FormatConvert {
	
    
	/**
	 * double转化为保留小数点后几位
	 * 保留方式为四舍五入式的保存
	 */
	public static String formatDecimals(Double dd,int num){
		
		DecimalFormat df = null;
		String str = "";
		if(1==num){
			str = "0.0";
		} else if(2==num){
			str = "0.00";
		}else if(3==num){
			str = "0.000";
		}else if(4==num){
			str = "0.0000";
		}else{
			str = "0";
		}
		df = new DecimalFormat(str); //#.00 表示两位小数 #.0000四位小数 以此类推...
		
		return df.format(dd);
		
	}
	//利用递归计算阶乘
	public static int recursion(int num){
        int sum=1;
        if(num < 0)
            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常
        if(num==1){
            return 1;//根据条件,跳出循环
        }else{
            sum=num * recursion(num-1);//运用递归计算
            return sum;
        }
    }
	//计算次方
	public static Double recursion1(Long num,Long cs){
		return Math.pow(num,cs );
	}
}
