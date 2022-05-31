import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {

    public static String[] seats;
    public static String[] combinations;
    public static boolean[] used;
    public static List<String> people;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

         people = Arrays.stream(bufferedReader.readLine().split(", ")).collect(Collectors.toList());

        seats = new String[people.size()];


        String line = bufferedReader.readLine();

        while (!line.equals("generate")) {
            String[] tokens = line.split(" - ");

            String name = tokens[0];
            int seatNumber = Integer.parseInt(tokens[1]) - 1;

            seats[seatNumber] = name;

            people.remove(name);


            line = bufferedReader.readLine();
        }

        combinations = new String[people.size()];
        used = new boolean[people.size()];

        permute(0);
    }

    private static void permute(int index) {
        if(index == combinations.length){
            print();
        } else {
            for (int i = 0; i < people.size(); i++) {
                if(!used[i]) {
                    used[i] = true;
                    combinations[index] = people.get(i);
                    permute(index + 1);
                    used[i] = false;
                }

            }
        }
    }

    private static void print() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (String seat : seats) {
            if (seat != null) {
                stringBuilder.append(seat).append(" ");
            } else {
                stringBuilder.append(combinations[index++]).append(" ");
            }
        }
        System.out.println(stringBuilder.toString().trim());

    }
}
