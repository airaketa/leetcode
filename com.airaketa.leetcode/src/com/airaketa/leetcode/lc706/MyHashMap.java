package com.airaketa.leetcode.lc706;

/**
 * https://leetcode.com/problems/design-hashmap/
 */
class MyHashMap {
    private final Integer[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new Integer[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Integer value = map[key];
        return value == null ? -1 : value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */