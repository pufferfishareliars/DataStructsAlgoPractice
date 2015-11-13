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
public class Selectionsort extends AbstractSort{
    /**
     * Method which sorts an arbitrary array of objects using the Selection sort algorithm.
     * @param array array to be sorted
     */
    public static void sort(Comparable[] array){
        int len = array.length;
        // for each index in the array, find the next smallest value and put it there
        for(int i = 0; i < len; i++){
            int min = i; // start with the index itself
            // second loop to iterate through remaining indexes to find the minimum
            for(int j = i+1; j < len; j++ ){
                if(less(array[j], array[min])){
                    min = j;
                } 
            }
            // put the minimum value into the index we are at
            exch(array, i, min);
            
        }
        
    }
}
