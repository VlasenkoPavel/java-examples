import java.lang.Integer;

public class Digits {
    public static void main(String[] args) {
        System.out.println(Digits.digitPow(695, 2));
    }

    public static int digitPow(int num, int pow) {
        String intString = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < intString.length(); ++i, ++pow)
          sum += Math.pow(Character.getNumericValue(intString.charAt(i)), pow);

        return (sum % num == 0) ? sum / num : -1;
        // int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();

        // int currentPow = pow;
        // int result = 0;

        // for (int digit:digits) {
        //     result = result + (int) Math.pow(digit, currentPow);
        //     currentPow++;
        // }

        // for (int i = 1; true; i++) {
        //     if (result == num * i) {
        //         return i;
        //     }

        //     if (result < num * i) {
        //         return -1;
        //     }
        // }
    }
}
