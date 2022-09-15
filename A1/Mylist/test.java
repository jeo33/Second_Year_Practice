package Mylist;
import Mylist.SinglyList;
public class test {
	public static void main(String[] args)
	{

		SinglyList<Integer> a=new SinglyList();
		for(int i=0;i<10;i++)
		{
			a.append(i);
			
		}
		
		System.out.println(a.length());
		a.moveToPos(0);
		for(int i=0;i<a.length();i++)
		{
			System.out.println("value is " +a.getValue());
			System.out.println("Current pos is "+a.currPos());
			a.next();
		}
		for(int i=0;i<a.length();i++)
		{
			System.out.println("Pos  is " +a.find(i));
			a.next();
		}
		
		
	}

}
