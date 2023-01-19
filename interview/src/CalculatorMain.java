import java.util.Scanner;

interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

class BasicCalculator implements Calculator {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        return a / b;
    }
}

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BasicCalculator calculator = new BasicCalculator();

        System.out.println("Enter first number:");
        double a = input.nextDouble();
        System.out.println("Enter second number:");
        double b = input.nextDouble();

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("Enter your choice:");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Addition: " + calculator.add(a, b));
                break;
            case 2:
                System.out.println("Subtraction: " + calculator.subtract(a, b));
                break;
            case 3:
                System.out.println("Multiplication: " + calculator.multiply(a, b));
                break;
            case 4:
                System.out.println("Division: " + calculator.divide(a, b));
                break;
            default:
                System.out.println("Invalid choice!");
        }
        input.close();
    }
}
