import mpi.MPI;
import java.util.Random;

public class ArrayAverage {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int unitsize = 4; // number of elements per process
        int root = 0;
        int send_buffer[] = null;
        send_buffer = new int[unitsize * size];
        int recieve_buffer[] = new int[unitsize];
        double new_recieve_buffer[] = new double[size];

        if (rank == root) {
            Random rand = new Random();
            System.out.println("Random numbers generated:");
            for (int i = 0; i < unitsize * size; i++) {
                send_buffer[i] = rand.nextInt(100); // random numbers between 0-99
                System.out.println("Element " + i + " = " + send_buffer[i]);
            }
        }

        MPI.COMM_WORLD.Scatter(
                send_buffer, 0, unitsize, MPI.INT,
                recieve_buffer, 0, unitsize, MPI.INT,
                root);

        int local_sum = 0;
        for (int i = 0; i < unitsize; i++) {
            local_sum += recieve_buffer[i];
        }
        double local_avg = (double) local_sum / unitsize;

        System.out.println(
                "Local average at process " + rank + " is " + local_avg);

        MPI.COMM_WORLD.Gather(
                new double[] { local_avg }, 0, 1, MPI.DOUBLE,
                new_recieve_buffer, 0, 1, MPI.DOUBLE,
                root);

        if (rank == root) {
            double total_avg = 0.0;
            for (int i = 0; i < size; i++) {
                total_avg += new_recieve_buffer[i];
            }
            total_avg /= size;
            System.out.println("Final average : " + total_avg);
        }

        MPI.Finalize();
    }
}
