import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DistanceServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            DistanceServerImpl server = new DistanceServerImpl();
            Naming.rebind("DistanceServer", server);
            System.out.println("Distance Server is ready...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
