import java.util.ArrayList;
import java.util.List;

/**
 * Max Heap for integers
 * parent is always bigger than children
 * 
 * @author me:)
 */
public class MaxHeap {
    private List<Integer> heap;
    
    // empty heap constructor
    public MaxHeap() {
        heap = new ArrayList<>();
    }
    
    /**
     * makes heap from array
     * @param array input array
     */
    public MaxHeap(int[] array) {
        heap = new ArrayList<>();
        for (int value : array) {
            heap.add(value);
        }
        buildHeap();
    }
    
    // get size
    public int size() {
        return heap.size();
    }
    
    // check if empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    /**
     * add new element
     * @param value number to add
     */
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1); // fix heap property
    }
    
    /**
     * get and remove max element
     * @return max value
     */
    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        
        int max = heap.get(0); // root is always max
        int last = heap.remove(heap.size() - 1);
        
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0); // fix heap
        }
        
        return max;
    }
    
    // just look at max without removing
    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }
    
    // convert to array
    public int[] toArray() {
        int[] arr = new int[heap.size()];
        for (int i = 0; i < heap.size(); i++) {
            arr[i] = heap.get(i);
        }
        return arr;
    }
    
    // move element up if needed
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = getParentIndex(index);
            if (heap.get(index) <= heap.get(parent)) {
                break; // already in right place
            }
            swap(index, parent);
            index = parent;
        }
    }
    
    // move element down if needed
    private void heapifyDown(int index) {
        while (true) {
            int left = getLeftChildIndex(index);
            int right = getRightChildIndex(index);
            int largest = index;
            
            // check left child
            if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                largest = left;
            }
            
            // check right child
            if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                largest = right;
            }
            
            if (largest == index) {
                break; // done
            }
            
            swap(index, largest);
            index = largest;
        }
    }
    
    // build heap from array
    private void buildHeap() {
        // start from last non-leaf node
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }
    
    // helper methods for indexes
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }
    
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }
    
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }
    
    // swap two elements
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
