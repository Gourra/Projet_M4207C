import java.io.Serializable;
import java.rmi.*;

public class Client implements Serializable{ //implements Serializable pour povoir envoyer les données sur le rzo

    public static void main(String[] args) {
        INTCentral C1 = null; //creer une interface central
        int ncapteur = Integer.parseInt(args[0]); //converti les args en integer
        int nsecondloop = Integer.parseInt(args[1]);

        try{
            CapteurIMPL cpt1 = new CapteurIMPL(ncapteur, "degrés"); //creer un capteur de temperature avec arg passé

            //Connexion au central
            String URL = new String("//localhost/Central"); //Creation de l'url du rmiregistry
            System.out.println("Client : lookup server, url = " + URL); //Debug
            C1 = (INTCentral)Naming.lookup(URL); //recherche dans le rmiregistry

            C1.message("Capteur n°" + cpt1.getId() +" connecté"); //Debug affiche sur le central la connexion

            while (true) { //genere des datas qui seront envoyé au central
                Data D1 = cpt1.createData(); // creer data
                C1.addToBdd(D1); //la donne au central

                try{
                    Thread.sleep(nsecondloop); ////attendre arg s puis continue
                }
                catch(InterruptedException e){//Erreur due au thread.sleep
                    System.out.println(e);
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