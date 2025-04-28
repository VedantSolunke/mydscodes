import java.rmi.Naming;
import java.util.Scanner;

public class VowelClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            VowelServerInterface server = (VowelServerInterface) Naming.lookup("rmi://localhost/VowelServer");

            System.out.print("Enter a word: ");
            String word = sc.nextLine();

            int vowelCount = server.countVowels(word);
            System.out.println("Number of vowels in \"" + word + "\" is: " + vowelCount);

            sc.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
