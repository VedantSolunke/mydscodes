import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringCompareServerInterface extends Remote {
    String findLargerString(String str1, String str2) throws RemoteException;
}
