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
public class IterMergesort extends AbstractSort{
    private static void merge(Comparable[] array, Comparable[] temp, 
            int lo, int mid, int hi){
        // copy over entries to the temporary array
        for(int i = lo; i <= hi; i++){
            temp[i] = array[i];
        }
        // initialize the pointers we need for the merging algorithm
        int Lpoint = lo; int Rpoint = mid + 1;
        
        // perform the merge
        for(int i = lo; i <= hi; i++){
            // case 1 : right pointer is exhausted
            if(Lpoint > mid){ array[i] = temp[Rpoint++];}
            // case 2 : left pointer is exhausted
            else if(Rpoint > hi){ array[i] = temp[Lpoint++];}
            // case 3 : left element less than right element
            else if(less(temp[Lpoint], temp[Rpoint])){ array[i] = temp[Lpoint++];}
            // case 4 : left element greater or equal to right element
            else{ array[i] = temp[Rpoint++];}
        }
    }
    public static void sort(Comparable[] array){
        int len = array.length;
        Comparable[] temp = new Comparable[len];
        int startSize = 1;
        //iteratively increase the size of the offset we are merging
        for(int size = startSize; size < len; size = size + size){
            // perform the merge on the discrete sets of elements
            for(int lo = 0; lo < len - size; lo += size + size){
                    int mid = lo + size - 1;
                    int hi = lo + size + size - 1;
                    merge(array, temp, lo, mid , Math.min(hi, len - 1));
            }
        }
    }
}
