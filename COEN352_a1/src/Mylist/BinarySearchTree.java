package Mylist;

public class BinarySearchTree<E extends Comparable<? super E>>  {

	private BinarySearchTreeNode<E> root; // Root of the BST
	private int nodecount; // Number of nodes in the BS
	
	BinarySearchTree()
	{
		root=null;
		nodecount=0;
	}
	public void clear() { root = null; nodecount = 0; }
	
	public void insert(E e) {
		root = inserthelp(root, e);
		nodecount++;
		}
	
	private BinarySearchTreeNode<E> inserthelp(BinarySearchTreeNode<E> rt,E e) {
		
		if (rt == null) return new BinarySearchTreeNode<E>(e);
		if (rt.element().compareTo(e) > 0)
			rt.setLeft(inserthelp(rt.left(),e));
		else
			rt.setRight(inserthelp(rt.right(),e));
		return rt;
			}
	private E findhelp(BinarySearchTreeNode<E> rt,E e) {
		if (rt == null) return null;
		if (rt.element().compareTo(e) > 0)
		return findhelp(rt.left(), e);
		else if (rt.element().compareTo(e) == 0) return rt.element();
		else return findhelp(rt.right(), e);
		}
	
	private BinarySearchTreeNode<E> removehelp(BinarySearchTreeNode<E> rt,E e) {
		if (rt == null) return null;
		if (rt.element().compareTo(e) > 0)
		rt.setLeft(removehelp(rt.left(), e));
		else if (rt.element().compareTo(e)< 0)
		rt.setRight(removehelp(rt.right(), e));
		else { // Found it
			if (rt.left() == null) return rt.right();
			else if (rt.right() == null) return rt.left();
			else { // Two children
				BinarySearchTreeNode<E> temp = getmin(rt.right());
				rt.setElement(temp.element());
				rt.setRight(deletemin(rt.right()));
				}
			}
		return rt;
		}
	
	private BinarySearchTreeNode<E> getmin(BinarySearchTreeNode<E> rt) {
		if (rt.left() == null) return rt;
		return getmin(rt.left());
		}

	private BinarySearchTreeNode<E> deletemin(BinarySearchTreeNode<E> rt) {
		if (rt.left() == null) return rt.right();
		rt.setLeft(deletemin(rt.left()));
		return rt;
		}

	
	
	public E remove(E e) {
		E temp = findhelp(root, e); // First find it
		if (temp != null) {
		root = removehelp(root, e); // Now remove it
		nodecount--;
		}
		return temp;
		}
	
	public E removeAny() {
		if (root == null) return null;
		E temp = root.element();
		root = removehelp(root, root.element());
		nodecount--;
		return temp;
		}
	
	public E find(E e) { return findhelp(root, e); }
	/** @return The number of records in the dictionary. */
	public int size() { return nodecount; }
	public BinarySearchTreeNode<E> rootNode() { return root; }
	//traversing
	
static private StringBuffer out = new StringBuffer();
	

	// Stick this in to test the preorder routine
	static void visit (BinarySearchTreeNode X) 
	{
	  out.append(X.element());
	  out.append(" ");
	}
	
	public static void depthFirstTraverse(BinarySearchTreeNode rt) // rt is the root of the subtree
	{
	  if (rt == null) 
		  return; // Empty subtree
	  
	  depthFirstTraverse(rt.left());
	  visit(rt);
	  depthFirstTraverse(rt.right());
	}
	
	public static void breathFirstTraverse(BinarySearchTreeNode rt)
	{
	  
	  visit(rt);
	  if (rt.left() != null) 
		  depthFirstTraverse(rt.left());
	  if (rt.right() != null) 
		  depthFirstTraverse(rt.right());
	}
	
	static int count(BinarySearchTreeNode rt) {
	  if (rt == null) 
		  return 0;  // Nothing to count
	  return 1 + count(rt.left()) + count(rt.right());
	}
	
	
	static boolean checkBST(BinarySearchTreeNode root,
	                 Integer low, Integer high) 
	{
	  if (root == null) 
		  return true; // Empty subtree
	  Integer rootkey = (Integer) root.key();
	  
	  if ((rootkey < low) || (rootkey > high))
	    return false; // Out of range
	  
	  if (!checkBST(root.left(), low, rootkey))
	    return false; // Left side failed
	  
	  return checkBST(root.right(), rootkey, high);
	}
	
	public static String print() {
		return out.toString();
	}
	
	
	
	
}
