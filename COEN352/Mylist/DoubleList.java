package Mylist;

public class DoubleList<T> implements List<T> {

	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	private DoubleNode<T> current;
	private int size;

	
	DoubleList()
	{	
		current=head=new DoubleNode<T>(null,null,null);
		tail=new DoubleNode<T>(null,head,null);
		head.setNextNode(tail);
		size=0;
	}

	@Override
	public void clear() {
		current=head.setNextNode(null);
		tail.setPreviousNode(null);
		size=0;
	}

	@Override
	public void insert(T item) {
		// TODO Auto-generated method stub
		
			current.setNextNode(new DoubleNode<T>(item,current,current.next()));
			current.next().next().setPreviousNode(current.next());
			current=current.next();
			size++;
		
	}

	@Override
	public void append(T item) {
		// TODO Auto-generated method stub
		
			if(size!=0)
			{
				tail.setPreviousNode(new DoubleNode<T>(item,tail.previous(),tail));
				//tail.previous().previous().setNextNode(current);
				tail.previous().previous().setNextNode(tail.previous());
			}
			else
			{
				head.setNextNode(new DoubleNode<T>(item,head,tail));
				tail.setPreviousNode(head.next());
				current=head.next();
			}
			
		
		size++;
	}

	@Override
	public T remove() {
		 
		// TODO Auto-generated method stub
		if(current.next()==tail)
			{
				return null;
			}
		else
			{	T it =current.next().element();
				current.next().next().setPreviousNode(current);
				current.setNextNode(current.next());
				
				size--;
				return it;
				
			}
		
	}
	
	
	public T remove(int pos) {
		 
		// TODO Auto-generated method stub
		if(pos<size)
		{
			return null;
		}
		else
		{	current=head;
			while(pos>=0)
			{
				current=current.next();
				pos--;
			}
			T it =current.next().element();
			current.next().next().setPreviousNode(current);
			current.setNextNode(current.next());
			size--;
			return it;
			
		}
		
		
		
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
		DoubleNode<T> temp=head;
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
		DoubleNode<T> temp=head;
		int i;
		for(i=0;i<size;i++)
		{
			if(temp.next().element()==t)
				{
					
					System.out.print("this is the position");
					System.out.println(i);
					return i;
				}
			else
				{
					System.out.print("Cant find at ");
					System.out.println(i);
					temp=temp.next();
				}
		}
		
		return i;
	}
	
	@Override
	public int currPos() {
		// TODO Auto-generated method stub
		DoubleNode<T> temp=head;
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
		DoubleNode<T> temp=head;
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
		DoubleNode<T> temp=head;
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
