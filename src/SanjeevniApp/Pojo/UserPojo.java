/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.Pojo;

/**
 *
 * @author hp
 */
public class UserPojo {

    
    @Override
    public String toString() {
        return "UserPojo{" + "uid=" + uid + ", pwd=" + pwd + ", utype=" + utype + '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }
private String uid,pwd,utype;    

    
}
