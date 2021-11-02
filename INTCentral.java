import java.util.ArrayList;

public interface INTCentral extends java.rmi.Remote {
    ArrayList<Data> getBdd() throws java.rmi.RemoteException;
    void addToBdd(Data data) throws java.rmi.RemoteException;
}
