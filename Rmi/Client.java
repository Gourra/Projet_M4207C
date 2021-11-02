import java.io.Serializable;
import java.rmi.*;

public class Client implements Serializable{

    public static void main(String[] args) {
        INTCentral C1 = null;

        try{
            Capteur cpt1 = new Capteur(1, "degrés");


            //Connexion au server
            String URL = new String("//localhost/Central");
            System.out.println("Client : lookup server, url = " + URL);
            C1 = (INTCentral)Naming.lookup(URL);
            C1.message("Capteur n°" + cpt1.getId() +" connecté");

            
            Data D1 = cpt1.createData();
            C1.addToBdd(D1);
            

        }
        catch (Exception e){
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }
}