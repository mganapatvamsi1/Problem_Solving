package algoexpert.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    private static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    private static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object element: array) {
            if (element instanceof ArrayList) {
                List<Object> list = (List<Object>) element;
                sum += productSumHelper(list, multiplier + 1);
            } else {
                sum += (int) element;
            }
        }
        return sum * multiplier;
    }


    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        System.out.println("product sum of given list is: "+productSum(list));
    }
}
