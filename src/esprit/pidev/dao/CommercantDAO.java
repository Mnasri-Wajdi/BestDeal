/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.dao;

import esprit.pidev.entities.Commercant;
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
 * @author Marwen
 */
//hfff
public class CommercantDAO {
    
    public void InsertCommercant(Commercant c){
    
         String requete = "insert into commercant (nom_commercant,description,adresse,email,telephone,login,password,note_commercant,nbr_note,somme_note) values (?,?,?,?,?,?,?,0,0,0)";
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
             JOptionPane.showMessageDialog(new GererCommercant(), "Commerçant supprimé avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
              JOptionPane.showMessageDialog(new GererCommercant(), "Suppression impossible ! \nDes deals sont liés à ce commerçant ","Erreur" ,JOptionPane.ERROR_MESSAGE);

        }
    
        }
     
      public Commercant findCommercantById(int id){
    Commercant commercant = new Commercant();
     String requete = "select * from commercant where id_commercant=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                commercant.setId_commercant(resultat.getInt(1));
                commercant.setNom_commercant(resultat.getString(2));
                commercant.setDescription(resultat.getString(3));
                commercant.setAdresse(resultat.getString(4));
                commercant.setEmail(resultat.getString(5));
                commercant.setTel(resultat.getInt(6));
                commercant.setLogin(resultat.getString(7));
                commercant.setPassword(resultat.getString(8));
            }
            return commercant;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
        
 public Commercant findCommByLogin (String login){
        Commercant com =null;
        String requete = "select * from commercant where login='"+login+"'";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                com = new Commercant();
                com.setId_commercant(resultat.getInt(1));
                com.setNom_commercant(resultat.getString(2));
                com.setDescription(resultat.getString(3));
                com.setAdresse(resultat.getString(4));
                com.setEmail(resultat.getString(5));
                com.setTel(resultat.getInt(6));
                com.setLogin(resultat.getString(7));
                com.setPassword(resultat.getString(8));
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins "+ex.getMessage());
        }
        return com;
    }
    

         public void insertcommercant(Commercant c) {

                String requete = "insert into commercant (nom_commercant,description,adresse,email,telephone,login,password,note_commercant,nbr_note,somme_note) values (?,?,?,?,?,?,?,0,0,0)";

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
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }
public List<Commercant> GetAllcommercant (){
        List<Commercant> listecommercant = new ArrayList<Commercant>();
        String requete = "select login,password from commercant";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Commercant commercant =new Commercant();
                commercant.setLogin(resultat.getString(1));
                commercant.setPassword(resultat.getString(2));
                listecommercant.add(commercant);
            }
            return listecommercant;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins "+ex.getMessage());
            return null;
        }
    }
    


        
    
    
    
    
}
