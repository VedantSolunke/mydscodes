import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class StringCompareServerImpl extends UnicastRemoteObject implements StringCompareServerInterface {

    StringCompareServerImpl() throws RemoteException {
        super();
    }

    public String findLargerString(String str1, String str2) throws RemoteException {
        System.out.println("Request handled by thread: " + Thread.currentThread().getName());
        if (str1.compareTo(str2) > 0) {
            return str1;
        } else {
            return str2;
        }
    }
}
