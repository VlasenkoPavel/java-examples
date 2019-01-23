import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class ArrayTest {
    public static void main(String[] args) {
        System.out.println(ArrayTest.countEvensByCicle(new int[] { 3, 4, 5, 6, 7 }));
    }

    public static int countEvensByCicle(int[] nums) {
        int count = 0;

        for (int i:nums) {
            if (i % 2 == 0) {
                count = ++count;  // count++ not good
            }
        }

        return count;
    }

    public static int countEvensByStreamFilter(int[] nums) {
        return (int) IntStream.of(nums).boxed().filter(i -> i % 2 == 0).count();
    }

    public static void createIntArray() {
        int[] arr1 = { 1, 2, 3 };
        int [] arr2 = new int[] { 3, 4, 5, 6, 7 };
        var arr3 = new int[] { 3, 4, 5, 6, 7 };
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

    public static List<Integer> transformToListByCicle(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i:nums) {
            list.add(i);
        }

        return list;
    }

    public static List<Integer> transformToListByStream(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList()); // or IntStream.of(nums).boxed()... not Stream.of(nums)...
    }

    public static int sum1(int[] nums) {
        return IntStream.of(nums).sum();
    }

    public static int sum2(int[] nums) {
        int result = 0;

        for (int i:nums) {      // or for (var i:nums)
          result = result + i;
        }

        return result;
    }

    public static int[] reverseByCollections(int[] nums) {
        var list = IntStream.of(nums).boxed().collect(Collectors.toList()); // or Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.reverse(list);

        return list.stream().mapToInt(i -> i).toArray();   // i -> i automaticali transform to  i -> i.intValue()

    }

    public static Boolean isContainsByCilcle(int[] nums, int n) {
        Boolean result = false;

        for (int i:nums) {
            result = i == n;

            if (result) {
                break;
            }
        }

        return result;
    }

    public static Boolean isContainsByStream(int[] nums, int n) {
        return IntStream.of(nums).boxed().collect(Collectors.toList()).contains(n);
    }

    public static int[] concatByCicle(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = i < a.length ? a[i] : b[i - a.length];
        }

        return result;
    }

    public static int[] concatByListTransform(int[] a, int[] b) {
        var list = IntStream.of(a).boxed().collect(Collectors.toList());
        list.addAll(IntStream.of(b).boxed().collect(Collectors.toList()));
        int[] result = list.stream().mapToInt(i -> i).toArray();

        return result;
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

    public int[] fix23(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] == 3 && nums[i - 1] == 2 ? 0 : nums[i]; // (nums[i] == 3 && nums[i-1] == 2) ? result[i] = 0 : result[i] = nums[i]; is error
        }

        return result;
    }

    public static void printIntArr(int[] nums) {
        System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));
    }
}
