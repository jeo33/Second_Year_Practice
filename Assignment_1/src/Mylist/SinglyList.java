package Mylist;

public class SinglyList<T> implements List<T> {
	private Node<T> head;
	private Node<T> tail;
	private Node<T> current;
	private int size;
	
	
	SinglyList()
	{	
		current=tail=head=new Node<T>(null);
		size=0;
	}

	@Override
	public void clear() {
		head.setNextNode(null);
		current=tail=head=new Node<T>(null);
		size=0;
	}

	@Override
	public void insert(T item) {
		// TODO Auto-generated method stub
		current.setNextNode(new Node<T>(item,current.next()));
		if(tail==current)
			tail=current.next();
		current=current.next();
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
		 
		// TODO Auto-generated method stub
		if(current.next()==null)
		{
			return null;
		}
		T item =current.next().element();
		if(tail==current.next())
		{
			tail=current;
		}
		current.setNextNode(current.next().next());
		size--;
		return item;
	}
	public int size() {
		// TODO Auto-generated method stub
		return size;
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
				{
				
				//System.out.print("this is the position");
				//System.out.println(i);
				return i;
				}
			else
			{
				//System.out.print("Cant find at ");
				//System.out.println(i);
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
		for(int i=0;i<=pos;i++)
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
		int i=0;
		// TODO Auto-generated method stub

		while(i!=pos)
		{
			temp=temp.next();
			i++;
		}
		return temp.next().element();
	}
	

}
