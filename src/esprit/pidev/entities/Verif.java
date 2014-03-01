/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.entities;

/**
 *
 * @author Wajdi
 */
public class Verif {
    
    private int id_verif_premier_note;
    private int id_client;
    private int id_commercant;

    public int getId_verif_premier_note() {
        return id_verif_premier_note;
    }

    public void setId_verif_premier_note(int id_verif_premier_note) {
        this.id_verif_premier_note = id_verif_premier_note;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_commercant() {
        return id_commercant;
    }

    public void setId_commercant(int id_commercant) {
        this.id_commercant = id_commercant;
    }
    

}
