public class Lab4Task2 {
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(2.4, 3.6);
        ComplexNumber num2 = new ComplexNumber(4.1, 5.6);

        ComplexNumber result = num1.multiply(num2);
        System.out.println("Результат умножения: " + result);
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {return real;}
    public void setReal(double real) {this.real = real;}

    public double getImaginary() {return imaginary;}
    public void setImaginary(double imaginary) {this.imaginary = imaginary;}

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;

        return new ComplexNumber(newReal, newImaginary);
    }


    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}
