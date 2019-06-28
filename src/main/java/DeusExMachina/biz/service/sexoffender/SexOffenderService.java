package DeusExMachina.biz.service.sexoffender;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DeusExMachina.biz.dao.SessionDaoInterface;
import DeusExMachina.common.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Program Name : SexOffenderService
 * Description : 성범죄자 창 서비스
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : SoNameService
 **/

@Service
@Slf4j
public class SexOffenderService implements SexOffenderInterface
{
    
    @Autowired
    SessionDaoInterface di;
    
    HashMap<String, Object> param;
    
    @Override
    public ModelAndView soName(HttpServletRequest req, RedirectAttributes attr)
    {
        param = HttpUtil.getParamMap(req);
        log.debug(""+param);
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
