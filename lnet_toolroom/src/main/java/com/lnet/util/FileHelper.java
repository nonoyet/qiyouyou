package com.lnet.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import sun.print.resources.serviceui;

public class FileHelper {
	/**
	 * 输出文件内容到页面
	 * @param filePath 文件目录
	 * @param response
	 * @param originFileName
	 * @throws IOException 
	 */
	public static void writeFile2Page(String filePath, HttpServletResponse response, String originFileName) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		originFileName = originFileName.toLowerCase();
		File orginFile = new File(filePath + File.separator + originFileName);
		
		if (originFileName.indexOf(".xls") > 0 || originFileName.indexOf(".xlsx") > 0) {	//excel文件
			response.setContentType("application/vnd.ms-excel");
		} else if (originFileName.indexOf(".doc") > 0) {
			response.setContentType("application/vnd.msword");
		} else if (originFileName.indexOf(".pdf") > 0) {
			response.setContentType("application/pdf");
		} else {
			response.setContentType("application/octet-stream");
		}
		
		//输入流
		InputStream in = new BufferedInputStream(new FileInputStream(orginFile));
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		in.close();
		
		//输出流
		OutputStream out = response.getOutputStream();
		out.write(buffer);
		out.flush();
		out.close();
	}
	/**
	 * 
	 * @param file
	 * @param response
	 * @throws IOException
	 */
	public static void writeFile2Page(File file, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		String originFileName = (""+file.getName()).toLowerCase();
		File orginFile = file;
		
		if (originFileName.indexOf(".xls") > 0 || originFileName.indexOf(".xlsx") > 0) {	//excel文件
			response.setContentType("application/vnd.ms-excel");
		} else if (originFileName.indexOf(".doc") > 0) {
			response.setContentType("application/vnd.msword");
		} else if (originFileName.indexOf(".pdf") > 0) {
			response.setContentType("application/pdf");
		} else {
			response.setContentType("application/octet-stream");
		}
		
		//输入流
		InputStream in = new BufferedInputStream(new FileInputStream(orginFile));
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		in.close();
		
		//输出流
		OutputStream out = response.getOutputStream();
		out.write(buffer);
		out.flush();
		out.close();
	}
	/**
	 * 下载文件(方式一)
	 * @param filePath 
	 * 		文件路径
	 * @param response
	 * @param originFileName
	 * 		源文件名
	 * @param newFileName
	 * 		新文件名
	 * @throws IOException 
	 */
	public static void downloadFile1(String filePath, HttpServletResponse response, String originFileName, String newFileName) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		originFileName = originFileName.toLowerCase();
		File orginFile = new File(filePath + File.separator + originFileName);
		
		if (originFileName.indexOf(".xls") > 0 || originFileName.indexOf(".xlsx") > 0) {	//excel文件
			response.setContentType("application/vnd.ms-excel");
		} else if (originFileName.indexOf(".doc") > 0) {
			response.setContentType("application/vnd.msword");
		} else if (originFileName.indexOf(".pdf") > 0) {
			response.setContentType("application/pdf");
		} else {
			response.setContentType("application/octet-stream");
		}
		
		//输入流
		InputStream in = new BufferedInputStream(new FileInputStream(orginFile));
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		in.close();
		
		//输出流
		response.setHeader("Content-Disposition","attachment;filename=" + newFileName);
		OutputStream out = response.getOutputStream();
		out.write(buffer);
		out.flush();
		out.close();
	}
	
	/**
	 * 下载方式(方式二)
	 * @param filePath
	 * @param response
	 * @param originFileName
	 * @param newFileName
	 * @throws IOException 
	 * @return void
	 */
	public static void downloadFile2(String filePath, HttpServletResponse response, String originFileName, String newFileName) throws IOException {
		
        // 构造子节输入流
		java.io.InputStream is = null;
		java.io.OutputStream os = null;
		try {
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(newFileName, "utf-8"));
			is = new FileInputStream(filePath + File.separator + originFileName);
			// 构造子节输出流
	        os = response.getOutputStream();
	        byte[] b = new byte[1024];
	        int len = 0;
	        while ((len = is.read(b)) > 0) {
	            os.write(b, 0, len);
	        }
	        os.flush();
	        is.close();
	        os.close();
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 下载方式(方式三)
	 * @param file
	 * @param response
	 * @param newFileName
	 * @throws IOException
	 */
	public synchronized static void downloadFile3(File file, HttpServletResponse response, String newFileName) throws IOException {
		
        // 构造子节输入流
		java.io.InputStream is = null;
		java.io.OutputStream os = null;
		try {
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(newFileName, "utf-8"));
			is = new FileInputStream(file);
			// 构造子节输出流
	        os = response.getOutputStream();
	        byte[] b = new byte[1024];
	        int len = 0;
	        while ((len = is.read(b)) > 0) {
	            os.write(b, 0, len);
	        }
	        os.flush();
	        is.close();
	        os.close();
		} finally {
			
		}
	}
}
