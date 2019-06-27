package com.java.sob;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SoBoardInterface
{
    
    public ModelAndView soList(HttpServletRequest req, RedirectAttributes attr, HttpSession session);
}
