import java.util.Scanner;

// Custom exception class
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class PasswordValidator {

    private static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Password must contain at least one uppercase letter.");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("Password must contain at least one lowercase letter.");
        }

        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit (0-9).");
        }

        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            throw new InvalidPasswordException("Password must contain at least one special character (any non-letter, non-digit character).");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        try {
            validatePassword(password);
            System.out.println("Password is valid.");
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid Password: " + e.getMessage());
        }
    }
}
