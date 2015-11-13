/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structs;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/**
 *
 * @author elie
 */
public class SymbolTableTest {
    @Test
    public void testInit(){
        System.out.println("@Test - testInit - testing creation of a symbol table object");
        SymbolTable st = new SymbolTable<String, Integer>();
    }
    
    @Test
    public void testPut(){
        System.out.println("@Test - testPut - adding an element to the symbol table");
        SymbolTable<String,Integer> st = new SymbolTable<String, Integer>();
        String key = "key";
        Integer value = 10;
        st.put(key, value);
        assertTrue(value.equals(st.get(key)));
    }
    
    @Test
    public void testAFewPuts(){
        System.out.println("@Test - testAFewPuts - adding a few elements to the symbol table");
        SymbolTable<String,Integer> st = new SymbolTable<String, Integer>();
        String[] keys = {"one", "two", "three", "four"};
        Integer[] values = {1, 2, 3, 4};
        
        for(int i = 0; i < keys.length; i++){
            st.put(keys[i], values[i]);
        }
        
        // let's check we've got them all and with the correct values
        for(int i = 0; i < keys.length; i++){
            assertTrue(values[i].equals(st.get(keys[i])));
        }
    }
    
    @Test
    public void testManyPuts(){
        System.out.println("@Test - testManyPuts - adding many elements to the symbol table");
        SymbolTable<Integer,String> st = new SymbolTable<Integer, String>();
        Integer[] keys = new Integer[100];
        String[] values = new String[100];
        
        Random random = new Random();
        
        for(int i = 0; i < keys.length; i++){
            keys[i] = random.nextInt();
            values[i] = new Double(random.nextDouble()).toString();
        }
        
        for(int i = 0; i < keys.length; i++){
            st.put(keys[i], values[i]);
        }
        
        // let's check we've got them all and with the correct values
        for(int i = 0; i < keys.length; i++){
            assertTrue(values[i].equals(st.get(keys[i])));
        }
    }
    
    @Test
    public void testIsEmpty(){
        System.out.println("@Test - testIsEmpty - verifying that isEmpty() works");
        SymbolTable<String, String> st = new SymbolTable<String, String>();
        assertTrue(st.isEmpty());
        st.put("single", "element");
        assertFalse(st.isEmpty());
    }
}
