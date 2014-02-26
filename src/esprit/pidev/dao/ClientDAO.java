/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.dao;



import esprit.pidev.entities.Client;
import esprit.pidev.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chala
 */
public class ClientDAO {
    public void insertclient (Client d){

        String requete = "INSERT INTO client (`login`, `password`, `nom`, `prenom`, `sexe`, "
                + "`adresse`, `ville`, `code_postal`, `date_naissance`, `email`, `telephone`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(   1 , d.getLogin());
            ps.setString(   2 , d.getPassword());
            ps.setString(   3 , d.getNom());
            ps.setString(   4 , d.getPrenom());
            ps.setString(   5 , d.getSexe()+"");
            ps.setString(   6 , d.getAdresse());
            ps.setString(   7 , d.getVille());
            ps.setString(8 , d.getCode_postal()+"");
            ps.setString(   9 , d.getDate_naissance());
            ps.setString(   10 , d.getEmail());
            ps.setString(   11 , Integer.toString(d.getTelephone()));

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    
    public List<Client> GetAllClient (){
        List<Client> listeadmins = new ArrayList<Client>();
        String requete = "select login,password from client";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Client client =new Client();
                client.setLogin(resultat.getString(1));
                client.setPassword(resultat.getString(2));
                listeadmins.add(client);
            }
            return listeadmins;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins "+ex.getMessage());
            return null;
        }
    }
     public Client findclientByLogin (String login){
        Client client =null;
        String requete = "select login,password from client where login='"+login+"'";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                client = new Client();
               client.setLogin(resultat.getString(1));
                client.setPassword(resultat.getString(2));
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins "+ex.getMessage());
        }
        return client;
    }
    
}
    
