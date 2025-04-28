
// ServerInterf.java
import java.rmi.*;

public interface ServerInterf extends Remote {
    public double addition(double a, double b) throws RemoteException;

    public double substraction(double a, double b) throws RemoteException;

    public double multiplication(double a, double b) throws RemoteException;

    public double division(double a, double b) throws RemoteException;

}