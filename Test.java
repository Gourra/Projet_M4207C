class Test{

    public static void main(String[] args){
        // initialisation des objets
        Central C1 = new Central(1);
        Terminal T1 = new Terminal(1);
        Data D1 = new Data("21/10/2021", 1, 12, "Degrés"); //Dans le futur creer dans capteurs 
        
        C1.addToBdd(D1); //Ajout de la donnée D1 a la bdd du central
        T1.getBddData(C1); //Transfers de la bbd central vers bddlocal du terminal
        T1.print(); //Affichage de la bddlocale
    }

}
