package Mylist;

public class DoubleNode<T> {
	
	
	
	
	private T elements;
	private DoubleNode<T> next;
	private DoubleNode<T> previous;
	//constructor
	DoubleNode(T value,DoubleNode<T> previousnode,DoubleNode<T> nextnode)
	{
		elements=value;
		next=nextnode;
		previous=previousnode;
	}
	

	//constructor
	DoubleNode(DoubleNode<T> previousnode,DoubleNode<T> nextnode)
	{
		next=nextnode;
		previous=previousnode;
	}

	//get for next
	DoubleNode<T> next()
	{
		return next;
	}
	
	//set for next
	DoubleNode<T> setNextNode(DoubleNode<T> nextnode)
	{
		next=nextnode;
		return next;
	}
	//get for previous
	DoubleNode<T> previous()
	{
		return previous;
	}
	

	//set for previous
	DoubleNode<T> setPreviousNode(DoubleNode<T> previousnode)
	{
		previous=previousnode;
		return previous;
	}
	

	//get for element
	T element()
	{
		return elements;
	}
	

	//set for element
	T setElement(T setElementValue)
	{
		return elements=setElementValue;
	}
	
	
	
}
