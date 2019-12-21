package cs2321;

import net.datastructures.Entry;
import net.datastructures.Position;
import net.datastructures.SortedMap;


public class BinarySearchTree<K extends Comparable<K>,V> extends AbstractMap<K,V> implements SortedMap<K,V> {
	
	//vars
	//
	
	LinkedBinaryTree<Entry<K,V>> tree; 
	int size;  //the number of entries (mappings)
	
	//constructors
	//
	
	//default constructor
	public BinarySearchTree() {
		tree = new LinkedBinaryTree<>();
		size = 0;
		tree.addRoot(null);
	}
	
	//utility
	//

	//convert a leaf node into an internal node with two leaf nodes below it
	@TimeComplexity("O(1)")
	private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry) {
		tree.set(p, entry);
		tree.addLeft(p, null);
		tree.addRight(p, null);
	}
	
	//search tree for given key under given node
	@TimeComplexity("O(n)")
	private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key){
		//worst case all nodes in tree are stacked in one direction creating a tree with height equal to size
		//a search could travel all nodes to reach the desired value, this leaves O(height), which is O(n)
		//best case O(log n) because if the tree is perfectly balanced the max height will always be log n
		
		if (tree.isExternal(p)) {
			return p;
		}
		int comp = key.compareTo(p.getElement().getKey());
		if (comp == 0) {
			return p;
		}
		else if (comp < 0) {
			return treeSearch(tree.left(p), key);
		}
		else {
			return treeSearch(tree.right(p), key);
		}
	}
	
	//functions
	//
	
	//used for testing
	@TimeComplexity("O(1)")
	public LinkedBinaryTree<Entry<K,V>> getTree() {
		return tree;
	}
	
	//return number of elements in tree
	@Override
	@TimeComplexity("O(1)")
	public int size(){
		return size;
	}
	
	//returns value linked to given key, or null
	@Override
	@TimeComplexity("O(n)")
	public V get(K key) {
		//calls treeSearch
		
		Position<Entry<K,V>> p = treeSearch(tree.root(), key);
		if (tree.isExternal(p)) {
			return null;
		}
		return p.getElement().getValue();
	}

	//links given value to given key. Inserts new entry if needed, overrides if key existed. Returns old value or null
	@Override
	@TimeComplexity("O(n)")
	public V put(K key, V value) {
		//calls treeSearch
		
		Entry<K,V> newEntry = new mapEntry<>(key, value);
		Position<Entry<K,V>> p = treeSearch(tree.root(), key);
		if (tree.isExternal(p)) {
			expandExternal(p, newEntry);
			size++;
			return null;
		}
		else {
			V old = p.getElement().getValue();
			tree.set(p, newEntry);
			return old;
		}
	}

	//removes given node and returns value
	@Override
	@TimeComplexity("O(n)")
	public V remove(K key) {
		//calls treeSearch
		
		Position<Entry<K,V>> p = treeSearch(tree.root(), key);
		if (tree.isExternal(p)) {
			return null;
		}
		else 
		{
			V old = p.getElement().getValue();
			
			if (tree.isExternal(tree.left(p))) {
				removeLeafAndBranch(tree.left(p));
			}
			else if (tree.isExternal(tree.right(p))) {
				removeLeafAndBranch(tree.right(p));
			} 
			else {
				Position<Entry<K,V>> n = succ(p);
				tree.set(p, n.getElement());
				removeLeafAndBranch(tree.left(n));
			}
			
			size--;
			return old;
		}
	}

	//removes given external node and its parent
	@TimeComplexity("O(1)")
	public void removeLeafAndBranch(Position<Entry<K,V>> n) {
		Position<Entry<K,V>> p = tree.parent(n);
		tree.remove(n);
		tree.remove(p);
	}

	//returns successor of given node
	@TimeComplexity("O(n)")
	public Position<Entry<K,V>> succ(Position<Entry<K,V>> n) {
		Position<Entry<K,V>> p = tree.right(n);
		while (tree.isInternal(p)) {
			p = tree.left(p);
		}
		return tree.parent(p);
	}
	
	//returns the node of the maximum element in subtree that has node n as its root
	@TimeComplexity("O(n)")
	public Position<Entry<K,V>> treeMax(Position<Entry<K,V>> n){
		Position<Entry<K,V>> walk = n;
		while (tree.isInternal(walk)) {
			walk = tree.right(walk);
		}
		return tree.parent(walk);
	}
	
	//returns the node of the minimum element in subtree that has node n as its root
	@TimeComplexity("O(n)")
	public Position<Entry<K,V>> treeMin(Position<Entry<K,V>> n){
		Position<Entry<K,V>> walk = n;
		while (tree.isInternal(walk)) {
			walk = tree.left(walk);
		}
		return tree.parent(walk);
	}
	
	//returns iterable set of entries
	@Override
	@TimeComplexity("O(n)")
	public Iterable<Entry<K, V>> entrySet() {
		//calls inorder, which is O(n)
		
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size+1);
		
		for(Position<Entry<K,V>> p : tree.inorder()) {
			if (tree.isInternal(p)) {
				buffer.addLast(p.getElement());
			}
		}
		return buffer;
	}
	
	//returns smallest entry
	@Override
	@TimeComplexity("O(n)")
	public Entry<K, V> firstEntry() {
		if (tree.isEmpty()) {
			return null;
		}
		return treeMin(tree.root()).getElement();
	}

	//returns largest entry
	@Override
	@TimeComplexity("O(n)")
	public Entry<K, V> lastEntry() {
		if (tree.isEmpty()) {
			return null;
		}
		return treeMax(tree.root()).getElement();
	}

	//returns smallest entry with key greater than or equal to given key
	@Override
	@TimeComplexity("O(n)")
	public Entry<K, V> ceilingEntry(K key) {
		Position<Entry<K,V>> p = treeSearch(tree.root(), key);
		if (tree.isInternal(p)) {
			return p.getElement();
		}
		while (!tree.isRoot(p)) {
			if (p == tree.left(tree.parent(p))) {
				return tree.parent(p).getElement();
			}
			else {
				p = tree.parent(p);
			}
		}
		return null;
	}

	//returns greatest entry with key less than or equal to given key
	@Override
	@TimeComplexity("O(n)")
	public Entry<K, V> floorEntry(K key)  {
		Position<Entry<K,V>> p = treeSearch(tree.root(), key);
		if (tree.isInternal(p)) {
			return p.getElement();
		}
		while (!tree.isRoot(p)) {
			if (p == tree.right(tree.parent(p))) {
				return tree.parent(p).getElement();
			}
			else {
				p = tree.parent(p);
			}
		}
		return null;
	}

	//returns entry with greatest key less than given key
	@Override
	@TimeComplexity("O(n)")
	public Entry<K, V> lowerEntry(K key) {
		Position<Entry<K,V>> p = treeSearch(tree.root(), key);
		if (tree.isInternal(p) && tree.isInternal(tree.left(p))) {
			return treeMax(tree.left(p)).getElement();
		}
		while (!tree.isRoot(p)) {
			if (p == tree.right(tree.parent(p))) {
				return tree.parent(p).getElement();
			}
			else {
				p = tree.parent(p);
			}
		}
		return null;
	}

	//returns entry with smallest key greater than given key
	@Override
	@TimeComplexity("O(n)")
	public Entry<K, V> higherEntry(K key){
		Position<Entry<K,V>> p = treeSearch(tree.root(), key);
		if (tree.isInternal(p) && tree.isInternal(tree.right(p))) {
			return treeMin(tree.right(p)).getElement();
		}
		while (!tree.isRoot(p)) {
			if (p == tree.left(tree.parent(p))) {
				return tree.parent(p).getElement();
			}
			else {
				p = tree.parent(p);
			}
		}
		return null;
	}

	//returns iterable collection of entries within given key range
	@Override
	@TimeComplexity("O(n)")
	public Iterable<Entry<K, V>> subMap(K fromKey, K toKey)
			throws IllegalArgumentException {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size);
		if (fromKey.compareTo(toKey) < 0) {
			subMapRecurse(fromKey, toKey, tree.root(), buffer);
		}
		return buffer;
	}

	@TimeComplexity("O(n)")
	private void subMapRecurse(K fromKey, K toKey, Position<Entry<K,V>> p, ArrayList<Entry<K,V>> buffer) {
		if (tree.isInternal(p)) {
			if (p.getElement().getKey().compareTo(fromKey) < 0) {
				subMapRecurse(fromKey, toKey, tree.right(p), buffer);
			}
			else {
				subMapRecurse(fromKey, toKey, tree.left(p), buffer);
				if (p.getElement().getKey().compareTo(toKey) < 0) {
					buffer.addLast(p.getElement());
					subMapRecurse(fromKey, toKey, tree.right(p), buffer);
				}
			}
		}
	}
	
	//returns true if tree is empty
	@Override
	@TimeComplexity("O(1)")
	public boolean isEmpty() {
		return size == 0;
	}

	

}
