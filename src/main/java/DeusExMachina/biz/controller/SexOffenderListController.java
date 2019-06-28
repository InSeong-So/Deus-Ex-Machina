package DeusExMachina.biz.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DeusExMachina.biz.dao.SessionDaoInterface;
import DeusExMachina.biz.service.sexoffenderList.SexOffenderListInterface;

/**
 * Program Name : SexOffenderListController
 * Description : 성범죄자 리스트
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : SoBoardController
 **/

@Controller
public class SexOffenderListController
{
    @Resource(name = "hdConf")
    Configuration conf;
    
    @Autowired
    SessionDaoInterface di;
    
    @Autowired
    SexOffenderListInterface lsi;
    
    @RequestMapping("/soList")
    public ModelAndView user(HttpServletRequest req, RedirectAttributes attr, HttpSession session)
    {
        return lsi.soList(req, attr, session);
    }
}
