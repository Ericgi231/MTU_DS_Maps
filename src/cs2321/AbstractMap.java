package cs2321;

import java.util.Iterator;

import net.datastructures.Entry;
import net.datastructures.Map;

/* 
 * This class has the shared data type, attributes and methods for different Map implementations
 */

public abstract class AbstractMap<K,V> implements Map<K,V> {
	public static class mapEntry<K,V> implements Entry<K,V> {
		K  key;
		V  value;
		
		public mapEntry(K key2, V value2) {
			key = key2;
			value = value2;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}
		
		public void setValue(V newValue) {
			value = newValue;
		}
	}	

	private class keyIterator implements Iterator<K> {
		private Iterator<Entry<K,V>> entries = entrySet().iterator();

		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}

		@Override
		public K next() {
			return entries.next().getKey();
		}
	}

	private class KeyIterable implements Iterable<K> {
		@Override
		public Iterator<K> iterator() {
			return new keyIterator();
		}
	}

	@Override
	public Iterable<K> keySet() {
		
		return new KeyIterable();
	}
	
	private class valueIterator implements Iterator<V> {
		private Iterator<Entry<K,V>> entries = entrySet().iterator();

		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}

		@Override
		public V next() {
			return entries.next().getValue();
		}
	}

	private class ValueIterable implements Iterable<V> {
		@Override
		public Iterator<V> iterator() {
			return new valueIterator();
		}
	}
	
	@Override
	public Iterable<V> values() {
		return new ValueIterable();
	}


}
