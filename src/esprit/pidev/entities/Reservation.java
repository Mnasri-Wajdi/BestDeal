/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.entities;

import java.util.Date;

/**
 *
 * @author syrine
 */
public class Reservation {
     int numero_reservation;
   String date_reservation;
   int quantite;
   double prix;
   int id_client;
   int id_deal;

    public int getNumero_reservation() {
        return numero_reservation;
    }

    public void setNumero_reservation(int numero_reservation) {
        this.numero_reservation = numero_reservation;
    }

    public String getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

     public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_deal() {
        return id_deal;
    }

    public void setId_deal(int id_deal) {
        this.id_deal = id_deal;
    }
     
     
   
}
