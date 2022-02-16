/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.utils;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author moete
 */
public class ControleSaisie {
    Connection mc=MyConnection.getInstance().getCnx();
    public String masque;
    
    //********************************Nom et Prenom contiennent que des alphabets****************//
    public boolean testNomPrenom(String nom){
        masque="^[a-zA-Z]+[a-z]";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller = pattern.matcher(nom);
        return controller.matches();
    }
    
    //********************************PASSWORD 8 CHIFFRES ****************//
    public boolean testPassword(String password){
        return (password.length()>=8);
    }
    
    public boolean testNum(String num){
        masque="[0-9]+";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller=pattern.matcher(num);
        if(controller.matches()){
            return true;
        }
        return false;
    }
    
    //********************************NUMERO TELEPHONE NE PASSE PAS 8 CHIFFRES **************************************//
    public boolean GSM(String num){
        masque="[0-9]{8}$";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller=pattern.matcher(num);
        if(controller.matches()){
            return true;
        }
        return false;
    }
    
    //******************************TEST FORMAT EMAIL**************************************************//
    public boolean mailFormat(String mail){
        masque ="^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z-9]@[a-zA-Z]+"
                + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller = pattern.matcher(mail);
        return controller.matches();
    }
    // *********************************** TEST LOGIN FORAMT ************************************************************
    
    public boolean testUsername(String login){
        masque="^[a-zA-Z]+[a-zA-Z0-9]";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller = pattern.matcher(login);
        return controller.matches();
    }
}
