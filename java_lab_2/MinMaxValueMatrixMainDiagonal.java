import java.util.Random;
import java.util.Scanner;

public class MinMaxValueMatrixMainDiagonal {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        return matrix;
    }
    public static int findSumOfMinMaxIndices(int[][] matrix, int n) {
        int minValue, minDiagIndex , maxValue, maxDiagIndex ;
        minValue = maxValue = matrix[0][0];
        minDiagIndex  = maxDiagIndex  = 0;

        for (int i = 0; i < n; i++) {
            if (maxValue < matrix[i][i]) {
                maxValue = matrix[i][i];
                maxDiagIndex  = i;
            }
            if (minValue > matrix[i][i]) {
                minValue = matrix[i][i];
                minDiagIndex  = i;
            }
        }

        return minDiagIndex + maxDiagIndex;
    }
    public static void main(String[] args){
        Scanner inputNumScanner = new Scanner(System.in);

        System.out.println("Введите стороны квадратной матрицы");
        int n = inputNumScanner.nextInt();

        int[][] matrix = generateMatrix(n);

        System.out.println("Матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][i]);
            }
            System.out.println();
        }

        int sumOfIndices = findSumOfMinMaxIndices(matrix, n);
        System.out.println("Сумма индексов минимального и максимального элементов главной диагонали: " + sumOfIndices);

        inputNumScanner.close();
    }
}
