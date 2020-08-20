/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.gui;

import SanjeevniApp.Pojo.EmpPojo;
import SanjeevniApp.dao.EmpDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class UpdateEmployeeFrame extends javax.swing.JFrame {
     private String eid,ename,job;
    private double sal;
    private ArrayList<String> idlist;
    
    
    
    public UpdateEmployeeFrame() {
        initComponents();
         loadReceptionistDetails();
               this.setLocationRelativeTo(null);

    }
    
    
     private boolean validateInputs1()
    {
    ename=txtEmpname.getText();
    //sal=Double.parseDouble(txtSal.getText());
    if(ename.isEmpty()||txtsal.getText().isEmpty())
        return false;
    return true;
    
    }
    
    private void loadReceptionistDetails()
    {
        try
        {
        idlist=EmpDao.getIdRole();
        if(idlist.size()==0)
        {
       
        JOptionPane.showMessageDialog(null,"No unregistered receptionist present...!");
       // btnRegiste.setEnabled(false);
       }
         //btnRegiste.setEnabled(true);
       
         Iterator <String> it=idlist.iterator();
        jcEmpId.removeAllItems();
        while(it.hasNext())
        {
        jcEmpId.addItem(it.next());
        }
        }
        
        catch (SQLException ex)
        {
          JOptionPane.showMessageDialog(null,"Problem in db..!");
        ex.printStackTrace();
       }
     }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtSal = new javax.swing.JPanel();
        txtEmpname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsal = new javax.swing.JTextField();
        jcbJob = new javax.swing.JComboBox();
        jcEmpId = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        btnUpdateEmp = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblAddEmployee = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSal.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Details"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Employee Id");

        jLabel3.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Employee Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("    Job");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("      Sal");

        jcbJob.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Compounder", "Receiptionist", "wardboy" }));
        jcbJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbJobActionPerformed(evt);
            }
        });

        jcEmpId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEmpIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtSalLayout = new javax.swing.GroupLayout(txtSal);
        txtSal.setLayout(txtSalLayout);
        txtSalLayout.setHorizontalGroup(
            txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtSalLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtSalLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(363, 363, 363))
                    .addGroup(txtSalLayout.createSequentialGroup()
                        .addGroup(txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtSalLayout.createSequentialGroup()
                                .addGroup(txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(txtSalLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(txtSalLayout.createSequentialGroup()
                                        .addGap(197, 197, 197)
                                        .addGroup(txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jcbJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmpname, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                            .addComponent(txtsal)
                                            .addComponent(jcEmpId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        txtSalLayout.setVerticalGroup(
            txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtSalLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 56, Short.MAX_VALUE)
                .addGroup(txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(txtSalLayout.createSequentialGroup()
                        .addGroup(txtSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(txtsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdateEmp.setText("Update Emp");
        btnUpdateEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEmpActionPerformed(evt);
            }
        });

        lblAddEmployee.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAddEmployee.setText("Update Employe Frame");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(46, 46, 46))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddEmployee)
                    .addComponent(btnLogout))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 137, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btnUpdateEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(156, 156, 156))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(txtSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnUpdateEmp))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEmpActionPerformed
             if(validateInputs1()==false)
        {
        JOptionPane.showMessageDialog(null,"Please inputs  values..!");
        return;
        }
        try
        {
       eid=(String)jcEmpId.getSelectedItem();
    ename=txtEmpname.getText();
    job=(String)jcbJob.getSelectedItem();
    sal=Double.parseDouble(txtsal.getText());
    
    EmpPojo ep=new EmpPojo();
    
    ep.setEmpid(eid);
    ep.setEmpname(ename);
    ep.setJob(job);
    ep.setSal(sal);
        
     boolean rs=EmpDao.getUpdate(ep);
     if(rs==true)
        {
            JOptionPane.showConfirmDialog(null,"Are you sure data is updated ..!","Sure.!",JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(null,"Your data Successfully Updated..!","Succes.!",JOptionPane.INFORMATION_MESSAGE);
         }
           else
            {
        JOptionPane.showMessageDialog(null,"Your data not  Deleted..!","UnSucces.!",JOptionPane.INFORMATION_MESSAGE);
         }
        }
        catch(NumberFormatException ex2)
        {
        JOptionPane.showMessageDialog(null,"Please inputs digits only ..!");
        ex2.printStackTrace();
        }
        catch(SQLException ex3)
        {
        JOptionPane.showMessageDialog(null,"Problem in db..!");
        ex3.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(UpdateEmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
      
   
    
    }//GEN-LAST:event_btnUpdateEmpActionPerformed

    private void jcbJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbJobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbJobActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ManageEmployeeFrame me=new ManageEmployeeFrame();
        me.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        AdminOptionFrame ad=new AdminOptionFrame();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jcEmpIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEmpIdActionPerformed
      if(jcEmpId.getItemCount()==0)
           return;
         try{
        EmpPojo ep=new EmpPojo();
        ep=EmpDao.getFindKey((String)jcEmpId.getSelectedItem());
       
        txtEmpname.setText(ep.getEmpname());
       jcbJob.setSelectedItem(ep.getJob());
        txtsal.setText(String.valueOf(ep.getSal()));
          }
        catch(NumberFormatException ex)
        {
        JOptionPane.showMessageDialog(null,"Please inputs digits only ..!");
        ex.printStackTrace();
        }
        catch(SQLException ex1)
        {
        JOptionPane.showMessageDialog(null,"Problem in db..!");
        ex1.printStackTrace();
        }
    }                                        

    /**
    
    }//GEN-LAST:event_jcEmpIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new UpdateEmployeeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdateEmp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox jcEmpId;
    private javax.swing.JComboBox jcbJob;
    private javax.swing.JLabel lblAddEmployee;
    private javax.swing.JTextField txtEmpname;
    private javax.swing.JPanel txtSal;
    private javax.swing.JTextField txtsal;
    // End of variables declaration//GEN-END:variables
}
