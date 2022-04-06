/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1bankapplicationweb.dao;

import static com.mycompany.p1bankapplicationweb.dao.DatabaseVariable.db;
import com.mycompany.p1bankapplicationweb.domain.Accounts;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ktbff
 */
@Repository
public class AccountDAOImplementation implements AccountDAO {

    @Override
    public boolean addAccount(int accountNumber, String accountName, int accountBalance) {
         if (findAccount(accountNumber) == null) {
            String sql="INSERT INTO `bankdb`.`account` (`accountNumber`, `accountName`, `accountBalance`) VALUES ('"+accountNumber+"', '"+accountName+"', '"+accountBalance+"');";
            return db.iud(sql);
        }
        return false;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Accounts findAccount(int accountNumber) {
       String sql="select * from bankdb.account where accountNumber="+accountNumber+";";
       ResultSet rs=db.select(sql);
       try{
           while(rs.next()){
               Accounts acc=new Accounts(rs.getInt(1),rs.getString(2),rs.getInt(3));
               return acc;
           }
       }catch(SQLException e){
           return null;
    }
       return null;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkBalance(int accountNumber) {
          if (findAccount(accountNumber) != null) {
            Accounts acc = findAccount(accountNumber);
            System.out.println("Balance is :" + acc.getAccountBalance());
        } else {
            System.out.println("Account doesn't exist");
        }
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean depositeAmount(int accountNumber, int depositeBalance) {
        if (findAccount(accountNumber) != null) {
            Accounts acc = findAccount(accountNumber);
            acc.setAccountBalance(acc.getAccountBalance() + depositeBalance);
            String sql="UPDATE `bankdb`.`account` SET `accountBalance` = '"+acc.getAccountBalance()+"' WHERE (`accountNumber` = '"+accountNumber+"');";
            return db.iud(sql);
        }
        return false;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int withdrawAmount(int accountNumber, int withdrawBalance) {
        if (findAccount(accountNumber) != null) {
            Accounts acc = findAccount(accountNumber);
            if (acc.getAccountBalance() > withdrawBalance) {
                acc.setAccountBalance(acc.getAccountBalance() - withdrawBalance);
                String sql="UPDATE `bankdb`.`account` SET `accountBalance` = '"+acc.getAccountBalance()+"' WHERE (`accountNumber` = '"+accountNumber+"');";
                if(db.iud(sql))
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int transferAmount(int senderAccountNumber, int receiverAccountNumber, int transferBalance) {
        if ((findAccount(senderAccountNumber) != null) && (findAccount(receiverAccountNumber) != null)) {
            Accounts acc1 = findAccount(senderAccountNumber);
            Accounts acc2 = findAccount(receiverAccountNumber);
            if (acc1.getAccountBalance() > transferBalance) {
                acc1.setAccountBalance(acc1.getAccountBalance() - transferBalance);
                acc2.setAccountBalance(acc2.getAccountBalance() + transferBalance);
                String sql1="UPDATE `bankdb`.`account` SET `accountBalance` = '"+acc1.getAccountBalance()+"' WHERE (`accountNumber` = '"+senderAccountNumber+"');";
                String sql2="UPDATE `bankdb`.`account` SET `accountBalance` = '"+acc2.getAccountBalance()+"' WHERE (`accountNumber` = '"+receiverAccountNumber+"');";
                if(db.iud(sql1)&&db.iud(sql2))
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
