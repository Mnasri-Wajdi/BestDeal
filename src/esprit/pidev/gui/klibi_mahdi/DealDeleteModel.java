
package esprit.pidev.gui.klibi_mahdi;

import esprit.pidev.dao.DealDAO;
import esprit.pidev.entities.Deal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marwen
 */
public class DealDeleteModel extends AbstractTableModel{
     List<Deal> listDeal = new ArrayList<Deal>();
    String []header = {"id Deal","Libelle Deal","description","Categorie","Date Debut","Date Fin","Ancien Montant","Nouveau Montant","Quantite Disponible","Nom commercant"};

    public DealDeleteModel() { 
        listDeal=new DealDAO().DisplayAllDeal();
    }
    
    public int getRowCount() { 
        return listDeal.size();
    }

    public int getColumnCount() { 
        return header.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {
            case 0:
                return listDeal.get(rowIndex).getId_deal();
            case 1:
                return listDeal.get(rowIndex).getLibelle_deal();
            case 2:
                return listDeal.get(rowIndex).getDescription();
            case 3:
                return listDeal.get(rowIndex).getCategorie();
                case 4:
                return listDeal.get(rowIndex).getDate_debut();
                    case 5:
                return listDeal.get(rowIndex).getDate_fin();
                        case 6:
                return listDeal.get(rowIndex).getAncien_montant();
                            case 7:
                return listDeal.get(rowIndex).getNouveau_montant();
                                case 8:
                return listDeal.get(rowIndex).getQuantite_disponible();
                                   case 9:
                return listDeal.get(rowIndex).getCommercant().getNom_commercant();
                                       
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column) { 
        return header[column]; 
    }
    
    
}
