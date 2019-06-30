package DeusExMachina.biz;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DeusExMachina.common.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Program Name : HomeController
 * Description : favicon.ico 컨트롤러
 * Author : 소인성
 * History : 2019-06-28 컨버전
 **/

@Controller
@Slf4j
public class HomeController
{
    // favicon.ico 설정
    @RequestMapping(value = "/favicon.ico", method = RequestMethod.GET)
    public void favicon(HttpServletRequest request, HttpServletResponse reponse)
    {
        try
        {
            reponse.sendRedirect("/resources/favicon.ico");
        }
        catch (IOException e)
        {
            log.debug("지정된 아이콘을 찾을 수 없습니다.");
        }
    }

}
