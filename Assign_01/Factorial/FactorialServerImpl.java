import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class FactorialServerImpl extends UnicastRemoteObject implements FactorialServerInterface {

    FactorialServerImpl() throws RemoteException {
        super();
    }

    public long findFactorial(int number) throws RemoteException {
        System.out.println("Request handled by thread: " + Thread.currentThread().getName());
        if (number < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
