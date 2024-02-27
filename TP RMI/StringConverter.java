import java.rmi.*;

public interface StringConverter extends Remote {
    String convertToUpper(String str) throws RemoteException;
}
