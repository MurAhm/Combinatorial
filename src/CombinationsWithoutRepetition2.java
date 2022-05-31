import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CombinationsWithoutRepetition2 {

    public static int n;
    public static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());

        arr = new int[k];


        combinations(0, 1);

    }

    private static void combinations(int index, int start) {
        if (index == arr.length) {
            print();
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[index] = i;
            combinations(index + 1, i + 1);
        }

    }

    private static void print() {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

