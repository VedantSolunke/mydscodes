import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoServerInterface extends Remote {
    String sayHello(String name) throws RemoteException;
}
