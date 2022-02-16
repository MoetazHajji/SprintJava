/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.services;

import edu.SprintJava.entities.Livreur;
import edu.SprintJava.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moete
 */
public class LivreurCRUD {
    public void ajouterLivreur(Livreur a){
        try {
            String requete = "insert into livreur(id,nom,prenom)"
                    + "values(?,?,?)";
            PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,a.getId());
            pst.setString(2,a.getNom());
            pst.setString(3,a.getPrenom());
            pst.executeUpdate();
            System.err.println("Livreur Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    public List<Livreur> ListerLivreur(){
         List<Livreur> LivreurList=new ArrayList<>();
        try {
            String requete ="Select * from livreur";
            Statement st=MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Livreur li =new Livreur();
                li.setId(rs.getInt(1));
                li.setNom(rs.getString("nom"));
                li.setPrenom(rs.getString("prenom"));
                LivreurList.add(li);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
        return LivreurList;
    }
    
    public void modifierLivreur(int id_l,String nom_l,String prenom_l){
        try {
            String requete="UPDATE livreur SET `id`='"+id_l+"' ,`nom`='"+nom_l+"' , `prenom`='"+prenom_l+"'  where `id`='"+id_l+"' ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.executeUpdate();
            System.err.println("Update Done !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerLivreur(Livreur li){
        try {
            String requete="DELETE from livreur where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, li.getId());
            pst.executeUpdate();
            System.err.println("livreur deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
