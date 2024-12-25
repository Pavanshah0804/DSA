import java.util.*;

class Trie{
    public static class Node{
        //Array to store links to child node
        //each index represent letter
        Node []links = new Node[26];
        
        //flag for end of word
        boolean flag = false;
        
        //check if node contains specific key
        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }
        
        //Insert new node with specific key 
        void put(char ch, Node node){
            links[ch-'a'] = node;
        }
        
        //Get node with specific key from trie
        Node get(char ch){
            return links[ch-'a'];
        }
        
        //Set current node as eod of word
        void setEnd(){
            flag = true;
        }
        
        boolean isEnd(){
            return flag;
        }
        
    }
    
    private Node root;
    //Constructor
    public Trie(){
        root = new Node();
    }
    
    public void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                //create node if not present
                node.put(word.charAt(i),new Node());
            }
            //move to next Node
            node = node.get(word.charAt(i));
        }
        node.setEnd(); // mark end of word
    }
    
    public boolean search(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        //check if last node marks the end of word
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix){
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            //move to next node
            node = node.get(prefix.charAt(i));
        }
        //prefix is found in trie
        return true;
    }
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Inserting words: pavan, pawan, pavamcana, pavanabhaya");
        trie.insert("pavan");
        trie.insert("pawan");
        trie.insert("pavamcana");
        trie.insert("pavanabhaya");

        System.out.println("Search if pavani exists in trie: " +
                (trie.search("pavani") ? "True" : "False"));

        System.out.println("Search if pavan exists in trie: " +
                (trie.search("pavan") ? "True" : "False"));

        System.out.println("If words in Trie start with pav: " +
                (trie.startsWith("pav") ? "True" : "False"));
    }
}
