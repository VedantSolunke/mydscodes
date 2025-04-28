import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TemperatureServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Start RMI registry on port 1099
            TemperatureServerImpl server = new TemperatureServerImpl();
            Naming.rebind("TemperatureServer", server);
            System.out.println("Temperature Server is ready...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
