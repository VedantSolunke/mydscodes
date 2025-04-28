
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TemperatureServerInterface extends Remote {
    double convertCelsiusToFahrenheit(double celsius) throws RemoteException;
}
