import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VowelServerInterface extends Remote {
    int countVowels(String word) throws RemoteException;
}
