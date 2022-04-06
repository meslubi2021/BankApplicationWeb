/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1bankapplicationweb.dao;

import com.mycompany.p1bankapplicationweb.domain.Accounts;

/**
 *
 * @author ktbff
 */
public interface AccountDAO {
    public boolean addAccount(int accountNumber, String accountName, int accountBalance);
    public Accounts findAccount(int accountNumber);
    public void checkBalance(int accountNumber);
    public boolean depositeAmount(int accountNumber, int depositeBalance);
    public int withdrawAmount(int accountNumber, int withdrawBalance);
    public int transferAmount(int senderAccountNumber, int receiverAccountNumber, int transferBalance);
    
}
