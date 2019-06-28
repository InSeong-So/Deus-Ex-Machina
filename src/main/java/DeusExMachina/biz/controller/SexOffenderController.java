package DeusExMachina.biz.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.hadoop.conf.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DeusExMachina.biz.dao.SessionDaoInterface;
import DeusExMachina.biz.service.sexoffender.SexOffenderInterface;

/**
 * Program Name : SexOffenderController
 * Description : 성범죄자 창 컨트롤러
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : SoNameController
 **/

@Controller
public class SexOffenderController
{
    
    @Resource(name = "hdConf")
    Configuration conf;
    
    @Autowired
    SexOffenderInterface ssi;
    
    @Autowired
    SessionDaoInterface di;
    
    @RequestMapping("/soName")
    public ModelAndView soName(HttpServletRequest req, RedirectAttributes attr)
    {
        return ssi.soName(req, attr);
    }
}
