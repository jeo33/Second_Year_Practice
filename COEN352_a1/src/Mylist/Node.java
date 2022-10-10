package Mylist;

public class Node<T> {
	
	
	
	
	private T elements;
	private Node<T> next;
	//constructor
	Node(T value,Node<T> nextnode)
	{
		elements=value;
		next=nextnode;
	}
	

	Node(Node<T> nextnode)
	{
		next=nextnode;
	}
	

	//get next
	Node<T> next()
	{
		return next;
	}
	

	//set next
	Node<T> setNextNode(Node<T> nextnode)
	{
		next=nextnode;
		return next;
	}
	

	//set element
	T element()
	{
		return elements;
	}

	//get element
	T setElement(T setElementValue)
	{
		return elements=setElementValue;
	}
	
	
	
}
