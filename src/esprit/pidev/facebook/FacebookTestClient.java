package esprit.pidev.facebook;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FacebookTestClient extends JFrame {


 JButton getPermissionsForApp;

 

 public FacebookTestClient() {

  getPermissionsForApp = new JButton("get permissions for app");

  

  JPanel panel = new JPanel();
  panel.setLayout(new GridLayout(0, 1));


  panel.add(getPermissionsForApp);

 

  add(panel);

  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setSize(100, 125);
  setLocationRelativeTo(null);
  setVisible(true);
  // VOIR MEANING
  pack();
 }


 public void setgetPermissionsForAppListener(ActionListener l) {
  getPermissionsForApp.addActionListener(l);
 }

 

 

}