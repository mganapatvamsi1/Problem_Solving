package others.dynamicprogramming;

public class DP1 {

    // using recursion (here time complexity is exponential(2ˆn) )
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int left = fib(n - 1);
        int right = fib(n - 2);
        return left + right;
    }

    // bottom-up approach (Linear time complexity i.e., O(n) )
    public int bottomupFib(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    // top-down approach (Linear time complexity i.e., O(n) )
    public int topDownFib(int[] memo, int n) {
        if (memo[n] == 0) {
            if (n < 2) {
                 memo[n] = n; // 0 and 1
            } else {
                // the current number is the sum of its 2 preceding numbers
                int left = topDownFib(memo, n - 1);
                int right = topDownFib(memo, n - 2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        DP1 dp1 = new DP1();
        System.out.println("6th fibonacci number using recursive approach ::- "+dp1.fib(6));
        System.out.println("6th fibonacci number using bottomUp approach::- "+dp1.bottomupFib(6));
        System.out.println("6th fibonacci number using topDown approach::- "+dp1.topDownFib(new int[6 + 1],6));
    }
}
