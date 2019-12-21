package cs2321;

/* 
 * This implements the mapping of one key to multiple values. 
 */

public class HashMultiMap <K, V> {
	
	/* use the the the following hash table for the underlying storage
	 * THe multiple values for a key is represented by a doubly linked list.
	 */
	HashMap<K, DoublyLinkedList<V>> data;
	
	public HashMultiMap() {
		// TODO Auto-generated method stub
		
	}
	
	/* 
	 * return how many entries in the map 
	 */
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/* 
	 * Returns a collection of all values associated with key k in the map.
	 * Don't return null, but return a collection that hold no data.     
	 */
	public Iterable<V> get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	 * Adds a new entry to the multimap associating key k with value v, 
	 * without overwriting any existing mappings for key k.
	 */
	public void put(K key, V value) {
		// TODO Auto-generated method stub

	}


	/*
	 * Removes an entry mapping key k to value v from the multimap. 
	 * return true if such entry exists, otherwise return false 
	 */
	public boolean remove(K key, V value) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Removes all entries having key equal to k from the multimap. 
	 * return an empty list if no entry matched the given key. Don't return null. 
	 */
	public Iterable<V> removeAll(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Returns a non-duplicative collection of keys in the multimap. 
	 * return an empty list if there is no key. Don't return null. 
	 */
	public Iterable<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * Returns a collection of values for all entries int the multimap 
	 * return an empty list if there is entry. Don't return null. 
	 */
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
