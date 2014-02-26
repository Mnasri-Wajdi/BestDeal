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
                administrateur.setLogin(resultat.getString(1));
                administrateur.setPassword(resultat.getString(2));
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
                admin.setLogin(resultat.getString(1));
                admin.setPassword(resultat.getString(2));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins " + ex.getMessage());
        }
        return admin;
    }
}
