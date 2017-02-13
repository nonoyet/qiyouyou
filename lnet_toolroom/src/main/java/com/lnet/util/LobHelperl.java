package com.lnet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import oracle.sql.CLOB;

import org.hibernate.lob.SerializableBlob;
import org.hibernate.lob.SerializableClob;



/**
 * 处理Blob,Clob类型字段的转换工具
 * @author nonoyet
 * @version 2015-12-02
 *
 */
public class LobHelperl {
	/**
	 * 将Blob类型的值转换成String类型的值
	 * @param blob
	 * @return
	 */
	public static String blob2String(SerializableBlob blob){
		if(blob == null) return null;
		try{  
	         String result = new String(blob.getBytes((long)1, (int)blob.length()),"utf-8");  
	         return result;
	    } catch(Exception e) {  
	         e.printStackTrace();  
	    }  
		return null;
	}
	/**
	 * 将String类型的值转换成Blob类型
	 * @param str
	 * @return
	 */
	public static SerializableBlob string2Blob(String str){
		if(str == null) return null;
//	    Blob blob = Hibernate.createBlob(str.getBytes());
		SerializableBlob blob = null;
		try {
			java.sql.Blob sb = new SerialBlob(str.getBytes("utf-8"));
			blob = new SerializableBlob(sb);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blob;
	}
	/**
	 * 将clob字段转换为String
	 * @param clob
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static String Clob2String(SerializableClob clob) throws SQLException,IOException {
		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给 StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}
}
