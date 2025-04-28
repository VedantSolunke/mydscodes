import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class StringCompareServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            StringCompareServerImpl server = new StringCompareServerImpl();
            Naming.rebind("StringCompareServer", server);
            System.out.println("String Compare Server is ready...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
