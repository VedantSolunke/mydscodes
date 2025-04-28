import mpi.MPI;

public class ArrayReciprocal {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int root = 0;
        int send_buffer[] = null;
        send_buffer = new int[size];
        int recieve_buffer[] = new int[1];
        double new_recieve_buffer[] = new double[size];

        if (rank == root) {
            System.out.println("Initializing " + size + " elements:");
            for (int i = 0; i < size; i++) {
                send_buffer[i] = i + 1; // avoid division by zero
                System.out.println("Element " + i + " = " + send_buffer[i]);
            }
        }

        MPI.COMM_WORLD.Scatter(
                send_buffer, 0, 1, MPI.INT,
                recieve_buffer, 0, 1, MPI.INT,
                root);

        double reciprocal = 1.0 / recieve_buffer[0];

        System.out.println(
                "Reciprocal at process " + rank + " is " + reciprocal);

        MPI.COMM_WORLD.Gather(
                new double[] { reciprocal }, 0, 1, MPI.DOUBLE,
                new_recieve_buffer, 0, 1, MPI.DOUBLE,
                root);

        if (rank == root) {
            System.out.println("Final array of reciprocals:");
            for (int i = 0; i < size; i++) {
                System.out.println("Reciprocal of element " + (i + 1) + " is " + new_recieve_buffer[i]);
            }
        }

        MPI.Finalize();
    }
}
