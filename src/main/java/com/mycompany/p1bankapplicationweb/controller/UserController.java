/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1bankapplicationweb.controller;

import com.mycompany.p1bankapplicationweb.command.LoginCommand;
import com.mycompany.p1bankapplicationweb.dao.UserDAO;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ktbff
 */
@Controller
public class UserController {
    @Autowired
     UserDAO ud;
    
    @RequestMapping(value={"/","/login"})
    public String loginForm(Model m,HttpSession session){
        m.addAttribute("command", new LoginCommand());
        session.invalidate();
        return "login";
    }
    
    @RequestMapping(value="/loginProcess",method=RequestMethod.POST)
    public String loginProcess(@ModelAttribute("command") LoginCommand lc,Model m,HttpSession session){
    if(ud.login(lc.getuName(), lc.getpWord())){
        session.setAttribute("uName", lc.getuName());
        return "redirect:dashboard";
    }
    else{
        m.addAttribute("message","Invaid LOgin");
        return "login";
    }
    }
    
    @RequestMapping("/dashboard")
    public String dash(Model m,HttpSession session){
        if(session.getAttribute("uName")!=null){
        m.addAttribute("title","Bank Application");
        m.addAttribute("message","Login Sucessful");
        return "dashboard";
        }
        else{
            return "redirect:login";
        }
    }
    
    @RequestMapping("/logout")
    public String logout(){
        return "redirect:login";
    }
}
