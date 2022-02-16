/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Client;
import edu.SprintJava.utils.MyConnection;
import java.sql.PreparedStatement;
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
public class ClientCRUD {
    public void ajouterClient(Client cl){
        try {
            String requete = "insert into client(id,nom,prenom,date_naissance,pays_ville,email,mobile,genre)"
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,cl.getId());
            pst.setString(2,cl.getNom());
            pst.setString(3,cl.getPrenom());
            pst.setString(4,cl.getDate_naissance());
            pst.setString(5,cl.getPays_ville());
            pst.setString(6,cl.getEmail());
            pst.setInt(7,cl.getMobile());
            pst.setString(8,cl.getGenre());
            pst.executeUpdate();
            System.err.println("Client Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public List<Client> ListerClient(){
         List<Client> ClientList=new ArrayList<>();
        try {
            String requete ="Select * from client";
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Client cl =new Client();
                cl.setId(rs.getInt(1));
                cl.setNom(rs.getString("nom"));
                cl.setPrenom(rs.getString("prenom"));
                cl.setDate_naissance(rs.getString("date_naissance"));
                cl.setPays_ville(rs.getString("pays_ville"));
                cl.setEmail(rs.getString("email"));
                cl.setMobile(rs.getInt(7));
                cl.setGenre(rs.getString("genre"));
                ClientList.add(cl);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
        return ClientList;
    }
    public void modifierClient(int id_c,String nom_c,String prenom_c,String date_naissance_c,String pays_ville_c,String email_c,int mobile_c,String genre_c){
        try {
            String requete="UPDATE client SET"
                    + " `id`='"+id_c+"' ,`nom`='"+nom_c+"' , `prenom`='"+prenom_c+"' , `date_naissance`='"+date_naissance_c+"',`pays_ville`='"+prenom_c+"'"
                    + ",`email` ='"+email_c+"' , `mobile`='"+mobile_c+"',`genre`='"+genre_c+"' where `id`='"+id_c+"' ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Update Done !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerClient(Client cl){
        try {
            String requete="DELETE from client where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, cl.getId());
            pst.executeUpdate();
            System.err.println("Client deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
}
