package Mylist;

public class BinarySearchTreeNode
{
	
		  private InventoryRecord record;  
		  private double root;          // Element for this node
		  private BinarySearchTreeNode left;  // Pointer to left child
		  private BinarySearchTreeNode right; // Pointer to right child

		  /** Constructors */
		  public BinarySearchTreeNode()
		  {
			  left = right = null; 
		  }
		  
		  public BinarySearchTreeNode( double val)
		  { 
			  left = right = null; 
			  root = val; 
		  }
		  
		  public BinarySearchTreeNode( double val,InventoryRecord r)
		  { 
			  left = right = null; 
			  root = val; 
			  record=r;
		  }
		  
		  public BinarySearchTreeNode(double val, BinarySearchTreeNode l, BinarySearchTreeNode r) 
		  { 
			  left = l; 
			  right = r; 
			  root = val; 
		  }



		  /** Return and set the element value */
		  public double getRoot() 
		  { 
			  return root; 
		  }
		  
		  public void setRoot(double v) { root = v; }

		  /** Return and set the left child */
		  public BinarySearchTreeNode left() { return left; }
		  public void setLeft(BinarySearchTreeNode p) { left = p; }

		  /** Return and set the right child */
		  public BinarySearchTreeNode right() { return right; }
		  public void setRight(BinarySearchTreeNode p) { right = p; }

		  /** Return true if this is a leaf node */
		  public boolean isLeaf()
		  { return (left == null) && (right == null); }

		public InventoryRecord getRecord() {
			return record;
		}

		public void setRecord(InventoryRecord record) {
			this.record = record;
		}
			
		}
	