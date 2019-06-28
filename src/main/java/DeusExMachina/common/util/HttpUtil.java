package DeusExMachina.common.util;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Program Name : HttpUtil
 * Description : Http 통신 유틸리티
 * Author : 소인성
 * History : 2019-06-28 컨버전
 **/

@Slf4j
public class HttpUtil
{
    
    public static final String FILE_DNS = "http://192.168.1.32/resources/";
    
    public static final int OK = 1;
    
    public static final int NO = 0;
    
    public static HashMap<String, Object> getParamMap(HttpServletRequest req)
    {
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        Enumeration<?> enums = req.getParameterNames();
        while (enums.hasMoreElements())
        {
            String paramName = enums.nextElement().toString();
            
            if ("".equals(req.getParameter(paramName)))
            {
                result = null;
                break;
            }
            result.put(paramName, req.getParameter(paramName));
        }
        return result;
    }
    
    public static ModelAndView makeJsonView(HashMap<String, Object> map)
    {
        ModelAndView mav = new ModelAndView();
        
        JSONObject j = JSONObject.fromObject(JSONSerializer.toJSON(map));
        
        mav.addObject("json", j);
        mav.setViewName("json"); // String "abc"
        
        return mav;
    }
    
    public static void makeJsonWriter(HttpServletResponse res, HashMap<String, Object> map)
    {
        
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=utf-8");
        
        JSONObject j = JSONObject.fromObject(JSONSerializer.toJSON(map));
        
        try
        {
            res.getWriter().write(j.toString()); //response 응답하는 페이지를 만듬
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public static boolean checkLogin(HttpSession session)
    {
        if (session == null)
        {
            log.info("Session 정보가 없습니다.");
            return false;
        }
        else
        {
            HashMap<String, Object> userMap = (HashMap<String, Object>) session.getAttribute("user");
            if (userMap == null)
            {
                log.info("로그인 되어 있지않습니다.");
                return false;
            }
            else
            {
                log.info("===========================================================");
                for (String data : userMap.keySet())
                {
                    log.info(data + " : " + userMap.get(data));
                }
                log.info("===========================================================");
                return true;
            }
        }
    }
    
}