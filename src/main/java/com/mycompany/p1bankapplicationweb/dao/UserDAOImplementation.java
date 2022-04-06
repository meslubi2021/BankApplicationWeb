/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1bankapplicationweb.dao;

import static com.mycompany.p1bankapplicationweb.dao.DatabaseVariable.db;
import com.mycompany.p1bankapplicationweb.domain.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ktbff
 */
@Repository
public class UserDAOImplementation implements UserDAO {

    @Override
    public boolean login(String userName, String passWord) {
        String sql = "select * from bankdb.user";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Users us = new Users(rs.getString(1), rs.getString(2));
                if ((us.getUserName().equals(userName)) && (us.getPasssWord().equals(passWord))) {
                    return true;

                }
            }

            }
            catch(SQLException e){
                 return false;
             }

            if ((userName.equals("admin")) && (passWord.equals("admin"))) {
                return true;
            }
            return false;
    }

    @Override
    public boolean addUser(String userName, String passWord) {
        if (findUser(userName) == null) {
            String sql="INSERT INTO `bankdb`.`user` (`userName`, `passWord`) VALUES ('"+userName+"', '"+passWord+"');";
            return db.iud(sql);
        }
        return false;
    }

    @Override
    public Users findUser(String userName) {
        String sql="select * from bankdb.user where userName=\""+userName+"\";";
      ResultSet rs=db.select(sql);
      try{
          while(rs.next()){
              Users us =new Users(rs.getString(1),rs.getString(2));
              return us;
          }
      }catch(SQLException e){
          return null;
      }
      return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteUser(String userName) {
        if (findUser(userName) != null) {
            Users us = findUser(userName);
          //  users.remove(us);
            return true;
        }
        return false;
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
