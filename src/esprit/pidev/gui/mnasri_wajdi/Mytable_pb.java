/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.mnasri_wajdi;

import esprit.pidev.dao.DealDAO;
import esprit.pidev.dao.adminDAO;
import esprit.pidev.entities.Notification;
import esprit.pidev.entities.Reclamation;
import esprit.pidev.entities.Reclamation2;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wajdi
 */
public class Mytable_pb extends AbstractTableModel{

    
    List<Reclamation2> list_pb = new ArrayList<Reclamation2>();
    String []header = {"Nom client","Email client","La réclamation"};
    
    public Mytable_pb(){
    
    list_pb=new adminDAO().GetAllReclamation();
    }
    @Override
    public int getRowCount() {
        return list_pb.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex) {// parcour par colonne
            case 0:
                return list_pb.get(rowIndex).getNom();
            case 1:
                return list_pb.get(rowIndex).getEmail();
            case 2:
                return list_pb.get(rowIndex).getMsg();
                
            default:
                return null;
        }   
    }
    
    
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    
    
}
