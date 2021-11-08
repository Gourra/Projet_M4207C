import java.rmi.*;

public class Server {
    public static void main(String[] args) {
    
        try{
            CentralIMPL C1 = new CentralIMPL(); //Creer un Central RMI
            System.out.println("[SERVER] : Central crée"); //Debug

            Naming.rebind("Central", C1); //Lie le central cree au registry
            System.out.println("[SERVER] : Central enregistré dans le RMI-registry"); //Debug

            System.out.println("[SERVER] : Ready"); //Debug final
        }
        catch (Exception e){ //Si erreur afficher l'erreur
            System.out.println("[SERVER] : Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }
    
}
