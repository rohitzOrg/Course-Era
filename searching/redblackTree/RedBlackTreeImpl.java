package redblackTree;

//https://algs4.cs.princeton.edu/32bst/BST.java.html
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class RedBlackTree<Key extends Comparable<Key>,Value>/* implements Iterable<Key>*/ {

private class Node{
	private Key key;
	private Value value;
	private int size;
	private Node left,right;
	private boolean color;
	
	public Node(Key key,Value value,int size,boolean color){
		this.key=key;
		this.value=value;
		this.size=size;
		this.color = color;
	}
}

private Node root;
private final boolean RED = true;
private final boolean BLACK = false;

/********************************************Helper Methods*************************************************/

private Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = x.right.color;
    x.right.color = RED;
    x.size = h.size;
    h.size = size(h.left) + size(h.right) + 1;
    return x;
}

private Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = x.left.color;
    x.left.color = RED;
    x.size = h.size;
    h.size = size(h.left) + size(h.right) + 1;
    return x;
}

private void flipColors(Node h) {
    h.color = !h.color;
    h.left.color = !h.left.color;
    h.right.color = !h.right.color;
}


public boolean isRed(Node x){
	if(x==null)
		return false;
	else
		return x.color = RED;
}

public boolean isEmpty(){
	return size()==0;
}

public int size() {
	return size(root);
}

public int size(Node x){
	if(x==null)
		return 0;
	else
		return x.size;
}

public boolean contains(Key key){
	if(key== null)
		throw new IllegalArgumentException("Key is null");
	return get(key)!=null;
}


public Key min(){
	if(isEmpty())
		throw new NoSuchElementException("empty symbol table");
	return min(root).key;
	
}

private Node min(Node x){
	if(x.left==null)
		return x;
	else
		return min(x.left);
}

public Key max(){
	if(isEmpty())
		throw new NoSuchElementException("empty symbol table");
	return max(root).key;
}

public Node max(Node x){
	if(x.right==null)
		return x;
	else
		return max(x.right);
}

public Iterable<Key> keys() {
	Queue<Key> queue = new LinkedList<>();
	//inorder(root,queue);
	//preorder(root,queue);
	postorder(root,queue);
	return queue;
}

private void postorder(Node x, Queue<Key> queue) {
	if(x==null)
		return;
	/*inorder(x.left,queue);
	queue.add(x.key);
	inorder(x.right,queue);*/
	
	
	/*queue.add(x.key);
	preorder(x.left,queue);
	preorder(x.right,queue);*/
	
	postorder(x.left,queue);
	postorder(x.right,queue);
	queue.add(x.key);
	
}

public Iterable<Value> values(){
	Queue<Value> queue = new LinkedList<Value>();
	values(root,queue);
	return queue;
}

private void values(Node x, Queue<Value> queue){
	if(x==null)
		return;
	
	values(x.left,queue);
	values(x.right,queue);
	queue.add(x.value);
}


/********************************************************************************************************/

/********************************************Operations*************************************************/

public void put(Key key, Value value){
	root = put(root,key,value);  //take the root and update it locally, which makes the global root untouched
	root.color = BLACK;
}

public Node put(Node x, Key key, Value value){
	if(x==null)
		x = new Node(key,value,1,RED);
	int cmp = key.compareTo(x.key);
	if(cmp<0)
		x.left = put(x.left,key,value);
	else if(cmp>0)
		x.right = put(x.right,key,value);
	else
		x.value=value;
	

    if (isRed(x.right) && !isRed(x.left))      x = rotateLeft(x);
    if (isRed(x.left)  &&  isRed(x.left.left)) x = rotateRight(x);
    if (isRed(x.left)  &&  isRed(x.right))     flipColors(x);
	x.size = 1/*for the root*/ + size(x.left) + size(x.right);
	
	return x;
}

/*	public Value get(Key key){
	return get(root,key);
}

public Value get(Node x,Key key){
	if(x==null)
		return null;
	int cmp = key.compareTo(x.key);
	if(cmp<0)
		return get(x.left,key);
	else if(cmp>0)
		return get(x.right,key);
	else
		return x.value;
}*/

//try using recursive approach instead of looping around
//below is acceptable for a get() but not for a put(); if we use it for put(), it will make the put() more complicated
// so we use recursive approach in a put()
public Value get(Key key){
	Node current = root;
	while(current!=null){
		int cmp = key.compareTo(current.key);
		if(cmp<0)
			current = current.left;
		else if(cmp>0)
			current = current.right;
		else
			return current.value;
	}
	return null;
}


public void deleteMin(){
	if(isEmpty())
		throw new IllegalArgumentException("empty tree");
	root = deleteMin(root);
}

private Node deleteMin(Node x) {
	if(x.left==null)
		return x.right;
	x.left = deleteMin(x.left);
	x.size = 1 + size(x.left) + size(x.right);
	return x;
}

public void deleteMax(){
	if(isEmpty())
		throw new IllegalArgumentException("empty tree");
	root = deleteMax(root);
}

private Node deleteMax(Node x) {
	if(x.right==null)
		return x.left;
	x.right = deleteMin(x.right);
	x.size = 1 + size(x.left) + size(x.right);
	return x;
}


public void delete(Key key) {
       if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
       root = delete(root, key);
   }

   private Node delete(Node x, Key key) {
       if (x == null) return null;

       int cmp = key.compareTo(x.key);
       if      (cmp < 0) x.left  = delete(x.left,  key);
       else if (cmp > 0) x.right = delete(x.right, key);
       else { 
           if (x.right == null) return x.left;
           if (x.left  == null) return x.right;
           
           Node t = x;
           x = min(t.right);					//find the successor ie min(E.right) = > H
           x.right = deleteMin(t.right);		// H.right =  deleteMin(E.right) see deleteMin() function
           									// H.right will be M
           x.left = t.left;					// H.left = E.left
       } 
       x.size = size(x.left) + size(x.right) + 1;
       return x;
   } 
/*******************************************************************************************************/
}

class RedBlackTreeImpl{

public static void main(String[] args) {
	RedBlackTree<Integer,String> bst = new RedBlackTree<>();
	bst.put(1, "rohit");
	bst.put(2, "anand");
	bst.put(4, "zayne");
	bst.put(5, "hippo");
	bst.put(3, "mambo");
	System.out.println("value corresponding to key 5 : " + bst.get(5));
/*	System.out.println("Does the tree has (key=19) ? : " + bst.contains(19));
	System.out.println("Minimum element : " + bst.min());
	System.out.println("Maximum element : " + bst.max());*/
	//System.out.println(bst.size());
	//bst.deleteMin();
	//bst.deleteMin();
	//System.out.println(bst.size());
	System.out.println(bst.keys());
	System.out.println(bst.values());
}


}

