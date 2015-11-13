/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import SwissArmy.Shuffle;

/**
 *
 * @author elie
 */
public class Quicksort extends AbstractSort{
    private static int partition(Comparable[] array, int start, int end){
        // element that will serve as our partition
        int par = start;

        // Starting and ending pointers 
        int Lpoint = start + 1; 
        int Rpoint = end;
        
        while(true){          
            // increment Lpoint while that value of that index < partition element
            while(Lpoint < end && less(array[Lpoint],array[par])){
                Lpoint++;
            }
            
            // decrement Rpoint while that value of that index > partition element
            while(Rpoint > par && less(array[par], array[Rpoint])){
                Rpoint--;
            }
            
            // if the Lpoint is stopped past the Rpoint, we have a situation where
            // Lpoint > partition and Rpoint < partition
            if(Lpoint >= Rpoint)
                break;
            
            // Exchange the two to put them on the correct side of the future partition
            exch(array, Lpoint, Rpoint);
        }
        
        // exchange the Rpoint and par elements so that all elements left of
        // par will be < par and all elements right of par will be > par
        exch(array, par, Rpoint);
        return Rpoint;
    }
    
    public static void sort(Comparable[] array){
        Shuffle.shuffle(array);
        quicksort(array, 0, array.length-1);
    }
    
    private static void quicksort(Comparable[] array, int start, int end){
        // return if the partition is too small
        if(end <= start){ return;}
        int par = partition(array, start, end);
        quicksort(array, start, par - 1);
        quicksort(array, par + 1, end);
    }
}
