import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class DistanceServerImpl extends UnicastRemoteObject implements DistanceServerInterface {

    DistanceServerImpl() throws RemoteException {
        super();
    }

    public double convertMilesToKilometers(double miles) throws RemoteException {
        System.out.println("Request handled by thread: " + Thread.currentThread().getName());
        return miles * 1.60934;
    }
}
