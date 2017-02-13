package com.lnet.util;
import java.util.Date;
/**
 * 身份证处理工具
 * @author nonoyet
 * @version 2016-07-20
 */
public class IDUtils {
	public static String WrongAddr = "不是正确的二代身份证";
	public static String UnknowAddr = "未找到地址信息";

	/**
	 * 根据身份证号获取性别(18位身份证)
	 * @param id
	 * 	身份证号
	 * @return
	 * "男"或"女"
	 */
	public static String getSex(String id){
		String sexStr = id.substring(14, 17);
		int sexCode = Integer.valueOf(sexStr)%2;
		if(sexCode == 0){
			return "女";
		}else{
			return "男";
		}
	}
	/**
	 * 根据身份证号获取出生年月(18位身份证)
	 * @param id
	 * 	身份证号
	 * @param format
	 * 	返回格式
	 * @return
	 * @throws Exception
	 */
	public static String getBirth(String id,String format) throws Exception{
		String result = DateUtils.dateToString(DateUtils.stringToDate(id.substring(6, 14),"yyyyMMdd"), format);
		return result;
	}
	/**
	 * 根据身份证号获取年龄
	 * @param id
	 * 	身份证号码
	 * @return
	 * @throws Exception
	 */
	public static int getAge(String id) throws Exception{
		String birth = getBirth(id, "yyyyMMdd");
		Date date = new Date();
		//年差
		int yearM = Integer.valueOf(DateUtils.dateToString(date, "yyyy")) - Integer.valueOf(birth.substring(0, 4));
		//月差
		int monthM = Integer.valueOf(DateUtils.dateToString(date, "MM")) - Integer.valueOf(birth.substring(4, 6));
		//日差
		int dayM = Integer.valueOf(DateUtils.dateToString(date, "dd")) - Integer.valueOf(birth.substring(6));
		
		if(yearM <=0) return 0;
		if(monthM < 0) return yearM -1;
		if(monthM >0) return yearM;
		if(monthM == 0){
			if(dayM<0) return yearM -1;
			else return yearM;
		}
		
		return 0;
	}
	/**
	 * 校验身份证
	 * @param id
	 * 	身份证号码
	 * @return
	 */
	public static boolean verfiy(String id){
		if((id+"").length() == 15) return verfiy15(id);
		if((id+"").length() == 18) return verfiy18(id);
		return false;
	}
	/**
	 * 身份证校验15位(已不用15位)
	 * @param id
	 * @return
	 */
	@Deprecated
	public static boolean verfiy15(String id){
		return false;
	}
	/**
	 * 身份证校验18位
	 * @param id
	 * 	身份证号
	 * @return
	 */
	public static boolean verfiy18(String id){
		String verfiyCode = getVerfiyCodeBy(id);
		if("-1".equals(verfiyCode)){
			return false;
		}
		return id.endsWith(verfiyCode);
	}
	/**
	 * 根据前17位得到最后一位的校验码
	 * @param id
	 * @return
	 * 		如果参数错误将返回"-1",否则返回正确的校验码
	 */
	public static String getVerfiyCodeBy(String id){
		if(id != null && id.length()>=17){
			String idPerfix = id.substring(0, 17);
			//规则
			int[] rule = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
			//校验码
			String[] lastValue = {"1","0","x","9","8","7","6","5","4","3","2"};
			int result = 0;
			for(int i=0;i<rule.length;i++){
				result += Integer.valueOf(idPerfix.charAt(i)+"")*rule[i];
			}
			int mod = result%11;
			return lastValue[mod];
			
		}else{
			return "-1";
		}
	}
}
