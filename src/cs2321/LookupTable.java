package cs2321;

import net.datastructures.*;

public class LookupTable<K extends Comparable<K>, V> extends AbstractMap<K,V> implements SortedMap<K, V> {
	
	//vars
	//
	
	private ArrayList<mapEntry<K,V>> table; 
	
	//constructors
	//
	
	//default constructor
	public LookupTable(){
		table = new ArrayList<>();
	}
	
	//utility
	//
	
	//return the index of the given key, assuming key is between given low and high indexes
	//if index not found return high index plus 1
	@TimeComplexity("O(lg n)")
	private int findIndex(K key, int low, int high) {
		if (high < low) {
			return high + 1;
		}
		int mid = (low + high) / 2;
		int comp = key.compareTo(table.get(mid).getKey());
		
		if (comp == 0) {
			return mid;
		}
		else if (comp < 0) {
			return findIndex(key, low, mid - 1);
		}
		//implied comp > 0
		return findIndex(key, mid + 1, high);
		
	}
	
	//calls findIndex for full size of lookup table
	@TimeComplexity("O(lg n)")
	private int findIndex(K key) {
		return findIndex(key, 0, table.size() - 1);
	}
	
	//return entry at given index or null if index out of bounds
	@TimeComplexity("O(1)")
	private Entry<K,V> safeEntry(int n){
		if(n < 0 || n >= table.size()) {
			return null;
		}
		return table.get(n);
	}
	
	//needed for entrySet and subMap
	@TimeComplexity("O(n)")
	private Iterable<Entry<K,V>> snapshot(int start, K stop) {
		//loops through all values in lookup table from start to stop, worst case is every value
		
		ArrayList<Entry<K,V>> buffer = new ArrayList<>();
		int n = start;
		while (n < table.size() && (stop == null || stop.compareTo(table.get(n).getKey()) > 0)) {
			buffer.addLast(table.get(n++));
		}
		return buffer;
	}
	
	//functions
	//
	
	//returns size of lookup table
	@Override
	@TimeComplexity("O(1)")
	public int size() {
		return table.size();
	}

	//returns true if lookup table is empty
	@Override
	@TimeComplexity("O(1)")
	public boolean isEmpty() {
		return table.size() == 0;
	}

	//returns value liked to given key, or null if not found
	@Override
	@TimeComplexity("O(log n)")
	public V get(K key) {
		//calls findIndex which is O(log n) then does static actions
		
		int n = findIndex(key);
		if (n == size() || key.compareTo( table.get(n).getKey()) != 0) {
			return null;
		}
		return table.get(n).getValue();
	}

	//puts entry into the look up table, overrides current entry if they share keys
	//returns old value if override, null if new entry
	@Override
	@TimeComplexity("O(n)")
	public V put(K key, V value) {
		//calls findIndex which is O(log n)
		//in the case that an old entry is being replaced, only static actions follow
		//in the case a new entry is needed, the ArrayList.add() function must be called
		//this function is O(n) so this function is O(n)
		//depending on use, replacing entries could be more or less common, so it is not fair to say the expected complexity is O(log n)
		//but O(log n) will occur often in some use cases
		
		int n = findIndex(key);
		if (n < size() && key.compareTo( table.get(n).getKey()) == 0) {
			V temp = table.get(n).getValue();
			table.get(n).setValue(value);
			return temp;
		}
		table.add(n, new mapEntry<K,V>(key,value));
		return null;
	}

	//remove entry at given key
	//returns value of entry or null if not found
	@Override
	@TimeComplexity("O(n)")
	public V remove(K key) {
		//calls findIndex which is O(log n)
		//in the case that the index is found, which should be most calls, arraylist.remove() is called
		//this function is O(n) so this is also O(n)
		
		int n = findIndex(key);
		if (n == size() || key.compareTo( table.get(n).getKey()) != 0) {
			return null;
		}
		return table.remove(n).getValue();
	}

	//returns iterable array list of the entire lookup table
	@Override
	@TimeComplexity("O(n)")
	public Iterable<Entry<K, V>> entrySet() {
		//calls snapshot which is O(n) and goes through the whole lookup table for all n values
		
		return snapshot(0,null);
	}

	//returns entry with least key
	@Override
	@TimeComplexity("O(1)")
	public Entry<K, V> firstEntry() {
		return safeEntry(0);
	}

	//returns entry with greatest key
	@Override
	@TimeComplexity("O(1)")
	public Entry<K, V> lastEntry() {
		return safeEntry(table.size()-1);
	}

	//returns entry with least key greater than or equal to given key
	@Override
	@TimeComplexity("O(lg n)")
	public Entry<K, V> ceilingEntry(K key)  {
		//calls find index
		
		return safeEntry(findIndex(key));
	}

	//returns entry with greatest key less than or equal to given key
	@Override
	@TimeComplexity("O(lg n)")
	public Entry<K, V> floorEntry(K key)  {
		//calls find index
		
		int n = findIndex(key);
		if (n == size() || !key.equals(table.get(n).getKey())) {
			n--;
		}
		return safeEntry(n);
	}

	//returns entry with greatest key less than given key
	@Override
	@TimeComplexity("O(lg n)")
	public Entry<K, V> lowerEntry(K key) {
		//calls find index
		
		return safeEntry(findIndex(key)-1);
	}

	//returns entry with least key greater than given key
	@Override
	@TimeComplexity("O(lg n)")
	public Entry<K, V> higherEntry(K key) {
		//calls find index
		
		int n = findIndex(key);
		if (n < size() && key.equals(table.get(n).getKey())) {
			n++;
		}
		return safeEntry(n);
	}

	//returns iterable array list of a sub portion of the lookup table
	@Override
	@TimeComplexity("O(n)")
	public Iterable<Entry<K, V>> subMap(K fromKey, K toKey){
		//calls snapshot which is O(n) but only loops for n times where n can be less than total values
		//also calls findIndex so the complexity is O(s + log n) where s is a number less than or equal to n
		//so worst case is still O(n)
		
		return snapshot(findIndex(fromKey),toKey);
	}


}
