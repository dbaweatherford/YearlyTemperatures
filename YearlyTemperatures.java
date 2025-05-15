import java.util.Scanner;

public class YearlyTemperatures {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        double[] temperatures = new double[12];

        System.out.println("Enter average temperatures for each month (0 - 999°F):");
        for (int i = 0; i < months.length; i++) {
            double temp;
            while (true) {
                System.out.print("Enter the average temperature for " + months[i] + ": ");
                if (input.hasNextDouble()) {
                    temp = input.nextDouble();
                    if (temp >= 0 && temp <= 999) {
                        temperatures[i] = temp;
                        break;
                    } else {
                        System.out.println("Temperature must be between 0 and 999°F. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    input.next();
                }
            }
        }

        double sum = 0;
        double highest = temperatures[0];
        double lowest = temperatures[0];
        int highIndex = 0;
        int lowIndex = 0;

        System.out.println("\nMonthly Temperatures:");
        for (int i = 0; i < months.length; i++) {
            System.out.printf("%-10s : %.1f°F\n", months[i], temperatures[i]);
            sum += temperatures[i];

            if (temperatures[i] > highest) {
                highest = temperatures[i];
                highIndex = i;
            }

            if (temperatures[i] < lowest) {
                lowest = temperatures[i];
                lowIndex = i;
            }
        }

        double average = sum / months.length;
        System.out.printf("\nYearly Average Temperature: %.1f°F\n", average);
        System.out.printf("Highest Monthly Average: %.1f°F in %s\n", highest, months[highIndex]);
        System.out.printf("Lowest Monthly Average: %.1f°F in %s\n", lowest, months[lowIndex]);

        input.close();
    }
}
