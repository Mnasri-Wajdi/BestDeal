/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.dao;

import esprit.pidev.entities.Deal;
import esprit.pidev.entities.Commercant;
import esprit.pidev.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DealDAO {
 public void insertDeal(Deal d){
   
      // CommercantDAO commercantdao=new CommercantDAO();
        String requete = "insert into deal (libelle_deal,description,categorie,date_debut,date_fin,ancien_montant,nouveau_montant,quantite_disponible,nombre_reservation,idcommercant) values (?,?,?,?,?,?,?,?,?,?)";
        try {//commercant=commercantdao.findDealById(st.getCommercant().getIdCommercant());
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getLibelle_deal());
            ps.setString(2, d.getDescription());
            ps.setString(3, d.getCategorie());
            ps.setString(4, d.getDate_debut());
            ps.setString(5, d.getDate_fin());
            ps.setDouble(6, d.getAncien_montant());
            ps.setDouble(7, d.getNouveau_montant());
            ps.setInt(8, d.getQuantite_disponible());
            ps.setInt(9, d.getNombre_reservation());
            ps.setInt(10, d.getCommercant().getId_commercant());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateDeal(Deal d){
        String requete;
     requete = "update deal set libelle_deal=?, description=?, categorie=?, date_debut=?, date_fin=?, ancien_montant=?, nouveau_montant=?, quantite_disponible=?, nombre_reservation=?,idcommercant=?  where id_deal=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getLibelle_deal());
            ps.setString(2, d.getDescription());
            ps.setString(3, d.getCategorie());
            ps.setString(4, d.getDate_debut());
            ps.setString(5, d.getDate_fin());
            ps.setDouble(6, d.getAncien_montant());
            ps.setDouble(7, d.getNouveau_montant());
            ps.setInt(8, d.getQuantite_disponible());
            ps.setInt(9, d.getNombre_reservation());
            ps.setInt(10, d.getCommercant().getId_commercant());
            ps.setInt(11, d.getId_deal());
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteDeal(int num){
        String requete = "delete from deal where id_deal=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, num);
            ps.executeUpdate();
            System.out.println("Deal supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Deal findDealById(int id){
   
     String requete = "select * from deal where id_deal=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
        ResultSet resultat = ps.executeQuery();
        CommercantDAO commercantDAO = new CommercantDAO();
        Deal deal = new Deal();
        while (resultat.next()){

            deal.setId_deal(resultat.getInt(1));
            deal.setLibelle_deal(resultat.getString(2));
            deal.setDescription(resultat.getString(3));
            deal.setCategorie(resultat.getString(4));
            deal.setDate_debut(resultat.getString(5));
            deal.setDate_fin(resultat.getString(6));
            deal.setAncien_montant(resultat.getFloat(7));
            deal.setNouveau_montant(resultat.getFloat(8));
            deal.setQuantite_disponible(resultat.getInt(9));
            deal.setNombre_reservation(resultat.getInt(10));
            deal.setCommercant(commercantDAO.findCommercantById(resultat.getInt(11)));
        }
        return deal;
        }
        catch(SQLException ex){
            System.out.println("erreur lors du chargement"+ex.getMessage());
            return null;
        }
    }
    
    public List<Deal> DisplayAllDeal (){ //@mehdi


        List<Deal> listecommercant = new ArrayList<Deal>();

        String requete = "select * from deal";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
             CommercantDAO commercantDAO = new CommercantDAO();
            while(resultat.next()){
                
                Deal deal =new Deal();
                deal.setId_deal(resultat.getInt(1));
                deal.setLibelle_deal(resultat.getString(2));
                deal.setDescription(resultat.getString(3));
                deal.setCategorie(resultat.getString(4));
                deal.setDate_debut(resultat.getString(5));
                deal.setDate_fin(resultat.getString(6));
                deal.setAncien_montant(resultat.getFloat(7));
                deal.setNouveau_montant(resultat.getFloat(8));
                deal.setQuantite_disponible(resultat.getInt(9));
                deal.setNombre_reservation(resultat.getInt(10));
                deal.setCommercant(commercantDAO.findCommercantById(resultat.getInt(11)));
            
                listecommercant.add(deal);
            }
            return listecommercant;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des deals "+ex.getMessage());
            return null;
        }
    }
    
    public List<Deal> DisplayAllDeals (){ //@syrine

            
            

        List<Deal> listeDeal = new ArrayList<Deal>();

        String requete = "select * from deal";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
   
            while(resultat.next()){
                Deal deal =new Deal();
                deal.setId_deal(resultat.getInt(1));
                deal.setLibelle_deal(resultat.getString(2));
                deal.setDescription(resultat.getString(3));
                deal.setCategorie(resultat.getString(4));
                deal.setDate_debut(resultat.getString(5));
                deal.setDate_fin(resultat.getString(6));
                deal.setAncien_montant(resultat.getFloat(7)) ;       
                deal.setNouveau_montant(resultat.getFloat(8));
               		
                listeDeal.add(deal);
            }
            return listeDeal;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return null;
        }}
    
} 
    
    
   