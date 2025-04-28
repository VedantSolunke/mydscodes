import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PowerServerInterface extends Remote {
    double calculatePower(int exponent) throws RemoteException;
}
