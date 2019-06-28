package DeusExMachina.biz.service.sexoffender;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Program Name : SexOffenderService
 * Description : 성범죄자 창 인터페이스
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : SoNameServiceInterface
 **/

public interface SexOffenderInterface
{
    public ModelAndView soName(HttpServletRequest req, RedirectAttributes attr);
}
