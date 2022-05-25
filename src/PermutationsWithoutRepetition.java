import java.util.Scanner;

public class PermutationsWithoutRepetition {

    public static String[] elements ;
    public static String[] permutes ;
    public static boolean[] used;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        elements = scan.nextLine().split(" ");

        permutes = new String[elements.length];

        used = new boolean[elements.length];

        permute(0);

    }

    private static void permute(int index) {
        if(index == elements.length) {
            print();
            return;
        }



        for (int i = 0; i < elements.length; i++) {
            if(!used[i]){
                used[i] = true;
                permutes[index] = elements[i];
                permute(index + 1);
                used[i] = false;
            }

        }

    }

    private static void print() {
        System.out.println(String.join(" ", permutes));
    }
}
