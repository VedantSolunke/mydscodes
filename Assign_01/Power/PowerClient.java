import java.rmi.Naming;
import java.util.Scanner;

public class PowerClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            PowerServerInterface server = (PowerServerInterface) Naming.lookup("rmi://localhost/PowerServer");

            System.out.print("Enter exponent for 2^exponent: ");
            int exponent = sc.nextInt();

            double result = server.calculatePower(exponent);
            System.out.println("2 raised to the power " + exponent + " is: " + result);

            sc.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
