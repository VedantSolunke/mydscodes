import java.util.*;

public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input for the number of nodes in the ring
        System.out.print("Enter the number of nodes you want in the ring: ");
        int n = sc.nextInt();

        // Displaying the nodes in the ring
        System.out.println("Ring formed is as below:");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        int choice = 0;
        int token = 0; // Initial token position (starts from node 0)

        do {
            // Input for sender, receiver, and data
            System.out.print("Enter the sender node: ");
            int sender = sc.nextInt();

            System.out.print("Enter the receiver node: ");
            int receiver = sc.nextInt();

            System.out.print("Enter the data to send: ");
            String data = sc.next();

            // Display token passing
            System.out.println("Token Passing:");

            // Print token movement until the sender node
            for (int i = token; i != sender; i = (i + 1) % n) {
                System.out.print(i + " -> ");
            }
            System.out.println(sender);

            // Data forwarding through the nodes
            System.out.println("Sender " + sender + " is sending data: " + data);
            for (int i = sender; i != receiver; i = (i + 1) % n) {
                System.out.println("Data: " + data + " forwarded by node " + i);
            }

            // Receiver receives the data
            System.out.println("Receiver " + receiver + " received the data: " + data);

            // Update token to be at the receiver
            token = receiver;

            System.out.print("Do you want to send data again? (1 for YES, 0 for NO): ");
            choice = sc.nextInt();

        } while (choice == 1);
    }
}
