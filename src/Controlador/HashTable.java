
package Controlador;

import java.util.LinkedList;

public class HashTable {
    
    private class Entry {
         String key;
        int value;
        Entry next;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private LinkedList<Entry>[] table;
    private int size;

    public HashTable(int size) 
    {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    int hash(String key) 
    {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash = (hash * 31 + c) % size;
        }
        return hash;
    }

    public void put(String key, int value) 
    {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry(key, value));
    }

    public Integer get(String key) 
    {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    
}
