package com.java.sol;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.hadoop.conf.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dao.DaoInterface;

@Controller
public class SoNameController
{
    
    @Resource(name = "hdConf")
    Configuration conf;
    
    @Autowired
    SoNameServiceinterface ssi;
    
    @Autowired
    DaoInterface di;
    
    @RequestMapping("/soName")
    public ModelAndView soName(HttpServletRequest req, RedirectAttributes attr)
    {
        return ssi.soName(req, attr);
    }
}
