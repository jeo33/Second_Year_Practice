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
		rt.setKey(temp.key());
		rt.setRight(deletemin(rt.right()));
		}
		}
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

	
}
