package com.mjvschool.calculadorapoo.utils;

import com.mjvschool.calculadorapoo.exceptions.InvalidInputException;
import com.mjvschool.calculadorapoo.models.User;
import com.mjvschool.calculadorapoo.services.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Initialization {

    private final CalculatorService calculatorService;
    private final User user;
    private final CalculatorUtils calculatorUtils;

    public void startProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the password to start the calculator: ");
        String passwordTyped = scanner.nextLine();

        if (!passwordTyped.equals(user.getPassword())) {
            System.out.println("Incorrect password. Closing the program.");
            return;
        }

        System.out.println("\nWelcome to the MJV School Java Project!");
        System.out.println("Name: " + user.getName());
        System.out.println("Profession: " + user.getProfession());
        System.out.println("Age: " + user.getAge());
        System.out.println("\n\n");

        displayMenuCalculator();
    }

    private void displayMenuCalculator() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Now, let's get started, enter a number to be calculated: ");
            Long value1 = scanner.nextLong();

            System.out.println("Enter another number: ");
            Long value2 = scanner.nextLong();

            calculatorUtils.validateInput(value1, value2);

            while (true) {
                System.out.println("\nCalulator Menu: ");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("0. Exit");

                System.out.print("Choose the desired operation: ");
                int choice = scanner.nextInt();

                double result;

                switch (choice) {
                    case 1:
                        result = calculatorService.add(value1, value2);
                        break;
                    case 2:
                        result = calculatorService.subtract(value1, value2);
                        break;
                    case 3:
                        result = calculatorService.multiply(value1, value2);
                        break;
                    case 4:
                        result = calculatorService.divide(value1, value2);
                        break;
                    case 0:
                        System.out.println("Closing the program. Thanks!");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                        continue;
                }

                System.out.println("Result: " + result);
            }
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numbers.");
            scanner.nextLine();
        }
    }

    public User getUserInformation(User userStatus) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your name: ");
        userStatus.setName(scanner.nextLine());

        System.out.println("Your profession: ");
        userStatus.setProfession(scanner.nextLine());

        System.out.println("Your age: ");
        userStatus.setAge(scanner.nextInt());

        return userStatus;
    }

}