package TP_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServer implements RemoteInterface {
    public RemoteServer() {}

    @Override
    public String echo(String message) throws RemoteException {
        return "Server Echo: " + message;
    }

    public static void main(String[] args) {
        try {
            RemoteServer server = new RemoteServer();
            RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteInterface", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
