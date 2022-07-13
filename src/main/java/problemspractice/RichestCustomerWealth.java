package problemspractice;

public class RichestCustomerWealth {

    static int richestCustomerWealth(int[][] accounts) {
        int count = Integer.MIN_VALUE;
//        int count = 0;
//        for (int row = 0; row < accounts.length; row++) {
//            int customerWealthCount = 0;
//            for (int col = 0; col < accounts[row].length; col++) {
//                customerWealthCount += accounts[row][col];
//                if (customerWealthCount > count) count = customerWealthCount;
//            }
//        }
        for (int[] account : accounts) {
            int customerWealthCount = 0;
            for (int element : account) {
                customerWealthCount += element;
            }
            if (customerWealthCount > count) count = customerWealthCount;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] test2DArr = {
                {2, 3, 1, 4, 5},
                {10, 11, 12},
                {7, 8, 9, 19}, // 43
                {26, 8},
                {-11}
        };
        int[][] test2DArr2 = {
                {2},
                {10},
                {7, 8},
                {26, 81}, // 107
                {7, -1}
        };

        System.out.println("richestCustomerCount1: "+ richestCustomerWealth(test2DArr)); // 43
        System.out.println("richestCustomerCount2: "+ richestCustomerWealth(test2DArr2)); // 107
    }
}
