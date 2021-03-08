package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTable {

    private List<Entry> bucket;

    int size;

    int slots;
    
    final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashTable() {
        this.size = 0;
        this.slots = 16; // better be 2^power
        bucket = new ArrayList<>();
        for(int i = 0; i < slots; i++){
            bucket.add(null);
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }


    public int getSize() {
        return size;
    }

    public int hashFunc(String key){
        return key.hashCode() % slots;
    }

    public void insert(String key, int value){
        int index = hashFunc(key);
        Entry head = bucket.get(index);

        //Checks if the key is already exists
        while(head != null) {
            if (head.getKey().equals(key)) {
                // reset value to newest value
                head.setValue(value);
                return;
            }
            head = head.getNext();
        }
        // key not exists


        // insert to the head
        // Inserts key in the chain
        size++;
        head = bucket.get(index);
        Entry newEntry = new Entry(key, value);
        newEntry.setNext(head);
        bucket.set(index, newEntry);

        //Checks if array >= 60% of the array gets filled
        if ((1.0 * size) / slots >= DEFAULT_LOAD_FACTOR) {
            List<Entry> temp = bucket;
            bucket = new ArrayList();
            slots = 2 * slots;
            size = 0;
            for (int i = 0; i < slots; i++)
                bucket.add(null);

            for (Entry headNode : temp) {
                while (headNode != null) {
                    insert(headNode.getKey(), headNode.getValue());
                    headNode = headNode.getNext();
                }
            }
        }

    }

    public Integer getValue(String key) {
        // Find the head of chain
        int index = hashFunc(key);
        Entry head = bucket.get(index);

        // Search key in the slots
        while (head != null) {
            if (head.getKey().equals(key))
                return head.getValue();
            head = head.getNext();
        }

        // If key not found
        return null;
    }



    public Integer delete(String key) {
        //Find index
        int index = hashFunc(key);

        // Get head of the chain for that index
        Entry head = bucket.get(index);

        //Find the key in slots
        Entry prev = null;
        while (head != null) {
            //If key exists
            if (head.getKey().equals(key)){
                // Decrease the size by one
                size--;
                // Remove key
                if (prev != null)
                    prev.setNext(head.getNext());
                else // prev == null -> we on the head
                    bucket.set(index, head.getNext());

                return head.getValue();
            }
            // Else keep moving in chain
            prev = head;
            head = head.getNext();
        }

        // If key does not exist

        return null;


    }


    public static void main(String[] args) {
        HashTable table = new HashTable(); //Create a HashTable
        //Before Insertion
        System.out.println("Table Size = " + table.getSize());
        table.insert("This",1 ); //Key-Value Pair
        table.insert("is",2 );
        table.insert("a",3 );
        table.insert("Test",4 );
        table.insert("Driver",5 );
        System.out.println(table.getValue("is"));
        System.out.println(table.getValue("Test"));
        System.out.println(table.getValue("Driver"));
        System.out.println("Table Size = " + table.getSize());
        // first search the key then delete it in the table
        // see the implementation first
        System.out.println(table.delete("is")+ " : This key is deleted from table");
        System.out.println("Now Size of the table = " + table.getSize() );
        if(table.isEmpty())
            System.out.println("Table is Empty");
        else
            System.out.println("Table is not Empty");

    }

}
