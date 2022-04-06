/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1bankapplicationweb.domain;

/**
 *
 * @author ktbff
 */
public class Users {
    private String userName;
    private String passsWord;

    public Users(String userName, String passsWord) {
        this.userName = userName;
        this.passsWord = passsWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasssWord() {
        return passsWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPasssWord(String passsWord) {
        this.passsWord = passsWord;
    }      
}
