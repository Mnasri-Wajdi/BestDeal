

package esprit.pidev.gui.klibi_mahdi;

import esprit.pidev.dao.DealDAO;
import esprit.pidev.entities.Deal;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class DealUpdateModel extends AbstractTableModel{
     List<Deal> listdeal = new ArrayList<Deal>();
    String []header = {"id Deal","Libelle Deal","description","Categorie","Date Debut","Date Fin","Ancien Montant","Nouveau Montant","Quantite Disponible","Nom commercant"};
  
    public DealUpdateModel() { 
        listdeal=new DealDAO().DisplayAllDeal();
    }
    
    public int getRowCount() { 
        return listdeal.size();
    }

    public int getColumnCount() { 
        return header.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {
            case 0:
                return listdeal.get(rowIndex).getId_deal();
            case 1:
                return listdeal.get(rowIndex).getLibelle_deal();
            case 2:
                return listdeal.get(rowIndex).getDescription();
            case 3:
                return listdeal.get(rowIndex).getCategorie();
                case 4:
                return listdeal.get(rowIndex).getDate_debut();
                    case 5:
                return listdeal.get(rowIndex).getDate_fin();
                        case 6:
                return listdeal.get(rowIndex).getAncien_montant();
                            case 7:
                return listdeal.get(rowIndex).getNouveau_montant();
                                case 8:
                return listdeal.get(rowIndex).getQuantite_disponible();
                                    case 9:
                return listdeal.get(rowIndex).getCommercant().getNom_commercant();
                                        
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
    Deal deal = listdeal.get(row);
    DealDAO dealdao= new DealDAO();
   
    if (col==0) {
   JOptionPane.showMessageDialog(new GererDeal(), "Le champ Id deal ne peut pas être modifié","Erreur" ,JOptionPane.ERROR_MESSAGE);     
    }
    
    
    if (col==1){
        if (value.toString().length()>0){
      deal.setLibelle_deal((String)value);
      dealdao.updateDeal(deal);}
        else{
  JOptionPane.showMessageDialog(new GererDeal(), "Le champ Libelle Deal ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
             }
               }
    
    
    else if (col==2) {
        if (value.toString().length()>0){
        deal.setDescription((String)value);
         dealdao.updateDeal(deal);}
         else{
  JOptionPane.showMessageDialog(new GererDeal(), "Le champ Description Deal ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
             }
               }
    
    
     else if (col==3) {
         if (value.toString().length()>0){
        deal.setCategorie((String)value);
         dealdao.updateDeal(deal);}
         else{
  JOptionPane.showMessageDialog(new GererDeal(), "Le champ Catégorie Deal ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
             }
     }     
         
         
     else if (col==4) {
         if (value.toString().length()>0){
        deal.setDate_debut((String)value);
         dealdao.updateDeal(deal);}
     else{
  JOptionPane.showMessageDialog(new GererDeal(), "Le champ Date_Début Deal ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
             }
         }
         
         
     else if (col==5) {
         if (value.toString().length()>0){
        deal.setDate_fin((String)value);
         dealdao.updateDeal(deal);}
   else{
  JOptionPane.showMessageDialog(new GererDeal(), "Le champ Date_Fin Deal ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
             }
     }
     
     
     else if (col==6) {
          if (value.toString().length()>0){
        deal.setAncien_montant(Float.parseFloat((String)value));
         dealdao.updateDeal(deal);}
    else{
  JOptionPane.showMessageDialog(new GererDeal(), "Le champ Ancien_Montant Deal ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
             }
     }
     
     
     else if (col==7) {
         if (value.toString().length()>0){
        deal.setNouveau_montant(Float.parseFloat((String)value));
         dealdao.updateDeal(deal);}
     else{
  JOptionPane.showMessageDialog(new GererDeal(), "Le champ nouveau_Montant Deal ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
             }
     }
    else if (col==8) {
        if (value.toString().length()>0){
        deal.setQuantite_disponible(Integer.parseInt((String)value));
         dealdao.updateDeal(deal);}
    else{
  JOptionPane.showMessageDialog(new GererDeal(), "Le champ Quantité_disponible Deal ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
             }
    }
    fireTableCellUpdated(row,col);
}


    @Override
    public String getColumnName(int column) { 
        return header[column]; 
    }
    
    
}
