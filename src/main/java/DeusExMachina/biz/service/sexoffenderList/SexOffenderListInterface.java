package DeusExMachina.biz.service.sexoffenderList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Program Name : SexOffenderListInterface
 * Description : 성범죄자 리스트 인터페이스
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : SoBoardInterface
 **/

public interface SexOffenderListInterface
{
    public ModelAndView soList(HttpServletRequest req, RedirectAttributes attr, HttpSession session);
}
