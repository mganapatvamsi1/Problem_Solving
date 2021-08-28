package others.arrays;

public class ArrayExamples {

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void arrayDemo() {
        int[] myArray = new int[5];
        printArray(myArray);
        myArray[0] = 10;
        myArray[1] = 20;
        myArray[2] = 30;
        myArray[3] = 40;
        System.out.println();
        printArray(myArray);
        System.out.println("array length is: "+myArray.length);
        System.out.println(myArray[myArray.length - 1]);
        System.out.println();

        int[] testing = {1, 3, 5, 7, 9};
        printArray(testing);
    }

    public int[] removeEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = 0;
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        return arr;
    }


    public static void main(String[] args) {
        ArrayExamples arrayExamples = new ArrayExamples();
        arrayExamples.arrayDemo();

        System.out.println();
        System.out.println();
        int[] testArray = {10, 12, 13, 14, 15, 16};
        arrayExamples.removeEven(testArray);

    }
}
