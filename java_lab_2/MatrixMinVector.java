import java.util.Scanner;
import java.util.Random;

public class MatrixMinVector {
    public static int[][] generateMatrix(int rows, int cols){
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        return matrix;
    }
    public static int[] findMinValuesInMatrix(int[][] matrix, int rows, int cols){
        int[] minValuesVector = new int[rows];

        for (int i = 0; i < rows; i++) {
            minValuesVector[i] = matrix[i][0];
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < minValuesVector[i]) {
                    minValuesVector[i] = matrix[i][j];
                }
            }
        }

        return minValuesVector;
    }
    public static void main(String[] args){
        int rows, cols;

        Scanner inputNumScanner = new Scanner(System.in);

        System.out.println("Введите количество строк в матрице");
        rows = inputNumScanner.nextInt();
        System.out.println("Введите количество столбцов в матрице");
        cols = inputNumScanner.nextInt();

        int[][] randomMatrix = generateMatrix(rows, cols);

        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", randomMatrix[i][j]);
            }
            System.out.println();
        }

        int[] minValuesVector = findMinValuesInMatrix(randomMatrix, rows, cols);

        for (int i = 0; i < rows; i++) {
            System.out.println("Минимум в строке №" + (i + 1) + ": " + minValuesVector[i]);
        }

        inputNumScanner.close();
    }
}
