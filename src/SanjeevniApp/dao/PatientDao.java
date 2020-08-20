/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;



import SanjeevniApp.Pojo.PatientPojo;
import SanjeevniApp.dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

  


public class PatientDao {
public static String getNewId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(p_id) from patient");
        int id = 1;
        if(rs.next())
        {
        String empid=rs.getString(1);
       // System.out.println(empid.substring(1));
       if (empid==null)
           return "P101";
	int eno=Integer.parseInt(empid.substring(1));
	id = id + eno;
        String sr = "P" + id;
      //  JOptionPane.showMessageDialog(null,"Error in DB!","Error"+sr,JOptionPane.ERROR_MESSAGE);
        return sr;
        }
        else 
        {
        return "P101";
    }
}
public static ArrayList<String> getPatientId()throws SQLException
    {
     Connection conn=DBConnection.getConnection();
        String qry="select p_id  from patient order by p_id";
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
public static ArrayList<String> getDoctId()throws SQLException
    {
     Connection conn=DBConnection.getConnection();
        String qry="select distinct doctorid from patient";
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

public static PatientPojo getFindKey(String id)throws SQLException
 {PatientPojo ep=null;
 PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from Patient where p_id=?");
   ps.setString(1, id);
   ResultSet rs=ps.executeQuery();
   if(rs.next());
   {
    ep=new PatientPojo();
ep.setP_id(rs.getString(1));
ep.setF_name(rs.getString(2));
ep.setS_name(rs.getString(3));
ep.setAge(rs.getInt(4));
ep.setOpd(rs.getString(5));
ep.setGender(rs.getString(6));
ep.setM_status(rs.getString(7));
ep.setDate(rs.getDate(8));
ep.setAddress(rs.getString(9));
ep.setCity(rs.getString(10));
ep.setMno(rs.getString(11));
ep.setDoctor_id(rs.getString(12));
  }
     //System.out.println(ep);
    return ep;
  }

public static boolean addPatient(PatientPojo p)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, p.getP_id());
        ps.setString(2, p.getF_name());
        ps.setString(3, p.getS_name());
           ps.setInt(4, p.getAge());
        ps.setString(5, p.getOpd());
        ps.setString(6, p.getGender());
        ps.setString(7, p.getM_status());
          ps.setDate(8,p.getDate());
        ps.setString(9, p.getAddress());
        ps.setString(10, p.getCity());
        ps.setString(11,p.getMno());
        ps.setString(12,p.getDoctor_id());
        return (ps.executeUpdate()!=0);    
    }
public static boolean updatePatient(PatientPojo p)throws SQLException
    {
PreparedStatement ps=DBConnection.getConnection().prepareStatement("update  Patient set FIRST_NAME=?,SECOND_NAME=?,AGE=?,OPD=?,GENDER=?,M_STATUS=?,P_DATE=?,ADDRESS=?,CITY=?,PHONE_NO=?,DOCTORID=? where p_id=?");
        
        ps.setString(1, p.getF_name());
        ps.setString(2, p.getS_name());
        ps.setInt(3, p.getAge());
        ps.setString(4, p.getOpd());
        ps.setString(5, p.getGender());
        ps.setString(6, p.getM_status());
        ps.setDate(7,p.getDate());
        ps.setString(8, p.getAddress());
        ps.setString(9, p.getCity());
        ps.setString(10,p.getMno());
        ps.setString(11,p.getDoctor_id());
        ps.setString(12, p.getP_id());
        int rs=ps.executeUpdate();
        System.out.println(rs);
        return rs==1;   
    }

 public static ArrayList<PatientPojo> getAllPatient()throws SQLException
{
Connection con=DBConnection.getConnection();
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Patient");
ArrayList<PatientPojo> EmpList=new ArrayList<>();
while(rs.next())
{ PatientPojo ep=new PatientPojo();
ep.setP_id(rs.getString(1));
ep.setF_name(rs.getString(2));
ep.setS_name(rs.getString(3));
ep.setAge(rs.getInt(4));
ep.setOpd(rs.getString(5));
ep.setGender(rs.getString(6));
ep.setM_status(rs.getString(7));
ep.setDate(rs.getDate(8));
ep.setAddress(rs.getString(9));
ep.setCity(rs.getString(10));
ep.setMno(rs.getString(11));
ep.setDoctor_id(rs.getString(12));
EmpList.add(ep);
}
        return EmpList;
}
   public static boolean removePatinet(String id)throws SQLException
{
PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete patient where P_id=?");
ps.setString(1,id);
int rs=ps.executeUpdate();
 return rs==1;
     
}
   public static ArrayList<PatientPojo> getAppointPatient()throws SQLException
   {
Connection con=DBConnection.getConnection();
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select P_id,FIRST_Name,opd from Patient");
ArrayList<PatientPojo> EmpList=new ArrayList<>();
while(rs.next())
{ PatientPojo ep=new PatientPojo();
ep.setP_id(rs.getString(1));
ep.setF_name(rs.getString(2));
ep.setOpd(rs.getString(3));
EmpList.add(ep);
}
        return EmpList;
}



    
}


