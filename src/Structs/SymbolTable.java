/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structs;

/**
 * Implementation of a symbol table API using a binary tree as the underlying
 * data structure.
 * @author elie
 */
public class SymbolTable<Key extends Comparable<Key>, Value>{
    private Node root;
    
    public SymbolTable(){
        // nothing required to initialize it
    }
    
    public void put(Key key, Value value){
        root = put(root, key, value);
    }
    
    private Node put(Node current, Key key, Value value){
        // if we are at a null node, we want to insert the new node there
        if(current == null){
            return new Node(key, value);
        }
        // compare the key and the current node's key to see where we should go next
        int cmp = key.compareTo(current.key);
        // case 1 : key exists and we are visiting that node
        if(cmp == 0){
            current.value = value;
        }
        // case 2 : key is less than the current node's key
        else if(cmp < 0){
            current.leftChild = put(current.leftChild, key, value);
        }
        // case 3 : key is greater than the current node's key
        else {
            current.rightChild = put(current.rightChild, key, value);
        }
        return current;
    }
   
    
    /**
     * Returns the stored value in the symbol table for that given key.  If the
     * key is not present, returns null;
     * @param key
     * @return 
     */
    public Value get(Key key){
        Node current = root;
        while(current != null){
            int cmp = key.compareTo(current.key);
            // case 1 : we found what we are looking for
            if(cmp == 0){
                return current.value;
            }
            // case 2 : the key is less than the current node's key
            else if(cmp < 0){
                current = current.leftChild;
            }
            // case 3 : the key is greater than the current node's key
            else {
                current = current.rightChild;
            }
        }
        // we got to a null link and couldn't find the key
        return null;
    }
    
    public boolean contains(Key key){
        return true;
    }
    
    public void delete(Key key){
        return ;
    }
    /** TO IMPLEMENT
    public Iterator<Key> getKeys(){
        return null;
    }*/
    
    public boolean isEmpty(){
        return root == null;
    }
        
    private class Node{
        private Key key;
        private Value value;
        private Node leftChild, rightChild;
        
        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }
}
