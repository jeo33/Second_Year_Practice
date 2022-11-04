package Mylist;

public class SinglyListDictionary<Key,E> implements ADTDictionary<Key,E>{
	
	
	protected SinglyList<Key> kList;
	protected SinglyList<E> vList;
	private int size;

	//constructor
	SinglyListDictionary(){ 
		kList = new SinglyList<Key>(); 
		vList = new SinglyList<E>();
		size=0;
	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		kList.clear();
		vList.clear();
		setSize(0);
	}

	

	
	

	//insert fore both list
	@Override
	public void insert(Key k, E e) {
		// TODO Auto-generated method stub
		kList.append(k);
		vList.append(e);
		size++;
	}


	//display for manually test
	public void show()
	{	int i=0;
		while(i!=size-1)
		{	
			System.out.println("this is the K: "+kList.getValue(i));
			System.out.println("this is the member: "+vList.getValue(i));
			i++;
		}
	}
	
	//return element by giving a key
	@Override

	public E find(Key k)
	{
		int pos=kList.find(k);
		if(pos>=0&&pos<kList.length())
			
			{
				//System.out.println("find E ");
				return vList.getValue(pos);
			}
		else
		{
			//System.out.println("cant find E ");
			return null;
		}
	}
	
	
	
	
	
	
	//remove element by giving a key
	@Override
	public E remove(Key k) {
		// TODO Auto-generated method stub
	
		
		E temp=find(k);
		int currentPose=kList.find(k);
		kList.remove(currentPose);
		vList.remove(currentPose);
		return temp;
		
	}

	@Override
	public E removeAny() {
		// TODO Auto-generated method stub
		if (size() != 0) {
			  kList.remove();
			  E temp = vList.getValue();
			  vList.remove();
			  return temp;
			}
			else 
				return null;
		
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return kList.length();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
