package com.java.sol;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SoNameServiceinterface
{
    
    public ModelAndView soName(HttpServletRequest req, RedirectAttributes attr);
}
