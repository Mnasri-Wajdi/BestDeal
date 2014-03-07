/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.dao;


import esprit.pidev.accueil.frame_aceuil;
import esprit.pidev.entities.Reservation;
import esprit.pidev.gui.tonniche_syrine.AfficherDeals;
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
 * @author syrine
 */
public class ReservationDAO {
    
    //test66
    //884
    public boolean verifier_quantite(Reservation reservation)
    {
         String requete = "select quantite_disponible from deal where id_deal=?";
        try {
           
                   PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                   ps.setInt(1,reservation.getId_deal());
                  
                   ResultSet result = ps.executeQuery();
                  result.next();
                   int quantite = result.getInt(1);
                 //  System.out.println(quantite_res(reservation));
                   //   System.out.println(quantite);
                 if (quantite>quantite_res(reservation)) {
                
           
                      return true;
                       }
                   
                     else 
                 
                       return false;
            
                   
        }
        catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement de la quantite "+ex.getMessage());
         return false;
        }
    

    }
    public int quantite_res(Reservation reservation)
    {
           String requete = "select quantite from reservation where id_deal=? and id_client=?";
        try {
           
                   PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                   ps.setInt(1,reservation.getId_deal());
                   ps.setInt(2, reservation.getId_client());
                   ResultSet result = ps.executeQuery();
                  result.next();
                   int quantite = result.getInt(1);
                  return quantite;
            
                   
        }
        catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement de la quantite "+ex.getMessage());
         return -1;
        }
    
    }
    
        public float total_reservation( ) 
             
     {
        
        String requete = "select sum(prix*quantite) from reservation where `id_client`=?";
        try {
           
                   PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                   ps.setInt(1, frame_aceuil.idlog);
                   System.out.println("idlog"+frame_aceuil.idlog); 
                   ResultSet result = ps.executeQuery();
                   result.next();
                   float sum = result.getFloat(1);
                   
                   
            return sum;
            
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement du total "+ex.getMessage());
          return 0;
        }
    }
      public boolean verifier_reservation(Reservation res )
    {
        

        String requete = "select * from reservation";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Reservation reservation =new Reservation();
                reservation.setId_client(resultat.getInt(3));
                reservation.setId_deal(resultat.getInt(4));
                if ((reservation.getId_client()== res.getId_client())&&(reservation.getId_deal()==res.getId_deal())) {
                    return true;
                }
         
            }
            return false;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return false;
        }
    }
    
    public void InsertReservation(Reservation reservation){
         if (verifier_reservation(reservation)) {
             if (verifier_quantite(reservation)) {
                 
             
             String requete="update reservation set  date_reservation =?,quantite=quantite+1 where id_client=? and id_deal=? ";
           try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setString(1,reservation.getDate_reservation());      
           //ps.setInt(2,reservation.getQuantite());
        ps.setInt(2,reservation.getId_client());
               ps.setInt(3,reservation.getId_deal());



            ps.executeUpdate();
            System.out.println("Update effectuée avec succès");
            JOptionPane.showMessageDialog(new AfficherDeals(), "Ajout effectué avec succès");
       } catch (SQLException ex) {
         
            System.out.println("erreur lors de l'Update "+ex.getMessage());
        }
         }
             else
             {System.out.println("Vous ne pouvez plus reserver");
             JOptionPane.showMessageDialog(new AfficherDeals(), "Vous ne pouvez plus reserver");
             }
         }
         else
         {
         String requete = "insert into reservation (date_reservation,id_client,id_deal,quantite,prix) values (?,?,?,?,?)";
       
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setString(1,reservation.getDate_reservation());
           ps.setInt(2,reservation.getId_client());
           ps.setInt(3,reservation.getId_deal());
           ps.setInt(4,reservation.getQuantite());
           ps.setDouble(5,reservation.getPrix());


            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
            JOptionPane.showMessageDialog(new AfficherDeals(), "Ajout effectué avec succès");
       } catch (SQLException ex) {
         
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
         }
    }
    public List<Reservation> DisplayAllReservations (int id){


        List<Reservation> listeReservation = new ArrayList<Reservation>();

        String requete = "select * from reservation where id_client="+id;
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Reservation reservation =new Reservation();
                reservation.setNumero_reservation(resultat.getInt(1));
                 reservation.setDate_reservation(resultat.getString(2));
                 resultat.getInt(3);
             reservation.setId_deal(resultat.getInt(4));
                 reservation.setQuantite(resultat.getInt(5));
                 reservation.setPrix(resultat.getDouble(6));
                
                 
                listeReservation.add(reservation );
            }
            return listeReservation;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des reservations "+ex.getMessage());
            return null;
        }
    }
   
   
}
