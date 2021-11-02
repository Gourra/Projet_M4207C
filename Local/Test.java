class Test{

    public static void main(String[] args){
        // initialisation des objets
        Central C1 = new Central();
        Terminal T1 = new Terminal(1);
        Capteur cpt1 = new Capteur(1,"degres");
        Capteur cpt2 = new Capteur(2, "Lumens");

        for(int i=0; i<20; i++){
            C1.addToBdd(cpt1.createData());
            C1.addToBdd(cpt2.createData());
        }

        //C1.addToBdd(cpt1.createData()); //Ajout de la donnée D1 a la bdd du central
        T1.getBddData(C1); //Transfers de la bbd central vers bddlocal du terminal
        T1.print(); //Affichage de la bddlocale
    }

}
