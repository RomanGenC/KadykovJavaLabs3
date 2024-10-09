import java.util.Scanner;

public class Lab1Task3 {
    public static double[] calculateFAndY(int x){
        double cos, sin, ctg, tg;
        sin = Math.sin(x);
        cos = Math.cos(x);
        ctg = cos / sin;
        tg = sin / cos;

        if (x > 0){
            return new double[]{Math.pow(ctg, 2), Math.pow(tg, 0.2)};
        }

        if (x <= -3){
            return new double[]{Math.pow(x, 3) + 1, Math.exp(x + 1)};
        }

        return new double[]{1 + Math.pow(2, tg), Math.pow(x, 4)};
    }
    public static void main(String[] args){
        int x;
        double[] resultF_Y;

        Scanner inputNumScanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        x = inputNumScanner.nextInt();
        inputNumScanner.close();

        resultF_Y = calculateFAndY(x);
        System.out.printf("Результат F = %.2f, Результат Y = %.2f%n", resultF_Y[0], resultF_Y[1]);
    }
}