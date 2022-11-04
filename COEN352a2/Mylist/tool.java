package Mylist;

public class tool {

		
	
	static private StringBuffer out = new StringBuffer();
	public void showPath()
	{
		System.out.println(out);
	}
	public void depthFirstTraverse(BinarySearchTreeNode root) // rt is the root of the subtree
	{
	  if (root == null) 
		  return; // Empty subtree
	  
	  depthFirstTraverse(root.left());
	  visit(root);
	  depthFirstTraverse(root.right());
	}
	
	
	// Stick this in to test the preorder routine
	static void visit (BinarySearchTreeNode X) 
	{
	  out.append(X.getRoot());
	  out.append(" ");
	}
	
	
	
	
		void QS(double[] a,int left,int right)
		{	
			
			if(left<right)
			{
				
				int flag=p(a,left,right);
				QS(a,left,flag-1);
				QS(a,flag+1,right);
			}
			
		}
		
		static int p(double[] a,int left,int right)
		{
			int l=left;
			int r=right;
			int flag=0;
			double pivot=a[right];
			
			
			
			while(left<right)
			{
				if(a[left]>pivot&&a[right-1]<pivot)
				{	double temp=a[right-1];
					a[right-1]=a[left];
					a[left]=temp;
					left++;
					right--;
				}
				else if(a[left]<pivot&&a[right-1]<pivot)
				{
					left++;
				}
				else if(a[left]>pivot&&a[right-1]>pivot)
				{
					right--;
				}
				else
				{
					left++;
					right--;
				}
				
			}

			
			for(int i=l;i<r;i++)
			{
				
				if(a[i]>pivot&&i!=l)
				{
					a[r]=a[i];
					a[i]=pivot;
					flag=i;
					return flag;
					
				}
				else if(a[i]>pivot&&i==l)
				{
					a[r]=a[l];
					a[l]=pivot;
					flag=l;
					return flag;
				}
				
			}
			
			return r;
			
		}
		
		
		static void print(double []a)
		{
			for(int i=0;i<a.length;i++)
			{
				System.out.print(a[i]);
				String s=(i==a.length-1)?" \n":" < ";
				System.out.print(s);
				
			}
		}
}
