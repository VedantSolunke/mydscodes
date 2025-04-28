import java.rmi.Naming;
import java.util.Scanner;

public class FactorialClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            FactorialServerInterface server = (FactorialServerInterface) Naming
                    .lookup("rmi://localhost/FactorialServer");

            System.out.print("Enter a number to find its factorial: ");
            int number = sc.nextInt();

            long factorial = server.findFactorial(number);
            System.out.println("Factorial of " + number + " is: " + factorial);

            sc.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
