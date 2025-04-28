import java.rmi.Naming;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            EchoServerInterface server = (EchoServerInterface) Naming.lookup("rmi://localhost/EchoServer");

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            String response = server.sayHello(name);
            System.out.println(response);

            sc.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
