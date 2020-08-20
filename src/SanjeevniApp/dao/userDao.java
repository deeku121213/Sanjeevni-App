/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;

import SanjeevniApp.dbutil.DBConnection;
import SanjeevniApp.Pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */

public class userDao {

public static String validateUser(UserPojo user)throws SQLException
{

  PreparedStatement ps=DBConnection.getConnection().prepareStatement("select username from users where userid=? and password=? and usertype=?");
  ps.setString(1, user.getUid());
  ps.setString(2,user.getPwd());
  ps.setString(3, user.getUtype());
  ResultSet rs=ps.executeQuery();
  String uname=null;
   if(rs.next())
  {
  uname=rs.getString(1);
  //    System.out.println(rs.getString(1));
   }
  return uname;
  }    
}

    
    

