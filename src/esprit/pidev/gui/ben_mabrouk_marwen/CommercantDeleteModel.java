
package esprit.pidev.gui.ben_mabrouk_marwen;

import esprit.pidev.dao.CommercantDAO;
import esprit.pidev.entities.Commercant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marwen
 */
public class CommercantDeleteModel extends AbstractTableModel{
     List<Commercant> listCommercant = new ArrayList<Commercant>();
    String []header = {"id_Commercant","nom commercant","description","adresse","email","telephone","login","password"};

    public CommercantDeleteModel() { 
        listCommercant=new CommercantDAO().DisplayAllCommercants();
    }
    
    public int getRowCount() { 
        return listCommercant.size();
    }

    public int getColumnCount() { 
        return header.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {
            case 0:
                return listCommercant.get(rowIndex).getId_commercant();
            case 1:
                return listCommercant.get(rowIndex).getNom_commercant();
            case 2:
                return listCommercant.get(rowIndex).getDescription();
            case 3:
                return listCommercant.get(rowIndex).getAdresse();
                case 4:
                return listCommercant.get(rowIndex).getEmail();
                    case 5:
                return listCommercant.get(rowIndex).getTel();
                        case 6:
                return listCommercant.get(rowIndex).getLogin();
                            case 7:
                return listCommercant.get(rowIndex).getPassword();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column) { 
        return header[column]; 
    }
    
    
}
