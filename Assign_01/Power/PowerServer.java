import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class PowerServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            PowerServerImpl server = new PowerServerImpl();
            Naming.rebind("PowerServer", server);
            System.out.println("Power Server is ready...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
