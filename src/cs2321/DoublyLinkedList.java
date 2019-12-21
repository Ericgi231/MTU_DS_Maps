package cs2321;
import java.util.Iterator;

import net.datastructures.Position;
import net.datastructures.PositionalList;


public class DoublyLinkedList<E> implements PositionalList<E>, Iterable<E> {

	// Nested Classes
	//
	public static class Node<E> implements Position<E>{
		
		// Variables
		//
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		// Constructor
		//
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		// Functions
		//
		// Return element in node
		@Override
		public E getElement() throws IllegalStateException {
			if (next == null) {
				throw new IllegalStateException("Position no longer valid");
			}
			return element;
		}
		
		// Return element previous to this node
		public Node<E> getPrev(){
			return prev;
		}
		
		// Return element after this node
		public Node<E> getNext(){
			return next;
		}
		
		// Set element of node to new value
		// e: new value
		public void setElement(E e) {
			element = e;
		}
		
		// Set previous node to given node
		// p: node to set
		public void setPrev(Node<E> p) {
			prev = p;
		}
		
		// Set next node to given node
		// n: node to set
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	public class DoublyLinkedListIterator implements Iterator<Position<E>>{
		// Variables
		//
		private Position<E> cursor = first();
		private Position<E> recent = null;
		
		// Functions
		//
		// Check if next item in DoublyLinkedList exists
		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		// Return next item in ArrayList
		@Override
		public Position<E> next() {
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		
		// Removes recently returned element
		public void remove() throws IllegalStateException{
			if (recent == null) {
				throw new IllegalStateException("Nothing to remove");
			}
			DoublyLinkedList.this.remove(recent);
			recent = null;
		}
	}
	
	public class DoublyLinkedListIterable implements Iterable<Position<E>>{
		public Iterator<Position<E>> iterator(){
			return new DoublyLinkedListIterator();
		}
	}
	
	public class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = new DoublyLinkedListIterator();
		
		public boolean hasNext() {
			return posIterator.hasNext();
		}
		
		public E next() {
			return posIterator.next().getElement();
		}
		
		public void remove() {
			posIterator.remove();
		}
	}
	
	// Variables
	//
	private int size = 0;
	public Node<E> head;
	public Node<E> tail;
	
	// Constructor
	//
	public DoublyLinkedList() {
		head = new Node<>(null,null,null);
		tail = new Node<>(null, head, null);
		head.setNext(tail);
	}

	// Functions
	//
	// Return size of DoublyLinkedList
	@Override
	public int size() {
		return size;
	}

	// Returns true if DoublyLinkedList is empty
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// Return first node in DoublyLinkedList
	@Override
	public Position<E> first() {
		return position(head.getNext());
	}
 
	// Return last node in DoublyLinkedList
	@Override
	public Position<E> last() {
		return position(tail.getPrev());
	}

	// Return node before given node
	// p: Origin node
	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	// Return node after given node
	// p: Origin node
	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}

	// Add new node to start of DoublyLinkedList
	// e: New node
	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, head, head.getNext());
	}

	// Add new node to end of DoublyLinkedList
	// e: New node
	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, tail.getPrev(), tail);
	}

	// Add new node before selected node
	// p: selected node
	// e: element stored in new node
	@Override
	public Position<E> addBefore(Position<E> p, E e)
			throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	// Add new node after selected node
	// p: selected node
	// e: element stored in new node
	@Override
	public Position<E> addAfter(Position<E> p, E e)
			throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	// Add new node between two selected nodes 
	// e: element stored in new node
	// prev: previous node 
	// next: next node 
	public Position<E> addBetween(E e, Node<E> prev, Node<E> next){
		Node<E> newNode = new Node<>(e, prev, next);
		prev.setNext(newNode);
		next.setPrev(newNode);
		size++;
		return newNode;
	}
	
	// Set given node to new node
	// p: given node
	// e: element for new node
	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	// Remove given node
	// p: given node
	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> prev = node.getPrev();
		Node<E> next = node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}

	// Remove first node in DoublyLinkedList
		public E removeFirst() throws IllegalArgumentException {
			return remove(head.getNext());
		}
		
		// Remove last node in DoublyLinkedList
		public E removeLast() throws IllegalArgumentException {
			return remove(tail.getPrev());
		}
	
	// Returns element iterator for DoublyLinkedList
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	// Returns doubly linked list iterable
	@Override
	public Iterable<Position<E>> positions() {
		return new DoublyLinkedListIterable();
	}
	
	// Utility
	//
	// Converts Position to Node if valid
	// p: position
	private Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Inalid p");
		}
		
		Node<E> node = (Node<E>) p;
		
		if (node.getNext() == null) {
			throw new IllegalArgumentException("p is no longer in the list");
		}
		
		return node;
	}
	
	// Returns node as position or null if not real node
	private Position<E> position(Node<E> node){
		if (node == head || node == tail) {
			return null;
		}
		return node;
	}
	
	
	
}
