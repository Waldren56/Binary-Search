import java.util.Arrays;
import java.util.Random;

public class Algorithms {
    // ANSI color codes used to make terminal output easier to read.
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";

    public static void binarySearch(int arrLength, int target, int maxValue){
        // Random is used to fill the array with generated numbers.
        Random rand = new Random();

        // Create an array with the length selected by the user.
        int[] arr = new int[arrLength];

        // left and right mark the current search area inside the sorted array.
        int left = 0, right = arrLength-1, mid;

        // Fill the array with random numbers from 0 to maxValue.
        for(int i = 0; i < arr.length; i++){

            arr[i] = rand.nextInt(maxValue + 1);
        }

        // Binary search only works correctly on a sorted array.
        Arrays.sort(arr);

        // Start from the middle of the array.
        mid = arr.length/2;

        // Keep searching while the current search area is valid.
        while(left <= right){

            // If the target is greater than the middle value, search the right half.
            if(target > arr[mid]){
                left = mid + 1;
                mid = (left + right)/2;

            // If the target is smaller than the middle value, search the left half.
            } else if(target < arr[mid]){
                right = mid - 1;
                mid = (left + right)/2;

            // If neither condition is true, the target matches the middle value.
            } else{
                System.out.printf("%sTarget was successfully found at index: %d!%s\n", GREEN, mid, RESET);
                return;
            }
        }

        // If the loop ends, the target does not exist in the generated array.
        System.err.println("The target was not found");
    }
}
