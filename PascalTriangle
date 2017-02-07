import java.util.Scanner;

public class PascalTriangle {

    public static void printPascalTriangle(int n) {
        long[][] matrix = new long[n][];

        //determine the length of the arrays
        for (int i = 0; i < n; i++) {
            matrix[i] = new long[i + 1];
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col == 0) {
                    //the first number in each array is 1
                    matrix[row][col] = 1;
                } else if (col == matrix[row].length - 1) {
                    //the last number in each array is 1
                    matrix[row][col] = 1;
                } else {
                    //calculate the current number by finding the sum of the two 'above' it
                    matrix[row][col] = matrix[row - 1][col] + matrix[row - 1][col - 1];
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        printPascalTriangle(n);
    }
}
