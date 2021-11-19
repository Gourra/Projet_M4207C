import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.*;


class Fenetre extends JFrame {

    // --- FENETRE ---
    JPanel Fentre() {

        JPanel conteneur = new JPanel();
        Terminal T2= new Terminal(2);
        
        // --- AFFICHAGE VALEURS FILTRÉES ---
        JPanel EST = new JPanel();
        JLabel filtre_val_label = new JLabel();

        // --- TOUTES LES VALEURS ---
        JPanel OUEST = new JPanel();
        JLabel toute_val_label = new JLabel();

        // --- FILTRE + DEMANDE VALEUR ---
        JPanel NORD = new JPanel( new GridLayout(1,2,10,0) );
        JPanel P1 = new JPanel();
        JPanel P2 = new JPanel();

        JLabel demande_label = new JLabel();
        JButton bouton_cap1 = new JButton("Capteur 1");
        JButton bouton_cap2 = new JButton("Capteur 2");

        JComboBox<String> filtre_combo = new JComboBox<String>();
        JLabel filtre_label = new JLabel();


        // --- CONNEXION CAPTEUR ---
        JPanel SUD1 = new JPanel(  );
        JPanel SUD2 = new JPanel(  );
        JPanel SUD = new JPanel(  );

        JLabel connect_label1 = new JLabel();
        JLabel connect_label2 = new JLabel();
        JLabel connect_label3 = new JLabel();
        JLabel connect_label4 = new JLabel();

        try {
            
            Central C1 = new Central();

            //setSize(1080, 675);
            setSize(1400, 875);
            setLocationRelativeTo(null);
            setResizable(false);
        

            conteneur.setLayout(new BorderLayout());
            conteneur.add( new CurveCanvas(), BorderLayout.CENTER );

            // --- AFFICHAGE VALEURS FILTRÉES ---
            filtre_val_label.setText("ICI VALEURS FILTRÉES");
            EST.add(filtre_val_label);

            // --- TOUTES LES VALEURS ---
            Thread t = new Thread(new Runnable(){
                public void run(){
                    T2.getSqlfull(C1);

                    while (true) {
                        int i = T2.localbdd.size();
                        T2.localbdd.get(i).print2();
                        toute_val_label.setText("<html><body>" + T2.localbdd.get(i).print2() + "<br><br>" +  T2.localbdd.get(i-1).print2() + "<br><br>" +  T2.localbdd.get(i-2).print2() + "<br><br>" +  T2.localbdd.get(i-3).print2() + "<br><br>" +  T2.localbdd.get(i-4).print2() + "<br><br>" +  T2.localbdd.get(i-5).print2() + "<br><br>" +  T2.localbdd.get(i-6).print2() + "<br><br>" +  T2.localbdd.get(i-7).print2() + "<br><br>" +  T2.localbdd.get(i-8).print2() + "<br><br>" +  T2.localbdd.get(i-9).print2() + "<br><br>" +  T2.localbdd.get(i-10).print2() + "<br><br>" +  T2.localbdd.get(i-11).print2() + "<br><br>" +  T2.localbdd.get(i-12).print2() + "<br><br>" +  T2.localbdd.get(i-13).print2() + "<br><br>" +  T2.localbdd.get(i-14).print2() + "<br><br>" +  T2.localbdd.get(i-15).print2() + "<br><br>" +  T2.localbdd.get(i-16).print2() + "<br><br>" +  T2.localbdd.get(i-17).print2() + "<br><br>" +  T2.localbdd.get(i-18).print2() + "<br><br>" +  T2.localbdd.get(i-19).print2() + "<br><br>" +  T2.localbdd.get(i-20).print2() + "<br><br>" +  T2.localbdd.get(i-21).print2() + "<br><br>" +  T2.localbdd.get(i-22).print2() + "<br><br>" +  T2.localbdd.get(i-23).print2() + "<br><br>" + "....... ...... ..... .... ... .. ." + "</body></html>");
                        
                    }
                    
                    
                }
            });
            t.start();

            toute_val_label.setText("ICI TOUTES LES VALEURS");
            OUEST.add(toute_val_label);


            // --- PARTIE DEMANDE VALEUR + FILTRAGE ---


            demande_label.setText("Demande de valeur :");
            P1.add(demande_label);
            P1.add(bouton_cap1);
            P1.add(bouton_cap2);

            bouton_cap1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /*label.setText("Vous avez cliqué sur le bouton numero 1");
                    conteneur.add(label, BorderLayout.SOUTH); ICI METTRE COMMANDE DEMANDE VALEUR */
                }
            });

            bouton_cap2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /*label.setText("Vous avez cliqué sur le bouton numero 1");
                    conteneur.add(label, BorderLayout.SOUTH); ICI METTRE COMMANDE DEMANDE VALEUR */
                }
            });


            filtre_label.setText("Filtrage capteur :");
            filtre_combo.addItem("Aucun");
            filtre_combo.addItem("Capteur 1");
            filtre_combo.addItem("Capteur 2");

            filtre_combo.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        /*label1.setText("Vous avez sélectionné le " + e.getItem());
                        conteneur.add(label1, BorderLayout.PAGE_END); ICI METTRE COMMANDE FILTRAGE CAPTEUR */
                    }
                }
            });

            P2.add(filtre_label);
            P2.add(filtre_combo);

            NORD.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            NORD.add(P1);
            NORD.add(P2);

            // --- PARTIE CONNEXION CAPTEUR ---
            connect_label1.setText("Capteur 1 :");
            SUD1.add(connect_label1);
            
            /*if (capteur1 == 1) {
                connect_label2.setText("On");
                SUD1.add(connect_label2);
            }
            else if (capteur1 == 2) {
                connect_label2.setText("Off");
                SUD1.add(connect_label2);
            }*/

            connect_label3.setText("Capteur 2 :");
            SUD2.add(connect_label3);

            /*if (capteur2 == 1) {
                connect_label4.setText("On");
                SUD2.add(connect_label4);
            }
            else if (capteur2 == 2) {
                connect_label4.setText("On");
                SUD2.add(connect_label4);
            }*/
            
            SUD.add(SUD1, BorderLayout.WEST);
            SUD.add(SUD2, BorderLayout.EAST);



            conteneur.add(NORD, BorderLayout.NORTH);
            conteneur.add(SUD, BorderLayout.SOUTH);
            conteneur.add(OUEST, BorderLayout.WEST);
            conteneur.add(EST, BorderLayout.EAST);
            
            setContentPane(conteneur);
            setTitle("TABLEAU DE BORD GRAPHIQUE");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            return conteneur;   
        }
        
        catch (Exception e) {
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return conteneur;  
    }
}