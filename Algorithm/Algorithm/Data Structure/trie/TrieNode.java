package trie;

import java.util.Arrays;

public class TrieNode {

    TrieNode[] children;

    boolean isEndNode;

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean hasNoChildren(){
        return children.length == 0;
    }


    public boolean isEndNode() {
        return isEndNode;
    }

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndNode = false;
    }

    void setEndNode(){
        this.isEndNode = true;
    }

    void unsetEndNode(){
        this.isEndNode = false;
    }

}
