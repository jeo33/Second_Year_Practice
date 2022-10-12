package exam;


public class sort {
	
	
	
	static int[] insert(int[] a)
	{	int temp = 0;
		for(int i=1;i<a.length;i++)
		{
			for(int j=i;j>=1;j--)
			{
				if(a[j-1]>a[j])
				{
					temp=a[j-1];
					a[j-1]=a[j];
					a[j]=temp;
				}
				else
					break;
			}
			System.out.println("After first "+i +" sort");
			print(a);
			
		}
		return a;
	}
	
	/*
	 * static int[] insert(int[] a,int l,int r)
	{	int temp = 0;
		for(int i=l+1;i<(r-l-1);i++)
		{
			for(int j=i;j>l;j--)
			{
				if(a[j-1]>a[j])
				{
					temp=a[j-1];
					a[j-1]=a[j];
					a[j]=temp;
				}
				else
					break;
			}
			System.out.println("After first "+i +" sort");
			print(a);
			
		}
		return a;
	}
	 */
	static int[] insert(int[] a,int start,int increment)
	{	int temp = 0;
		for(int i=start+increment;i<a.length;i+=increment)
		{
			for(int j=i;j>=increment;j-=increment)
			{
				if(a[j-increment]>a[j])
				{
					temp=a[j-increment];
					a[j-increment]=a[j];
					a[j]=temp;
				}
				else
					break;
			}
			System.out.println("After first "+i +" sort");
			print(a);
			
		}
		return a;
	}
	
	
	static int[] bubble(int[] a)
	{	int temp = 0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
				else continue;
			}
			print(a);
		}
		return a;
	}
	
	static int[] selection(int[] a)
	{	int temp = 0;
		int p=0;
		for(int i=0;i<a.length;i++)
		{			temp=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[temp])
				{
					temp=j;
				}
			}
			p=a[i];
			a[i]=a[temp];
			a[temp]=p;
			
			print(a);
		}
		return a;
	}
	
	static int[] shell(int[] a)
	{	
		for(int increment=a.length/2;increment>1;increment/=2)
		{System.out.println("Increment is : "+increment);
			for(int j=0;j<increment;j++)
			{
				insert(a,j,increment);
			}
		}
		return a;
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
	
	
	
	 
	void mergesort(int[] a, int l, int r) {
	  if(l<r)
	  {
		  int mid = (l+r)/2;
		  mergesort(a, l, mid);
		  mergesort(a,  mid+1, r);
		  merge(a,l,mid,r);
	  }
	  
	  }
	
	
	
	 void merge(int[] a,int l,int temp,int r)
	{
		int l1=temp-l+1;
		int l2=r-temp+1;
		int[] LH=new int[l1];
		int[] RH=new int[l2];
		for(int i=0;i<l1;i++)
		{
			LH[i]=a[l+i];
		}
		for(int i=0;i<l1;i++)
		{
			RH[i]=a[temp+1+i];
		}
		int i=0;
		int j=0;
		int k=l;
		while(i<l1&&j<l2)
		{
			if(LH[i]>RH[j])
			{
				a[k]=RH[j];
				j++;
			}
			else
			{
				a[k]=RH[i];
				i++;
			}
		}
		
		while (i < l1) {
		      a[k] = LH[i];
		      i++;
		      k++;
		    }

		    while (j < l2) {
		      a[k] = RH[j];
		      j++;
		      k++;
		    }
	}
	 public static void main(String[] args)
		{
			int[]a={42,20,17,13,28,14,23,15};

			int[]b={59,20,17,13,28,14,23,83,36,98,11,70,65,41,42,15};
			sort x=new sort();
			System.out.println("Origional:");
			
			sort.print(a);
			x.mergesort(a,0,a.length-1);
			sort.print(a);
			
		}
	
}
