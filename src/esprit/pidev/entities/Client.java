/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.entities;

import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author Wajdi
 */
public class Client {

    private int id_client;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private String ville;
    private int code_postal;
    private String date_naissance;
    private String email;
    private int telephone;

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }
    
    
    
    public int getId_client() {
        return id_client;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public int getCode_postal() {
        return code_postal;
    }

   
    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

  

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    
    
    
    
    
}
