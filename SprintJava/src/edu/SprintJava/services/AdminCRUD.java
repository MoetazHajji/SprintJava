/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Admin;
//import edu.SprintJava.entities.User;
import java.sql.PreparedStatement;
import edu.SprintJava.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moete
 */
public class AdminCRUD {

    private Connection mc = MyConnection.getInstance().getCnx();

    public void ajouterAdmin(Admin a) {
        try {
            String requete = "insert into admin(id,nom,prenom,cin,username,email,pass)"
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getNom());
            pst.setString(3, a.getPrenom());
            pst.setInt(4, a.getCin());
            pst.setString(5, a.getUsername());
            pst.setString(6, a.getEmail());
            pst.setString(7, a.getPass());
            pst.executeUpdate();
            System.err.println("Admin Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<Admin> ListerAdmin() {
        List<Admin> AdminList = new ArrayList<>();
        try {
            String requete = "Select * from Admin";
            Statement st = mc.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Admin ad = new Admin();
                ad.setId(rs.getInt(1));
                ad.setNom(rs.getString("nom"));
                ad.setPrenom(rs.getString("prenom"));
                ad.setCin(rs.getInt(4));
                ad.setUsername(rs.getString("username"));
                ad.setEmail(rs.getString("email"));
                ad.setPass(rs.getString("pass"));
                AdminList.add(ad);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return AdminList;
    }

    public void modifierAdmin(int id_a, String nom_a, String prenom_a, int cin_a,String username_a, String email_a, String pass_a) {
        try {
            String requete = "UPDATE Admin SET"
                    + " `id`='" + id_a + "' ,`nom`='" + nom_a + "' , `prenom`='" + prenom_a + "' , `cin`='" + cin_a + "'"
                    + "`role`='" + username_a + "',`email` ='" + email_a + "' ,`pass`='" + pass_a + "'  where `id`='" + id_a + "' ";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Update Done !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerAdmin(Admin ad) {
        try {
            String requete = "DELETE from Admin where id=?";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.setInt(1, ad.getId());
            pst.executeUpdate();
            System.err.println("Admin deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Admin getAdmin(int id) {
        try {
            String requete = "SELECT * FROM `admin` WHERE(id=" + id + ")";
            AdminCRUD adc = new AdminCRUD();
            PreparedStatement ps = mc.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Admin ad = new Admin(rs.getString("email"), rs.getString("pass"));
                return ad;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public String getAdmin2(int id_ad )
    {
    String requete = "SELECT email FROM `admin` WHERE (id =" + id_ad+ ")";
    String mail="";
        try {
            PreparedStatement ps = mc.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
             mail= rs.getString(5);
            return mail;
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());;
        }
   return mail;
    }
    
    public List<Admin> rechercherAdmin (int id){
        List <Admin> AdminList = new ArrayList<>();
        try {
            String requete="SELECT * FROM Admin WHERE `id`='"+id+"' ";
            Statement st= mc.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                Admin ad =new Admin();
                
                ad.setId(rs.getInt(1));
                ad.setNom(rs.getString("nom"));
                ad.setPrenom(rs.getString("prenom"));
                ad.setCin(rs.getInt(4));
                ad.setRole(rs.getString("username"));
                ad.setEmail(rs.getString("email"));
                ad.setPass(rs.getString("pass"));
                
                AdminList.add(ad);
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return AdminList;
    }
    public void affecterAdminRolle(int id_ad,String role_a) {
        try {
            String requete="update Admin SET `role`='"+role_a+"'WHERE `id`='"+id_ad+"'  ";
            PreparedStatement pst = mc.prepareStatement(requete);
            pst.executeUpdate();
            System.out.println("Admin Affecté !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
    }
    
    public Admin Login (String user , String password){
        Admin ad =new Admin();
        try {
            String requete="SELECT username , pass  FROM admin "
                    + "where `username`='"+user+"' AND `pass`='"+password+"' ";
            PreparedStatement st=mc.prepareStatement(requete);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                if(user.equals(rs.getString("username")) && password.equals(rs.getString("pass")) ){
                   rs.getString("username");
                   rs.getString("pass");
                    System.out.println("LOGIN accepté :)");
                    
                }else{
                    System.out.println("LOGIN refusé :( \n"
                            + "Vérifier vos données");
                }
            }
           
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public boolean LOGIN(String user,String password){
        boolean checkUser = false;
         Admin ad=new Admin();
        try {
            String requete="SELECT * FROM admin where username=? AND pass=? ";
            PreparedStatement pst=mc.prepareStatement(requete);
            pst.setString(1, user);
            pst.setString(2, password);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                checkUser =true;
                System.out.println("User name existe");
            }else{
                System.out.println("user n'existe pas");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return checkUser;
    }
}
