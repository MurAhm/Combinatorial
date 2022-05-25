import java.util.Scanner;

public class PermutationsWithoutRepetitionSwap {

    public static String[] elements;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        elements = scan.nextLine().split(" ");

        permute(0);

    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }


        permute(index + 1);
        for (int i = index + 1; i < elements.length; i++) {
            swap(elements, index, i);

            permute(index + 1);

            swap(elements, index, i);


        }

    }

    private static void swap(String[] elements, int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
