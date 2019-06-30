package DeusExMachina.biz.controller;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DeusExMachina.biz.dao.SessionDaoInterface;
import DeusExMachina.biz.service.sexoffender.SexOffenderInterface;
import DeusExMachina.biz.service.user.userServiceInterface;
import DeusExMachina.common.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Program Name : WebController
 * Description : 메인 컨트롤러
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : WebController + userController
 **/

@Controller
@Slf4j
public class WebController
{
    
    @Resource(name = "hdConf")
    Configuration conf;
    
    @Autowired
    SexOffenderInterface ssi;
    
    @Autowired
    userServiceInterface usi;
    
    @Autowired
    SessionDaoInterface di;
    
    static int soCode;
    
    String fileName = "sexOffender";
    
    String inputFile = "/input/csv2";
    
    HashMap<String, Object> resultMap;
    
    List<HashMap<String, Object>> resultList;
    
    @RequestMapping("/")
    public String main(HttpSession session)
    {
//        if (HttpUtil.checkLogin(session))
//        {
//            log.debug("메인화면 진입");
//            return "redirect:/resources/0home.html";
//        }
//        else
//        {
//            log.debug("로그인이 되어있지 않습니다.");
            return "redirect:/resources/0home.html";
//        }
    }
    
    @RequestMapping("/user/{menu}")
    public ModelAndView user(@PathVariable("menu") String menu, HttpServletRequest req, RedirectAttributes attr, HttpSession session)
    {
        return usi.user(menu, req, attr, session);
    }
    
    @RequestMapping("/session")
    public void Session(HttpServletResponse resp, HttpSession session)
    {
        HashMap<String, Object> param = (HashMap<String, Object>) session.getAttribute("user");
        HttpUtil.makeJsonWriter(resp, param);
    }
    
    @RequestMapping("/sessionDel")
    public void SessionDel(HttpServletResponse resp, HttpSession session)
    {
        session.invalidate();
    }
    
    @RequestMapping(value = "/mrCall", method = RequestMethod.POST)
    public void mrCall(HttpServletRequest req, HttpServletResponse resp) throws Exception
    {

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
                log.debug("폴더 : " + name);
            }
            else
            {
                resultMap = new HashMap<String, Object>();
                resultMap.put(name, newPath + "/" + name);
                resultList.add(resultMap);
                log.debug("파일 : " + newPath + "/" + name);
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
