import java.util.*;
import java.util.stream.Collectors;

public class WordCruncher {
    public static List<String> words;
    public static String target;
    public static List<String> combinations = new ArrayList<>();

    public static Set<String> out = new TreeSet<>();

    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> occurencies = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        words = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        target = scanner.nextLine();

        words.removeIf(next -> !target.contains(next));


        for (String subString : words) {
            occurencies.putIfAbsent(subString, 0);
            occurencies.put(subString, occurencies.get(subString) + 1);

            int index = target.indexOf(subString);

            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(subString);
                index = target.indexOf(subString, index + 1);
            }
        }


        permute(0);

        for (String s : out) {
            System.out.println(s);
        }

    }

    private static void permute(int index) {
        if (index == target.length()) {
            print();
        } else if(table.containsKey(index)){
            List<String> strings = table.get(index);
            for (String s : strings) {
                if(occurencies.get(s) > 0){
                    occurencies.put(s, occurencies.get(s) - 1);
                    combinations.add(s);
                    permute(index + s.length());
                    combinations.remove(combinations.size() - 1);
                    occurencies.put(s, occurencies.get(s) + 1);
                }


            }
        }
    }

    private static void print() {
        String actual = String.join("", combinations);

        if (actual.contains(target)) {
            out.add(String.join(" ", combinations));
        }
    }
}
