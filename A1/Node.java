package Mylist;

public class Node<T> {
	
	
	
	
	private T elements;
	private Node<T> next;
	Node(T value,Node<T> nextnode)
	{
		elements=value;
		next=nextnode;
	}
	


	Node(Node<T> nextnode)
	{
		next=nextnode;
	}
	

	Node<T> next()
	{
		return next;
	}
	

	Node<T> setNextNode(Node<T> nextnode)
	{
		next=nextnode;
		return next;
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
