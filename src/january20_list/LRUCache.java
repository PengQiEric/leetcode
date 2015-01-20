package january20_list;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author PAUL QI
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * 			  otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * 					 When the cache reached its capacity, 
 *                   it should invalidate the least recently used item before inserting a new item.
 */

// better to use a double linked list, and the map will be key DoubleLinkedNode
// operation: setHead, remove( for remove O(1) because of double linked)

public class LRUCache {
	private int capacity;
	private HashMap<Integer, Integer> cache;
	private int count;
	private int date;
	private Queue<Element> queue;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Integer>();
        this.date = 0;
        this.count = 0;
        this.queue = new PriorityQueue<LRUCache.Element>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
        	queue.remove(new Element(key,date));
        	queue.add(new Element(key,date++));
        	return cache.get(key);
        }
        else{
        	return -1;
        }
    }
    
    public void set(int key, int value) {
        if(!cache.containsKey(key)){
        	if(count>=capacity){
        		Element least = queue.poll();
        		cache.remove(least.key);
        		count--;
        	}
        	cache.put(key,value);
        	queue.add(new Element(key,date++));
        	count++;
        }
        else{
        	cache.put(key, value);
        	queue.remove(new Element(key,date));
        	queue.add(new Element(key,date++));
        }
    }
    
    private class Element implements Comparable<Element>{
    	int key;
    	int time;
    	public Element(int value, int time){
    		this.key = value;
    		this.time = time;
    	}
		@Override
		public int compareTo(Element o) {
			return this.time - o.time;
		}
		@Override
		public boolean equals(Object o){
			if(o == null || o.getClass()!=this.getClass()){
				return false;
			}
			else if(this.key == ((Element)o).key){
				return true;
			}
			return false;
		}
		@Override
		public int hashCode(){
			return key;
		}
    }
    
    public static void main(String[] args){
    	LRUCache test = new LRUCache(2);
    	test.set(2, 2);
    	test.set(2,-1);
    	System.out.println(test.get(2));
    	test.set(4,1);
    	test.set(3, -1);
    	System.out.println(test.get(2));
    	
    }
}
