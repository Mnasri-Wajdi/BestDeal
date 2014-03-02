/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.tonniche_syrine;

import esprit.pidev.dao.ReservationDAO;
import esprit.pidev.entities.Reservation;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author syrine
 */
public class TableModelReservation extends AbstractTableModel{
     List<Reservation> listeReservation = new ArrayList<Reservation>();
     String []header = {"Numero","Date","Prix","Quantité"};

    public TableModelReservation(int id) {
        
        listeReservation= new ReservationDAO().DisplayAllReservations(id);
    }
     
    // @Override
    public int getRowCount() {//nombre de lignes de la table
        return listeReservation.size();
    }
    

   // @Override
    public int getColumnCount() {//nombre de colonnes de la table
        return header.length;
    }

   // @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listeReservation.get(rowIndex).getNumero_reservation();
            case 1:
                return listeReservation.get(rowIndex).getDate_reservation();
            case 2:
                return listeReservation.get(rowIndex).getPrix();
           case 3:
              return listeReservation.get(rowIndex).getQuantite();
            default:
                return null;
        }
    }
  //  @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
}
