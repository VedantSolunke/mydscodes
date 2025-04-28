import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EchoServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            EchoServerImpl server = new EchoServerImpl();
            Naming.rebind("EchoServer", server);
            System.out.println("Echo Server is ready...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
