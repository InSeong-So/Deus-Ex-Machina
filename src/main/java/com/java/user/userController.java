package com.java.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dao.DaoInterface;
import com.java.util.HttpUtil;

@Controller
public class userController
{
    
    @Autowired
    userServiceInterface usi;
    
    @Autowired
    DaoInterface di;
    
    @RequestMapping("/user/{menu}")
    public ModelAndView user(@PathVariable("menu") String menu, HttpServletRequest req, RedirectAttributes attr, HttpSession session)
    {
        return usi.user(menu, req, attr, session);
    }
    
    @RequestMapping("/session")
    public void Session(HttpServletResponse resp, HttpSession session)
    {
        HashMap<String, Object> param = (HashMap<String, Object>) session.getAttribute("user");
        HttpUtil.makeJsonWriter(resp, param);
    }
    
    @RequestMapping("/sessionDel")
    public void SessionDel(HttpServletResponse resp, HttpSession session)
    {
        session.invalidate();
    }
}
