import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationsWIthRepetition2 {
    public static int[] arr;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());

        arr = new int[k];

        combine(0, 1);


    }

    private static void combine(int index, int start) {
        if (index == arr.length) {
            printArr();
        } else {
            for (int i = start; i <= n; i++) {
                arr[index] = i;
                combine(index + 1, i);
            }
        }
    }


    private static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }
}

