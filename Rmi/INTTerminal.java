import java.util.ArrayList;

public interface INTTerminal {
    int getId();
    ArrayList<Data> getLocalBdd();
    void print();
    void getBddData(Central central);
}
