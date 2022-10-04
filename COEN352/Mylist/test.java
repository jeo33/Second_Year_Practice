package Mylist;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Mylist.SinglyList;

public class test {
	
	
	private static DoubleListDictionary<Integer, String> dict;
	  
	@BeforeAll
	public static void setUp() {
		dict = new DoubleListDictionary<Integer, String>();
	}
		

	
	 @Test
	void testClear() 
	 {
		dict.clear();
		assertEquals(0, dict.size(), "clear failed, size is non zero");
	}

	@Test
	void testInsert() 
	{
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		assertEquals(4, dict.size(), "insert failed, size is not as expected");
	}

	@Test
	void testRemove() 
	{
		
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		dict.remove(0);
		dict.show();
		
		//assertEquals("1:blue , 2:yellow , 3:grey ,", dict.toString());
		
		assertEquals("grey", dict.find(3), "remove failed"); 
		
	}

	@Test
	void testRemoveAny() 
	{
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		assertNotEquals("grey", dict.removeAny(), "removeAny failed"); 
		
	}
	

	@Test
	void testFind() 
	{
		
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");	
		assertEquals("yellow", dict.find(2), "find failed"); 
	}

	
	 @Test
	void testSize() 
	 {
		dict.clear();
		dict.insert(0, "red");

		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");	
	
		
		assertEquals(4, dict.size(), "size failed, size is not as expected");
	}


	 
		
		
	}