package com.java.mail;

import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.util.HttpUtil;

@Controller
public class mail
{
    
    HashMap<String, Object> param;
    
    @RequestMapping("/emailAuth")
    public ModelAndView emailAuth(HttpServletResponse resp, HttpServletRequest req) throws Exception
    {
        param = HttpUtil.getParamMap(req);
        HashMap<String, Object> result = new HashMap<String, Object>();
        String email = req.getParameter("email");
        String authNum = "";
        authNum = RandomNum();
        
        sendEmail(email.toString(), authNum);
        
        param.put("email", email);
        param.put("authNum", authNum);
        
        result.put("result", param);
        return HttpUtil.makeJsonView(result);
    }
    
    public String RandomNum()
    {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <= 6; i++)
        {
            int n = (int) (Math.random() * 10);
            buffer.append(n);
        }
        return buffer.toString();
    }
    
    private void sendEmail(String email, String authNum)
    {
        final String username = "goflvhxj2547@gmail.com";
        final String password = "zmfhslzmf4!@";
        String host = "smtp.gmail.com";
        String subject = "DEM 인증번호 전송";
        String fromName = "데우스엑스마키나 운영자";
        String to1 = email;
        String content = "인증번호 [ " + authNum + " ]";
        
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.ransport.protocol", "smtp");
            props.put("mail.smtp.host", host);
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(username, password);
                }
            });
            
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username, MimeUtility.encodeText(fromName, "UTF-8", "B")));
            InternetAddress[] address1 = { new InternetAddress(to1) };
            msg.setRecipients(Message.RecipientType.TO, address1);
            msg.setSubject(subject);
            msg.setSentDate(new java.util.Date());
            msg.setContent(content, "text/html;charset=UTF-8");
            
            Transport.send(msg);
            
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @RequestMapping("/mailSender")
    public ModelAndView mailSender(HttpServletRequest req, HttpServletResponse resp) throws AddressException, MessagingException
    {
        HashMap<String, Object> result = new HashMap<String, Object>();
        String email = req.getParameter("userEmail");
        String password = req.getParameter("userPassword");
        String subject = req.getParameter("subject");
        String contents = req.getParameter("contents");
        
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(email, password);
            }
        });
        
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("goflvhxj2547@naver.com"));
            message.setSubject(subject);
            message.setText(contents);
            
            Transport.send(message);
            
            result.put("result", 1);
            return HttpUtil.makeJsonView(result);
            
        }
        catch (MessagingException e)
        {
            result.put("result", 0);
            return HttpUtil.makeJsonView(result);
        }
    }
}
