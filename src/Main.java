import java.util.Random;
import java.util.Arrays;

/**
 * Main to present the functions
 * demo
 */

public class Main {

    /**
     * main method
     * @param args size of array (optional)
     */
    public static void main(String[] args) {
        int size = 20;

        // get size from args if given
        if (args.length > 0) {
            try {
                size = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid size, using default: " + size);
            }
        }

        // make random array
        int[] randomArray = generateRandomIntegers(size);
        System.out.println("Generated array of size " + size + ":");
        printArray(randomArray);

        // copy for sorting
        int[] arrayToSort = Arrays.copyOf(randomArray, randomArray.length);

        // sort it
        System.out.println("Sorting using Heap Sort...");
        HeapSort.sort(arrayToSort);

        System.out.println("Sorted array:");
        printArray(arrayToSort);

        // check if sorted
        if (isSorted(arrayToSort)) {
            System.out.println("Array is correctly sorted!");
        } else {
            System.out.println("Array is NOT sorted correctly!");
        }

        // test heap
        System.out.println("Heap check");
        demonstrateMaxHeap();


       // is it stable?
        // heap sort is unstable because it performs long distance swaps so it's not
        // (because of the heapify procces)

    }

    /**
     * makes random array
     * @param size how many numbers
     * @return random array
     */
    public static int[] generateRandomIntegers(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }

        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(101); // 0 to 100
        }

        return arr;
    }

    // print array
    private static void printArray(int[] array) {
        if (array.length <= 20) {
            System.out.println(Arrays.toString(array));
        } else {
            // just show first and last few for big arrays
            System.out.print("[");
            for (int i = 0; i < 10; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print("... ");
            for (int i = array.length - 10; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    // check if sorted
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // test heap
    private static void demonstrateMaxHeap() {
        MaxHeap heap = new MaxHeap();

        System.out.println("Inserting: 10, 5, 20, 15, 30");
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);

        System.out.println("Extracting max:");
        while (!heap.isEmpty()) {
            System.out.print(heap.extractMax() + " ");
        }
        System.out.println();
    }


}
