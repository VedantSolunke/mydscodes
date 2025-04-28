
// ServerImp.java

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ServerImp extends UnicastRemoteObject implements ServerInterf {

    ServerImp() throws RemoteException {
        super();
    }

    public double addition(double a, double b) throws RemoteException {
        System.out.println("Request handled by thread : " + Thread.currentThread().getName());
        return a + b;
    }

    public double substraction(double a, double b) throws RemoteException {
        System.out.println("Request handled by thread : " + Thread.currentThread().getName());
        return a - b;
    }

    public double multiplication(double a, double b) throws RemoteException {
        System.out.println("Request handled by thread : " + Thread.currentThread().getName());
        return a * b;
    }

    public double division(double a, double b) throws RemoteException {
        System.out.println("Request handled by thread : " + Thread.currentThread().getName());
        if (b == 0) {
            System.out.println("Division by zero is not allowed");
            return 0;
        } else {
            return a / b;
        }
    }
}
