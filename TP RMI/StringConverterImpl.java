import java.rmi.*;
import java.rmi.server.*;

public class StringConverterImpl extends UnicastRemoteObject implements StringConverter {
    protected StringConverterImpl() throws RemoteException {
        super();
    }

    public String convertToUpper(String str) throws RemoteException {
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        try {
            StringConverterImpl obj = new StringConverterImpl();
            Naming.rebind("//localhost/StringConverter", obj);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
