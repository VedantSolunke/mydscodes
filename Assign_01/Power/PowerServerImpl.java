import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class PowerServerImpl extends UnicastRemoteObject implements PowerServerInterface {

    PowerServerImpl() throws RemoteException {
        super();
    }

    public double calculatePower(int exponent) throws RemoteException {
        System.out.println("Request handled by thread: " + Thread.currentThread().getName());
        return Math.pow(2, exponent);
    }
}
