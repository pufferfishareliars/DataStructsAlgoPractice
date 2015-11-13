package Structs;

/**
 *
 * @author elie
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int initialCapacity = 10;
    private int numberOfElements;
    
    public MaxPQ(){
        pq = (Key[]) new Comparable[initialCapacity + 1]; // keys loaded in starting at index 1 so add one
        numberOfElements = 0;
    }
    
    public void insert(Key key){
        pq[++numberOfElements] = key;
        swim(numberOfElements);
    }
    public Key delMax(){
        // save the maximum element
        Key max = pq[1];
        
        // swap the max element with the last element
        swap(1, numberOfElements--);

        // sink new value it down to where it belongs to restore heap order
        sink(1);
        
        // null out the value to prevent loitering
        pq[numberOfElements + 1] = null;
        
        // return the max value
        return max;
    }
    
    private void swim(int keyIndex){
        // while the parent's key is less than the child's key, swap it up
        while(keyIndex > 1 && less(pq[keyIndex/2], pq[keyIndex])){
            swap(keyIndex/2, keyIndex);
            keyIndex = keyIndex/2;
        }
    }
    
    private void sink(int keyIndex){
        // make sure that it has children to swap it with
        while(keyIndex * 2 <= numberOfElements){
            
            // swap it with the larger of the two children if key > parent
            // setting the pointer to the Left Child which we know is there based on previous guard
            int toSwap = keyIndex * 2;
            
            // check which child is greater (or check if it doesn't have a child)
            if(toSwap < numberOfElements && less(pq[toSwap], pq[toSwap + 1])){
                toSwap++;
            }
            
            // if it's already in the correct place, get out of here
            if(!less(pq[keyIndex], pq[toSwap])) break;
            
            // perform the swap
            swap(toSwap, keyIndex);
            
            // update the index to the new location of that key
            keyIndex = toSwap;
        }
    }
    
    public boolean isEmpty(){
        return numberOfElements == 0;
    }
    
    private boolean less(Comparable first, Comparable second){
        return first.compareTo(second) < 0;
    }
    
    private void swap(int index1, int index2){
        Key temp = pq[index1];
        pq[index1] = pq[index2];
        pq[index2] = temp;
    }
}
