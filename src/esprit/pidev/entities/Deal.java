
package esprit.pidev.entities;

import java.sql.Date;

public class Deal {
    //Déclaration des variables//
    int id_deal;
    String libelle_deal;
    String description;
    String categorie;
    String date_debut;
    String date_fin;
    float ancien_montant;
    float nouveau_montant;
    int quantite_disponible;
    int nombre_reservation;
    private Commercant commercant;
    //int idcommercant;

    public Commercant getCommercant() {
        return commercant;
    }

    public void setCommercant(Commercant commercant) {
        this.commercant = commercant;
    }

    //public int getIdcommercant() {
        //return idcommercant;
    //}

    //public void setIdcommercant(int idcommercant) {
      //  this.idcommercant = idcommercant;
   // }
    
    //les getters et les setters//
    public int getId_deal() {
        return id_deal;
    }

    public void setId_deal(int id_deal) {
        this.id_deal = id_deal;
    }

    public String getLibelle_deal() {
        return libelle_deal;
    }

    public void setLibelle_deal(String libelle_deal) {
        this.libelle_deal = libelle_deal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public float getAncien_montant() {
        return ancien_montant;
    }

    public void setAncien_montant(float ancien_montant) {
        this.ancien_montant = ancien_montant;
    }

    public float getNouveau_montant() {
        return nouveau_montant;
    }

    public void setNouveau_montant(float nouveau_montant) {
        this.nouveau_montant = nouveau_montant;
    }

    public int getQuantite_disponible() {
        return quantite_disponible;
    }

    public void setQuantite_disponible(int quantite_disponible) {
        this.quantite_disponible = quantite_disponible;
    }

    public int getNombre_reservation() {
        return nombre_reservation;
    }

    public void setNombre_reservation(int nombre_reservation) {
        this.nombre_reservation = nombre_reservation;
    }
    
    
 
    
}
