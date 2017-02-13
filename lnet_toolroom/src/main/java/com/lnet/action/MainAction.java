package com.lnet.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.ResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.lnet.service.MainService;
import com.lnet.util.PageShowUtil;

/**
 * 
 * @author nonoyet
 * 2016-07-06
 *
 */
public class MainAction extends  PageAction {
    // AutoStruts2Action  BaseAction implements ModelDriven<User>  
	private static Logger logger = LoggerFactory.getLogger(MainAction.class);
    
	private static final long serialVersionUID = -5605915123625733293L;
	private MainService mainService;
	
	
	public String index(){
		
		return "index";
	}
	
	@SuppressWarnings({ "serial", "unchecked" })
	public void querylist(){
		response.setHeader("Content-type", "text/html;charset=UTF-8"); //解决输出到页面乱码问题
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
		try{
			String sql = "select * from sys_yhcs_global t";
			List<Map<String, Object>> datalist = (List<Map<String, Object>>) mainService.findSQL(sql, null, new ResultTransformer(){

				public List transformList(List list) {
					// TODO Auto-generated method stub
					return list;
				}

				public Map<String, Object> transformTuple(Object[] val, String[] parma) {
					// TODO Auto-generated method stub
					Map<String, Object> map = new HashMap<String, Object>();
					for(int i=0;i<parma.length;i++){
						map.put(parma[i].toLowerCase(), val[i]);
					}
					return map;
				}
				
			});
			
			jsonObject.put("success", true);
			jsonObject.put("list", PageShowUtil.getPageShowValue(datalist));
			
			PrintWriter writer = response.getWriter();
			writer.write(jsonObject.toJSONString());
			writer.flush();
			writer.close();
			writer = null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("查询数据库错误："+e.getMessage());
		}
		
	}
	
	
	
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	public MainService getMainService() {
		return mainService;
	}
	
}
