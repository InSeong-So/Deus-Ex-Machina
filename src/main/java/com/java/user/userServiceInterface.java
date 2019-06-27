package com.java.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface userServiceInterface
{
    
    public ModelAndView user(String menu, HttpServletRequest req, RedirectAttributes attr, HttpSession session);
}
