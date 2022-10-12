package exam;

public class QuickSort {
	
	static void QS(int[] a,int left,int right)
	{	
		
		if(left<right)
		{
			
			int flag=p(a,left,right);
			QS(a,left,flag-1);
			QS(a,flag+1,right);
		}
		print(a);
	}
	
	static int p(int[] a,int left,int right)
	{
		int l=left;
		int r=right;
		int flag=0;
		int pivot=a[right];
		
		
		
		while(left<right)
		{
			if(a[left]>pivot&&a[right-1]<pivot)
			{	int temp=a[right-1];
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
	
	
	static void print(int []a)
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]);
			String s=(i==a.length-1)?" \n":"<";
			System.out.print(s);
			
		}
	}
	public static void main(String[] args)
	{
		int[]a={42,20,17,13,28,14,23,15};
		print(a);
		QS(a,0,a.length-1);
		print(a);
	}
	
	
}
