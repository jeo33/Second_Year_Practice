package Mylist;

public interface TutorialInterface<E> {
	
	public void clear();
	
	public void insert(E item,int pos);
	
	public void append(E item);
	
	public E remove();
	
	public void moveToStart();
	
	public void moveToEnd();
	
	public void prev();
	
	public void next();
	
	public int length();
	
	public int currPos();
	
	public void moveToPos(int pos);
	
	public E getValue();
	
}
