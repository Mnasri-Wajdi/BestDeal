/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.dao;


import esprit.pidev.entities.Reservation;
import esprit.pidev.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author syrine
 */
public class ReservationDAO {
    
    //test66
    //884
    
     public void InsertReservation(Reservation reservation){
    
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
       } catch (SQLException ex) {
         
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    
    }
  
    public List<Reservation> DisplayAllReservations (){


        List<Reservation> listeReservation = new ArrayList<Reservation>();

        String requete = "select * from reservation";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Reservation reservation =new Reservation();
                reservation.setNumero_reservation(resultat.getInt(1));
                 reservation.setDate_reservation(resultat.getString(2));
                 resultat.getInt(3);
                 resultat.getInt(4);
                 reservation.setQuantite(resultat.getInt(5));
                 reservation.setPrix(resultat.getDouble(6));
                
                 
                listeReservation.add(reservation );
            }
            return listeReservation;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return null;
        }
    }
   
   
}