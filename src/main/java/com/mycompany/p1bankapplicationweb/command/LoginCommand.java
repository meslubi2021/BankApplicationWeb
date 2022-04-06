/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1bankapplicationweb.command;

/**
 *
 * @author ktbff
 */
public class LoginCommand {
    private String uName;
    private String pWord;

    public LoginCommand(String uName, String pWord) {
        this.uName = uName;
        this.pWord = pWord;
    }
    
    public LoginCommand(){
        
    }

    public String getuName() {
        return uName;
    }

    public String getpWord() {
        return pWord;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setpWord(String pWord) {
        this.pWord = pWord;
    }
    
    
    
}
