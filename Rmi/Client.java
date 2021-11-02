import java.io.Serializable;
import java.rmi.*;

public class Client implements Serializable{

    public static void main(String[] args) {
        INTCentral C1 = null;
        int ncapteur = Integer.parseInt(args[0]);
        int nsecondloop = Integer.parseInt(args[1]);

        try{
            CapteurIMPL cpt1 = new CapteurIMPL(ncapteur, "degrés");

            //Connexion au central
            String URL = new String("//localhost/Central");
            System.out.println("Client : lookup server, url = " + URL);
            C1 = (INTCentral)Naming.lookup(URL);
            C1.message("Capteur n°" + cpt1.getId() +" connecté");

            while (true) {
                Data D1 = cpt1.createData();
                C1.addToBdd(D1);

                try{
                    Thread.sleep(nsecondloop);
                }
                catch(InterruptedException e){
                    System.out.println(e);
                } 
            }
        }
        catch (Exception e){
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }
}