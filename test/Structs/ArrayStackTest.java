/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structs;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 *
 * @author elie
 */
public class ArrayStackTest {
    public ArrayStackTest(){
        // any initialization code needed here
    }
    
    @Test
    public void isEmptyTest(){
        ArrayStack stack = new ArrayStack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
    
    @Test
    public void popTest(){
        int expected = 10;
        ArrayStack stack = new ArrayStack<Integer>();
        stack.push(expected);
        assertEquals(expected, stack.pop());
    }
    
    /**
     * Default size is 10 so will try to push 11 elements and see if it breaks.
     */
    @Test
    public void resizeTest(){
        ArrayStack stack = new ArrayStack<String>();
        int counter = 0;
        while(counter++ < 12){
            stack.push(Integer.toString(counter));
        }
        assertEquals(Integer.toString(counter - 1), stack.pop());
    }
    
    /**
     * Try to see if we can add a lot of elements and break the stack through the resizing
     */
    @Test
    public void manyResizesTest(){
        int elementsToAdd = 1000;
        ArrayStack stack = new ArrayStack<Integer>();
        for(int i = 0; i < elementsToAdd; i++){
            stack.push(i);
        }
        assertEquals(elementsToAdd - 1, stack.pop());
    }
    
}
