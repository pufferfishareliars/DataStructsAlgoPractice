/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author elie
 */
public abstract class AbstractSort {
    /**
     * Method to determine if a given object is less than another value
     */
    protected static boolean less(Comparable first, Comparable second){
        return first.compareTo(second) < 0;
    }
    
    /**
     * method to swap entries in an array by given indexes 
     */
    protected static void exch(Comparable[] array, int index1, int index2){
        Comparable temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
