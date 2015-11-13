/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwissArmy;

import java.util.Random;

/**
 *
 * @author elie
 */
public class Shuffle {
    public static void shuffle(Comparable[] toShuffle){
        Random rnd = new Random();
        int len = toShuffle.length;
        for(int i = 0; i < len; i++){
            swap(toShuffle, i, rnd.nextInt(len));
        }
    }
    
    private static void swap(Comparable[] array, int index1, int index2){
        Comparable temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
