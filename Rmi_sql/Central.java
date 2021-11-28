import java.util.ArrayList;
import java.sql.*;

class Central{
    //Attributs
    ArrayList<Data> bdd;
    ArrayList<Data> toReturn;

    //Contructeur
    public Central(){
        this.bdd = new ArrayList<Data>(); //Initiation de la base de donnée
        this.toReturn = new ArrayList<Data>(); //Arraylist qui sera envoyé aux terminaux
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

    public void getSqlfull(){ //méthode qui renvoie l'intégralité de la bdd avec sql

        //initialisation
        ArrayList<Data> toReturn2 = new ArrayList<Data>();
        Connection c = null;
        Statement stmt = null;

        try {
            //connection BDD
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully"); //debug
            
            //creation de la requete
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM VALEURS;" );
            
            while ( rs.next() ) { //recuperation dans la bdd
                int idcapt = rs.getInt("ncpt");
                String  date = rs.getString("datecpt");
                int val  = rs.getInt("val");
                String  unite = rs.getString("unite");
                
                toReturn2.add((new Data(date, idcapt, val, unite))); //stockage dans l'arraylist a return
                //System.out.println(date + "  -  capteur n°" + idcapt + "  -  " + val + " " + unite );
            }
            
            //fermeture de connextion
            rs.close();
            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        toReturn = toReturn2; //actualisation de l'arraylist
    }

    public void getSqlfilter(int ncapt){ //filtre les valeurs pour un capteur particulier
        
        //initialisation
        ArrayList<Data> toReturn2 = new ArrayList<Data>();
        Connection c = null;
        Statement stmt = null;

        try {
            //conection a la BDD
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully"); //debug
            
            //creation de la requete
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM VALEURS WHERE ncpt="+ncapt+";" );
            
            while ( rs.next() ) { //recuperation dans la bdd
                int idcapt = rs.getInt("ncpt");
                String  date = rs.getString("datecpt");
                int val  = rs.getInt("val");
                String  unite = rs.getString("unite");
                
                toReturn2.add((new Data(date, idcapt, val, unite))); //stockage dans l'arraylist a return
                //System.out.println(date + "  -  capteur n°" + idcapt + "  -  " + val + " " + unite );
            }
            
            //fermeture de connection
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

    public void getSqlreq(String req){ //execute une requète sql ATTENTION potentielle faille de sécurité

        ArrayList<Data> toReturn2 = new ArrayList<Data>();
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully"); //debug

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( req );
            
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

    public void getSqlDate(String req){ //filtre sur une date 

        ArrayList<Data> toReturn2 = new ArrayList<Data>();
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully"); //debug

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM VALEURS WHERE DATECPT LIKE '%" +req+"%';" );
            
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
