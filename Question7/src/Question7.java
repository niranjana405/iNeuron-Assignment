import java.util.Scanner;

public class Question7 {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Target value found at index: " + result);
        } else {
            System.out.println("Target value not found in the array.");
        }
    }
}
