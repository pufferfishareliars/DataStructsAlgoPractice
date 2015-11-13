package Sort;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elie
 */
public class RecursiveMergesort extends AbstractSort{
    private static void merge(Comparable[] array, Comparable[] temp, int lo, 
        int mid, int hi){
        // copy entries to the temporary array
        for(int i = lo; i <= hi; i++){
            temp[i] = array[i];
        }
        
        // initialize the pointers that we need to perform the merge
        int Lpoint = lo; int Rpoint = mid + 1;
        
        // perform the merge
        for(int i = lo; i <= hi; i++){
            // case 1 : entries left of mid are exhausted
            if(Lpoint > mid){ array[i] = temp[Rpoint++]; }
            // case 2 : entries right of mid are exhausted
            else if( Rpoint > hi) { array[i] = temp[Lpoint++]; }
            // case 3 : left value < right value
            else if( less(temp[Lpoint], temp[Rpoint])) { array[i] = temp[Lpoint++]; }
            // case 4 : right value <= left value
            else { array[i] = temp[Rpoint++]; }
        }
    }
    
    public static void sort(Comparable[] array){
        // initialize temporary array for mergesort
        Comparable[] temp = new Comparable[array.length];
        // make first call
        mergesort(array, temp, 0, array.length - 1);
    }
    
    private static void mergesort(Comparable[] array, Comparable[] temp, 
            int lo, int hi){
        // return if we have a single value (hi == lo) or no values (hi < lo)
        if(hi <= lo) return;
        // calculate midpoint to make recursive call using it as high index
        int mid = lo + (hi - lo)/2;
        // divide the left part of the array
        mergesort(array, temp, lo, mid);
        // divide the right part of the array
        mergesort(array, temp, mid + 1, hi);
        // merge the values
        merge(array, temp, lo, mid, hi);
    }
}
