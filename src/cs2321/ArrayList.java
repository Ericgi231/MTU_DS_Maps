package cs2321;

import java.util.Iterator;

import net.datastructures.List;

public class ArrayList<E> implements List<E>, Iterable<E> {

	// Nested Classes
	//
	public class ArrayListIterator implements Iterator<E>{

		// Initialize cursor below start of index
		int cursor = -1;
		
		// Check if next item in ArrayList exists
		@Override
		public boolean hasNext() {
			if(data[cursor+1] != null) {
				return true;
			}
			return false;
		}

		// Return next item in ArrayList
		@Override
		public E next() {
			cursor++;
			return (E)data[cursor];
		}
		
	}
	
	// Variables
	//
	public static final int CAPACITY = 16;
	private E[] data;
	private int size = 0;
	
	// Constructors
	//
	// Instantiate ArrayList with default CAPACITY
	public ArrayList() {
		this(CAPACITY);
	}
	
	// Instantiate ArrayList at given capacity
	// capacity: Integer used to set ArrayList capacity
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	// Functions
	//
	// Return number of elements contained in array list
	@Override
	public int size() {
		return size;
	}

	// Return true if ArrayList is empty
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Gets element at index i
	// i: Index to check
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size);
		
		return data[i];
	}

	// Replaces element at index i with element e
	// Returns replaced element
	// i: Index to replace at
	// e: Element to set at index
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	// Inserts element e at index i
	// Shifts all subsequent elements
	// i: Index to add at
	// e: Element to add at index
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size + 1);
		
		// Expand ArrayList if needed
		if(size == data.length) {
			resize(data.length * 2);
		}
		
		// Shift elements
		for(int n = size - 1; n >= i; n--) {
			data[n+1] = data[n];
		}
		
		// Insert new element
		data[i] = e;
		size++;
	}
	
	// Removes element at index i
	// Returns removed element
	// Shifts all subsequent elements
	// i: Index to remove at
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size);
		E temp = data[i];
		
		// Shift elements
		for(int n = i; n < size-1; n++) {
			data[n] = data[n+1];
		}
		
		// Remove element
		data[size-1] = null;
		size--;
		return temp;
	}

	// Returns ArrayListIterator<E>
	@Override
	public Iterator<E> iterator() {
		return (Iterator<E>) new ArrayListIterator();
	}

	// Adds element e at first node in ArrayList
	// e: Element to add at start of ArrayList
	public void addFirst(E e)  {
		add(0,e);
	}
	
	// Adds element e at last node in ArrayList
	// e: Element to add at end of ArrayList
	public void addLast(E e)  {
		if(size == data.length) {
			resize(data.length * 2);
		}
		data[size] = e;
		size++;
	}
	
	// Removes element at first node in ArrayList
	public E removeFirst() throws IndexOutOfBoundsException {
		E temp = remove(0);
		return temp;
	}
	
	// Removes element at last node in ArrayList
	public E removeLast() throws IndexOutOfBoundsException {
		E temp = data[size-1];
		data[size-1] = null;
		return temp;
	}
	
	// Return the capacity of array, not the number of elements.
	// The initial capacity is CAPACITY. When the array is full, array should be doubled. 
	public int capacity() {
		return data.length;
	}
	
	// Utility
	//
	// Check that index is in bounds
	// i: Index to check
	// n: Upper bound
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
		if(i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("Illegal index: " + i);
		}
	}
	
	// Resize data array capacity
	// capacity: Desired new capacity for data
	@SuppressWarnings("unchecked")
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int n = 0; n < size; n++) {
			temp[n] = data[n];
		}
		data = temp;
	}
}
