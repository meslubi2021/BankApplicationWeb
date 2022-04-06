/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1bankapplicationweb.controller;

import com.mycompany.p1bankapplicationweb.command.AccountCommand;
import com.mycompany.p1bankapplicationweb.dao.AccountDAO;
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
public class AccountController {

    @Autowired
    AccountDAO ad;

    @RequestMapping("/createnewaccount")
    public String createNewAccount(Model m, HttpSession session) {
        if (session.getAttribute("uName") != null) {
            m.addAttribute("account", new AccountCommand());
            return "createnewaccount";
        }
        return "redirect:login";
    }

    @RequestMapping(value = {"/processNewAccount"}, method = RequestMethod.POST)
    public String processNewAcccountView(@ModelAttribute("account") AccountCommand ac, HttpSession session) {
        if (session.getAttribute("uName") != null) {
            if (ad.addAccount(ac.getAccountNumber(), ac.getAccountName(), ac.getAccountBalance())) {
                session.setAttribute("message", "Account added sucessfully");
                return "redirect:createnewaccount";
            } else {
                session.setAttribute("message", "Account already exist");
                return "redirect:createnewaccount";
            }

        }
        return "redirect:login";
    }
}

