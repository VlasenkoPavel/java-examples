import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.List;
import java.lang.Math;
import java.util.ArrayList;

/**
 * if need concreate subtype of LIST:
 * Supplier<List<Shape>> supplier = () -> new LinkedList<Shape>();
 * List<Shape> list = shapes.stream().filter(...).collect(Collectors.toCollection(supplier));
 * Or:
 * List<Shape> list = shapes.stream().filter(...).collect(Collectors.toCollection(LinkedList::new));
 */

public class StreamCalc {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 4, 5, 6, 7 };
        // Boolean[] bools = new Boolean[] { true,  true,  true,  false, true,  true,  true,  true, true,  false, true };
        System.out.println(StreamCalc.findShort("asdsad asda sd"));
    }

    public static int bigDiff(int[] nums) {
        var max = IntStream.of(nums).max().getAsInt();
        var min = IntStream.of(nums).min().getAsInt();

        return max - min;
    }

    public static long fiboStreamGenerator (int n) {
        long[] firsTwo = { 0, 1 };
        int size = n/2 + 1;

        long[] fiboSequense = Stream.iterate(firsTwo, pair -> new long[] { pair[0] + pair[1], pair[0] + pair[1] * 2 })
            .limit(size)
            .flatMapToLong(LongStream::of)
            .toArray();

        System.out.println(LongStream.of(fiboSequense).boxed().collect(Collectors.toList()));

        return fiboSequense[n - 1];
    }

    public static int countEvensByStreamFilter(int[] nums) {
        return (int) IntStream.of(nums).boxed().filter(i -> i % 2 == 0).count();
    }

    public static int[] firsTwoByStream(int[] nums) {
        return IntStream.of(nums).limit(2).toArray();
    }

    public static int[] firsTwoByArraysStream(int[] nums) {
        return Arrays.stream(nums, 0, 2).toArray();
    }

    public static int[] firsTwoByCollection(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());

        return list.subList(0, 2).stream().mapToInt(i -> i).toArray();
    }

    public static List<Integer> transformToListByStream(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList()); // or IntStream.of(nums).boxed()... not Stream.of(nums)...
    }

    public static int sum1(int[] nums) {
        return IntStream.of(nums).sum();
    }

    public static Boolean isContainsByStream(int[] nums, int n) {
        return IntStream.of(nums).boxed().collect(Collectors.toList()).contains(n);
    }

    public static int[] concatByFlatMap(int[] a, int[] b) {
        return Stream.of(IntStream.of(a), IntStream.of(b)).flatMapToInt(i -> i).toArray(); // or Stream.of(new int[][] { a, b }).flatMapToInt(IntStream::of).toArray();
    }

    public static int[] concatByStreamConcat(int[] a, int[] b) {
        return Stream.concat(IntStream.of(a).boxed(), IntStream.of(b).boxed()).mapToInt(i -> i).toArray();
    }

    public static int maxByCollections(int[] nums) {
        return Collections.max(IntStream.of(nums).boxed().collect(Collectors.toList()));
    }

    public static int maxByStream(int[] nums) {
        return IntStream.of(nums).max().getAsInt();
    }

    public static void printIntArr(int[] nums) {
        System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));
    }

    public static int findShort(String s) {
        return Stream.of(s.split(" ")).mapToInt(String::length).min().getAsInt();
        // return Arrays.stream(s.split(" ")).map(String::length).min(Comparator.naturalOrder()).get();
        //Stream.of(s.split(" ")).map(word -> word.length()).min(Math::min).get();  // dont do that!!! now work correctly
       //return Stream.of(s.split(" ")).reduce(s.length(), (x, y) -> x > y.length() ? y.length() : x, (x, y) -> x > y ? y : x);
    }

    public static int сonvertBinaryArrayToInt(List<Integer> binary) {
        return binary.stream().reduce(0, (x, y)-> x * 2 + y);
    }

    public static int summation(int num) {
        return IntStream.rangeClosed(1, num).sum();
        // return IntStream.iterate(1, n -> ++n).limit(num).sum();
        // return  n*(n+1)/2;

        // public static int summation(int n) {
        //     if (n == 1)
        //       return 1;
        //     return summation(n-1) + n;
        // }
    }

    public String dnaToRna(String dna) {
        return dna.replace('U', 'X').replace('T', 'U').replace('X', 'T'); // or dna.replace('U', 'X')?s
    }

    public static int chekNull(Boolean[] arr) {
        return (int) Stream.of(arr).filter(Boolean::booleanValue).count();

        // int count = 0;
        // for (Boolean b : arrayOfSheeps) if (b) count++;
        // return count;

        // if(Boolean.TRUE.equals(sheep)) {
        //     count++;
        // }

        // return (int) Stream.of(arr)
        //                     .filter(i -> i != null && i == true)
        //                     .count();
    }
}
