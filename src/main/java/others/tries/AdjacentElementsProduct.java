package others.tries;

public class AdjacentElementsProduct {

    public int adjacentElementsProduct(int[] inputArray) {
        int x = 0;
        int y = 0;
        int product = Integer.MIN_VALUE;

        for (int i = 0; i < inputArray.length - 1; i++) {
            x = inputArray[i];
            y = inputArray[i + 1];
            if (x * y > product) {
                product = x * y;
            }
        }
        return product;

    }

    public static void main(String[] args) {
        AdjacentElementsProduct adjacentElementsProduct = new AdjacentElementsProduct();
        int[] sample = new int[]{1, 3, 5, 2, 8, 4};
        System.out.println(adjacentElementsProduct.adjacentElementsProduct(sample));

    }
}
