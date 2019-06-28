package DeusExMachina.biz.service.sexoffenderList;

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
 * Program Name : SexOffenderListService
 * Description : 성범죄자 리스트 서비스
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : SoBoardService
 **/

@Service
public class SexOffenderListService implements SexOffenderListInterface
{
    
    @Autowired
    SessionDaoInterface di;
    
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
