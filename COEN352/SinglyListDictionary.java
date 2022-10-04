package Mylist;

public class SinglyListDictionary<Key,E> implements ADTDictionary<Key,E>{
	
	
	private SinglyList<Key> kList;
	private SinglyList<E> vList;
	private int size;
	SinglyListDictionary() { 
		 setSize(0);
	}
	
	SinglyListDictionary(int sz){ 
		kList = new SinglyList<Key>(sz); 
		vList = new SinglyList<E>(sz);
		setSize(sz);
	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		kList.clear();
		vList.clear();
		setSize(0);
	}

	
	@Override
	public void insert(Key k, E e) {
		// TODO Auto-generated method stub
		kList.append(k);
		vList.append(e);
		size++;
	}

	
	public void show()
	{	int i=0;
		while(i!=size)
		{	
			System.out.println("this is the K: "+kList.getValue(i));
			System.out.println("this is the member: "+vList.getValue(i));
			i++;
		}
	}
	
	
	
	@Override

	public E find(Key k)
	{
		int pos=kList.find(k);
		if(pos>=0&&pos<kList.length())
			return vList.getValue(pos);
		return null;
	}
	
	
	
	@Override
	public E remove(Key k) {
		// TODO Auto-generated method stub
		E temp=find(k);
		int currentPose=kList.currPos();
		if(temp!=null)
		{
			int Pos=kList.find(k);
			kList.moveToPos(Pos);
			vList.moveToPos(Pos);
			kList.remove();
			vList.remove();
		}
		kList.moveToPos(currentPose-1);
		vList.moveToPos(currentPose-1);
		
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
