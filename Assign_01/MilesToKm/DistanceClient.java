import java.rmi.Naming;
import java.util.Scanner;

public class DistanceClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            DistanceServerInterface server = (DistanceServerInterface) Naming.lookup("rmi://localhost/DistanceServer");

            System.out.print("Enter distance in Miles: ");
            double miles = sc.nextDouble();

            double kilometers = server.convertMilesToKilometers(miles);
            System.out.println("Distance in Kilometers: " + kilometers);

            sc.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
