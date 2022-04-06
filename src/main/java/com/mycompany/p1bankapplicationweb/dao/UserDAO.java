/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1bankapplicationweb.dao;

import com.mycompany.p1bankapplicationweb.domain.Users;

/**
 *
 * @author ktbff
 */
public interface UserDAO {
    public boolean login(String userName, String passWord);
    public boolean addUser(String userName, String passWord);
    public Users findUser(String userName);
    public boolean deleteUser(String userName);
}
