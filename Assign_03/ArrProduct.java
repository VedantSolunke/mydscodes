import mpi.MPI;

public class ArrProduct {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int root = 0;
        int send_buffer[] = null;
        send_buffer = new int[size];
        int recieve_buffer[] = new int[1];
        int new_recieve_buffer[] = new int[size];

        if (rank == root) {
            System.out.println("Initializing " + size + " elements:");
            for (int i = 0; i < size; i++) {
                send_buffer[i] = i + 1; // elements: 1, 2, 3, ..., size
                System.out.println("Element " + i + " = " + send_buffer[i]);
            }
        }

        MPI.COMM_WORLD.Scatter(
                send_buffer, 0, 1, MPI.INT,
                recieve_buffer, 0, 1, MPI.INT,
                root);

        // Intermediate multiplication: here each processor just has 1 element
        recieve_buffer[0] *= 2; // For example, multiply each element by 2

        System.out.println(
                "Intermediate multiplication at process " + rank + " is " + recieve_buffer[0]);

        MPI.COMM_WORLD.Gather(
                recieve_buffer, 0, 1, MPI.INT,
                new_recieve_buffer, 0, 1, MPI.INT,
                root);

        if (rank == root) {
            System.out.println("Final results gathered at root:");
            for (int i = 0; i < size; i++) {
                System.out.println("Processor " + i + " result: " + new_recieve_buffer[i]);
            }
        }

        MPI.Finalize();
    }
}
