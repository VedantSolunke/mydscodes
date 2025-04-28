import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class FactorialServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            FactorialServerImpl server = new FactorialServerImpl();
            Naming.rebind("FactorialServer", server);
            System.out.println("Factorial Server is ready...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
