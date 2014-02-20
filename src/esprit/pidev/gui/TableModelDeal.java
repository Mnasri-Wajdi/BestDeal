/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui;

import esprit.pidev.dao.DealDAO;
import esprit.pidev.entities.Deal;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author syrine
 */
public class TableModelDeal extends AbstractTableModel{
 
    List<Deal> listDeal = new ArrayList<Deal>();
     String []header = {"id deal","Libelle","Description","Categorie","Date debut","date_fin","Ancien montant","Nouveau montant"};

    public TableModelDeal() {
        listDeal=new DealDAO().DisplayAllDeals();
    }
     
     
     
     
     
    @Override
    public int getRowCount() {//nombre de lignes de la table
        return listDeal.size();
    }
    

    @Override
    public int getColumnCount() {//nombre de colonnes de la table
        return header.length;
    }

    @Override
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
                
                 
                
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
}
