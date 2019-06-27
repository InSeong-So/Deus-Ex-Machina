package com.java.web;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dao.DaoInterface;
import com.java.sol.SoNameServiceinterface;
import com.java.util.HttpUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
public class WebController
{
    
    @Resource(name = "hdConf")
    Configuration conf;
    
    @Autowired
    SoNameServiceinterface ssi;
    
    @Autowired
    DaoInterface di;
    
    static int soCode;
    
    String fileName = "sexOffender";
    
    String inputFile = "/input/csv2";
    
    HashMap<String, Object> resultMap;
    
    List<HashMap<String, Object>> resultList;
    
    @RequestMapping("/")
    public String main(HttpSession session)
    {
        if (HttpUtil.checkLogin(session))
        {
            System.out.println("메인화면");
            return "redirect:/resources/0home.html";
        }
        else
        {
            System.out.println("로그인이 되어있지 않습니다.");
            return "redirect:/resources/0home.html";
        }
    }
    
    @RequestMapping(value = "/mrCall", method = RequestMethod.POST)
    public void mrCall(HttpServletRequest req, HttpServletResponse resp) throws Exception
    {
        FileSystem hdfs = FileSystem.get(conf);
        Path path = new Path("/result");
        if (hdfs.exists(path))
        {
            hdfs.delete(path, true);
        }
        for (soCode = 0; soCode < 5; soCode++)
        {
            System.out.println("**************** " + soCode + "번째 시작 ****************");
            Job job = Job.getInstance(conf, "test");
            URI inputUri = URI.create("/input/csv/" + fileName + ".csv");
            URI outputUri = URI.create("/result/" + fileName + soCode);
            
            FileInputFormat.addInputPath(job, new Path(inputUri));
            job.setInputFormatClass(TextInputFormat.class);
            
            FileOutputFormat.setOutputPath(job, new Path(outputUri));
            job.setOutputFormatClass(TextOutputFormat.class);
            
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            
            job.setJarByClass(this.getClass());
            job.setMapperClass(WebMapper.class);
            job.setReducerClass(WebReducer.class);
            
            job.waitForCompletion(true);
            
            HashMap<String, Object> resultMap = new HashMap<String, Object>();
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/json;charset=utf-8");
            JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultMap));
            resp.getWriter().write(json.toString());
        }
        System.out.println("**************** 종료 ****************");
    }
    
    @RequestMapping("/dir")
    public void dir(HttpServletResponse resp) throws IOException
    {
        resultList = new ArrayList<HashMap<String, Object>>();
        getDir(inputFile); // 디렉토리 호출
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", resultList);
        
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=utf-8");
        JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(result));
        try
        {
            resp.getWriter().write(json.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public FileStatus[] getStatus(String newPath) throws IOException
    {
        URI uri = URI.create(newPath);
        Path path = new Path(uri);
        FileSystem file = FileSystem.get(uri, conf);
        return file.listStatus(path); // 목록 보내기
    }
    
    public void getDir(String newPath) throws IOException
    {
        FileStatus[] dirList = getStatus(newPath); // 목록 호출
        for (int i = 0; i < dirList.length; i++)
        {
            String name = dirList[i].getPath().getName();
            if (dirList[i].isDirectory())
            {
                getDir(newPath + "/" + name); // 다음 디렉토리 호출
                System.out.println("폴더 : " + name);
            }
            else
            {
                resultMap = new HashMap<String, Object>();
                resultMap.put(name, newPath + "/" + name);
                resultList.add(resultMap);
                System.out.println("파일 : " + newPath + "/" + name);
            }
        }
    }
    
    @RequestMapping("/con")
    public void getContents(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String fileContents = req.getParameter("data");
        
        FileSystem file = FileSystem.get(conf);
        FSDataInputStream fs = file.open(new Path(fileContents));
        byte[] buffer = new byte[500000];
        int byteRead = 0;
        String result = "";
        while ((byteRead = fs.read(buffer)) > 0)
        {
            result = new String(buffer, 0, byteRead);
        }
        String[] rows = result.split("\n");
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int j = 1; j < rows.length; j++)
        {
            String row = rows[j];
            String[] cols = row.split("\t");
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (int c = 0; c < cols.length; c++)
            {
                map.put(c + "", cols[c]);
            }
            list.add(map);
        }
        HashMap<String, Object> resultMap2 = new HashMap<String, Object>();
        resultMap2.put("result", list);
        JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultMap2));
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(json.toString());
    }
    
}
