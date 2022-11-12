package Mylist;

public class tool {

	static private StringBuffer out = new StringBuffer();
	static private SinglyList<InventoryRecord> RecordOut;
	public int size;
	
	public StringBuffer GetStringBuffer()
	{
		StringBuffer x;
		x=out;
		return x;
	}
	
	public void showPath()
	{
		System.out.println(out);

	}
	public void showRecord()
	{
		SinglyList<InventoryRecord> temp=RecordOut;
		int i=0;
		while(i!=size-1)
		{	
			temp.getValue(i).printRecord();
			
			i++;
		}
	}
	//  inorder traversal
	
	public void Traverse(BinarySearchTree t)
	{	
		size=t.size();
		RecordOut=new SinglyList<InventoryRecord>();
		depthFirstTraverse(t.getRootNode());
		
	}
	public void depthFirstTraverse(BinarySearchTreeNode root) // rt is the root of the subtree
	{
		
	  if (root == null) 
		  return; // Empty subtree
	  
	  depthFirstTraverse(root.left());
	  visit(root);
	  depthFirstTraverse(root.right());
	}
	
	
	static void visit (BinarySearchTreeNode X) 
	{
		RecordOut.insert(X.getRecord());
	  out.append(X.getRoot());
	  out.append(" ");
	}
	
	// QuickSort algorithm
	public static void QuickSort(InventoryRecord[] a, String attribute)
	{	// Select left pointer as first element and right pointer as last element
		qs(a, 0, a.length-1, attribute);
	}
		
	static void qs(InventoryRecord[] a, int i, int j, String attribute) {
		
		int pivIndex = (i+j)/2; // Update pivot index, take middle array position
		
		swap(a, pivIndex, j); // Swap last array element with pivot
		
		int pos = p(a, i-1, j, attribute, a[j]); // Partition
		  
		  swap(a, pos, j);  // Put pivot in place
		  
		  if ((pos-i) > 1) qs(a, i, pos-1, attribute);   // Sort left partition
		  if ((j-pos) > 1) qs(a, pos+1, j, attribute);   // Sort right partition
	}
	// Partition algorithm
	static int p(InventoryRecord[] a, int left, int right, String attribute, InventoryRecord pivot)
	{
		// Check for attribute, then do the partition accordingly
			if(attribute.equals("name")) {
				do { 
					while (a[++left].compareName(pivot)<0);
				
					while ((right!=0) && (a[--right].compareName(pivot)>0));
				    
					swap(a, left, right);       
				  } while (left < right); 
				  swap(a, left, right);         
				  return left; 
			}
			if(attribute.equals("description")) {
				do { 
					while (a[++left].compareDescription(pivot)<0);
				
					while ((right!=0) && (a[--right].compareDescription(pivot)>0));
				    
					swap(a, left, right);       
				  } while (left < right); 
				  swap(a, left, right);         
				  return left; 
			}
			if(attribute.equals("unitprice")) {
				 do { // As long as left element's unit price is smaller than the pivot's unit price
						while (a[++left].compareUnitPrice(pivot)<0);
					    // As long as right element position is not the first position
						// and that the right element's unit price is bigger than the pivot
						while ((right!=0) && (a[--right].compareUnitPrice(pivot)>0));
					    // Swap the elements
						swap(a, left, right);       
					  } while (left < right); // Stop when right position >= left position
					  swap(a, left, right);         // Reverse last, wasted swap
					  return left;      // Return first position in right partition
			}
			if(attribute.equals("quantityinstock")) {
				do { 
					while (a[++left].compareQtyInStock(pivot)<0);
				
					while ((right!=0) && (a[--right].compareQtyInStock(pivot)>0));
				    
					swap(a, left, right);       
				  } while (left < right); 
				  swap(a, left, right);         
				  return left;      
			}
			if(attribute.equals("inventroyvalue")) {
				do { 
					while (a[++left].compareInventoryValue(pivot)<0);
				
					while ((right!=0) && (a[--right].compareInventoryValue(pivot)>0));
				    
					swap(a, left, right);       
				  } while (left < right); 
				  swap(a, left, right);         
				  return left;    
			}
			if(attribute.equals("recorderlevel")) {
				do { 
					while (a[++left].compareReorderLevel(pivot)<0);
				
					while ((right!=0) && (a[--right].compareReorderLevel(pivot)>0));
				    
					swap(a, left, right);       
				  } while (left < right); 
				  swap(a, left, right);         
				  return left;  
			}
			if(attribute.equals("reordertime")) {
				do { 
					while (a[++left].compareReorderTime(pivot)<0);
				
					while ((right!=0) && (a[--right].compareReorderTime(pivot)>0));
				    
					swap(a, left, right);       
				  } while (left < right); 
				  swap(a, left, right);         
				  return left; 
			}
			if(attribute.equals("reorderqty")) {
				do { 
					while (a[++left].compareReorderQty(pivot)<0);
				
					while ((right!=0) && (a[--right].compareReorderQty(pivot)>0));
				    
					swap(a, left, right);       
				  } while (left < right); 
				  swap(a, left, right);         
				  return left; 
			}
			if(attribute.equals("discontinued")) {
				do { 
					while (a[++left].compareDiscontinuity(pivot)<0);
				
					while ((right!=0) && (a[--right].compareDiscontinuity(pivot)>0));
				    
					swap(a, left, right);       
				  } while (left < right); 
				  swap(a, left, right);         
				  return left; 
			}
			return 0;
	}
	
	// Swap inventory records in an array given the positions
	private static void swap(InventoryRecord[] arr, int i, int j) {
        InventoryRecord temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

	// Print an array of inventory records
	static void print(InventoryRecord[] arr)
	{
		for(int i = 0; i < arr.length; i++) arr[i].printRecord();
	}
}
