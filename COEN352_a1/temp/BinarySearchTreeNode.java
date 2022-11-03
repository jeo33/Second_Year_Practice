package Mylist;

public class BinarySearchTreeNode<E> {
	
		  
		  private E root;          // Element for this node
		  private BinarySearchTreeNode<E> left;  // Pointer to left child
		  private BinarySearchTreeNode<E> right; // Pointer to right child

		  /** Constructors */
		  public BinarySearchTreeNode()
		  {
			  left = right = null; 
		  }
		  
		  public BinarySearchTreeNode( E val)
		  { 
			  left = right = null; 
			  root = val; 
		  }
		  
		  public BinarySearchTreeNode(E val, BinarySearchTreeNode<E> l, BinarySearchTreeNode<E> r) 
		  { 
			  left = l; 
			  right = r; 
			  root = val; 
		  }



		  /** Return and set the element value */
		  public E element() 
		  { 
			  return root; 
		  }
		  
		  public void setElement(E v) { root = v; }

		  /** Return and set the left child */
		  public BinarySearchTreeNode<E> left() { return left; }
		  public void setLeft(BinarySearchTreeNode<E> p) { left = p; }

		  /** Return and set the right child */
		  public BinarySearchTreeNode<E> right() { return right; }
		  public void setRight(BinarySearchTreeNode<E> p) { right = p; }

		  /** Return true if this is a leaf node */
		  public boolean isLeaf()
		  { return (left == null) && (right == null); }
	
}
