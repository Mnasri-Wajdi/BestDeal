
package esprit.pidev.gui;

import esprit.pidev.dao.CommercantDAO;
import esprit.pidev.entities.Commercant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marwen
 */
public class CommercantUpdateModel extends AbstractTableModel{
     List<Commercant> listCommercant = new ArrayList<Commercant>();
    String []header = {"id_Commercant","nom commercant","description","adresse","email","telephone","login","password"};
  
    public CommercantUpdateModel() { 
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
public boolean isCellEditable(int row, int col) { 
    return true; 
}

@Override
public void setValueAt(Object value, int row, int col)
{
    Commercant commercant = listCommercant.get(row);
    CommercantDAO cdao= new CommercantDAO();
    if (col==1)
    {commercant.setNom_commercant((String)value);
      cdao.updateCommercant(commercant);
    }
    else if (col==2) {
        commercant.setDescription((String)value);
         cdao.updateCommercant(commercant);
    }
     else if (col==3) {
        commercant.setAdresse((String)value);
         cdao.updateCommercant(commercant);
    }
     else if (col==4) {
        commercant.setEmail((String)value);
         cdao.updateCommercant(commercant);
    }
     else if (col==5) {
        commercant.setTel(Integer.parseInt((String)value));
         cdao.updateCommercant(commercant);
    }
     else if (col==6) {
        commercant.setLogin((String)value);
         cdao.updateCommercant(commercant);
    }
     else if (col==7) {
        commercant.setPassword((String)value);
         cdao.updateCommercant(commercant);
    }
    fireTableCellUpdated(row,col);
}


    @Override
    public String getColumnName(int column) { 
        return header[column]; 
    }
    
    
}
