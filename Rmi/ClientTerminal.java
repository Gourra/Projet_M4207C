import java.rmi.*;

public class ClientTerminal{

    public static void main(String[] args) {
        INTCentral C1 = null;
        int nterm = Integer.parseInt(args[0]);

        try{
            TerminalIMPL T1 = new TerminalIMPL(nterm);

            //Connexion au central
            String URL = new String("//localhost/Central");
            System.out.println("Client : lookup server, url = " + URL);
            C1 = (INTCentral)Naming.lookup(URL);
            C1.message("Termianl n°" + T1.getId() +" connecté");

            while (true) {
                System.out.println("----------------------------------------");
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                T1.getBddData(C1);
                T1.print();

                try{
                    Thread.sleep(10000);
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