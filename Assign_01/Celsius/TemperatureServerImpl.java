import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class TemperatureServerImpl extends UnicastRemoteObject implements TemperatureServerInterface {

    TemperatureServerImpl() throws RemoteException {
        super();
    }

    public double convertCelsiusToFahrenheit(double celsius) throws RemoteException {
        System.out.println("Request handled by thread: " + Thread.currentThread().getName());
        return (celsius * 9 / 5) + 32;
    }
}
