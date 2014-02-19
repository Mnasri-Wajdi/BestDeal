/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.dao;

import esprit.pidev.entities.Commercant;
import esprit.pidev.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marwen
 */
public class CommercantDAO {
    
    public void InsertCommercant(Commercant c){
    
         String requete = "insert into commercant (nom_commercant,description,adresse,email,telephone,login,password) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, c.getNom_commercant());
            ps.setString(2, c.getDescription());
            ps.setString(3, c.getAdresse());
            ps.setString(4,c.getEmail());
            ps.setInt(5, c.getTel());
            ps.setString(6, c.getLogin());
            ps.setString(7, c.getPassword());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
         
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    
    }
        
public void updateCommercant(Commercant c){
        String requete = "update commercant set nom_commercant=?, description=?, adresse=?,email=?,telephone=?,login=?,password=? where id_commercant=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, c.getNom_commercant());
            ps.setString(2, c.getDescription());
            ps.setString(3, c.getAdresse());
            ps.setString(4,c.getEmail());
            ps.setInt(5, c.getTel());
            ps.setString(6, c.getLogin());
            ps.setString(7, c.getPassword());
            ps.setInt(8, c.getId_commercant());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }

    }
    
    public List<Commercant> DisplayAllCommercants (){

            
            

        List<Commercant> listeCommercant = new ArrayList<Commercant>();

        String requete = "select * from Commercant";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
   
            while(resultat.next()){
                Commercant commercant =new Commercant();
                commercant.setId_commercant(resultat.getInt(1));
                commercant.setNom_commercant(resultat.getString(2));
                commercant.setDescription(resultat.getString(3));
                commercant.setAdresse(resultat.getString(4));
                commercant.setEmail(resultat.getString(5));
                commercant.setTel(resultat.getInt(6));
                commercant.setLogin(resultat.getString(7));
                commercant.setPassword(resultat.getString(8));
                listeCommercant.add(commercant);
            }
            return listeCommercant;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return null;
        }}
     public void deleteCommercant(int num){

          String requete = "delete from Commercant where id_commercant=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, num);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    
        }
        

        
        
    
    
    
    
}
