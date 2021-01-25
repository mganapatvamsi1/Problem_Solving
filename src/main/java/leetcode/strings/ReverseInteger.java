package leetcode.strings;

public class ReverseInteger {

    public int reverseNo(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x *= -1;
        }
        long reversed = 0; // to avoid integer overflow
        while (x > 0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }
        if (reversed > Integer.MAX_VALUE ||
                reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return negative ? (int) (-1 * reversed) : (int) reversed;
    }


}
