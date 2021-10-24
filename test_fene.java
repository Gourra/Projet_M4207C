import java.util.*;
import java.text.DateFormat;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JLabel;

public class test_fene {
    public static void main(String[] args) {

        // Tout ce qui suit est la génération d'une données de capteur, c'est temporaire
        // \\
        // ############################ \\
        // DÉBUT DES DONNÉES DE CAPTEUR \\
        // ############################ \\
        ArrayList<Object> val = new ArrayList<Object>();

        Date aujourdhui = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        int n;
        String v = "";
        n = (int) (Math.random() * 50);
        v = v + n;

        String liste = String.format("%-20s %-20s %-5s %-20s", shortDateFormat.format(aujourdhui), "Capteur n°1", v,
                "Degré(s)");
        val.add(liste);

        // ########################## \\
        // FIN DES DONNÉES DE CAPTEUR \\
        // ########################## \\

        // on crée une fenêtre dont le titre est "Hello World!"
        JFrame frame = new JFrame("Hello World!");
        // la fenêtre doit se fermer quand on clique sur la croix rouge
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // on ajoute le texte "Hello, World!" dans la fenêtre
        int i = 99990000;
        for (Object str : val) {
            String S = "<html><span>valeur: \n" + str + "</span>\n<br/>" + "<span>valeur2: \n" + str + "</span><br/>"
                    + i + "</html>"; // On met du code html pour définir ce que l'on veut (je l'utilise surtout pour
            // les sauts de ligne)
            frame.getContentPane().add(new JLabel(S)); // On affiche donc la variable S qui contient le code html
        }
        // on demande d'attribuer une taille minimale à la fenêtre
        // (juste assez pu r voir tous les composants)
        frame.setSize(1080, 720);
        // on centre la fenêtre
        frame.setLocationRelativeTo(null);
        // on rend la fenêtre visible
        frame.setVisible(true);
    }
}