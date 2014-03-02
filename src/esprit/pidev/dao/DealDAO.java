/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.dao;

import esprit.pidev.entities.Deal;
import esprit.pidev.entities.Commercant;
import esprit.pidev.entities.Notification;
import esprit.pidev.entities.Reclamation;
import esprit.pidev.entities.Reservation2;
import esprit.pidev.entities.Verif;
import esprit.pidev.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DealDAO {
 public void insertDeal(Deal d){
   
      // CommercantDAO commercantdao=new CommercantDAO();
        String requete = "insert into deal (libelle_deal,description,categorie,date_debut,date_fin,ancien_montant,nouveau_montant,quantite_disponible,idcommercant) values (?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(9, d.getCommercant().getId_commercant());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateDeal(Deal d){
        String requete;
     requete = "update deal set libelle_deal=?, description=?, categorie=?, date_debut=?, date_fin=?, ancien_montant=?, nouveau_montant=?, quantite_disponible=?,idcommercant=?  where id_deal=?";
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
            ps.setInt(9, d.getCommercant().getId_commercant());
            ps.setInt(10, d.getId_deal());
            
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
            deal.setCommercant(commercantDAO.findCommercantById(resultat.getInt(10)));
        }
        return deal;
        }
        catch(SQLException ex){
            System.out.println("erreur lors du chargement"+ex.getMessage());
            return null;
        }
    }
    
    public List<Deal> DisplayAllDeal (){ //@mehdi


        List<Deal> listedeal = new ArrayList<Deal>();

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
                deal.setCommercant(commercantDAO.findCommercantById(resultat.getInt(10)));
            
                listedeal.add(deal);
            }
            return listedeal;
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
    
    
    
    //Mnasri wajdi
    
