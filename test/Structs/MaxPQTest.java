/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structs;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import SwissArmy.Shuffle;

/**
 *
 * @author elie
 */
public class MaxPQTest {
    @Test
    public void integerAddSingleTest(){
        Integer expected = 10; // needed to use Integer wrapper to make error in assertEquals go away
        MaxPQ<Integer> pq = new MaxPQ<Integer>();
        pq.insert(expected);
        assertEquals(expected, pq.delMax());
    }
    
    @Test
    public void isEmptyTest(){
        MaxPQ<String> pq = new MaxPQ<String>();
        assertTrue(pq.isEmpty());
        pq.insert("first element");
        assertFalse(pq.isEmpty());
    }
    
    @Test
    public void integerAddManyTest(){
        Integer[] ordered = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] shuffled = ordered.clone();
        Shuffle.shuffle(shuffled);
        System.out.printf("Shuffled array to insert: %s\n", Arrays.toString(shuffled));
        
        MaxPQ<Integer> pq = new MaxPQ<Integer>();
        // let's get all the keys in random order
        for(int i = 0; i < shuffled.length; i++){
            pq.insert(shuffled[i]);
        }
        // make sure we are getting it back in the correct order
        for(int i = ordered.length - 1; i >= 0; i--){
            Integer actual = pq.delMax();
            assertEquals(ordered[i], actual);
        }
    }
}
