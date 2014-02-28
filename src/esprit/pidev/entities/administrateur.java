/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.entities;

/**
 *
 * @author Chala
 */
public class administrateur {
   
    private String login;
    private String password;
    private String nom_admin;
    private int id_admin;
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    
    
    
    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
    
    

    public String getNom_admin() {
        return nom_admin;
    }

    public void setNom_admin(String nom_admin) {
        this.nom_admin = nom_admin;
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
    
    
    
}
