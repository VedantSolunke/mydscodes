// Server.java

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Start RMI registry on port 1099

            ServerImp server = new ServerImp();
            Naming.bind("MyServer", server);

            System.out.println("Server is Started .................");

        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
