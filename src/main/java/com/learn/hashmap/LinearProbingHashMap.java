package com.learn.hashmap;

class LinearProbingHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public LinearProbingHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    static class Entry<K, V> {
        K key;
        V value;
        boolean isDeleted;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        if (size >= LOAD_FACTOR * table.length) {
            resize();
        }
        int index = hash(key);
        while (table[index] != null && !table[index].isDeleted) {
            if (table[index].key.equals(key)) {
                table[index].value = value; // Update existing key
                return;
            }
            index = (index + 1) % table.length; // Linear probing
        }
        table[index] = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
        }
        return null; // Key not found
    }

    public void delete(K key) {
        int index = hash(key);
        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                table[index].isDeleted = true;
                size--;
                return;
            }
            index = (index + 1) % table.length;
        }
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        @SuppressWarnings("unchecked")
        Entry<K, V>[] newTable = new Entry[oldTable.length * 2];
        table = newTable;
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null && !entry.isDeleted) {
                put(entry.key, entry.value);
            }
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        //S -> 0 , E -> 10 , A -> 2, R -> 3, C -> 4 , H -> 5, E -> 6, X -> 7, A -> 8 , M  -> 9 , p -> 10, L -> 11 , E -> 12
        LinearProbingHashMap<String, Integer> linearProbingHashMap = new LinearProbingHashMap<>();
        linearProbingHashMap.put("S", 0);
        linearProbingHashMap.put("E", 10);
        linearProbingHashMap.put("A", 2);
        linearProbingHashMap.put("R", 3);
        linearProbingHashMap.put("C", 4);
        linearProbingHashMap.put("H", 5);
        linearProbingHashMap.put("E", 6);
        linearProbingHashMap.put("X", 7);
        linearProbingHashMap.put("A", 8);
    }
}
