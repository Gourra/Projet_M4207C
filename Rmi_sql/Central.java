import java.util.ArrayList;
import java.sql.*;

class Central{
    //Attributs
    ArrayList<Data> bdd;
    ArrayList<Data> toReturn;

    //Contructeur
    public Central(){
        this.bdd = new ArrayList<Data>(); //Initiation de la base de donnée
        this.toReturn = new ArrayList<Data>();
    }

    //Méthodes d'accès
    public ArrayList<Data> getBdd() {return bdd;}
    public ArrayList<Data> getToReturn() {return toReturn;}
    public void addToBdd(Data data){
        bdd.add(data);
    }

    public void addSql(Data data){ //modifie une base de donnée au format .db pour compatibilité avec logiciel tiers

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

    public void getSqlfull(){

        ArrayList<Data> toReturn2 = new ArrayList<Data>();
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
                
                toReturn2.add((new Data(date, idcapt, val, unite)));
                //System.out.println(date + "  -  capteur n°" + idcapt + "  -  " + val + " " + unite );
            }

            rs.close();
            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        toReturn = toReturn2;
    }

    public void getSqlfilter(int ncapt){

        ArrayList<Data> toReturn2 = new ArrayList<Data>();
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully"); //debug

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM VALEURS WHERE ncpt="+ncapt+";" );
            
            while ( rs.next() ) {
                int idcapt = rs.getInt("ncpt");
                String  date = rs.getString("datecpt");
                int val  = rs.getInt("val");
                String  unite = rs.getString("unite");
                
                toReturn2.add((new Data(date, idcapt, val, unite)));
                //System.out.println(date + "  -  capteur n°" + idcapt + "  -  " + val + " " + unite );
            }

            rs.close();
            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        toReturn = toReturn2;
    }

}  
