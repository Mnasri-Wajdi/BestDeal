package esprit.pidev.gui.ben_mabrouk_marwen;


import esprit.pidev.dao.CommercantDAO;
import esprit.pidev.entities.Commercant;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PieJPanel.java
 *
 * Created on 28 févr. 2014, 15:53:54
 */

/**
 *
 * @author Houssem Eddine
 */
public class PieJPanel extends javax.swing.JPanel {
 DefaultPieDataset dataset;//Dataset qui va contenir les Données
    JFreeChart graphe;        //Graphe
    ChartPanel cp;            //Panel

    public PieJPanel() {
   
        setSize(820, 520);
        dataset = new DefaultPieDataset();
        CommercantDAO cdao= new CommercantDAO();
         List<Commercant> listecommercant =   cdao.CommercantChart();
//Statique
         for(Commercant c: listecommercant){
        dataset.setValue(c.getNom_commercant(),new Double(c.getNote()) );
        
         }
         graphe = ChartFactory.createPieChart("Statistique par note", dataset,true ,true ,false);
        cp = new ChartPanel(graphe);
        this.add(cp);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
