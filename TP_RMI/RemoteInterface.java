package TP_RMI;
import java.rmi.*;

public interface RemoteInterface extends Remote {
    String echo(String message) throws RemoteException;
}
