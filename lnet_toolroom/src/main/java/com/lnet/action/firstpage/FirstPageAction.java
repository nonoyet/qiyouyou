package com.lnet.action.firstpage;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.transform.ResultTransformer;

import com.alibaba.fastjson.JSONObject;
import com.lnet.action.PageAction;
import com.lnet.common.config.QType;
import com.lnet.entities.base.Account;
import com.lnet.entities.base.QProcess;
import com.lnet.entities.firstpage.BrowseAccess;
import com.lnet.service.MainService;
import com.lnet.service.impl.CommonServiceImpl;
import com.lnet.util.DateUtils;
import com.lnet.util.PageShowUtil;
import com.lnet.util.PropertyUtil;
/**
 * 首页业务action
 * @author nonoyet
 * @version 2016-07-07
 *
 */
public class FirstPageAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(FirstPageAction.class);
	
	private MainService mainService;
	
	private BrowseAccess browseAccess;
	
	/**
	 * 首页
	 * @return
	 */
	public String index(){
		return "index";
	}
	
	/**
	 * 添加浏览器访问
	 */
	public void addBrowseAccess(){
		response.setHeader("Content-type", "text/html;charset=UTF-8"); //解决输出到页面乱码问题
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
		boolean success = true;
		String msg = "保存成功";
		try{
			if(browseAccess == null){
				success = false;
				msg = "访问记录保存失败";
			}
			
			if(success){
				Account account = new Account();
				account.setRemoteAddr(super.getRemoteAddr());
				
				PropertyUtil.setCreateProperty(null, browseAccess);
				PropertyUtil.setOperatorProperty(account, browseAccess, QType.process.type_Add, QType.process.type_Add_Name);
				
				mainService.save(browseAccess);
				
				QProcess process = new QProcess();
				PropertyUtil.setProcess(account, process, QType.process.type_Add, QType.process.type_Add_Name, browseAccess.getId(), "tools_browse", null, null);
				mainService.save(process);
			}
			
			jsonObject.put("success", true);
			jsonObject.put("msg", msg);
			PrintWriter writer = response.getWriter();
			writer.write(jsonObject.toJSONString());
			writer.flush();
			writer.close();
			writer = null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("添加浏览器访问记录错误："+e.getMessage());
		}
	}
	/**
	 * 今日访问总数
	 */
	public void todayAccess(){
		response.setHeader("Content-type", "text/html;charset=UTF-8"); //解决输出到页面乱码问题
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
		boolean success = true;
		String msg = "获取成功";
		int total = 0;
		try{
			if(success){
				String hql = "select count(*) from BrowseAccess t where t.creatorTime like '"+DateUtils.dateToString(new Date(), "yyyy-MM-dd")+"%'";
				
				total = commonService.count(hql);
			}
			
			jsonObject.put("success", true);
			jsonObject.put("msg", msg);
			jsonObject.put("total", total);
			PrintWriter writer = response.getWriter();
			writer.write(jsonObject.toJSONString());
			writer.flush();
			writer.close();
			writer = null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("添加浏览器访问记录错误："+e.getMessage());
		}
	}
	/**
	 * 访问的浏览器类型
	 */
	@SuppressWarnings({ "serial", "unchecked" })
	public void browseType(){
		response.setHeader("Content-type", "text/html;charset=UTF-8"); //解决输出到页面乱码问题
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
		boolean success = true;
		String msg = "获取成功";
		try{
			if(success){
				String sql = "select t.*,ROUND(cnt*100/total) as precent FROM "
								+" ( "
								+" select t.*,(select count(*) from tools_browse) as total from (select t.browse_Type,count(browse_Type) cnt from tools_browse t GROUP BY t.browse_Type) t "
								+" ) t";
				List<Map<String, Object>> list = (List<Map<String, Object>>) mainService.findSQL(sql, null, new String[]{"cnt"}, new String[]{"desc"}, 0, 3, new ResultTransformer() {
					
					public Map<String, Object> transformTuple(Object[] val, String[] parma) {
						// TODO Auto-generated method stub
						Map<String, Object> map = new HashMap<String, Object>();
						for(int i=0;i<parma.length;i++){
							map.put(parma[i].toLowerCase(), val[i]);
						}
						return map;
					}
					
					public List transformList(List list) {
						// TODO Auto-generated method stub
						return list;
					}
				});
				
				jsonObject.put("list", PageShowUtil.getPageShowValue(list)); 
			}
			
			jsonObject.put("success", true);
			jsonObject.put("msg", msg);
			PrintWriter writer = response.getWriter();
			writer.write(jsonObject.toJSONString());
			writer.flush();
			writer.close();
			writer = null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("获取浏览器访问类型错误："+e.getMessage());
		}
	}
	
	public MainService getMainService() {
		return mainService;
	}

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	public CommonServiceImpl getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonServiceImpl commonService) {
		this.commonService = commonService;
	}

	public void setBrowseAccess(BrowseAccess browseAccess) {
		this.browseAccess = browseAccess;
	}

	public BrowseAccess getBrowseAccess() {
		return browseAccess;
	}
	
}
