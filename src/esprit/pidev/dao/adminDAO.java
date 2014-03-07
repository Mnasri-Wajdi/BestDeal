/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import esprit.pidev.entities.administrateur;
import esprit.pidev.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chala
 */
public class adminDAO {

   

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
    
}
