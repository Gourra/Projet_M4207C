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

    

    ArrayList<Object> cap2 = new ArrayList<Object>();
    ArrayList<Integer> cap2_x = new ArrayList<Integer>();
    ArrayList<Integer> cap2_y = new ArrayList<Integer>();

    

    public void liste() {
        principal princi = new principal();
        

        //ArrayList<Object> cap1 = new ArrayList<Object>();
        //ArrayList<Integer> cap1_x = new ArrayList<Integer>();
        //ArrayList<Integer> cap1_y = new ArrayList<Integer>();
        
        
        String liste1 = String.format("%-2s %-10s %-20s %-5s %-20s", 1, "l'heure", "Capteur n°1", 5, "Degré(s)");
        String liste2 = String.format("%-2s %-10s %-20s %-5s %-20s", 2, "l'heure", "Capteur n°1", 10, "Degré(s)");
        String liste3 = String.format("%-2s %-10s %-20s %-5s %-20s", 3, "l'heure", "Capteur n°1", 15, "Degré(s)");
        String liste4 = String.format("%-2s %-10s %-20s %-5s %-20s", 4, "l'heure", "Capteur n°1", 20, "Degré(s)");
        String liste5 = String.format("%-2s %-10s %-20s %-5s %-20s", 5, "l'heure", "Capteur n°1", 25, "Degré(s)");
        
        
        //cap1.add(liste1);
        princi.cap1_x(10);
        princi.cap1_y(5);
        //cap1.add(liste2);
        princi.cap1_x(20);
        princi.cap1_y(15);
        //cap1.add(liste3);
        princi.cap1_x(30);
        princi.cap1_y(10);
        //cap1.add(liste4);
        princi.cap1_x(40);
        princi.cap1_y(25);
        //cap1.add(liste5);
        princi.cap1_x(50);
        princi.cap1_y(35);

        /*for (Object str : cap1) {

            System.out.println(str); // Cette ligne permet d'afficher la Arraylist sans les crochets.
        }*/

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

    public Object cap1_y;
    ArrayList<Integer> def_cap1_y = new ArrayList<Integer>();
    public boolean cap1_y( int y ) {
        def_cap1_y_copie.add(y);
        return def_cap1_y.add( y );
    }

    public Object cap1_x;
    ArrayList<Integer> def_cap1_x = new ArrayList<Integer>();
    public boolean cap1_x( int x ) {
        def_cap1_x_copie.add(x);
        return def_cap1_x.add( x );
    }

    
    //Arraylist<Integer> def_cap1_x_copie =  new ArrayList<Integer>();
    public ArrayList<Integer> def_cap1_x_copie = new ArrayList<Integer>();
    public Integer getList1x( int pos ) {
        //boolean x = cap1_x(pos);
        //def_cap1_x_copie.add(x);
        return def_cap1_x_copie.get(pos);
    }

 
    public ArrayList<Integer> def_cap1_y_copie = new ArrayList<Integer>();
    public Integer getList1y( int pos ) {
        //boolean y = cap1_y(pos);
        //def_cap1_y_copie.add(y);
        return def_cap1_y_copie.get(pos);
    }

    public Integer taille1 (){
        int taille = def_cap1_y.size();
        return taille;
    }

    /*ArrayList<Object> def_cap1 = new ArrayList<Object>();
    public Integer cap1( int pos ) {
        return def_cap1.get( pos );
    }*/

    ArrayList<Integer> def_cap2_y = new ArrayList<Integer>();
    public Integer cap2_y( int pos ) {
        return def_cap2_y.get( pos );
    }

    ArrayList<Integer> def_cap2_x = new ArrayList<Integer>();
    public Integer cap2_x( int pos ) {
        return def_cap2_x.get( pos );
    }

    /*ArrayList<Object> def_cap2 = new ArrayList<Object>();
    public Integer cap2( int pos ) {
        return def_cap2.get( pos );
    }*/

    public static void main(String[] args) {
        Fenetre mafenetre = new Fenetre();
        mafenetre.setVisible(true);
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
    private JPanel NORD = new JPanel( new GridLayout(1,2,10,0) );
    private JPanel P1 = new JPanel();
    private JPanel P2 = new JPanel();

    private JLabel demande_label = new JLabel();
    private JButton bouton_cap1 = new JButton("Capteur 1");
    private JButton bouton_cap2 = new JButton("Capteur 2");

    private JComboBox<String> filtre_combo = new JComboBox<String>();
    private JLabel filtre_label = new JLabel();


    // --- CONNEXION CAPTEUR ---
    private JPanel SUD1 = new JPanel(  );
    private JPanel SUD2 = new JPanel(  );
    private JPanel SUD = new JPanel(  );

    private JLabel connect_label1 = new JLabel();
    private JLabel connect_label2 = new JLabel();
    private JLabel connect_label3 = new JLabel();
    private JLabel connect_label4 = new JLabel();



    // --- FENETRE ---
    public Fenetre() {
        setTitle("TABLEAU DE BORD GRAPHIQUE");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
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
    
    }
}