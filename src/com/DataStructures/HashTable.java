package com.DataStructures;

import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private int key;
        private String value;
        public Entry(int key,String value){
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] enteries = new LinkedList[5];
    public void put(int key,String value){
        int index = hash(key);
        if(enteries[index] == null)
            enteries[index] = new LinkedList<>();
        for(var entry : enteries[index]){
            if(entry.key == key) {
                entry.value = value;
                return;
            }
        }
        enteries[index].addLast(new Entry(key,value));
    }
    private int hash(int key){
        return key % enteries.length;
    }
    public String get(int key){
        int index = hash(key);
        if(enteries[index] != null) {
            for (var entry : enteries[index]) {
                if (entry.key == key)
                    return entry.value;
            }
        }
        return null;
    }
    public void remove(int key){
        int index = hash(key);
        if(enteries[index] == null)
            throw new IllegalStateException();
        for(Entry entry : enteries[index]){
            if(entry.key == key){
                enteries[index].remove(entry);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
