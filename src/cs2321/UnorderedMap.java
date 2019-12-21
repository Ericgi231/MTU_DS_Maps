package cs2321;


import java.util.Iterator;
import java.util.NoSuchElementException;

import net.datastructures.Entry;

public class UnorderedMap<K,V> extends AbstractMap<K,V> {
	
	//vars
	//
	private ArrayList<mapEntry<K,V>> table = new ArrayList<>();
	
	//constructors
	//
	public UnorderedMap() {
		
	}

	//utility
	//
	
	//find index of entry given a K key
	@TimeComplexity("O(n)")
	private int findIndex(K key) {
		//worst case the key is not found in the table, in this case the entire table needs to be looped through
		//this leaves you with O(n)
		
		int n = table.size();
		//loop through all values in table until one is found with a key equal to given key, then return index
		for(int j = 0; j < n; j++) {
			if(table.get(j).getKey().equals(key)) {
				return j;
			}
		}
		
		//return -1 if key is not found in table
		return -1;
	}
	
	//functions
	//
	
	//returns number of elements in map
	@Override
	@TimeComplexity("O(1)")
	public int size() {
		return table.size();
	}

	//return true if map is empty
	@Override
	@TimeComplexity("O(1)")
	public boolean isEmpty() {
		return table.size() == 0;
	}

	//return V linked to given K key, or null if key not found
	@Override
	@TimeComplexity("O(n)")
	public V get(K key) {
		//calls findIndex then does static actions
		//has same complexity as findIndex, O(n)
		
		int j = findIndex(key);
		if (j == -1) {
			return null;
		}
		return table.get(j).getValue();
	}

	//puts V value into map at given K key, if no key in map, creates new entry
	//returns V linked to given K key, or null if key not found
	@Override
	@TimeComplexity("O(n)")
	public V put(K key, V value) {
		//calls findIndex then does static actions
		//has same complexity as findIndex, O(n)
		
		int j = findIndex(key);
		if (j == -1) {
			table.addLast(new mapEntry<>(key, value));
			return null;
		} else {
			V temp = table.get(j).getValue();
			table.get(j).setValue(value);
			return temp;
		}
	}

	//removes entry with given K key
	//returns value of removed entry
	@Override
	@TimeComplexity("O(n)")
	public V remove(K key) {
		//calls findIndex then does static actions
		//has same complexity as findIndex, O(n)
		
		int j = findIndex(key);
		int n = size();
		if (j == -1) {
			return null;
		}
		V answer = table.get(j).getValue();
		if (j != n - 1) {
			table.set(j, table.get(n-1));
		}
		table.remove(n-1);
		return answer;
	}

	//private class for iterator
	private class EntryIterator implements Iterator<Entry<K,V>>{
		
		private int j = 0;
		
		public boolean hasNext() {
			return j < table.size();
		}
		
		public Entry<K,V> next(){
			if (j == table.size()) {
				throw new NoSuchElementException();
			}
			return table.get(j++);
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	//private class for iterable
	private class EntryIterable implements Iterable<Entry<K,V>>{
		public Iterator<Entry<K,V>> iterator(){
			return new EntryIterator();
		}
	}
	
	//returns iterable collection
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return new EntryIterable();
	}

}
