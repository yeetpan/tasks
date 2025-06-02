import java.util.Scanner;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class ExceptionAssgmt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // NullPointerException
        try {
            String str = null;
            System.out.println(str.length()); // triggers NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        }

        // NumberFormatException
        try {
            System.out.println("Enter a number:");
            String input = sc.nextLine(); // Read input as String
            int num = Integer.parseInt(input); // Try to parse as int
            System.out.println("You entered: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught a NumberFormatException: " + e.getMessage());
        }

        // IndexOutOfBoundsException
        try {
            String[] lottery = {"1M", "250M", "5M"};
            System.out.println("Enter a number between (0-10) to win Lottery:");
            int ltno = sc.nextInt();
            String prize = lottery[ltno];
            System.out.println("Congrats! You won " + prize);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(" Bad Luck .");
        }

        // CustomException
        try {
            System.out.println("Enter a number (positive only):");
            int n = sc.nextInt();
            if (n < 0) {
                throw new CustomException("No number below 0 allowed.");
            } else {
                System.out.println("Valid input: " + n);
            }
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        }

        sc.close();
    }
}
