import java.util.ArrayList;
import java.util.Random;

public class Lab2Task1 {
    private static final int THRESHOLD = 50;

    public static void CreateReciprocalFraction(int[] numbers){
        int numbersLength = numbers.length;

        double[] newNumbersArray = new double[numbersLength];
        ArrayList<Integer> smallerNumbers = new ArrayList<>();
        ArrayList<Integer> smallerNumbersIndices = new ArrayList<>();

        for (int i = 0; i < numbersLength; i++) {
            try {
                newNumbersArray[i] = 1.0 / numbers[i];
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: деление на ноль в элементе с индексом " + i);
                newNumbersArray[i] = 0;
            }

            if (numbers[i] < THRESHOLD) {
                smallerNumbers.add(numbers[i]);
                smallerNumbersIndices.add(i);
            }
        }

        System.out.println("Вывод массива с перевернутыми значениями массива numbers");
        for (double num : newNumbersArray) {
            System.out.println(num);
        }

        System.out.println("Вывод значений, меньший константы, и их индексов");
        for (int i = 0; i < smallerNumbers.size(); i++) {
            System.out.printf("Значение %d, Индекс %d%n", smallerNumbers.get(i), smallerNumbersIndices.get(i));
        }

    }
    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(199) - 99;
        }

        CreateReciprocalFraction(numbers);
    }
}
