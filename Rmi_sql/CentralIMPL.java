import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.sql.*;

public class CentralIMPL extends UnicastRemoteObject implements INTCentral{
    //Attributs
    ArrayList<Data> bdd = null; 

    //Constructeur
    CentralIMPL() throws java.rmi.RemoteException{
        this.bdd = new ArrayList<Data>(); //Initiation de la base de donnée
    }

    //méthodes
    public ArrayList<Data> getBdd() throws java.rmi.RemoteException {return bdd;} // Retourne sa base de donnée
    public void addToBdd(Data data) throws java.rmi.RemoteException{ //Ajoute une valeur a sa base de donnée
        bdd.add(data);
        //System.out.println("[Server-log] : (New data) " + data.printToString()); //Debug
    }

    public void message(String mess) throws java.rmi.RemoteException { //Afficher message [Server] :
        System.out.println("[Server] : " + mess);
    }

    public void addSql(Data data) throws java.rmi.RemoteException{ //modifie une base de donnée au format .db pour compatibilité avec logiciel tiers

        // décomposiotion pour fabriquer la requete sql
        String date = data.getDate();
        int ncpt = data.getIdCapteur();
        int val = data.getValeur();
        String unite = data.getUnite();

        //initialisation des interfaces pour lier la base sql et envoyer requete
        Connection sqlDB = null;
        Statement stmt = null;

        try {
            // connexion à la base de donnee
            Class.forName("org.sqlite.JDBC");
            sqlDB = DriverManager.getConnection("jdbc:sqlite:database.db");
            sqlDB.setAutoCommit(false);
            //System.out.println("opened database success"); //debug

            //creation de la requete
            stmt = sqlDB.createStatement();
            String insert = "INSERT INTO VALEURS (DATECPT,NCPT,VAL,UNITE) VALUES (" + "'" + date + "'" + ", " + ncpt + ", " + val + ", " + "'" + unite + "'" +" ); ";
            //System.out.println("[REQUEST] " + insert ); //debug
            stmt.executeUpdate(insert);

            stmt.close();
            sqlDB.commit(); //envoy la requete
            sqlDB.close(); //fermeture connexion
            //System.out.println(" success"); //debug
        } 
        
        catch (Exception e) {
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
