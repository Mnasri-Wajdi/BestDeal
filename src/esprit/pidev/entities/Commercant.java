/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.entities;

/**
 *
 * @author Marwen
 */
public class Commercant {
   private int id_commercant; 
   private String nom_commercant;
   private String description;
   private String adresse;
   private int tel;
   private String email;
   private String login;
   private String password;
   


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    public int getId_commercant() {
        return id_commercant;
    }

    public void setId_commercant(int id_commercant) {
        this.id_commercant = id_commercant;
    }
    
    public String getNom_commercant() {
        return nom_commercant;
    }

    public void setNom_commercant(String nom_commercant) {
        this.nom_commercant = nom_commercant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
