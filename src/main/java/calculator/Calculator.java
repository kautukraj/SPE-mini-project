package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator
{
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator()
    {
    }

    public static void main(String[] args)
    {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        do
        {
            System.out.println("Calculator-using-DevOps, choose an operation");
            System.out.print("Press 1 for Multiplication\nPress 2 for Cube Root\nPress 3 for Square\nPress 4 for Subtraction\n" +
                    "Press 5 to exit\nEnter your choice: ");
            int choice;
            try
            {
                choice = scanner.nextInt();
            } catch (InputMismatchException error)
            {
                return;
            }

            switch (choice)
            {
                case 1:
                    // do Multiplication
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                    System.out.println("Multiplication of " + number1 + " and " + number2 + " is : " + calculator.multiplication(number1, number2));
                    System.out.println("\n");

                    break;
                case 2:
                    // find cube root
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Cube root of " + number1 + " is : " + calculator.cuberoot(number1));
                    System.out.println("\n");

                    break;
                case 3:
                    // find square
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Square of " + number1 + " is : " + calculator.square(number1));
                    System.out.println("\n");

                    break;
                case 4:
                    // do Subtraction
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                    System.out.println("Subtraction of " + number2 + " from " + number1 + " is : " + calculator.sub(number1, number2));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Exiting now....");
                    return;
            }
        } while (true);
    }


    public double multiplication(double number1, double number2)
    {
        logger.info("[MULTIPLICATION - " + number1 + " AND " + number2);
        double result = number1 * number2;
        logger.info("[RESULT - MULTIPLICATION] - " + result);
        return result;
    }

    public double cuberoot(double number1)
    {
        logger.info("[CUBE ROOT] - " + number1);
        double result = Math.cbrt(number1);
        logger.info("[RESULT - CUBE ROOT] - " + result);
        return result;
    }

    public double square(double number1)
    {
        logger.info("[SQUARE] - " + number1);
        double result = number1 * number1;
        logger.info("[RESULT - SQUARE] - " + result);
        return result;
    }

    public double sub(double number1, double number2)
    {
        logger.info("[SUBTRACTION - " + number2 + " FROM " + number1);
        double result = number1 - number2;
        logger.info("[RESULT - SUBTRACTION] - " + result);
        return result;
    }


}

