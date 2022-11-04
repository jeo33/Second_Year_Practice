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
	
	public void insert(double val)
	{
		root = inserthelp(root, val);
		nodecount++;
	}
	
	private BinarySearchTreeNode inserthelp(BinarySearchTreeNode root,double val)
	{
		

		if (root == null) return new BinarySearchTreeNode(val);
		if (val<root.getRoot())
			root.setLeft(inserthelp(root.left(),val));
		else
			root.setRight(inserthelp(root.right(), val));
		return root;
		
	}
	
	

		
	
}
