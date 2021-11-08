import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class tableau_bord{

    public static void main(String[] args){
        boolean boucle = false;
        Scanner sca = new Scanner(System.in);
        
        
        while( !boucle ){
            System.out.println("\n----------------------------------------------------------------\n");
            System.out.println("\nVoici ce que vous pouvez faire :");
            System.out.println("1. Demande de nouvelle valeur");
            System.out.println("2. Filtrage par capteur");
            System.out.println("S. Sortir");
            System.out.println("T. Tout éteindre");
            System.out.println("\n----------------------------------------------------------------\n");

            System.out.println("Votre réponse :");
            char reponse = sca.next().charAt(0);;

           

            if ( reponse == '1' ){
                demande();
            }

            else if ( reponse == '2' ){
                filtre();
            }

            else if ( reponse == 'S' ){
                System.out.println("\nFin");
                boucle = true;
            }

            else if ( reponse == 'T' ){
                System.out.println("\nExtinction des feux");
                boucle = true;
            }
        }
    }

    public static void demande(){
        Scanner sca = new Scanner(System.in);

        boolean boucle_demande = false;
        while( !boucle_demande ){
            System.out.println("\n----------------------------------------------------------------\n");
            System.out.println("\nVoici ce que vous pouvez faire :");
            System.out.println("1. Capteur 1");
            System.out.println("2. Capteur 2");
            System.out.println("S. Revenir en arrière");
            System.out.println("\n----------------------------------------------------------------\n");

            System.out.println("Votre réponse :");
            char reponse_demande = sca.next().charAt(0);

            if ( reponse_demande == '1' ){
                //demande(); // Commande nouvelle valeur capteur 1
                boucle_demande = true;
            }

            else if ( reponse_demande == '2' ){
                //demande(); // Commande nouvelle valeur capteur 2
                boucle_demande = true;
            }

            else if ( reponse_demande == 'S' ){
                boucle_demande = true;
            }

            
        }
    }

    public static void filtre(){
        Scanner sca = new Scanner(System.in);
        

        boolean boucle_filtre = false;
        while( !boucle_filtre ){
            System.out.println("\n----------------------------------------------------------------\n");
            System.out.println("\nVoici ce que vous pouvez faire :");
            System.out.println("1. Capteur 1");
            System.out.println("2. Capteur 2");
            System.out.println("S. Revenir en arrière");
            System.out.println("\n----------------------------------------------------------------\n");

            System.out.println("Votre réponse :");
            char reponse_filtre = sca.next().charAt(0);

            if ( reponse_filtre == '1' ){
                // demande(); // Commande filtre Capteur 1
                boucle_filtre = true;
            }

            else if ( reponse_filtre == '2' ){
                // demande(); // Commande filtre Capteur 2
                boucle_filtre = true;
            }

            else if ( reponse_filtre == 'S' ){
                boucle_filtre = true;
            }

            
        }
    }

    
}
