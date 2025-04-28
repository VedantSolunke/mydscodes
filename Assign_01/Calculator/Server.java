// Server.java

import java.rmi.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerImp server = new ServerImp();
            Naming.bind("MyServer", server);

            System.out.println("Server is Started .................");

        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
