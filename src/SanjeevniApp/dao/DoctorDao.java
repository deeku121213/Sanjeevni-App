/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;

import SanjeevniApp.Pojo.DoctorPojo;
import SanjeevniApp.Pojo.UserPojo1;
import SanjeevniApp.dbutil.DBConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorDao {

 public static ArrayList<String> getUserDetails()throws SQLException
    {
     Connection conn=DBConnection.getConnection();
        String qry="select distinct empid  from users where usertype='DOCTOR' order by empid";
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
 
    public static ArrayList<String> getFindEmp()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select ename from employe where role='DOCTOR'";
        //and empid not in (select empid from users where usertype='DOCTOR')";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<String> Empname=new ArrayList<>();
        while(rs.next())
        {
        String name=rs.getString(1);
           // System.out.println("name "+id);
           Empname.add(name);
        }
        return Empname;
     }
    public static String getEmpId(String s)throws SQLException
    {
    String eid=null;
    UserPojo1 up =new UserPojo1();
 PreparedStatement ps=DBConnection.getConnection().prepareStatement("select empid from employe where ename=?");
   ps.setString(1, up.getEmpid());
   ResultSet rs=ps.executeQuery();
   if(rs.next())
   {
   
   eid= rs.getString(1);
   }
 return eid;
    
    }
 public static boolean getRegisterUsers(UserPojo1 ep)throws SQLException
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
 
 public static boolean getRegisterDoctor(DoctorPojo dp)throws SQLException
{
PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into doctor values(?,?,?,?,?)");
ps.setString(1,dp.getUserid());
ps.setString(2, dp.getDoctorId());
ps.setString(3, dp.getQualification());
ps.setString(4, dp.getSpecialize());
ps.setString(5, dp.getActive());
int rs=ps.executeUpdate();
 return rs==1;
}
public static String getNewId()throws SQLException
{
Connection con=DBConnection.getConnection();
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select max(doctorid) from doctor where active='y'");
int id=1;
String sr=null;
if(rs.next())
{
 String empid=rs.getString(1);
 if(empid==null)
 {
 return "d101";
 }
 int eno=Integer.parseInt(empid.substring(1));
  id=id+eno;

sr= "d"+id;
  System.out.println(sr);
}
return sr;
}

public static ArrayList<String> getAllDoctorsId()throws SQLException
    {
     
        
        
        
        
        
        
        
        
        
        
        
        ArrayList<String> docId = new ArrayList<>();
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery("select doctorid from doctor where active='y'");
        while(rs.next())
        {
            docId.add(rs.getString(1));
        }
        return docId;
    }
 public static boolean RemoveDoctor(String st)throws SQLException
 {
 PreparedStatement ps=DBConnection.getConnection().prepareStatement("update doctor set active='N' where doctorid=?");
ps.setString(1,st);
int rs=ps.executeUpdate();
 return rs==1;
 }

public static ArrayList<DoctorPojo> getAllDoctor()throws SQLException
{
    Connection con=DBConnection.getConnection();
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from Doctor where Active='y'");
    ArrayList<DoctorPojo> EmpList=new ArrayList<>();
    while(rs.next())
    { DoctorPojo ep=new DoctorPojo();
        ep.setDoctorId(rs.getString(1));
        ep.setUserid(rs.getString(2));
        ep.setQualification(rs.getString(3));
        ep.setSpecialize(rs.getString(4));
        EmpList.add(ep);
    }
        return EmpList;
}


}