package com.java.sob;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dao.DaoInterface;

@Controller
public class SoBoardController
{
    
    @Resource(name = "hdConf")
    Configuration conf;
    
    @Autowired
    DaoInterface di;
    
    @Autowired
    SoBoardInterface lsi;
    
    @RequestMapping("/soList")
    public ModelAndView user(HttpServletRequest req, RedirectAttributes attr, HttpSession session)
    {
        return lsi.soList(req, attr, session);
    }
    
}
