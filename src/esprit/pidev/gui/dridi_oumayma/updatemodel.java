/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.dridi_oumayma;

import esprit.pidev.dao.ClientDAO;
import esprit.pidev.entities.Client;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class updatemodel extends AbstractTableModel {
 List<Client> listclient = new ArrayList<>();
    String []header = {"id_client","login","password","nom","prenom","sexe"," adresse"," ville"," code_postal","date_naissance","email","telephone"};
    
     public static boolean isEmailAdress(String email){
    Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
    Matcher m = p.matcher(email.toUpperCase());
    return m.matches();
    }
    private Component updateclt;
  public updatemodel (){
       listclient =new ClientDAO().DisplayAllClients();
    }
   
 @Override
   public int getRowCount() {
        return listclient.size();
        
    }

    
 @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return listclient.get(rowIndex).getId_client();
            case 1:
                return listclient.get(rowIndex).getLogin();
            case 2:
               return listclient.get(rowIndex).getPassword();
            case 3:
                return listclient.get(rowIndex).getNom();
            case 4:
                return listclient.get(rowIndex).getPrenom();
            case 5:
                return listclient.get(rowIndex).getSexe();
            case 6 :
                return listclient.get(rowIndex).getAdresse();
            case 7:
                return listclient.get(rowIndex).getVille();
            case 8:
                return listclient.get(rowIndex).getCode_postal();
            case 9:
                return listclient.get(rowIndex).getDate_naissance();
            case 10:
                return listclient.get(rowIndex).getEmail();
            case 11:
                return listclient.get(rowIndex).getTelephone();
            default :
                return null;
                
        }
        
    }
 
 @Override
 public boolean isCellEditable(int row, int col) { 
    return true; 
}
 @Override
 public void setValueAt(Object value, int row, int col)
{
   Client client =listclient.get(row);
    ClientDAO cdao= new ClientDAO();
    if (col==0) {
        JOptionPane.showMessageDialog(updateclt, "impossible de modifier ce champs", "Erreur", JOptionPane.ERROR_MESSAGE);
        
    }
    if (col==1)
    {
      client.setLogin((String)value);
      cdao.updateClient(client);
    }
    else if (col==2) {
        client.setPassword((String)value);
         cdao.updateClient(client);
    }
     else if (col==3) {
        client.setNom((String)value);
         cdao.updateClient(client);
    }
     else if (col==4) {
        client.setPrenom((String)value);
         cdao.updateClient(client);
    }
     else if (col==5) {
        client.setSexe((String)value);
         cdao.updateClient(client);
    }
     else if (col==6) {
        client.setAdresse((String)value);
         cdao.updateClient(client);
    }
     else if (col==7) {
        client.setVille((String)value);
         cdao.updateClient(client);
    }
     else if (col==8) {
        client.setCode_postal(Integer.parseInt((String)value));
         cdao.updateClient(client);
     }
     else if (col==9) {
        client.setDate_naissance((String)value);
         cdao.updateClient(client);
     }
     else if (col==10) {
         if(isEmailAdress(value.toString())){
        client.setEmail((String)value);
         cdao.updateClient(client);
     }
         else {
             JOptionPane.showMessageDialog(updateclt, "email invalid", "Erreur", JOptionPane.ERROR_MESSAGE);
         }
             
         }
     if (col==11) {
        client.setTelephone(Integer.parseInt((String)value));
         cdao.updateClient(client);
     }
    fireTableCellUpdated(row,col); 
    
}
 @Override
    public String getColumnName(int column) { 
        return header[column]; 
    }
}
