package Sort;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Sort.IterMergesort;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 *
 * @author elie
 */
public class IterMergesortTest {
    
    public IterMergesortTest() {
    }

    /**
     * Test of sort method, of class IterMergesort.
     */
    @Test
    public void testSort() {
        System.out.println("Sorting with integers");
        Comparable[] arrayActual = {10, 8, 6, 3, 7, 9};
        Comparable[] arrayExpected = {3, 6, 7, 8, 9, 10};
        IterMergesort.sort(arrayActual);
        System.out.printf("Results:%s\n", Arrays.toString(arrayActual));
        assertArrayEquals(arrayExpected, arrayActual);
    }
        /**
     * Test of sort method, of class IterMergesort.
     */
    @Test
    public void testStringAlreadySort() {
        System.out.println("Sorting with strings(already sorted)");
        Comparable[] arrayActual = {"a", "b", "c", "d", "e", "f"};
        Comparable[] arrayExpected = {"a", "b", "c", "d", "e", "f"};
        IterMergesort.sort(arrayActual);
        System.out.printf("Results:%s\n", Arrays.toString(arrayActual));
        assertArrayEquals(arrayExpected, arrayActual);
    }
            /**
     * Test of sort method, of class IterMergesort.
     */
    @Test
    public void testStringNotSort() {
        System.out.println("Sorting with strings(shuffled)");
        Comparable[] arrayActual = {"b", "c", "f", "d", "e", "a"};
        Comparable[] arrayExpected = {"a", "b", "c", "d", "e", "f"};
        IterMergesort.sort(arrayActual);
        System.out.printf("Results:%s\n", Arrays.toString(arrayActual));
        assertArrayEquals(arrayExpected, arrayActual);
    }
    
    @Test
    public void testStringOddNumElementsSort() {
        System.out.println("Sorting with strings(odd number of elements)");
        Comparable[] arrayActual = {"b", "c", "f", "d", "e"};
        Comparable[] arrayExpected = {"b", "c", "d", "e", "f"};
        IterMergesort.sort(arrayActual);
        System.out.printf("Results:%s\n", Arrays.toString(arrayActual));
        assertArrayEquals(arrayExpected, arrayActual);
    }
    
    @Test
    public void testIntOneElementSort() {
        System.out.println("Sorting with one integer");
        Comparable[] arrayActual = {10};
        Comparable[] arrayExpected = {10};
        IterMergesort.sort(arrayActual);
        System.out.printf("Results:%s\n", Arrays.toString(arrayActual));
        assertArrayEquals(arrayExpected, arrayActual);
    }
    
    
}
