package DeusExMachina.biz.service.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DeusExMachina.biz.dao.SessionDaoInterface;
import DeusExMachina.common.util.HttpUtil;

/**
 * Program Name : userService
 * Description : 유저 서비스
 * Author : 소인성
 * History : 2019-06-28 컨버전
 **/

@Service
public class userService implements userServiceInterface
{
    
    @Autowired
    SessionDaoInterface di;
    
    HashMap<String, Object> param;
    
    @Override
    public ModelAndView user(String menu, HttpServletRequest req, RedirectAttributes attr, HttpSession session)
    {
        param = HttpUtil.getParamMap(req);
        HashMap<String, Object> result = new HashMap<String, Object>();
        param.put("menu", menu);
        param.put("param", HttpUtil.getParamMap(req));
        
        if ("insert".equals(menu))
        {
            param.put("sql", "selectOne");
            param.put("sqlType", "user.userOne");
            
            if (di.call(param) == null)
            {
                param.put("sql", menu);
                param.put("sqlType", "user.userInsert");
            }
            else
            {
                result.put("result", 0);
                return HttpUtil.makeJsonView(result);
            }
        }
        else if ("selectOne".equals(menu))
        {
            param.put("sql", menu);
            param.put("sqlType", "user.userSelect");
            
        }
        else if ("idCheck".equals(menu))
        {
            param.put("sql", "selectOne");
            param.put("sqlType", "user.userOne");
            
            if (di.call(param) == null)
            {
                result.put("result", 0);
                return HttpUtil.makeJsonView(result);
            }
        }
        result.put("result", di.call(param));
        
        if ("selectOne".equals(menu))
        {
            session.setAttribute("user", result.get("result"));
        }
        
        return HttpUtil.makeJsonView(result);
    }
}
