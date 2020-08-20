/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;

import SanjeevniApp.Pojo.EmpPojo;
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
public class EmpDao {
     public static String getNewID()throws SQLException {
         Connection conn =DBConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery("select max(EMPID) from Employe");
         int id =1;
         if(rs.next())
         {
             String empid = rs.getString(1);
             int eno = Integer.parseInt(empid.substring(1));
             id = id + eno;    
         }
         String sr ="E"+id;
         System.out.println(sr);
         return sr; 
     }
     public static boolean addEmployee(EmpPojo ep)throws  SQLException {
          PreparedStatement ps =DBConnection.getConnection().prepareStatement("insert into Employe values(?,?,?,?)");
         ps.setString(1,ep.getEmpid());
          ps.setString(2,ep.getEmpname());
          ps.setString(3,ep.getJob());
          ps.setDouble(4,ep.getSal());
          int result = ps.executeUpdate();
        
          return result==1;  
     }
      public static boolean DeleteEmp(String Empid)throws SQLException {
         int num=0;
     PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete users where empid=?");
       ps.setString(1,Empid);
       int rs=ps.executeUpdate();
       if(rs==1||rs==0)
       {
       PreparedStatement ps1=DBConnection.getConnection().prepareStatement("delete employe where empid=?");
       ps1.setString(1,Empid);
       num=ps1.executeUpdate();
       }
       return num==1;
     }

      public static boolean getUpdate(EmpPojo ep) throws Exception{
         
         PreparedStatement ps = DBConnection.getConnection().prepareStatement("update Employe set Ename=?,role=?,sal=? where Empid=?");
          ps.setString(1,ep.getEmpname());
       ps.setString(2,ep.getJob());
       ps.setDouble(3,ep.getSal());  
        ps.setString(4,ep.getEmpid());
         int res = ps.executeUpdate();
         return res==1;   
     }
      
       public static EmpPojo getFindKey(String id)throws SQLException
 {
     EmpPojo ep=null;
    PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from employe where empid=?");
   ps.setString(1, id);
   ResultSet rs=ps.executeQuery();
   if(rs.next())
   {
    ep=new EmpPojo();
ep.setEmpid(rs.getString(1));
ep.setEmpname(rs.getString(2));
ep.setJob(rs.getString(3));
ep.setSal(rs.getDouble(4));
   }
 return ep;
 }
     public static HashMap<String,String> getNonRegisteredRecieptionistList()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select empid,ename from employe where role='RECEPTIONIST' and empid not in (select empid from users where usertype='RECEPTIONIST')";
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
   public static ArrayList<String> getIdRole()throws SQLException
    {
     Connection conn=DBConnection.getConnection();
        String qry="select distinct empid  from employe order by empid";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<String> idlist=new ArrayList<>();
        while(rs.next())
        {
        String id=rs.getString(1);
        idlist.add(id);
        }
        return idlist;
    }       
 

     
      public static ArrayList<EmpPojo> getAllEmp()throws SQLException {
         ArrayList<EmpPojo>empList = new ArrayList<>();
         Statement st = DBConnection.getConnection().createStatement();
         ResultSet rs = st.executeQuery("select * from Employe");
         while(rs.next()) {
             EmpPojo e = new EmpPojo();
             e.setEmpid(rs.getString(1));
             e.setEmpname(rs.getString(2));
 	e.setJob(rs.getString(3));
             e.setSal(rs.getDouble(4));
             empList.add(e);
        }
	return empList;
      }
    }
