import java.util.ArrayList;
import java.sql.*;

class Terminal{
    //Attributs
    int id;
    ArrayList<Data> localbdd;

    //constructeur
    public Terminal(int n){
        id = n; //initialisation du n°id
        this.localbdd = new ArrayList<Data>(); //Initialisation de la local bdd
    }

    //Méthodes d'acces
    public int getId(){return id;}
    public ArrayList<Data> getLocalBdd(){return localbdd;}

    //###################################
    //          METHODES
    //###################################

    //Afficher les valeurs de la bdd locale
    public void print(){

        System.out.println("---------------------------");
        System.out.println("Récupération avec Arraylist");
        System.out.println("---------------------------");
        System.out.println(" ");
        
        for(int i = 0; i < localbdd.size(); i++){
            localbdd.get(i).print();
        }
    }

    //Requète de recupération de bdd du central
    public void getBddData(Central central){
        localbdd = central.getBdd();
    }

    public void readBddSQL(){

        System.out.println("---------------------");
        System.out.println("Récupération avec SQL");
        System.out.println("---------------------");
        System.out.println(" ");

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully"); //debug

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM VALEURS;" );
            
            while ( rs.next() ) {
                int idcapt = rs.getInt("ncpt");
                String  date = rs.getString("datecpt");
                int val  = rs.getInt("val");
                String  unite = rs.getString("unite");
                
                System.out.println(date + "  -  capteur n°" + idcapt + "  -  " + val + " " + unite );
            }

            rs.close();
            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
