/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structs;

/**
 *
 * @author elie
 */
public class ArrayStack<Type>{
    private Type[] stack;
    private int stackTop; // ie. where the next item will go
    /**
     * Constructor for ArracyStack.  Initially creates array of 10 elements.
     */
    public ArrayStack(){
        stack = (Type[]) new Object[10];
        stackTop = 0;
    }
    
    public void push(Type elem){
        // if full, add more space to array
        if(stackTop == stack.length) 
            resize();
        // add the element at the next free space
        stack[stackTop++] = elem;
    }
    
    public Type pop(){
        Type poppedElement = stack[--stackTop];
        stack[stackTop] = null;
        return poppedElement;
    }
    public boolean isEmpty(){
        return stackTop == 0;
    }
    
    /**
     * Increase size by 50% each time.
     */
    public void resize(){
        // make a new array that has space
        Type[] resizedArray = (Type[]) new Object[stackTop + stackTop / 2];
        // copy all the elements over
        for(int i = 0; i < stackTop; i++)
            resizedArray[i] = stack[i];
        // clean up the old array
        stack = resizedArray;
    }
}
