
package esprit.pidev.gui.dridi_oumayma;


import esprit.pidev.dao.ClientDAO;
import esprit.pidev.entities.Client;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import sun.security.util.Length;


 public class modeldelate extends AbstractTableModel{
     

     List<Client> listClient = new ArrayList<>();

    String []header = {"id_client","login","password","nom","prenom","sexe","adresse","ville","code_postal","date_naissance","email","telephone"};

    public modeldelate() { 
        listClient =new ClientDAO().DisplayAllClients();
                }
    
     @Override
    public int getRowCount() { 
        return listClient.size();
    }

     @Override
    public int getColumnCount() { 
        return header.length;
    }
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {
            case 0:
                return listClient.get(rowIndex).getId_client();
            case 1:
                return listClient.get(rowIndex).getLogin();
            case 2:
                return listClient.get(rowIndex).getPassword();
            case 3:
                return listClient.get(rowIndex).getNom();
                case 4:
                return listClient.get(rowIndex).getPrenom();
                    case 5:
                return listClient.get(rowIndex).getSexe();
                        case 6:
                return listClient.get(rowIndex).getAdresse();
                          case 7:
                return listClient.get(rowIndex).getVille();
                          case 8:
                 return listClient.get(rowIndex).getCode_postal();
                           case 9:
                return listClient.get(rowIndex).getDate_naissance();
                            case 10:
                 return listClient.get(rowIndex).getSexe();
                            case 11:
                return listClient.get(rowIndex).getTelephone();
                            default :
                return null;
        }
    }
     @Override
    public String getColumnName(int column) { 
        return header[column]; 
    }
    
    
}



