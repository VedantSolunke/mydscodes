import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FactorialServerInterface extends Remote {
    long findFactorial(int number) throws RemoteException;
}
