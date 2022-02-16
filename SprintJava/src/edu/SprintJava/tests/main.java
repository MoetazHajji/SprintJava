/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.tests;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Client;
import edu.SprintJava.entities.Livreur;
import edu.SprintJava.entities.Session;
//import edu.SprintJava.entities.User;
import edu.SprintJava.services.AdminCRUD;
import edu.SprintJava.services.ClientCRUD;
import edu.SprintJava.services.LivreurCRUD;
//import edu.SprintJava.services.UserService;
import edu.SprintJava.utils.MyConnection;

/**
 *
 * @author moete
 */
public class main {

    public static void main(String[] args) throws Exception {
        MyConnection mc = new MyConnection();
        Admin ad = new Admin(1912261, "Moetaz", "Hajji", 65745,"Mootaaz-hub", "Moetaz.hajji@esprit.tn", "oqsjf");
        Admin ad1 = new Admin(8965, "hamdi", "l3ou9", 44654968, "hamdi@esprit.tn", "sqddqfq","admin produits");
        Admin ad2 = new Admin(74123698, "loulou", "bounifa", 1456564, "loulou@esprit.tn", "fqsfggqe","admin xxxx");
        
        AdminCRUD adc = new AdminCRUD();
        Admin ad3 = new Admin(138, "moumouet", "ben khalifet", 35168, "Mootaaz-hub", "mimouet@esprit.tn","admin xxxx");
        // adc.ajouterAdmin(ad);
        // adc.ajouterAdmin(ad1);
        //adc.ajouterAdmin(ad2);
        //System.out.println(adc.ListerAdmin());
        //adc.modifierAdmin(8965, "oihjlk", "vdfsg",5343, "email@fgdsgd.tn", "fqsfazq");
        //adc.supprimerAdmin(ad);
//        Client c=new Client(89658, "ahmed", "fazeni", "17/05/199", "tunis-ariana", "ahmed.fazeni@esprit.tn", 98563214, "homme");
//        Client c1=new Client(3513, "dsfgq", "DFDSF", "17/05/199", "tunis-FdsfDSF", "DSfgds.fQSDF@esprit.tn", 455684, "FEMME");
//        Client c2=new Client(435864, "FDSqfQ", "FDSfdsF", "17/05/199", "tdsfsFdsf", "DsfsdF.dsFSDFFFFFFFFFD@esprit.tn", 98563214, "PERSONALISE");
//        ClientCRUD clc=new ClientCRUD();
        //clc.ajouterAdmin(c2);
        //System.out.println(clc.ListerClient());
        //clc.modifierClient(435864, "khdjsf", "klqshf", "19/2/946563", "lfhjdnsqf", "qsffqs@fqsfq.com", 56464, "dfsfq");
        //clc.supprimerClient(c2);

//        Livreur l1=new Livreur(5644564, "qsdsq", "qsdfgsd");
//        Livreur l2=new Livreur(426874, "dqsdff", "qstaztaztazdfgsd");
//        LivreurCRUD lc=new LivreurCRUD();
        //lc.ajouterLivreur(l2);
        //System.out.println(lc.ListerLivreur());
        //lc.modifierLivreur(426874, "mootaz", "hajji");
//        lc.supprimerLivreur(l2);
//        User us=new User();
//        UserService uss = new UserService();
//        Session s=new Session();
//        uss.getUser(8965);
       // adc.getAdmin2(8965);
        //System.out.println(adc.rechercherAdmin(8965));
        //adc.affecterAdminRolle(8965, "Master");
        //adc.ajouterAdmin(ad2);
//        System.out.println(adc.rechercherAdmin(8965));
           adc.Login1("Mootaaz-hub","oqsjf");
            //adc.checkUsername("ygug");
    }
    
}
