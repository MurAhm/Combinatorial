import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("\\s+");

        reverse(arr, arr.length - 1);
    }

    private static void reverse(String[] arr, int index) {
        if (index < 0) {
            return;
        }

        System.out.print(arr[index] + " ");

        reverse(arr, index - 1);

    }
}
