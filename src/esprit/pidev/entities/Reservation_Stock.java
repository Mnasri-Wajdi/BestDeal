/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.entities;

/**
 *
 * @author Wajdi
 */
public class Reservation_Stock {
    
    private int id_reservation_stock;
    private int id_deal;
    private int nbr_reservation;

    
    public int getId_reservation_stock() {
        return id_reservation_stock;
    }

    public void setId_reservation_stock(int id_reservation_stock) {
        this.id_reservation_stock = id_reservation_stock;
    }

    public int getId_deal() {
        return id_deal;
    }

    public void setId_deal(int id_deal) {
        this.id_deal = id_deal;
    }

    public int getNbr_reservation() {
        return nbr_reservation;
    }

    public void setNbr_reservation(int nbr_reservation) {
        this.nbr_reservation = nbr_reservation;
    }
    
    
    
    
}
