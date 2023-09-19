import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question6 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3, 9, 4, 6, 7);

        // Sorting the numbers
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted Numbers: " + sortedNumbers);

        // Filtering even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evenNumbers);
    }
}
