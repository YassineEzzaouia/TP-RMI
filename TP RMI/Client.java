package TP RMI;
import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            StringConverter obj = (StringConverter) Naming.lookup("//localhost/StringConverter");
            String result = obj.convertToUpper("hello, world!");
            System.out.println("Result from server: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
