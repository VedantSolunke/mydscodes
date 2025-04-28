import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DistanceServerInterface extends Remote {
    double convertMilesToKilometers(double miles) throws RemoteException;
}
