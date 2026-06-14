// === Task: Implement basic binary search in Java. ===

import java.util.Scanner;

public class Main{
    // Shared Scanner used to read all user input from the terminal.
    static Scanner input = new Scanner(System.in);

    // Values collected from the user before starting the binary search.
    static int target;
    static int arrLength = 1;
    static int maxValue = 1;

    static void askUserBinarySearch(){
        // Keep asking until the user provides a positive array length.
        do {
            System.out.print("Enter the length of the number list: ");
            arrLength = input.nextInt();

            if(arrLength <= 0) {
                System.out.println("Invalid length! Must be greater than 0!");
            }
        } while(arrLength <= 0);

        // Keep asking until the user provides a positive maximum value.
        do {
            System.out.print("Enter the maximum possible value inside the list: ");
            maxValue = input.nextInt();

            if(maxValue <= 0) {
                System.out.println("Invalid maximum value! Must be greater than 0!");
            }
        } while(maxValue <= 0);

        // Keep asking until the target is inside the generated number range.
        do {
            System.out.printf("Enter the target you are searching for in the list of numbers (0-%d): ", maxValue);
            target = input.nextInt();

            if(target < 0 || target > maxValue) {
                System.out.printf("Invalid target! Must be between 0 and %d!\n", maxValue);
            }
        } while(target < 0 || target > maxValue);
    }


    public static void main(String[] args){
        // Collect all search settings from the user before running the algorithm.
        askUserBinarySearch();

        // Run binary search using the length, target, and maximum value provided by the user.
        Algorithms.binarySearch(arrLength, target, maxValue);
    }
}
