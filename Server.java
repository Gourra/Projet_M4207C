import java.rmi.*;

public class Server {
    public static void main(String[] args) {
    
        try{
            CentralIMPL C1 = new CentralIMPL();
            System.out.println("[SERVER] : Central crée");

            Naming.rebind("Central", C1);
            System.out.println("[SERVER] : Central enregistré dans le RMI-registry");

            System.out.println("[SERVER] : Ready");
        }
        catch (Exception e){
            System.out.println("[SERVER] : Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }
    
}
