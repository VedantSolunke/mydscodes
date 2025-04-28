import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ring {
    int max_processes;
    int coordinator;
    boolean[] processes;
    ArrayList<Integer> pid;

    public Ring(int max) {
        this.coordinator = max;
        this.max_processes = max;
        pid = new ArrayList<>();
        processes = new boolean[max];

        for (int i = 0; i < max; i++) {
            processes[i] = true;
            System.out.println("Process " + (i + 1) + " is created.");
        }
        System.out.println("Process " + coordinator + " is the coordinator.");
    }

    void displayProcess() {
        for (int i = 0; i < max_processes; i++) {
            if (processes[i]) {
                System.out.println("Process " + (i + 1) + " is UP.");
            } else {
                System.out.println("Process " + (i + 1) + " is DOWN.");
            }
        }
        System.out.println("Process " + coordinator + " is the coordinator.");
    }

    void upProcess(int process_id) {
        if (processes[process_id - 1]) {
            System.out.println("Process " + process_id + " is already UP.");
        } else {
            processes[process_id - 1] = true;
            System.out.println("Process " + process_id + " is UP.");
        }
    }

    void downProcess(int process_id) {
        if (!processes[process_id - 1]) {
            System.out.println("Process " + process_id + " is already DOWN.");
        } else {
            processes[process_id - 1] = false;
            System.out.println("Process " + process_id + " is DOWN.");
        }
    }

    void displayArrayList(ArrayList<Integer> pid) {
        System.out.print("[ ");
        for (Integer id : pid) {
            System.out.print(id + " ");
        }
        System.out.println("]");
    }

    void runElection(int process_id) {
        if (processes[process_id - 1]) {
            pid.add(process_id);

            int temp = process_id;
            System.out.print("Process P " + process_id + " is sending the following list :- ");
            displayArrayList(pid);

            while (temp != process_id - 1) {
                if (processes[temp]) {
                    pid.add(temp + 1);
                    System.out.print("Process P " + (temp + 1) + " is sending the following list :- ");
                    displayArrayList(pid);
                }
                temp = (temp + 1) % max_processes;
            }
            coordinator = Collections.max(pid);
            System.out.println("Process P " + process_id + " has declared P " + coordinator + " as Coordinator.");
            pid.clear();

        } else {
            System.out.println("Process " + process_id + " is DOWN, it cannot start Election.");
        }
    }

    public static void main(String[] args) {
        Ring ring = null;
        int max_processes = 0;
        int process_id = 0;
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Ring Algorithm");
            System.out.println("1. Create processes");
            System.out.println("2. Display processes");
            System.out.println("3. Up a process");
            System.out.println("4. Down a process");
            System.out.println("5. Run election algorithm");
            System.out.println("6. Exit Program");
            System.out.print("Enter your choice:- ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the total number of processes:- ");
                    max_processes = sc.nextInt();
                    ring = new Ring(max_processes);
                    break;
                case 2:
                    ring.displayProcess();
                    break;

                case 3:
                    System.out.print("Enter the process to up:- ");
                    process_id = sc.nextInt();
                    ring.upProcess(process_id);
                    break;
                case 4:
                    System.out.print("Enter the process to down:- ");
                    process_id = sc.nextInt();
                    ring.downProcess(process_id);
                    break;
                case 5:
                    System.out.print("Enter the process which will initiate election:- ");
                    process_id = sc.nextInt();
                    ring.runElection(process_id);
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error in choice, try again !!");
                    break;
            }
        }
    }
}
