package Mylist;

public class BinarySearchTree  {

	private BinarySearchTreeNode root; // Root of the BST
	private int nodecount; // Number of nodes in the BS
	
	BinarySearchTree()
	{
		root=null;
		nodecount=0;
	}
	
	
	
	void setRootNode(BinarySearchTreeNode x)
	{
		root=x;
	}
	
	BinarySearchTreeNode getRootNode()
	{
		return root;
	}
	
	
	
	public void clear() { root = null; nodecount = 0; }

	public int size() { return nodecount; }
	
	public void insert(double val,InventoryRecord record)
	{
		root = inserthelp(root, val,record);
		nodecount++;
	}
	
	private BinarySearchTreeNode inserthelp(BinarySearchTreeNode root,double val,InventoryRecord record)
	{
		

		if (root == null) return new BinarySearchTreeNode(val,record);
		if (val<root.getRoot())
			root.setLeft(inserthelp(root.left(),val, record));
		else
			root.setRight(inserthelp(root.right(), val,record));
		return root;
		
	}
	
	

		
	
}
