
// ServerImp.java

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ServerImp extends UnicastRemoteObject implements ServerInterf {

    ServerImp() throws RemoteException {

    }

    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }

    public double substraction(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    public double division(double a, double b) throws RemoteException {
        if (b == 0) {
            System.out.println("Division by zero is not allowed");
            return 0;
        } else {
            return a / b;
        }
    }
}
