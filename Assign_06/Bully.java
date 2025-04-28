// import java.util.Scanner;

// public class Bully {

//     int coordinator;
//     int max_processes;
//     boolean[] processes;

//     public Bully(int max) {
//         this.max_processes = max;
//         this.processes = new boolean[max];
//         this.coordinator = max;

//         System.out.println("Creating Processes...");
//         for (int i = 0; i < max; i++) {
//             processes[i] = true;
//             System.out.println("Process : " + (i + 1) + " created");
//         }
//         System.out.println("Process " + coordinator + " is the coordinator");
//     }

//     void displayProcesses() {
//         for (int i = 0; i < max_processes; i++) {
//             if (processes[i]) {
//                 System.out.println("Process " + (i + 1) + " is UP");
//             } else {
//                 System.out.println("Process " + (i + 1) + " is DOWN");
//             }
//         }
//         System.out.println("Process " + coordinator + " is the coordinator");

//     }

//     void upProcess(int id) {
//         if (processes[id - 1]) {
//             System.out.println("Process " + (id) + " is already UP.");
//         } else {
//             processes[id - 1] = true;
//             System.out.println("Process " + (id) + " is UP.");
//         }
//     }

//     void downProcess(int id) {
//         if (!processes[id - 1]) {
//             System.out.println("Process " + (id) + " is already DOWN.");
//         } else {
//             processes[id - 1] = false;
//             System.out.println("Process " + (id) + " is DOWN.");
//         }
//     }

//     void runElection(int process_id) {
//         if (!processes[process_id - 1]) {
//             System.out.println("Process " + process_id + " is DOWN and cannot start an election.");
//             return;
//         }

//         coordinator = process_id;
//         boolean keepGoing = true;

//         for (int i = process_id; i < max_processes && keepGoing; i++) {
//             System.out.println("Election Message send from process " + process_id + " to process " + (i + 1));
//             if (processes[i]) {
//                 keepGoing = false;
//                 runElection(i + 1);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Bully bully = null;
//         int max_processes = 0;
//         int process_id = 0;

//         int choice = 0;

//         Scanner sc = new Scanner(System.in);

//         while (true) {
//             System.out.println("==== Bully Algorithm Menu ====");
//             System.out.println("1. Create Processes");
//             System.out.println("2. Display Processes");
//             System.out.println("3. Bring a process UP");
//             System.out.println("4. Bring a process DOWN");
//             System.out.println("5. Run Election");
//             System.out.println("6. Exit");
//             System.out.print("Enter your choice: ");
//             choice = sc.nextInt();

//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter the no. of Processes : ");
//                     max_processes = sc.nextInt();
//                     bully = new Bully(max_processes);
//                     break;

//                 case 2:
//                     bully.displayProcesses();
//                     break;

//                 case 3:
//                     System.out.print("Enter the process ID to up: ");
//                     process_id = sc.nextInt();
//                     bully.upProcess(process_id);
//                     break;

//                 case 4:
//                     System.out.print("Enter the process ID to down: ");
//                     process_id = sc.nextInt();
//                     bully.downProcess(process_id);
//                     break;
//                 case 5:
//                     System.out.print("Enter the process ID which will start the Election : ");
//                     process_id = sc.nextInt();
//                     bully.runElection(process_id);
//                     bully.displayProcesses();
//                     break;

//                 case 6:
//                     System.out.println("Exiting program. Goodbye!");
//                     sc.close();
//                     System.exit(0);
//                     break;
//                 default:
//                     System.out.println("Error in choice, try again !!");
//                     break;
//             }

//         }
//     }
// }

import java.util.Scanner;

public class Bully {

    int coordinator;
    int max_processes;
    boolean[] processes;

    public Bully(int max) {
        this.max_processes = max;
        this.processes = new boolean[max];
        this.coordinator = -1; // No coordinator initially

        System.out.println("Creating Processes...");
        for (int i = 0; i < max; i++) {
            processes[i] = true;
            System.out.println("Process " + (i + 1) + " created");
        }
        System.out.println("Initial coordinator is not set.");
    }

    void displayProcesses() {
        for (int i = 0; i < max_processes; i++) {
            System.out.println("Process " + (i + 1) + " is " + (processes[i] ? "UP" : "DOWN"));
        }
        if (coordinator != -1) {
            System.out.println("Process " + (coordinator) + " is the coordinator.");
        } else {
            System.out.println("No coordinator has been elected.");
        }
    }

    void upProcess(int id) {
        if (id < 1 || id > max_processes) {
            System.out.println("Invalid Process ID.");
            return;
        }

        if (processes[id - 1]) {
            System.out.println("Process " + (id) + " is already UP.");
        } else {
            processes[id - 1] = true;
            System.out.println("Process " + (id) + " is UP.");
        }
    }

    void downProcess(int id) {
        if (id < 1 || id > max_processes) {
            System.out.println("Invalid Process ID.");
            return;
        }

        if (!processes[id - 1]) {
            System.out.println("Process " + (id) + " is already DOWN.");
        } else {
            processes[id - 1] = false;
            System.out.println("Process " + (id) + " is DOWN.");
        }
    }

    void runElection(int process_id) {
        if (process_id < 1 || process_id > max_processes) {
            System.out.println("Invalid Process ID.");
            return;
        }

        if (!processes[process_id - 1]) {
            System.out.println("Process " + process_id + " is DOWN and cannot start an election.");
            return;
        }

        // Election starts here
        System.out.println("Process " + process_id + " is starting the election...");

        // Find processes with higher IDs that are UP
        for (int i = process_id; i < max_processes; i++) {
            if (processes[i]) {
                System.out.println("Election message sent from process " + process_id + " to process " + (i + 1));
            }
        }

        // New coordinator is the highest process that remains UP
        for (int i = max_processes - 1; i >= process_id; i--) {
            if (processes[i]) {
                coordinator = i + 1; // Set the coordinator to the highest process ID
                System.out.println("Process " + (i + 1) + " is elected as the new coordinator.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Bully bully = null;
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("==== Bully Algorithm Menu ====");
            System.out.println("1. Create Processes");
            System.out.println("2. Display Processes");
            System.out.println("3. Bring a process UP");
            System.out.println("4. Bring a process DOWN");
            System.out.println("5. Run Election");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of processes: ");
                    int max_processes = sc.nextInt();
                    bully = new Bully(max_processes);
                    break;

                case 2:
                    if (bully != null) {
                        bully.displayProcesses();
                    } else {
                        System.out.println("Please create processes first.");
                    }
                    break;

                case 3:
                    if (bully != null) {
                        System.out.print("Enter the process ID to bring UP: ");
                        int process_id_up = sc.nextInt();
                        bully.upProcess(process_id_up);
                    } else {
                        System.out.println("Please create processes first.");
                    }
                    break;

                case 4:
                    if (bully != null) {
                        System.out.print("Enter the process ID to bring DOWN: ");
                        int process_id_down = sc.nextInt();
                        bully.downProcess(process_id_down);
                    } else {
                        System.out.println("Please create processes first.");
                    }
                    break;

                case 5:
                    if (bully != null) {
                        System.out.print("Enter the process ID to start the election: ");
                        int election_id = sc.nextInt();
                        bully.runElection(election_id);
                        bully.displayProcesses();
                    } else {
                        System.out.println("Please create processes first.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
