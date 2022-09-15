package Mylist;

public class SinglyListDictionary<Key,E> implements ADTDictionary<Key,E>{
	
	
	private SinglyList<Key> kList;
	private SinglyList<E> vList;
	
	SinglyListDictionary() { 
		 
	}
	
	SinglyListDictionary(int sz){ 
		kList = new SinglyList<Key>(sz); 
		vList = new SinglyList<E>(sz);
	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		kList.clear();
		vList.clear();
	}

	
	@Override
	public void insert(Key k, E e) {
		// TODO Auto-generated method stub
		kList.insert(k);
		vList.insert(e);
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
		kList.moveToPos(currentPose);
		vList.moveToPos(currentPose);
		
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

}
