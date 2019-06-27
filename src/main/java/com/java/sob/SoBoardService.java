package com.java.sob;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dao.DaoInterface;
import com.java.util.HttpUtil;

@Service
public class SoBoardService implements SoBoardInterface
{
    
    @Autowired
    DaoInterface di;
    
    HashMap<String, Object> param;
    
    @Override
    public ModelAndView soList(HttpServletRequest req, RedirectAttributes attr, HttpSession session)
    {
        param = HttpUtil.getParamMap(req);
        HashMap<String, Object> result = new HashMap<String, Object>();
        /****************************************************************/
        param.put("sql", "selectOne");
        param.put("sqlType", "so.soListCnt");
        result.put("result", di.call(param));
        /****************************************************************/
        param.put("sql", "selectList");
        param.put("sqlType", "so.soList");
        result.put("result2", di.call(param));
        /****************************************************************/
        return HttpUtil.makeJsonView(result);
    }
    
}
