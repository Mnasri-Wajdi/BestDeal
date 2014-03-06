/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.dao;

import esprit.pidev.entities.Client;
import esprit.pidev.entities.Reclamation;
import esprit.pidev.entities.Reclamation2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import esprit.pidev.entities.administrateur;
import esprit.pidev.gui.ben_mabrouk_marwen.GererCommercant;
import esprit.pidev.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Chala
 */
public class adminDAO {

   
    public administrateur findAdminByEmail(String email)
    {
      administrateur admin = new administrateur();
     String requete = "select * from administrateur where mail=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                        admin.setId_admin(resultat.getInt(1));
                        admin.setNom_admin(resultat.getString(2));
                        admin.setLogin(resultat.getString(3));
                        admin.setPassword(resultat.getString(4));
                        admin.setMail(resultat.getString(5));
               
            }
            
            return admin;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Admin introuvable "+ex.getMessage());
            return null;
        }
    
    }
    
    

    public List<administrateur> GetAlladministrateur() {
        List<administrateur> listeadmins = new ArrayList<administrateur>();
        String requete = "select * from administrateur";
        try {
            Statement statement = MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                administrateur administrateur = new administrateur();
               administrateur.setId_admin(resultat.getInt(1));
                administrateur.setNom_admin(resultat.getString(2));
                administrateur.setLogin(resultat.getString(3));
                administrateur.setPassword(resultat.getString(4));
                administrateur.setMail(resultat.getString(5));
                listeadmins.add(administrateur);
            }
            return listeadmins;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins " + ex.getMessage());
            return null;
        }
    }

    public administrateur findAdminByLogin(String login) {
        administrateur admin = null;
        String requete = "select * from administrateur where login='" + login + "'";
        try {
            Statement statement = MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                admin = new administrateur();
                 admin.setId_admin(resultat.getInt(1));
                admin.setNom_admin(resultat.getString(2));
                admin.setLogin(resultat.getString(3));
                admin.setPassword(resultat.getString(4));
                admin.setMail(resultat.getString(5));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins " + ex.getMessage());
        }
        return admin;
    }
    
    public administrateur findAdminById(int id){
    administrateur admin = new administrateur();
     String requete = "select * from administrateur where id_admin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                        admin.setId_admin(resultat.getInt(1));
                        admin.setNom_admin(resultat.getString(2));
                        admin.setLogin(resultat.getString(3));
                        admin.setPassword(resultat.getString(4));
                        admin.setMail(resultat.getString(5));
               
            }
            return admin;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
    
    //Mnasri Wajdi
    
     public List<Reclamation2> GetAllReclamation() {
        List<Reclamation2> listereclamtion = new ArrayList<Reclamation2>();
        String requete1 = "select id_client,message from reclamation ORDER BY id_client ASC";
        try {
            Statement statement = MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat1 = statement.executeQuery(requete1);
            while (resultat1.next()) {
                
                  Reclamation2 rec = new Reclamation2();
                rec.setNom(FindNomById(resultat1.getInt(1)));
                rec.setEmail(FindEmailByID(resultat1.getInt(1)));
                rec.setMsg(resultat1.getString(2));
                listereclamtion.add(rec);
            }
            return listereclamtion;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des réclamation " + ex.getMessage());
            return null;
        }
    }
    
    
    public String FindNomById(int id){
        String x ="";
     String requete2 = "select nom from client where id_client=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete2);
            ps.setInt(1, id);
            ResultSet resultat2 = ps.executeQuery();
            while (resultat2.next()) {
                
                 x= resultat2.getString(1);
            }
            return x;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du nom "+ex.getMessage());
            return null;
        }
    }
    
    
    public String FindEmailByID(int id){
        String v="";
     String requete3 = "select email from client where id_client=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete3);
            ps.setInt(1, id);
            ResultSet resultat3 = ps.executeQuery();
             while (resultat3.next()) {
               v=resultat3.getString(1);
             }
              return v;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du mail "+ex.getMessage());
            return null;
        }
    }
    
    public void DeleteRec(String n){

         String requete = "delete from reclamation where message=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, n);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
             
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
             

        }
    
        }
    
    
    
    
    
    
    
}
