import java.util.ArrayList;

public interface INTTerminal { //Interface qui liste toutes les foncntions
    int getId();
    ArrayList<Data> getLocalBdd();
    void print();
    void getBddData(Central central);
    void getSqlfull(Central central);
    void getSqlfilter(Central central, int ncapt);
    void getSqlreq(Central central, String req);
}
