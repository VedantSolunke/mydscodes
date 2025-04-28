import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class VowelServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            VowelServerImpl server = new VowelServerImpl();
            Naming.rebind("VowelServer", server);
            System.out.println("Vowel Server is ready...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
