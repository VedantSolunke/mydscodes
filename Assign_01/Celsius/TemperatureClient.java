import java.rmi.Naming;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            TemperatureServerInterface server = (TemperatureServerInterface) Naming
                    .lookup("rmi://localhost/TemperatureServer");

            System.out.print("Enter temperature in Celsius: ");
            double celsius = sc.nextDouble();

            double fahrenheit = server.convertCelsiusToFahrenheit(celsius);
            System.out.println("Temperature in Fahrenheit: " + fahrenheit);

            sc.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
