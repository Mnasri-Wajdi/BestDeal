/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui;

import esprit.pidev.dao.DealDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import esprit.pidev.entities.Notification;
/**
 *
 * @author Wajdi
 */
public class Mytable_Notification extends AbstractTableModel{

    
    List<Notification> listNot = new ArrayList<Notification>();
    String []header = {"Numéro_Notification","Type_Notification"};
    
    public Mytable_Notification(int id){
    
    listNot=new DealDAO().DisplayAllNot(id);
    }
    @Override
    public int getRowCount() {
        return listNot.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex) {// parcour par colonne
            case 0:
                return listNot.get(rowIndex).getId_notification();
            case 1:
                return listNot.get(rowIndex).getType_notification();
            default:
                return null;
        }   
    }
    
    
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    
    
}
