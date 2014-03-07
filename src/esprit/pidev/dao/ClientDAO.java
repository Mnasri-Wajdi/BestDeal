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
    
     //marwen chalghoumi//  Le client fait une inscription pour la première fois//
    
    
    public Client findClientByEmail(String email)
    {
        Client client = new Client();
        
      

     String requete = "select * from Client where email=?";
        try {
            
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,email);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                client.setId_client(resultat.getInt(1));
                client.setLogin(resultat.getString(2));
                client.setPassword(resultat.getString(3));
                client.setNom(resultat.getString(4));
                client.setPrenom(resultat.getString(5));
                client.setSexe(resultat.getString(6));
                client.setAdresse(resultat.getString(7));
                client.setVille(resultat.getString(8));
                client.setCode_postal(resultat.getInt(9));
                client.setDate_naissance(resultat.getString(10));
                client.setEmail(resultat.getString(11));
                client.setTelephone(resultat.getInt(12));
               
            }
            return client;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Client introuvable"+ex.getMessage());
            return null;
        }

    
    
    }
    
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
            ps.setString(   5 , d.getSexe());
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
        String requete = "select * from client where login='"+login+"'";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                client = new Client();
                
                client.setId_client(resultat.getInt(1));
                client.setLogin(resultat.getString(2));
                client.setPassword(resultat.getString(3));
                client.setNom(resultat.getString(4));
                client.setPrenom(resultat.getString(5));
                client.setSexe(resultat.getString(6));
                client.setAdresse(resultat.getString(7));
                client.setVille(resultat.getString(8));
                client.setCode_postal(resultat.getInt(9));
                client.setDate_naissance(resultat.getString(10));
                client.setEmail(resultat.getString(11));
                client.setTelephone(resultat.getInt(12));
                
                
               
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins "+ex.getMessage());
        }
        return client;
    }
   
     
     //oumaima
     
     
      public void AjouterClient(Client C){

        String requete = "insert into Client (id_client,login,password,nom,prenom,sexe,adresse,ville,code_postal,date_naissance,email,telephone) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, C.getId_client());
            ps.setString(2, C.getLogin());
            ps.setString(3, C.getPassword());
            ps.setString(4, C.getNom());
            ps.setString(5, C.getPrenom());
            ps.setString(6, C.getSexe());
            ps.setString(7, C.getAdresse());
            ps.setString(8, C.getVille());
            ps.setInt(9, C.getCode_postal());
            ps.setString(10,C.getDate_naissance());
            ps.setString(11, C.getEmail());
            ps.setInt(12, C.getTelephone());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
            //System.out.println(C.getDate_naissance());
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
            
        }}
       public void updateClient (Client c){
           
        String requete = "update client set login=?, password=?, nom=?,prenom=?,sexe=?,adresse=?,ville=?,code_postal=?,date_naissance=?,email=?,telephone=? where id_client=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
     
            ps.setString(1, c.getLogin().toString());
            ps.setString(2, c.getPassword().toString());
            ps.setString(3, c.getNom().toString());
            ps.setString(4,c.getPrenom());
            ps.setString(5, c.getSexe());
            ps.setString(6, c.getAdresse());
            ps.setString(7, c.getVille());
            ps.setInt(8, c.getCode_postal());
            ps.setString(9, c.getDate_naissance());
            ps.setString(10, c.getEmail());
            ps.setInt(11, c.getTelephone());
            ps.setInt(12, c.getId_client());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }

       }
    
     
        
           public  List<Client> DisplayAllClients () {
        
        List<Client> listClient = new ArrayList<>();

        String requete = "select * from client";
        try {
      Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
   
            while(resultat.next()){
                Client client =new Client();
                client.setId_client(resultat.getInt(1));
                client.setLogin(resultat.getString(2));
                client.setPassword(resultat.getString(3));
                client.setNom(resultat.getString(4));
                client.setPrenom(resultat.getString(5));
                client.setSexe(resultat.getString(6));
                client.setAdresse(resultat.getString(7));
                client.setVille(resultat.getString(8));
                client.setCode_postal(resultat.getInt(9));
                client.setDate_naissance(resultat.getString(10));
                client.setEmail(resultat.getString(11));
                client.setTelephone(resultat.getInt(12));
                
                listClient.add(client);
            }
            return listClient;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des clients "+ex.getMessage());
            return null ;
        }   
}
         public List<Client> chercherClientBynom( String nom) {
        List<Client> listeclient = new ArrayList<>();
        String requete = "select * from client where nom like '" + nom + "%'";
        //   String requete = "select * from client where nom='"+nom+"'";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat;
            resultat = ps.executeQuery(requete);
            while (resultat.next()) {
                Client op = new Client();
                op.setId_client(resultat.getInt(1));
                op.setLogin(resultat.getString(2));
                op.setPassword(resultat.getString(3));
                op.setNom(resultat.getString(4));
                op.setPrenom(resultat.getString(5));
                op.setSexe(resultat.getString(6));
                op.setAdresse(resultat.getString(7));
                op.setVille(resultat.getString(8));
                op.setCode_postal(resultat.getInt(9));
                op.setDate_naissance(resultat.getString(10));
                op.setEmail(resultat.getString(11));
                op.setTelephone(resultat.getInt(12));
                
                listeclient.add(op);
            }
            return listeclient;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des comptes " + ex.getMessage());
            return null;
        }
    }
        
      
    public void deleteClient(int id){

          String requete = "delete from client where id_client=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
     
     public Client findClientById(int id){
    Client client = new Client();
     String requete = "select * from Client where id_client=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                client.setId_client(resultat.getInt(1));
                client.setLogin(resultat.getString(2));
                client.setPassword(resultat.getString(3));
                client.setNom(resultat.getString(4));
                client.setPrenom(resultat.getString(5));
                client.setSexe(resultat.getString(6));
                client.setAdresse(resultat.getString(7));
                client.setVille(resultat.getString(8));
                client.setCode_postal(resultat.getInt(9));
                client.setDate_naissance(resultat.getString(10));
                client.setEmail(resultat.getString(11));
                client.setTelephone(resultat.getInt(12));
               
            }
            return client;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
    
     
     
}
    