public void insertProbleme(Reclamation r){

        String requete = "insert into reclamation (message,id_client) values (?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, r.getMessage());
            ps.setString(2, Integer.toString(r.getId_client()));
            ps.executeUpdate();
            
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    
    
public void updateNoteCommercant(Commercant c){
    
    
        String requete = "update commercant set note_commercant=?,nbr_note=?,somme_note=? WHERE id_commercant=?" ;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setFloat(1,c.getNote());
            ps.setInt(2,c.getNbr_note());
            ps.setFloat(3,c.getSomme_note());
            ps.setInt(4, c.getId_commercant());
            ps.executeUpdate();
            System.out.println("Mise à jour du note effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }

    }
    
    
    public List<Commercant> allcommercant (){


        List<Commercant> listecommercant = new ArrayList<Commercant>();

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
                commercant.setNote(resultat.getFloat(9));
                commercant.setNbr_note(resultat.getInt(10));
                commercant.setSomme_note(resultat.getFloat(11));
                

                listecommercant.add(commercant);
            }
            return listecommercant;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des commercant"+ex.getMessage());
            return null;
        }
    }
    
    public boolean allverif (int a,int b){


        List<Verif> listeverif = new ArrayList<Verif>();

        String requete = "select * from verif_premier_note where id_client="+a+" and id_commercant="+b;
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Verif verif =new Verif();
                verif.setId_verif_premier_note(resultat.getInt(1));
                verif.setId_client(resultat.getInt(2));
                verif.setId_commercant(resultat.getInt(3));
                
                

                listeverif.add(verif);
            }
            if( listeverif.isEmpty() ){
                return true;}
                else
            { return false;}
            
            
            
            
            
            
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Vérification"+ex.getMessage());
            return false;
        }
    }
    
    public void insertVerif(Verif v){

        String requete = "insert into verif_premier_note (id_client,id_commercant) values (?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, v.getId_client());
            ps.setInt(2, v.getId_commercant());
            ps.executeUpdate();
            
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    
public List<Notification> DisplayAllNot(int id) {
        
       List<Notification> listeNot = new ArrayList<Notification>();
       System.out.println(id);
        String requete = "select type_notification,date_notification,vu from notification  where id_client="+id+" ORDER BY vu ASC";//tf_idClient=id_client
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Notification notification =new Notification();
                
                notification.setType_notification(resultat.getString(1));
                notification.setDate_notification(resultat.getString(2));
                notification.setVu(resultat.getInt(3));
                
                
                

                listeNot.add(notification);
            }
            return listeNot;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des notification"+ex.getMessage());
            return null;
        } 
        
    }

    public void UpdateVu(Notification n) {
        
        String requete = "update notification set vu=? WHERE id_client=?" ;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1,1);
            ps.setInt(2, n.getId_client());
            ps.executeUpdate();
            System.out.println("Vu du notification effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
        
        
        
        
        
    }
    
       public void DisplayNotifDeal(int id) {
        
       
       
       String nom_deal="";
       String description_deal="";
       String requete = "select id_deal2,date_reservation2 from reservation2 where id_client2="+id;
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                           Statement statement2 = MyConnection.getInstance()
                           .createStatement();
                           int x=resultat.getInt(1);                  
                           String requete2 = "select libelle_deal,description from deal where id_deal="+x;
                           ResultSet resultat2 = statement2.executeQuery(requete2);
                           while(resultat2.next()){
                
                           nom_deal=resultat2.getString(1);
                           description_deal=resultat2.getString(2);
                
                                                  }
                
                
                String requete3 = "insert into notification (type_notification,date_notification,id_client,vu) values (?,?,?,?)";
                
               
                            try {
                                   PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete3);
                                   ps.setString(1,"Le deal "+nom_deal+" "+description_deal+" est Réservé" );
                                   ps.setString(2,resultat.getString(2));
                                   ps.setInt(3,id);
                                   ps.setInt(4,0);
                                   ps.executeUpdate();
            
                                   System.out.println("Ajout effectuée avec succès");
                                   } catch (SQLException ex) {
                                   //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            
                                   System.out.println("erreur lors de l'insertion "+ex.getMessage());
                                      }
                
             
                
            }
            
           
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des notifications"+ex.getMessage());
          
        } 
        
        
            
        String requete4 = "delete from reservation2" ;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete4);
            
            ps.executeUpdate();
            System.out.println("contenu reservation2 supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    
       public void InsertReservation2(Reservation2 reservation2){
    
         String requete = "insert into reservation2 (date_reservation2,id_client2,id_deal2,quantite2,prix2) values (?,?,?,?,?)";
       
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setString(1,reservation2.getDate_reservation2());
           ps.setInt(2,reservation2.getId_client2());
           ps.setInt(3,reservation2.getId_deal2());
           ps.setInt(4,reservation2.getQuantite2());
           ps.setDouble(5,reservation2.getPrix2());


            ps.executeUpdate();
            System.out.println("Ajout dans res 2 effectuée avec succès");
       } catch (SQLException ex) {
         
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    
    } 
       public void InsertDealNot (Deal d){ 

       
       
       String requete = "select id_client from client";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while(resultat.next()){
                
                         
                
                String requete9 = "insert into notification (type_notification,date_notification,id_client,vu) values (?,?,?,?)";
                
               
                            try {
                                   PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete9);
                                   ps.setString(1,"Un nouveau deal "+d.getLibelle_deal()+" de catégorie "+d.getCategorie()+" avec un prix de "+d.getNouveau_montant()+" est Ajouté" );
                                   ps.setString(2,new Date().toString());
                                   ps.setInt(3,resultat.getInt(1));
                                   ps.setInt(4,0);
                                   ps.executeUpdate();
            
                                   System.out.println("Ajout effectuée avec succès");
                                   } catch (SQLException ex) {
                                   //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            
                                   System.out.println("erreur lors de l'insertion "+ex.getMessage());
                                      }
                
             
                
            }
            
           
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des notifications"+ex.getMessage());
          
        } 
       
       
       
       
       
    
    
   }    
    public  void Insert_Reserv_Deal(){
        
        
        
            String requete = "select id_deal from deal";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                
               if(verif_res(resultat.getInt(1))){
                   
                   
                 
        String requete2 = "insert into reservation_stock (id_deal,nbr_reservation) values (?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete2);
            ps.setInt(1,resultat.getInt(1));
            ps.setInt(2,0);
            ps.executeUpdate();
            
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
                
                     
               }
     
            }
   
            
            
            
            
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement "+ex.getMessage());
          
        }
        
        
   
    
}
    
    
    public boolean verif_res(int m){
    
    boolean q=true;
        
        String requete5 = "select id_deal from reservation_stock";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat5 = statement.executeQuery(requete5);
             
            while(resultat5.next()){
                
                if (resultat5.getInt(1)==m) {
                    q= false;
                }

            
                
            }
            return q;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement  "+ex.getMessage());
            return false;
        }
    }
        
      // public void Payer  
        
    
    
    
    }
    
    
    
    
    
    
    

    
    
   