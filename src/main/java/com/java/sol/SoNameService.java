package com.java.sol;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dao.DaoInterface;
import com.java.util.HttpUtil;

@Service
public class SoNameService implements SoNameServiceinterface
{
    
    @Autowired
    DaoInterface di;
    
    HashMap<String, Object> param;
    
    @Override
    public ModelAndView soName(HttpServletRequest req, RedirectAttributes attr)
    {
        param = HttpUtil.getParamMap(req);
        System.out.println(param);
        int soCheck = Integer.parseInt((String) param.get("soCheck"));
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (soCheck == 0)
        {
            /****************************************************************/
            param.put("sql", "selectOne");
            param.put("sqlType", "so.soReCnt");
            result.put("result", di.call(param));
            /****************************************************************/
            param.put("sql", "selectList");
            param.put("sqlType", "so.soRe");
            result.put("result2", di.call(param));
            /****************************************************************/
        }
        else if (soCheck == 1)
        {
            /****************************************************************/
            param.put("sql", "selectOne");
            param.put("sqlType", "so.soCnt");
            result.put("result", di.call(param));
            /****************************************************************/
            param.put("sql", "selectList");
            param.put("sqlType", "so.soName");
            result.put("result2", di.call(param));
            /****************************************************************/
        }
        else if (soCheck == 2)
        {
            /****************************************************************/
            param.put("sql", "selectOne");
            param.put("sqlType", "so.soReNaCnt");
            result.put("result", di.call(param));
            /****************************************************************/
            param.put("sql", "selectList");
            param.put("sqlType", "so.soReName");
            result.put("result2", di.call(param));
            /****************************************************************/
        }
        return HttpUtil.makeJsonView(result);
    }
}
