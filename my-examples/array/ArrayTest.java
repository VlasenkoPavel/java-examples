import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class ArrayTest {
    public static void main(String[] args) {}

    public static void createIntArray() {
        int[] arr1 = { 1, 2, 3 };
        int [] arr2 = new int[] { 3, 4, 5, 6, 7 };
        var arr3 = new int[] { 3, 4, 5, 6, 7 };

        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    public static void firsTwoByStream(int[] nums) {
        int[] result = IntStream.of(nums).limit(2).toArray();

        ArrayTest.printIntArr(result);
    }

    public static void firsTwoByCollection(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        int[] result = list.subList(0, 2).stream().mapToInt(i -> i).toArray();

        ArrayTest.printIntArr(result);
    }

    public static void transformToListByCicle(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i:nums) {
            list.add(i);
        }

        System.out.println(list);
    }

    public static void transformToListByStream(int[] nums) {
        var list = Arrays.stream(nums).boxed().collect(Collectors.toList()); // or IntStream.of(nums).boxed()... not Stream.of(nums)...
        System.out.println(list);
    }

    public static void sum1(int[] nums) {
        int sum = IntStream.of(nums).sum();
        System.out.println(sum);
    }

    public static void sum2(int[] nums) {
        int result = 0;

        for (var i:nums) {      // or for (int i:nums)
          result = result + i;
        }

        System.out.println(result);
    }

    public static void reverse(int[] nums) {
        var list = IntStream.of(nums).boxed().collect(Collectors.toList()); // or Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        int[] reversed = list.stream().mapToInt(i -> i).toArray();   // i -> i automaticali transform to  i -> i.intValue()

        System.out.println(nums);
        System.out.println(Arrays.stream(reversed).boxed().collect(Collectors.toList()));
    }

    public static void isContainsByCilcle(int[] nums, int n) {
        Boolean result = false;

        for (int i:nums) {
            result = i == n;

            if (result) {
                break;
            }
        }

        System.out.println(result);
    }

    public static void isContainsByStream(int[] nums, int n) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        System.out.println(list.contains(n));
    }

    public static void concatByCicle(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = i < a.length ? a[i] : b[i - a.length];
        }

        System.out.println(IntStream.of(result).boxed().collect(Collectors.toList()));
    }

    public static void concatByListTransform(int[] a, int[] b) {
        var list = IntStream.of(a).boxed().collect(Collectors.toList());
        list.addAll(IntStream.of(b).boxed().collect(Collectors.toList()));
        int[] result = list.stream().mapToInt(i -> i).toArray();

        System.out.println(list);
    }

    public static void concatByFlatMap(int[] a, int[] b) {
        int [] result = Stream.of(IntStream.of(a), IntStream.of(b)).flatMapToInt(i -> i).toArray(); // or Stream.of(new int[][] { a, b }).flatMapToInt(IntStream::of).toArray();

        System.out.println(IntStream.of(result).boxed().collect(Collectors.toList()));
    }

    public static void concatByStreamConcat(int[] a, int[] b) {
        int [] result = Stream.concat(IntStream.of(a).boxed(), IntStream.of(b).boxed()).mapToInt(i -> i).toArray();

        System.out.println(IntStream.of(result).boxed().collect(Collectors.toList()));
    }

    public static void maxByCollections(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());

        System.out.println(Collections.max(list));
    }

    public static void maxByStream(int[] nums) {
        var max = IntStream.of(nums).max().getAsInt();

        System.out.println(max);
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
