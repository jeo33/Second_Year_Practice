package Mylist;

public class ArrayBasedList<E> implements TutorialInterface<E> {
	private  static final int Maxsize=20;
	private int currentSize;
	private E[] myArray;
	private int currentPosition;
	@SuppressWarnings("unchecked")
	ArrayBasedList(int SZ)
	{	currentSize=SZ;
		currentPosition=SZ;
		myArray =(E[]) new Object[SZ];
	}
	ArrayBasedList()
	{	
		this(Maxsize);
	}
	
	@Override
	public void clear() {
		for(int i=0;i<currentSize;i++)
		{
			myArray[i]=null;
			currentSize--;
		}
		
	}

	

	@Override
	public void append(E item) {
		// TODO Auto-generated method stub
		if(currentSize+1<=Maxsize)
		{
			myArray[currentSize]=null;
			currentSize++;
		}
		else 
		{
			
		}
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		
		if(currentSize>0)
		{
			E temp=myArray[currentSize];
			currentSize--;
			return temp;
		}
		return null;
	}

	@Override
	public void moveToStart() {
		currentPosition=0;
		
	}

	@Override
	public void moveToEnd() {
		currentSize=currentPosition;
		
	}

	@Override
	public void prev() {
		if(currentPosition<currentSize)
		{
			currentPosition--;
		}
		
	}

	@Override
	public void next() {
		if(currentPosition<currentSize)
		{
			currentPosition++;
		}
		
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return currentSize;
	}

	@Override
	public int currPos() {
		// TODO Auto-generated method stub
		return currentPosition;
	}

	@Override
	public void moveToPos(int pos) {
		currentPosition=pos;
		
	}

	@Override
	public E getValue() {
		if(currentSize!=0)
		{
			return myArray[currentPosition];
		}
		else
		return null;
	}
	@Override
	public void insert(E item, int pos) {
		// TODO Auto-generated method stub
		
	}
	
}
