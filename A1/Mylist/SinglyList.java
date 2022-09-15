package Mylist;

public class SinglyList<T> implements List<T> {
	private Node<T> head;
	private Node<T> tail;
	private Node<T> current;
	private int size;
	SinglyList(int sz)
	{
		size=sz;
	}
	
	SinglyList()
	{	
		current=tail=head=new Node<T>(null);
		size=0;
	}

	@Override
	public void clear() {
		head.setElement(null);
		current=tail=head=new Node<T>(null);
		size=0;
	}

	@Override
	public void insert(T item) {
		// TODO Auto-generated method stub
		current.setNextNode(new Node<T>(item,null));
		if(tail==current)
			tail=current.next();
		size++;
	}

	@Override
	public void append(T item) {
		// TODO Auto-generated method stub
		tail=tail.setNextNode(new Node<T>(item,null));
		size++;
	}

	@Override
	public T remove() {
		 T it = null;
		// TODO Auto-generated method stub
		if(current.next().element()==null)
		{

			 it = current.next().element();
		}
		if(tail==current.next())
		{
			tail=current;
		}
		current.setNextNode(current.next().next());
		size--;
		return it;
	}

	@Override
	public void moveToStart() {
		// TODO Auto-generated method stub
		current=head;
	}

	@Override
	public void moveToEnd() {
		// TODO Auto-generated method stub
		current=tail;
	}

	@Override
	public void prev() {
		// TODO Auto-generated method stub
		if(current==head)return;
		Node<T> temp=head;
		while(temp.next()!=current)
		{
			temp=temp.next();
		}
		current=temp;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		if(current==tail)return;
		else
		{
			current=current.next();
		}
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return size;
	}
	
	
	
	public int find(T t)
	{
		Node<T> temp=head;
		int i=0;
		for(i=0;i<size;i++)
		{
			if(temp.next().element()==t)
				return i;
			else
			{
				temp=temp.next();
			}
		}
		return i;
	}
	
	@Override
	public int currPos() {
		// TODO Auto-generated method stub
		Node<T> temp=head;
		int i=0;
		for(i=0;i<size;i++)
		{
			if(temp==current)
				return i;
			else
			{
				temp=temp.next();
			}
		}
		return i;
	}

	@Override
	public void moveToPos(int pos) {
		// TODO Auto-generated method stub
		Node<T> temp=head;
		for(int i=0;i<pos;i++)
		{
			temp=temp.next();
		}
	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return current.next().element();
	}
	
	public T getValue(int pos) {
		Node<T> temp=head;
		
		// TODO Auto-generated method stub
		for(int i=0;i<pos;i++)
		{
			if(i<pos-1)temp=temp.next();
			else
			{
				return temp.next().element();
			}
			
		}
		return temp.next().element();
	}
	

}
