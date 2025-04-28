import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class EchoServerImpl extends UnicastRemoteObject implements EchoServerInterface {

    EchoServerImpl() throws RemoteException {
        super();
    }

    public String sayHello(String name) throws RemoteException {
        System.out.println("Request handled by thread: " + Thread.currentThread().getName());
        return "Hello " + name;
    }
}
