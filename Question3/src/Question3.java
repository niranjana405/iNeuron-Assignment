import java.util.Scanner;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        try {
            System.out.print("Enter a number : ");
            int number = scanner.nextInt();

            if (number < 0) {
                throw new NegativeNumberException("Negative number entered!");
            }

            System.out.println("You entered positive number: " + number);
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
