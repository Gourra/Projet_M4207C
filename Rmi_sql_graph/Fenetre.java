import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class base {

    String liste1[];
    String liste2[];
    String liste3[];
    String liste4[];
    String liste5[];
    String liste6[];
    String liste7[];
    String liste8[];
    String liste9[];
    String liste10[];

    ArrayList<Object> cap1 = new ArrayList<Object>();
    ArrayList<Object> cap2 = new ArrayList<Object>();
    ArrayList<Object> cap1_xy = new ArrayList<Object>();
    ArrayList<Object> cap2_xy = new ArrayList<Object>();

    public void liste() {
        String liste1 = String.format("%-2s %-10s %-20s %-5s %-20s", 1, "l'heure", "Capteur n°1", 1, "Degré(s)");
        String liste2 = String.format("%-2s %-10s %-20s %-5s %-20s", 2, "l'heure", "Capteur n°1", 2, "Degré(s)");
        String liste3 = String.format("%-2s %-10s %-20s %-5s %-20s", 3, "l'heure", "Capteur n°1", 3, "Degré(s)");
        String liste4 = String.format("%-2s %-10s %-20s %-5s %-20s", 4, "l'heure", "Capteur n°1", 4, "Degré(s)");
        String liste5 = String.format("%-2s %-10s %-20s %-5s %-20s", 5, "l'heure", "Capteur n°1", 5, "Degré(s)");
        cap1.add(liste1);
        cap1.add(liste2);
        cap1.add(liste3);
        cap1.add(liste4);
        cap1.add(liste5);
        for (Object str : cap1) {

            System.out.println(str); // Cette ligne permet d'afficher la Arraylist sans les crochets.
        }

        String liste6 = String.format("%-2s %-10s %-20s %-5s %-20s", 1, "l'heure", "Capteur n°2", 10, "Lumens");
        String liste7 = String.format("%-2s %-10s %-20s %-5s %-20s", 2, "l'heure", "Capteur n°2", 20, "Lumens");
        String liste8 = String.format("%-2s %-10s %-20s %-5s %-20s", 3, "l'heure", "Capteur n°2", 30, "Lumens");
        String liste9 = String.format("%-2s %-10s %-20s %-5s %-20s", 4, "l'heure", "Capteur n°2", 40, "Lumens");
        String liste10 = String.format("%-2s %-10s %-20s %-5s %-20s", 5, "l'heure", "Capteur n°2", 50, "Lumens");
        cap2.add(liste6);
        cap2.add(liste7);
        cap2.add(liste8);
        cap2.add(liste9);
        cap2.add(liste10);
        for (Object str : cap2) {

            System.out.println(str); // Cette ligne permet d'afficher la Arraylist sans les crochets.
        }
    }
}

class principal {

    public static void main(String[] args) {
        // base cap = new base();
        Fenetre mafenetre = new Fenetre();
        mafenetre.setVisible(true);
        // cap.liste();
    }
}

public class Fenetre extends JFrame {

    private JPanel conteneur = new JPanel();

    // --- AFFICHAGE VALEURS FILTRÉES ---
    private JPanel EST = new JPanel();
    private JLabel filtre_val_label = new JLabel();

    // --- TOUTES LES VALEURS ---
    private JPanel OUEST = new JPanel();
    private JLabel toute_val_label = new JLabel();

    // --- FILTRE + DEMANDE VALEUR ---
    private JPanel NORD = new JPanel(new GridLayout(1, 2, 10, 0));
    private JPanel P1 = new JPanel();
    private JPanel P2 = new JPanel();

    private JLabel demande_label = new JLabel();
    private JButton bouton_cap1 = new JButton("Capteur 1");
    private JButton bouton_cap2 = new JButton("Capteur 2");

    private JComboBox<String> filtre_combo = new JComboBox<String>();
    private JLabel filtre_label = new JLabel();

    // --- CONNEXION CAPTEUR ---
    private JPanel SUD = new JPanel();

    private JLabel connect_label1 = new JLabel();
    private JLabel connect_label2 = new JLabel();

    private JLabel connect_label3 = new JLabel();
    private JLabel connect_label4 = new JLabel();

    // --- FENETRE ---
    public Fenetre() {
        setTitle("INTERFACE GRAPHIQUE!!");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(1080, 675);
        // setSize(1400, 875);
        setLocationRelativeTo(null);
        setResizable(false);

        conteneur.setLayout(new BorderLayout());
        conteneur.add(new CurveCanvas(), BorderLayout.CENTER);

        // --- AFFICHAGE VALEURS FILTRÉES ---
        filtre_val_label.setText("ICI VALEURS FILTRÉES");
        EST.add(filtre_val_label);

        // --- TOUTES LES VALEURS ---
        toute_val_label.setText("ICI TOUTES LES VALEURS");
        OUEST.add(toute_val_label);

        // --- PARTIE DEMANDE VALEUR + FILTRAGE ---

        demande_label.setText("Demande de valeur :");
        P1.add(demande_label);
        P1.add(bouton_cap1);
        P1.add(bouton_cap2);

        bouton_cap1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                 * label.setText("Vous avez cliqué sur le bouton numero 1");
                 * conteneur.add(label, BorderLayout.SOUTH); ICI METTRE COMMANDE DEMANDE VALEUR
                 */
            }
        });

        bouton_cap2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                 * label.setText("Vous avez cliqué sur le bouton numero 1");
                 * conteneur.add(label, BorderLayout.SOUTH); ICI METTRE COMMANDE DEMANDE VALEUR
                 */
            }
        });

        filtre_label.setText("Filtrage capteur :");
        filtre_combo.addItem("Aucun");
        filtre_combo.addItem("Capteur 1");
        filtre_combo.addItem("Capteur 2");

        filtre_combo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    /*
                     * label1.setText("Vous avez sélectionné le " + e.getItem());
                     * conteneur.add(label1, BorderLayout.PAGE_END); ICI METTRE COMMANDE FILTRAGE
                     * CAPTEUR
                     */
                }
            }
        });

        P2.add(filtre_label);
        P2.add(filtre_combo);

        NORD.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        NORD.add(P1);
        NORD.add(P2);

        // --- PARTIE CONNEXION CAPTEUR ---
        connect_label1.setText("Capteur 1 :");
        connect_label2.setText("Off");
        connect_label3.setText("Capteur 2 :");
        connect_label4.setText("Off");

        SUD.add(connect_label1);
        SUD.add(connect_label2);
        SUD.add(connect_label3);
        SUD.add(connect_label4);

        

        conteneur.add(NORD, BorderLayout.NORTH);
        conteneur.add(SUD, BorderLayout.SOUTH);
        conteneur.add(OUEST, BorderLayout.WEST);
                     
        conteneur.add(EST, BorderLayout.EAST);
        
        setContentPane(conteneur);
    
    }
}