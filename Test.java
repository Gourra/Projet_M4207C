class Test{

    public static void main(String[] args){
        Central C1 = new Central(1);
        Terminal T1 = new Terminal(1);
        Data D1 = new Data("21/10/2021", 1, 12, "Degrés");
        C1.addToBdd(D1);
        T1.getBddData(C1);
        T1.print(); 
    }

}