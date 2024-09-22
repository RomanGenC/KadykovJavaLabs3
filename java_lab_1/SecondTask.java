import java.util.Scanner;

public class SecondTask {
    public static double calculateMinRaisedToEight(int x, int y){
        double minimum;
        minimum = Math.min(x, y);
        return Math.pow(minimum, 8);
    }
    public static void main(String[] args){
        int firstNumber, secondNumber;
        double result;

        Scanner inputNumScanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        firstNumber = inputNumScanner.nextInt();
        System.out.println("Введите второе число: ");
        secondNumber = inputNumScanner.nextInt();
        inputNumScanner.close();

        result = calculateMinRaisedToEight(firstNumber, secondNumber);
        System.out.printf("Результат (минимальное из чисел возведенное в 8 степень) = %.2f%n", result);
    }
}
