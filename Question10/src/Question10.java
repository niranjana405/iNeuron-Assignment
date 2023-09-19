import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read integers from the user and store in a List
        List<Integer> numbers = new ArrayList<>();
        System.out.print("Enter integers (enter a non-integer to stop): ");
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        // Find the second largest and second smallest elements
        if (numbers.size() < 2) {
            System.out.println("At least two integers are required.");
        } else {
            Collections.sort(numbers);
            int secondSmallest = numbers.get(1);
            int secondLargest = numbers.get(numbers.size() - 2);

            System.out.println("Second Smallest Element: " + secondSmallest);
            System.out.println("Second Largest Element: " + secondLargest);
        }

        scanner.close();
    }
}
