package com.lnet.action.firstpage;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.ResultTransformer;

import com.alibaba.fastjson.JSONObject;
import com.lnet.action.PageAction;
import com.lnet.common.config.QType;
import com.lnet.entities.firstpage.FeedBack;
import com.lnet.service.MainService;
import com.lnet.util.PageShowUtil;
import com.lnet.util.PropertyUtil;
/**
 * 处理反馈信息
 * @author nonoyet
 * @version 2017-01-22
 */
public class FeedBackAction extends PageAction {
	private MainService mainService;
	
	private FeedBack feedBack;
	private List<FeedBack> feedBackList;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 获取列表内容
	 */
	@SuppressWarnings({ "serial", "unchecked" })
	public void queryList(){
		response.setHeader("Content-type", "text/html;charset=UTF-8"); //解决输出到页面乱码问题
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
		boolean success = true;
		List<Map<String, Object>> list = null ;
		try{
			if(success){
				String sql = "select * from tools_feedback t where t.deleter_flag='0' ";
				list = (List<Map<String, Object>>) mainService.findSQL(sql, null, new String[]{sortName}, new String[]{sortType}, curPage-1, pageSize, new ResultTransformer(){

					public List transformList(List list) {
						// TODO Auto-generated method stub
						return list;
					}

					public Object transformTuple(Object[] val, String[] parma) {
						// TODO Auto-generated method stub
						Map<String, Object> map = new HashMap<String, Object>();
						for(int i=0;i<parma.length;i++){
							map.put(parma[i].toLowerCase(), val[i]);
						}
						return map;
					}
					
				});
				
				
			}
			
			jsonObject.put("success", success);
			jsonObject.put("list", PageShowUtil.getPageShowValue(list));
			PrintWriter writer = response.getWriter();
			writer.write(jsonObject.toJSONString());
			writer.flush();
			writer.close();
			writer = null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("获取反馈列表错误："+e.getMessage());
		}
	}
	
	/**
	 * 保存反馈
	 */
	public void save(){
		response.setHeader("Content-type", "text/html;charset=UTF-8"); //解决输出到页面乱码问题
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
		boolean success = true;
		String msg = "保存成功";
		try{
			if(feedBack == null){
				success = false;
				msg = "保存失败";
			}
			if(success){
				PropertyUtil.setCreateProperty(null, feedBack);
				feedBack.setCreatorIP(super.getRemoteAddr());
				
				PropertyUtil.setOperatorProperty(null, feedBack, QType.process.type_Add, QType.process.type_Add_Name);
				feedBack.setOperatorIP(super.getRemoteAddr());
				
				mainService.save(feedBack);
			}
			
			jsonObject.put("success", success);
			jsonObject.put("msg", msg);
			PrintWriter writer = response.getWriter();
			writer.write(jsonObject.toJSONString());
			writer.flush();
			writer.close();
			writer = null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("保存反馈信息错误："+e.getMessage());
		}
	}

	public void setFeedBack(FeedBack feedBack) {
		this.feedBack = feedBack;
	}

	public FeedBack getFeedBack() {
		return feedBack;
	}

	public void setFeedBackList(List<FeedBack> feedBackList) {
		this.feedBackList = feedBackList;
	}

	public List<FeedBack> getFeedBackList() {
		return feedBackList;
	}

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	public MainService getMainService() {
		return mainService;
	}
}
