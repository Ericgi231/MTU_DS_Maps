package cs2321;
import java.util.Iterator;

import net.datastructures.*;
	

public class LinkedBinaryTree<E> implements BinaryTree<E>{

	//vars
	//
	
	private Node<E> root = null;
	private int size = 0;
	
	//nested classes
	//
	
	//positional nodes
	private static class Node<E> implements Position<E>{
		
		//vars
		//
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		//constructor
		//
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}
		
		//functions
		//
		public E getElement() {
			return element;
		}
		
		public Node<E> getParent(){
			return parent;
		}
		
		public Node<E> getLeft(){
			return left;
		}
		
		public Node<E> getRight(){
			return right;
		}
		
		public void setElement(E e) {
			element = e;
		}
		
		public void setParent(Node<E> parentNode) {
			parent = parentNode;
		}
		
		public void setLeft(Node<E> leftNode) {
			left = leftNode;
		}
		
		public void setRight(Node<E> rightNode) {
			right = rightNode;
		}
	}
	
	//element iterator
	private class ElementIterator implements Iterator<E>{
		
		Iterator<Position<E>> posIterator = positions().iterator();
		
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
	
	//constructors
	//
	
	//default constructor
	public  LinkedBinaryTree( ) {
		
	}
	
	//utility
	//
	
	//create new node from given data
	@TimeComplexity("O(1)")
	private Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
		return new Node<E>(e, parent, left, right);
	}
	
	//validate that a position is a node
	@TimeComplexity("O(1)")
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Not valid position type");
		}
		Node<E> node = (Node<E>) p;
		if(node.getParent() == node) {
			throw new IllegalArgumentException("p is no longer in the tree");
		}
		return node;
	}
	
	//functions
	//
	
	//return root of tree
	@Override
	@TimeComplexity("O(1)")
	public Position<E> root() {
		return root;
	}
	
	//return parent of given node
	@Override
	@TimeComplexity("O(1)")
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}

	//return iterable of given nodes children
	@Override
	@TimeComplexity("O(1)")
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		ArrayList<Position<E>> children = new ArrayList<>(2);
		if (left(p) != null) {
			children.addLast(left(p));
		}
		if (right(p) != null) {
			children.addLast(right(p));
		}
		return children;
	}

	//return count of direct children to given node
	@Override
	@TimeComplexity("O(1)")
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		int count = 0;
		if (left(p) != null) {
			count ++;
		}
		if (right(p) != null) {
			count ++;
		}
		return count;
	}

	//return true if node is internal
	@Override
	@TimeComplexity("O(1)")
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) != 0;
	}

	//return true if node is external
	@Override
	@TimeComplexity("O(1)")
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) == 0;
	}

	//return true if node is root
	@Override
	@TimeComplexity("O(1)")
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		return p == root;
	}

	//return number of items in tree
	@Override
	@TimeComplexity("O(1)")
	public int size() {
		return size;
	}

	//return true if tree is empty
	@Override
	@TimeComplexity("O(1)")
	public boolean isEmpty() {
		return size == 0;
	}
	
	//return element iterator
	@Override
	@TimeComplexity("O(1)")
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	//orders given tree into in order
	@TimeComplexity("O(n)")
	private void inorderSubtree(Position<E> p, ArrayList<Position<E>> sub) {
		//calls itself for all n nodes in the tree
		
		if(left(p) != null) {
			inorderSubtree(left(p), sub);
		}
		sub.addLast(p);
		if(right(p) != null) {
			inorderSubtree(right(p), sub);
		}
	}
	
	//returns and array list of all positions in order
	@TimeComplexity("O(n)")
	public Iterable<Position<E>> inorder(){
		//fills a list with all n positions in the tree, this requires it to loop through all n values
		
		ArrayList<Position<E>> sub = new ArrayList<>();
		if(!isEmpty()) {
			inorderSubtree(root(), sub);
		}
		return sub;
	}
	
	//returns in order iterable of positions
	@Override
	@TimeComplexity("O(n)")
	public Iterable<Position<E>> positions() {
		//inorder() is O(n)
		
		return inorder();
	}

	//return left child of given node
	@Override
	@TimeComplexity("O(1)")
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	//return right child of given node
	@Override
	@TimeComplexity("O(1)")
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}

	//return sibling of given node, or null if node does not have sibling
	@Override
	@TimeComplexity("O(1)")
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		Position<E> parent = parent(p);
		if (parent == null) {
			return null;
		}
		return left(parent) == p ? right(p) : left(p);
	}
	
	//create root node of tree
	@TimeComplexity("O(1)")
	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty()) {
			throw new IllegalStateException("Tree is not empty");
		}
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}
	
	//create left child node for given parent node
	@TimeComplexity("O(1)")
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getLeft() != null) {
			throw new IllegalArgumentException("p already has a left child");
		}
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}

	//create right child node for given parent node
	@TimeComplexity("O(1)")
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getRight() != null) {
			throw new IllegalArgumentException("p already has a left child");
		}
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	//combine two trees into one at given node
	@TimeComplexity("O(1)")
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2)
			throws IllegalArgumentException {
		
		Node<E> node = validate(p);
		if (isInternal(p)) {
			throw new IllegalArgumentException("p must be a leaf");
		}
		
		size += t1.size() + t2.size();
		
		if (!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		
		if (!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}
	
	//replaces element at given node with new element e, return old element
	@TimeComplexity("O(1)")
	public E set(Position<E> p, E e) {
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	
	//remove given node and restore tree
	@TimeComplexity("O(1)")
	public E remove(Position<E> p) throws IllegalArgumentException {
		
		Node<E> node = validate(p);
		
		if (numChildren(p) == 2) {
			throw new IllegalArgumentException("p has two children");
		}
		
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight() );
		if (child != null) {
			child.setParent(node.getParent());
		}
		
		if (node == root) {
			root = child;
		}
		else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		
		size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(null);
		return temp;
	}
}

