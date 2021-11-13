import java.util.ArrayList;

public interface INTTerminal { //Interface qui liste toutes les foncntions
    int getId();
    ArrayList<Data> getLocalBdd();
    void print();
    void getBddData(Central central);
}
