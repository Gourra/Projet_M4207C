import java.util.*;

public class nouvelle_valeur {
    public static void main(String[] args) {
        int numero_capteur;
        Scanner sca = new Scanner(System.in);
        boolean ajout_valeur = false;

        while (!ajout_valeur) {
            System.out.println( "De quel capteur souhaitez-vous une nouvelle valeur? ");
            System.out.println("Pour annuler l'action taper 0 ! ");
            numero_capteur = sca.nextInt();
            if ( numero_capteur == 0 ) {
                ajout_valeur = true;
            }

            else {
                // Faire la fonction 
                // Exemple précédent
                // cap.chiant( numero_capteur ); <-- on fait le processus d'appel de nouvelle valeur avec le 
                // numero de capteur rentré...
                // ⚠️ attention surt le processus de fabrication de valeur mettre des if pour chaque capteur pour qu'il puisse 
                // se reperer en fonction de si le capteur est en pourcentage, en entier, en réel, ...
            }
        }
    }
}
