import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class StringExamples {
    public static void main(String[] args) {

    }

    public static int getVowelsCount(String str) {

        return str.replaceAll("(?i)[^aeiou]", "").length();
        // return str.replaceAll("[^aeiou]+", "").length();

        // List<Integer> vowelCps = "aeiou".codePoints().boxed().collect(Collectors.toList());
        // return (int) str.codePoints().filter(point -> vowelCps.contains(point)).count();

        // int vowelsCount = 0;
        // for(char c : str.toCharArray())
        //   vowelsCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
        // return vowelsCount;

        // return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();

        // private static List<Character> vowels;
        // static {
        //   vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        // }
        // public static int getCount(String str) {
        //   int vowelsCount = 0;
        //   for(int i = 0; i < str.length(); i++) {
        //     if (vowels.contains(str.charAt(i))) {
        //       vowelsCount++;
        //     }
        //   }
        //   return vowelsCount;
        // }
    }

}
