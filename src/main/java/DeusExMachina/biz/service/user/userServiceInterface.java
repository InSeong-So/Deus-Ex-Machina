package DeusExMachina.biz.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Program Name : userServiceInterface
 * Description : 유저 인터페이스
 * Author : 소인성
 * History : 2019-06-28 컨버전
 **/

public interface userServiceInterface
{
    public ModelAndView user(String menu, HttpServletRequest req, RedirectAttributes attr, HttpSession session);
}
