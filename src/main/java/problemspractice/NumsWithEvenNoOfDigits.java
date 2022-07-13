package problemspractice;

public class NumsWithEvenNoOfDigits {

    /*
     * Given an array "nums" of integers, return how many of them contain an even no. of digits.
     *
     * article to check: https://stackoverflow.com/questions/1306727/way-to-get-number-of-digits-in-an-int
     *
     * */
    private static int findNumsWithEvenNoOfDigits(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int findNumsWithEvenNoOfDigits2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((int) (Math.log10(num) + 1) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    //// suggested solution
    private static int findNumsWithEvenNoOfDigits3(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)) count++;
        }
        return count;
    }

    private static int findNumsWithEvenNoOfDigits4(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int element = countNoOfDigitsInNum(num);
            if (element % 2 == 0) count++;
        }
        return count;
    }

    // function to check if the given no. has even num of digits or not
    public static boolean even(int num) {
//        return String.valueOf(num).length() % 2 == 0;
        int numberOfDigits = countNoOfDigitsInNum(num);
        return numberOfDigits % 2 == 0;
    }

    // function to count the number of digits in a given number
    public static int countNoOfDigitsInNum(int num) {
        if (num < 0) num *= -1;
        if (num == 0) return 1;
        int counter = 0;
        while (num > 0) {
            counter++;
            num /= 10;
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] integersArr = {3333, 201, 322, 83135, 9111, 1999}; // 3
        int[] integersArr2 = {2, 3, 1, 4, 5, 10, 11, 12, 6, 7, 8, 9, 19}; // 4
        System.out.println("number of even digits1a: " + findNumsWithEvenNoOfDigits(integersArr)); // 3
        System.out.println("number of even digits1b: " + findNumsWithEvenNoOfDigits2(integersArr)); // 3
        System.out.println("number of even digits1c: " + findNumsWithEvenNoOfDigits3(integersArr)); // 3
        System.out.println("number of even digits1d: " + findNumsWithEvenNoOfDigits4(integersArr)); // 3
        System.out.println("number of even digits2a: " + findNumsWithEvenNoOfDigits(integersArr2)); // 4
        System.out.println("number of even digits2b: " + findNumsWithEvenNoOfDigits2(integersArr2)); // 4
        System.out.println("number of even digits2c: " + findNumsWithEvenNoOfDigits3(integersArr2)); // 4
        System.out.println("number of even digits2d: " + findNumsWithEvenNoOfDigits4(integersArr2)); // 4
        System.out.println("number of digits: " + countNoOfDigitsInNum(1234567890)); // 10
    }
}
