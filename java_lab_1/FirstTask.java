import java.util.Scanner;

public class FirstTask {
    public static double calculateResult(int x, int y){
        if (x * y > 100) {
            return 2 * Math.pow(x, 3);
        }
        return -1;
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

        result = calculateResult(firstNumber, secondNumber);
        if (result != -1) {
            System.out.printf("Удвоенные куб числа %d равен: %.2f%n", firstNumber, result);
            return;
        }
        System.out.println("Произведение чисел меньше либо равно 100. Попробуйте еще раз");
    }
}
