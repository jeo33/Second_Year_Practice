package Mylist;

public class DoubleNode<T> {
	
	
	
	
	private T elements;
	private DoubleNode<T> next;
	private DoubleNode<T> previous;
	DoubleNode(T value,DoubleNode<T> previousnode,DoubleNode<T> nextnode)
	{
		elements=value;
		next=nextnode;
		previous=previousnode;
	}
	

	DoubleNode(DoubleNode<T> previousnode,DoubleNode<T> nextnode)
	{
		next=nextnode;
		previous=previousnode;
	}
	
	DoubleNode<T> next()
	{
		return next;
	}
	

	DoubleNode<T> setNextNode(DoubleNode<T> nextnode)
	{
		next=nextnode;
		return next;
	}
	
	DoubleNode<T> previous()
	{
		return previous;
	}
	

	DoubleNode<T> setPreviousNode(DoubleNode<T> previousnode)
	{
		previous=previousnode;
		return previous;
	}
	
	
	T element()
	{
		return elements;
	}
	
	
	T setElement(T setElementValue)
	{
		return elements=setElementValue;
	}
	
	
	
}
