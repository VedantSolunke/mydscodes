import java.rmi.Naming;
import java.util.Scanner;

public class StringCompareClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            StringCompareServerInterface server = (StringCompareServerInterface) Naming
                    .lookup("rmi://localhost/StringCompareServer");

            System.out.print("Enter first string: ");
            String str1 = sc.nextLine();

            System.out.print("Enter second string: ");
            String str2 = sc.nextLine();

            String largerString = server.findLargerString(str1, str2);
            System.out.println("Lexicographically larger string is: " + largerString);

            sc.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
