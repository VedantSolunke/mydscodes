import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class VowelServerImpl extends UnicastRemoteObject implements VowelServerInterface {

    VowelServerImpl() throws RemoteException {
        super();
    }

    public int countVowels(String word) throws RemoteException {
        System.out.println("Request handled by thread: " + Thread.currentThread().getName());
        int count = 0;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}
