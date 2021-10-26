import java.util.*;

public class nouveau_capteur {
    public static void main(String[] args) {
        int numero_capteur;
        Scanner sca = new Scanner(System.in);
        boolean ajout_capteur = false;

        while (!ajout_capteur) {
            System.out.println( "Quel type de données renvoie le capteur ? ");
            System.out.println( "1. Des pourcentages ? ");
            System.out.println( "2. Des entiers ? ");
            System.out.println( "3. Des réels ? ");
            System.out.println(" Pour annuler l'action taper 0 ! ");
            numero_capteur = sca.nextInt();
            if ( numero_capteur == 0 ) {
                ajout_capteur = true;
            }

            else if ( numero_capteur == 1 ) {
                // System.out.println( "L'unité ? ");
                // Là on refait une boucle et même principe que l'ajout de valeur
                // On appelle la fonction adéquate avec les attributs :
                // cap.ajout_pourcen( numero_capteur ; unité ); unité est une variable
                ajout_capteur = true;
            }

            else if ( numero_capteur == 2 ) {
                // System.out.println( "L'unité ? ");
                // Là on refait une boucle et même principe que l'ajout de valeur
                // On appelle la fonction adéquate avec les attributs :
                // cap.ajout_capteur( numero_capteur ; unité ); unité est une variable
                ajout_capteur = true;
            }

            else if ( numero_capteur == 3 ) {
                // System.out.println( "L'unité ? ");
                // Là on refait une boucle et même principe que l'ajout de valeur
                // On appelle la fonction adéquate avec les attributs :
                // cap.ajout_capteur( numero_capteur ; unité ); unité est une variable
                ajout_capteur = true;
            }

            else {
                System.out.println( "Votre choix ne peut être pris en compte, veuillez recommencer ! ");
            }
    }
}


// public class ajout_capteur{
    
    // public ajout_pourcen(numéro ; unité){
        //...
    //}

    // public ajout_entier(numéro ; unité){
        //...
    //}

    // public ajout_réel(numéro ; unité){
        //...
    //}

// }