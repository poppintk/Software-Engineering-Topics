package trie;

import java.util.Arrays;

public class Trie {
    private TrieNode root; //Root Node

    Trie(){
        root = new TrieNode();
    }
    //Function to get the index of a character 'x'
    public int getIndex(char x) {
        return x - 'a';  // the index is based on the position of character in alphabets
    }

    //Function to insert a key in the Trie
    public void insert(String key) {
        if(key == null){
            System.out.println("Null Key can not be Inserted!");
            return;
        }
        key = key.toLowerCase(); //Keys are stored in lowercase
        TrieNode currentNode = this.root;
        int index = 0; //to store character index

        //Iterate the Trie with given character index,
        //If it is null, then simply create a TrieNode and go down a level
        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if(currentNode.getChildren()[index] == null) {
                currentNode.getChildren()[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        //Mark the end character as leaf node
        currentNode.setEndNode();
    }


    public boolean search(String key) {

        if (key == null) return false; //Null Key

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;

        //Iterate the Trie with given character index,
        //If it is null at any point then we stop and return false
        //We will return true only if we reach leafNode and have traversed the
        //Trie based on the length of the key

        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }
        if (currentNode.isEndNode()) return true;

        return false;
    }

    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level)
    {
        boolean deletedSelf = false;

        if (currentNode == null){
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length){
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (currentNode.hasNoChildren()){
                currentNode = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else {
                currentNode.unsetEndNode();
                deletedSelf = false;
            }
        }
        else {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted) {
                //Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;

                if (currentNode.hasNoChildren() && !currentNode.isEndNode()){
                    currentNode = null;
                    deletedSelf = true;
                }
            }
        }
        return deletedSelf;
    }

    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }


    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie trie = new Trie();

        System.out.println("Keys to insert: "+ Arrays.toString(keys) + "\n");

        // Construct trie
        for (int i = 0; i < keys.length ; i++) {
            trie.insert(keys[i]);
            System.out.println("\""+ keys[i]+ "\"" + "Inserted.");
        }


        System.out.println("----------------------");


        // Search for different keys
        if(trie.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(trie.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(trie.search("abc") == true)
            System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);

        System.out.println("--------------------------------");
                // Search for different keys and delete if found
        if(trie.search("the") == true) {
            System.out.println("the --- " + output[1]);
            trie.delete("the");
            System.out.println("Deleted key \"the\"");
        }
        else System.out.println("the --- " + output[0]);

        if(trie.search("these") == true) {
            System.out.println("these --- " + output[1]);
            trie.delete("these");
            System.out.println("Deleted key \"these\"");
        }
        else System.out.println("these --- " + output[0]);

        if(trie.search("abc") == true) {
            System.out.println("abc --- " + output[1]);
            trie.delete("abc");
            System.out.println(trie.search("abc"));
            System.out.println("Deleted key \"abc\"");
        }
        else System.out.println("abc --- " + output[0]);

        // check if the string has deleted correctly or still present
        if(trie.search("abc") == true)
            System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);

        System.out.println(trie);
    }
}
