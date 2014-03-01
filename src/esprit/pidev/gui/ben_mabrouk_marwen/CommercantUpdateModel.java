
package esprit.pidev.gui.ben_mabrouk_marwen;

import esprit.pidev.dao.CommercantDAO;
import esprit.pidev.entities.Commercant;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marwen
 */
public class CommercantUpdateModel extends AbstractTableModel{
     List<Commercant> listCommercant = new ArrayList<Commercant>();
    String []header = {"Id","Nom commerçant","Description","Adresse","Email","Téléphone","Login","Mot de passe"};
  
  
     public static boolean isEmailAdress(String email){
    Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
    Matcher m = p.matcher(email.toUpperCase());
    return m.matches();
    }
    //private Component UpdateCommercant;
    
    
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
    if (col==0) {
   JOptionPane.showMessageDialog(new GererCommercant(), "Le champ Id commercant ne peut pas être modifié","Erreur" ,JOptionPane.ERROR_MESSAGE);     
    }
    
    if (col==1)
    {
        if (value.toString().length()>0) {
      commercant.setNom_commercant((String)value);
      cdao.updateCommercant(commercant);
            
   }
        else{
  JOptionPane.showMessageDialog(new GererCommercant(), "Le champ nom commercant ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
        }
        }
    else if (col==2) {
         if (value.toString().length()>0) {
         commercant.setDescription((String)value);
         cdao.updateCommercant(commercant);}
         else{
  JOptionPane.showMessageDialog(new GererCommercant(), "Le champ description ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
        }
    }
     else if (col==3) {
         if (value.toString().length()>0) {
        commercant.setAdresse((String)value);
         cdao.updateCommercant(commercant);
    }
         else{
  JOptionPane.showMessageDialog(new GererCommercant(), "Le champ adresse ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
        }
     }
     else if (col==4) {
          if ((value.toString().length()>0)&&(isEmailAdress(value.toString()))) {
        commercant.setEmail((String)value);
         cdao.updateCommercant(commercant);
          }
    else{
  JOptionPane.showMessageDialog(new GererCommercant(), "Adresse email non valide","Erreur" ,JOptionPane.ERROR_MESSAGE);
        }
     }
     else if (col==5) {
         if (value.toString().length()==8)
         {
          try{
              int tel = Integer.parseInt(value.toString());
               commercant.setTel(Integer.parseInt((String)value));
                cdao.updateCommercant(commercant);
              }catch(Exception e){
                  JOptionPane.showMessageDialog(new GererCommercant(), "Le numero de téléphone doit contenir seulement des chiffres","Erreur" ,JOptionPane.ERROR_MESSAGE);
  
              }   
       
    }
     else{
  JOptionPane.showMessageDialog(new GererCommercant(), "Le numero de téléphone doit contenir 8 chiffres ","Erreur" ,JOptionPane.ERROR_MESSAGE);
        }
     }
     else if (col==6) {
         if (value.toString().length()>0) {
        commercant.setLogin((String)value);
         cdao.updateCommercant(commercant);
    }
     else{
  JOptionPane.showMessageDialog(new GererCommercant(), "Le champ login ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
        }
     }
     else if (col==7) {
        if (value.toString().length()>0) {
         commercant.setPassword((String)value);
         cdao.updateCommercant(commercant);
    }
     else{
  JOptionPane.showMessageDialog(new GererCommercant(), "Le champ mot de passe ne peut pas être vide","Erreur" ,JOptionPane.ERROR_MESSAGE);
        }
     }
    fireTableCellUpdated(row,col);
}


    @Override
    public String getColumnName(int column) { 
        return header[column]; 
    }
    
    
}
