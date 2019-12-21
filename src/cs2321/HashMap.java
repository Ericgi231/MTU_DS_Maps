package cs2321;

import net.datastructures.*;

public class HashMap<K, V> extends AbstractMap<K,V> implements Map<K, V> {
	
	//vars
	//
	private UnorderedMap<K,V>[] table;
	int 	size;  // number of mappings(entries) 
	int 	capacity; // The size of the hash table. 
	int     DefaultCapacity = 17; //The default hash table size
	double  loadfactor= 0.75;  
	
	//constructors
	//
	
	//instantiate with given capacity
	public HashMap(int hashtablesize) {
		instantiate(hashtablesize);
	}
	
	//instantiate with default capacity
	public HashMap() {
		instantiate(DefaultCapacity);
	}
	
	//utility
	//
	
	//instantiate class object
	private void instantiate(int hashtablesize) {
		capacity = hashtablesize;
		size = 0;
		createTable();
	}
	
	//instantiates table as an array of UnorderedMap
	@SuppressWarnings("unchecked")
	private void createTable() {
		table = (UnorderedMap<K,V>[]) new UnorderedMap[capacity];
	}
	
	//returns hash of key
	private int hashValue(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}
	
	private void resize(int cap) {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size+1);
		for(Entry<K,V> e : entrySet()) {
			buffer.addLast(e);
		}
		capacity = cap;
		createTable();
		size = 0;
		for(Entry<K,V> e : buffer) {
			put(e.getKey(),e.getValue());
		}
	}
	
	//functions
	//
	
	//return total length of array 
	@TimeComplexity("O(1)")
	public int tableSize() {
		return table.length;
	}
	
	//return number of elements in map
	@Override
	@TimeComplexity("O(1)")
	public int size() {
		return size;
	}

	//returns true if map is empty
	@Override
	@TimeComplexity("O(1)")
	public boolean isEmpty() {
		return size() == 0;
	}

	//return value associated with given key or null if no entry found
	@Override
	@TimeComplexity("O(n)")
	@TimeComplexityExpected("O(1)")
	public V get(K key) {
		//worst case there are multiple entries in the bucket and the entry needed is the last one
		//in this case the findIndex function will loop through all n values in the bucket
		//the most likely situation is that a bucket has one value in it meaning findIndex only loops through one value
		//in the most likely case you would expect O(1)
		
		UnorderedMap<K,V> bucket = table[hashValue(key)];
		if (bucket == null) {
			return null;
		}
		return bucket.get(key);
	}

	//adds entry to hash map, returns value of entry overridden or null if new insertion
	@Override
	@TimeComplexity("O(n)")
	@TimeComplexityExpected("O(1)")
	public V put(K key, V value) {
		//worst case there are multiple entries in the bucket and the entry needed is the last one
		//in this case the findIndex function will loop through all n values in the bucket
		//the most likely situation is that a bucket has one value in it meaning findIndex only loops through one value
		//in the most likely case you would expect O(1)
		
		int hash = hashValue(key);
		UnorderedMap<K,V> bucket = table[hash];
		if (bucket == null) {
			bucket = table[hash] = new UnorderedMap<>();
		}
		int oldSize = bucket.size();
		V answer = bucket.put(key, value);
		size += (bucket.size() - oldSize);
		if(size > capacity * loadfactor) {
			resize(2 * capacity - 1);
		}
		return answer;
	}

	//removes entry from hash map, then return value of removed entry or null if no entry found
	@Override
	@TimeComplexity("O(n)")
	@TimeComplexityExpected("O(1)")
	public V remove(K key) {
		//worst case there are multiple entries in the bucket and the entry needed is the last one
		//in this case the findIndex function will loop through all n values in the bucket
		//the most likely situation is that a bucket has one value in it meaning findIndex only loops through one value
		//in the most likely case you would expect O(1)
		
		int hash = hashValue(key);
		UnorderedMap<K,V> bucket = table[hash];
		if (bucket == null) {
			return null;
		}
		int oldSize = bucket.size();
		V answer = bucket.remove(key);
		size -= (oldSize - bucket.size());
		return answer;
	}

	//returns iterable collection of entries in map
	@Override
	@TimeComplexity("O(n)")
	public Iterable<Entry<K, V>> entrySet() {
		//loops through all n values in the map
		
		ArrayList<Entry<K,V>> buffer = new ArrayList<>();
		for(int n = 0; n < capacity; n++) {
			if(table[n] != null) {
				for(Entry<K,V> entry : table[n].entrySet()) {
					buffer.addLast(entry);
				}
			}
		}
		return buffer;
	}
	

}
