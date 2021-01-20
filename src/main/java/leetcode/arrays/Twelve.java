package leetcode.arrays;

/*
Rotate Image
 */
public class Twelve {

    public void printElementsOfAMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void printMatrix90Degrees(int[][] matrix) {
        int n = matrix.length;
        //transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j);
//                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
        // reverse columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }


    public static void main(String[] args) {
        Twelve test = new Twelve();
        int[][] dample = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        test.printElementsOfAMatrix(dample);
        test.printMatrix90Degrees(dample);
    }

}
