import java.util.Scanner;

public class Intervall2 {

    private static int setPrint(String variableName) {
        int x = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter "+variableName + ":");
            if (sc.hasNextInt()) {
                x = sc.nextInt();
                break;
            }
            System.out.println("Error: Please insert an Integer.");
            sc.nextLine(); // Clear the input buffer
        }

        return x;
    }


    public static void main(String[] args) {
        long seed = setPrint("Seed");
        int it = setPrint("Amount of random numbers");
        int min = setPrint("Minimum");
        int max;
        do {
            max = setPrint("Maximum (exclusive, >=Min: " + min + ")");
            if (max < min) {
                System.out.println("The given Integer is invalid");
            }
        } while (max < min);

        long m = 2147483647;//Module
        long a = 48271; //Multiplicator
        int c = 0; //Increment

        for (int i = 0; i < it; i++) {
            seed = (a * seed + c) % m; //x_i+1 = (a+x_i +c) mod m
            long res = (seed % (max - min)) +min; //y_i = x_i mod (max - min) + min
            System.out.println(res);
        }
    }
}
