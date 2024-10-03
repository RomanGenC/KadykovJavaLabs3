import java.util.Random;

public class NegativeElementsProcessor {
    public static int[] DoubleNegativeNumsFromNumbers(int[] numbersX){
        int count = 0;

        for (int number : numbersX) {
            if (number < 0) {
                count++;
            }
        }

        int[] arrayY = new int[count];
        int index = 0;

        for (int number : numbersX) {
            if (number < 0) {
                arrayY[index++] = number * 2;
            }
        }
        return arrayY;
    }
    public static void selectionSort(int[] y) {
        int yLength = y.length;
        for (int i = 0; i < yLength - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < yLength; j++) {
                if (y[j] < y[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = y[minIndex];
            y[minIndex] = y[i];
            y[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] x = new int[100];
        Random random = new Random();

        for (int i = 0; i < x.length; i++) {
            x[i] = random.nextInt(199) - 99;
        }

        int[] y = DoubleNegativeNumsFromNumbers(x);
        selectionSort(y);

        for (int value : y) {
            System.out.print(value + " ");
        }
    }
}
