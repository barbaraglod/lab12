/**
 * Heap Sort
 * sorts array using max heap
 *
 */
public class HeapSort {
    
    /**
     * sort array in ascending order
     * @param array array to sort
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // already sorted or empty
        }
        
        buildMaxHeap(array);
        
        // extract max and put at end
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i); // move max to end
            heapify(array, i, 0); // fix heap
        }
    }
    
    // build heap from array
    private static void buildMaxHeap(int[] array) {
        int n = array.length;
        // start from last non-leaf
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
    }
    
    /**
     * maintain heap property
     * @param array the array
     * @param heapSize size of heap
     * @param rootIndex root index
     */
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;
        
        // find largest among root and children
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }
        
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        
        // if largest is not root, swap and continue heaping
        if (largest != rootIndex) {
            swap(array, rootIndex, largest);
            heapify(array, heapSize, largest);
        }
    }
    
    // swap helper
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
