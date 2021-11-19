import java.rmi.*;
import java.util.Scanner;

public class ClientTerminal{

    public static void main(String[] args) {
        INTCentral C1 = null; //Creer une interface central
        int nterm = Integer.parseInt(args[0]); //converti les argument en int (n° du terminal)
        

        try{
            TerminalIMPL T1 = new TerminalIMPL(nterm); //Creer un Terminal RMI

            //Connexion au central
            String URL = new String("//localhost/Central"); //Creation de l'url du rmiregistry
            System.out.println("Client : lookup server, url = " + URL); //Debug
            C1 = (INTCentral)Naming.lookup(URL); //recherche dans le rmiregistry
            Fenetre fen = new Fenetre();
        
            fen.Fentre();

            C1.message("Termianl n°" + T1.getId() +" connecté"); //Debug affiche sur le central la connexion

            // while (true) { // Récupère et affiche les valeurs
            //     System.out.println("----------------------------------------");
            //     //System.out.print("\033[H\033[2J");
            //     //System.out.flush(); 
            //     T1.getBddData(C1); //recupere la bdd du central
            //     T1.print(); //Affiche ses valeurs

            //     try{
            //         Thread.sleep(10000); //attendre 10s puis continue
            //     }
            //     catch(InterruptedException e){ //Erreur due au thread.sleep
            //         System.out.println(e);
            //     } 
            // }
            Scanner clavier = new Scanner(System.in);
            
            while (true) {
                String choix = null;
                String choix2 = null;

                System.out.println("------------------------------------------------");
                System.out.println("[1]Récupérer la base de donnée");
                System.out.println("[2]Récupérer les donées d'un capteur spécifique");
                System.out.println("[ctrl+c] pour quitter");
                choix = clavier.next(); 

                switch (choix) {
                    case "1":
                        T1.getSqlfull(C1);
                        T1.print(); 
                        break;

                    case "2":
                        System.out.println("------------------------------------------------");
                        System.out.println("ex: #1");
                        System.out.println("Entrez un numéro de capteur :");
                        choix2 = clavier.next();
                        int parsechoix = Integer.parseInt(choix2);
                        T1.getSqlfilter(C1, parsechoix);
                        T1.print();
                        break;
                    default:
                        System.out.println("Pas de choix disponible crtl+c pour quitter");
                        break;
                }    
            }
        }
        catch (Exception e){ //Si erreur afficher l'erreur
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }
}