package com.java.crm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
public class CrmController {

	@Resource(name="hdConf")
	Configuration conf;
	
	@Resource(name="sqlSession")
	SqlSession session;
	
	List<HashMap<String, Object>> resultList;
	
	@RequestMapping(value = "getData/{viewNm}", method = RequestMethod.POST)
	public void getData(@PathVariable("viewNm") String viewNm, HttpServletResponse resp) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		if(viewNm.equals("crarea")){
			resultList = session.selectList("crm.creaSelect");
		} else if(viewNm.equals("cras")){
			resultList = session.selectList("crm.crasSelect");
		} else if(viewNm.equals("crday")){
			resultList = session.selectList("crm.crdaySelect");
		} else if(viewNm.equals("creducational")){
			resultList = session.selectList("crm.creducationalSelect");
		} else if(viewNm.equals("crhideout")){
			resultList = session.selectList("crm.crhideoutSelect");
		} else if(viewNm.equals("crjob")){
			resultList = session.selectList("crm.crjobSelect");
		} else if(viewNm.equals("crmotive")){
			resultList = session.selectList("crm.crmotiveSelect");
		} else if(viewNm.equals("crtime")){
			resultList = session.selectList("crm.crtimeSelect");
		}
		result.put("result", resultList);
		result.put("size", resultList.size());
		result.put("columns", session.selectList("crm.selectColumnList", viewNm));
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;charset=utf-8");
		JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(result));
		try {
			resp.getWriter().write(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/crm")
	public void getContents(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String fileContents = req.getParameter("data");
		
		FileSystem file = FileSystem.get(conf);
		FSDataInputStream fs = file.open(new Path(fileContents));
		byte[] buffer = new byte[500000];
		int byteRead = 0;
		String result = "";
		while((byteRead = fs.read(buffer)) > 0) { 
			result = new String(buffer, 0, byteRead);
			System.out.println("while문 테스트 : " + result);
		}
		String[] rows = result.split("\n");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		for(int j = 0; j < rows.length; j++) {
			String row = rows[j];
			String[] cols = row.split("\t");
			HashMap<String, Object> map = new HashMap<String, Object>();
			for(int c = 0; c < cols.length; c++) {
				map.put(c + "", cols[c]);
			}
			list.add(map);
		}
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", list);
		JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultMap));
		System.out.println(resultMap);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;charset=utf-8");
		resp.getWriter().write(json.toString());
	}
}
