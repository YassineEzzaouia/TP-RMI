package TP_RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteInterface stub = (RemoteInterface) registry.lookup("RemoteInterface");

            String response = stub.echo("Hello from client");
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
