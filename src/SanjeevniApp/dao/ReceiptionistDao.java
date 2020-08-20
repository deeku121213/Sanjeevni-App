/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;

import SanjeevniApp.Pojo.EmpPojo;
import SanjeevniApp.Pojo.UserPojo1;
import SanjeevniApp.dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hp
 */
public class ReceiptionistDao {
    
public static boolean addReceptionist(UserPojo1 ep)throws SQLException
{
PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,?)");
ps.setString(1,ep.getUserid());
ps.setString(2, ep.getUsername());
ps.setString(3, ep.getEmpid());
ps.setString(4, ep.getPassword());
ps.setString(5,ep.getUsertype());
 int rs=ps.executeUpdate();
 return rs==1;
}
public static ArrayList<EmpPojo> getAllReceptionist()throws SQLException
{
Connection con=DBConnection.getConnection();
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from employe where role='RECEPTIONIST' and empid not in (select empid from users where usertype='RECEPTIONIST')");
ArrayList<EmpPojo> EmpList=new ArrayList<>();
while(rs.next())
{ EmpPojo ep=new EmpPojo();
ep.setEmpid(rs.getString(1));
ep.setEmpname(rs.getString(2));
ep.setJob(rs.getString(3));
ep.setSal(rs.getDouble(4));
EmpList.add(ep);
}
        return EmpList;
}
public static HashMap<String,String> getRegisteredRecieptionistList()throws SQLException
{
        Connection conn=DBConnection.getConnection();
        String qry="select userid,username from users where usertype='RECEPTIONIST'";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        HashMap<String,String> receptionist=new HashMap<>();
        while(rs.next())
        {
        String id=rs.getString(1);
        String name=rs.getString(2);
           // System.out.println("name "+id);
           receptionist.put(id, name);
        }
        return receptionist;
 }
public static boolean getUpdatePassword(UserPojo1 ep)throws SQLException
{
PreparedStatement ps=DBConnection.getConnection().prepareStatement("update users set password=? where userid=? and username=? and usertype=?");
ps.setString(1,ep.getPassword());
ps.setString(2, ep.getUserid());
ps.setString(3, ep.getUsername());
ps.setString(4, ep.getUsertype());
 int rs=ps.executeUpdate();
 return rs==1;
}
 public static ArrayList<String> getAllRcptId()throws SQLException
{
Connection con=DBConnection.getConnection();
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select userid from users where usertype='RECEPTIONIST'");
ArrayList<String> EmpList=new ArrayList<>();
while(rs.next())
{ 
EmpList.add(rs.getString(1));
}
return EmpList;
}
 public static boolean RemoveRcpt(String id)throws SQLException
 {
 PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete users where userid=?");
ps.setString(1,id);
int rs=ps.executeUpdate();
 return rs==1;
 }
 

    
}
