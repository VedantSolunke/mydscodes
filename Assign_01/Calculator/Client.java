
import java.rmi.*;
import java.util.Scanner;

// Client.java
public class Client {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);

            String serverURL = "rmi://localhost/MyServer";
            ServerInterf server = (ServerInterf) Naming.lookup(serverURL);

            System.out.println("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.println("Enter second number: ");
            double num2 = sc.nextDouble();

            System.out.println("First number is: " + num1);
            System.out.println("Second number is: " + num2);

            System.out.println("-------- Results ---------");

            System.out.println("Addition: " + server.addition(num1, num2));
            System.out.println("Subtraction: " + server.substraction(num1, num2));
            System.out.println("Multiplication: " + server.multiplication(num1, num2));
            System.out.println("Division: " + server.division(num1, num2));

            sc.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
