package Mylist;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class test {
	
	private static SinglyListDictionary<Integer, String> Dict_Singly;
	private static DoubleListDictionary<Integer, String> Dict_Double;
	private static WarehouseInventory WarehouseDict;
	private static BinarySearchTree BSTtest;
	private static double[] ArrayIndex;
	
	public static InventoryRecord temp;
	
	
	//set up 
	@BeforeAll
	public static void setUp() {
		Dict_Singly = new SinglyListDictionary<Integer, String>();
		Dict_Double = new DoubleListDictionary<Integer, String>();
		WarehouseDict = new WarehouseInventory();
		temp = new InventoryRecord();
	}
		
	
	
	  @Test	
	  void testQuery_unitprice() {
		  WarehouseDict.clear();
			//WarehouseDict.init();
			InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
			InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
			InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
			InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
			InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
			InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");
			WarehouseDict.insert(R1.getID(), R1);
			WarehouseDict.insert(R2.getID(), R2);
			WarehouseDict.insert(R3.getID(), R3);
			WarehouseDict.insert(R4.getID(), R4);
			WarehouseDict.insert(R5.getID(), R5);
			WarehouseDict.insert(R6.getID(), R6);
			WarehouseDict.createIndex("unitprice");
	    assertEquals(11.00, WarehouseDict.query("unitprice", 0));
	    assertEquals(11.00, WarehouseDict.query("unitprice", 0.2));
	    assertEquals(19.00, WarehouseDict.query("unitprice", 0.4));
	    assertEquals(57.00, WarehouseDict.query("unitprice", 0.8));
	    assertEquals(93.00, WarehouseDict.query("unitprice", 1));
	  }
	
	
	  
	  @Test	
	  void testQuery_getQtyInStock() {
		  WarehouseDict.clear();
			//WarehouseDict.init();
			InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
			InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
			InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
			InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
			InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
			InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");
			WarehouseDict.insert(R1.getID(), R1);
			WarehouseDict.insert(R2.getID(), R2);
			WarehouseDict.insert(R3.getID(), R3);
			WarehouseDict.insert(R4.getID(), R4);
			WarehouseDict.insert(R5.getID(), R5);
			WarehouseDict.insert(R6.getID(), R6);
			WarehouseDict.createIndex("quantityinstock");
	    assertEquals(5.00, WarehouseDict.query("quantityinstock", 0));
	    assertEquals(5.00, WarehouseDict.query("quantityinstock", 0.2));
	    assertEquals(25.00, WarehouseDict.query("quantityinstock", 0.4));
	    assertEquals(132.00, WarehouseDict.query("quantityinstock", 0.8));
	    assertEquals(186.00, WarehouseDict.query("quantityinstock", 1));
	  }
	  
	  
	

	
	
	//SinglyListDictionaryTestClear()     test
	
	@Test
	void SinglyListDictionaryTestClear() 
	 {
		 Dict_Singly.clear();
		assertEquals(0, Dict_Singly.size(), "clear failed, size is non zero");
	}
	//DoubleListDictionaryTestClear()     test
	
	@Test
	void DoubleListDictionaryTestClear() 
	 {
		Dict_Double.clear();
		assertEquals(0, Dict_Double.size(), "clear failed, size is non zero");
	}

	//WarehouseInventoryTestClear()     test
	@Test
	void WarehouseInventoryTestClear() 
	 {
		WarehouseDict.clear();
		assertEquals(0, WarehouseDict.size(), "clear failed, size is non zero");
	}


	//SinglyListDictionaryTestInsert()    test
	@Test
	void SinglyListDictionaryTestInsert() 
	{
		Dict_Singly.clear();
		Dict_Singly.insert(0, "red");
		Dict_Singly.insert(1, "blue");
		Dict_Singly.insert(2,"yellow");
		Dict_Singly.insert(3, "grey");
		assertEquals(4, Dict_Singly.size(), "insert failed, size is not as expected");
	}

	//DoubleListDictionaryTestInsert()    test
	@Test
	void DoubleListDictionaryTestInsert() 
	{
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");
		assertEquals(4, Dict_Double.size(), "insert failed, size is not as expected");
	}
	//WarehouseInventoryTestInsert()    test
	
	@Test
	void WarehouseInventoryTestInsert() 
	{
		WarehouseDict.clear();
		//WarehouseDict.init();
		InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
		InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
		InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
		InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
		InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
		InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");
		WarehouseDict.insert(R1.getID(), R1);
		WarehouseDict.insert(R2.getID(), R2);
		WarehouseDict.insert(R3.getID(), R3);
		WarehouseDict.insert(R4.getID(), R4);
		WarehouseDict.insert(R5.getID(), R5);
		WarehouseDict.insert(R6.getID(), R6);
		assertEquals(6, WarehouseDict.size(), "insert failed, size is not as expected");
		
	}

	
	
	//SinglyListDictionaryTestRemove()   test
	
	@Test
	void SinglyListDictionaryTestRemove() 
	{
		
		Dict_Singly.clear();
		Dict_Singly.insert(0, "red");
		Dict_Singly.insert(1, "blue");
		Dict_Singly.insert(2,"yellow");
		Dict_Singly.insert(3, "grey");
		Dict_Singly.remove(0);
		assertEquals("grey", Dict_Singly.find(3), "remove failed"); 
		
	}
	//DoubleListDictionaryTestRemove()   test

	@Test
	void DoubleListDictionaryTestRemove() 
	{
		
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");
		Dict_Double.remove(0);
		assertEquals("grey", Dict_Double.find(3), "remove failed"); 
		
	}

	//WarehouseInventoryTestRemove()   test
	@Test
	void WarehouseInventoryTestRemove() 
	{
		
		WarehouseDict.clear();
		InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
		InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
		InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
		InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
		InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
		InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");
		WarehouseDict.insert(R1.getID(), R1);
		WarehouseDict.insert(R2.getID(), R2);
		WarehouseDict.insert(R3.getID(), R3);
		WarehouseDict.insert(R4.getID(), R4);
		WarehouseDict.insert(R5.getID(), R5);
		WarehouseDict.insert(R6.getID(), R6);
		temp=WarehouseDict.remove("IN0002");
		assertEquals(R2, temp, "remove failed"); 
	}


	//SinglyListDictionaryTestRemoveAny()  test
	
	@Test
	void SinglyListDictionaryTestRemoveAny() 
	{
		Dict_Singly.clear();
		Dict_Singly.insert(0, "red");
		Dict_Singly.insert(1, "blue");
		Dict_Singly.insert(2,"yellow");
		Dict_Singly.insert(3, "grey");
		assertNotEquals("grey", Dict_Singly.removeAny(), "removeAny failed"); 
		
	}
	//DoubleListDictionaryTestRemoveAny()  test
	@Test
	void DoubleListDictionaryTestRemoveAny() 
	{
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");
		assertNotEquals("grey", Dict_Double.removeAny(), "removeAny failed"); 
		
	}
	//WarehouseInventoryTestRemoveAny()  test
	@Test
	void WarehouseInventoryTestRemoveAny() 
	{
		WarehouseDict.clear();
		InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
		InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
		InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
		InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
		InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
		InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");
		WarehouseDict.insert(R1.getID(), R1);
		WarehouseDict.insert(R2.getID(), R2);
		WarehouseDict.insert(R3.getID(), R3);
		WarehouseDict.insert(R4.getID(), R4);
		WarehouseDict.insert(R5.getID(), R5);
		WarehouseDict.insert(R6.getID(), R6);
		assertNotEquals(R6, WarehouseDict.removeAny(), "removeAny failed"); 
		
	}


	//SinglyListDictionaryTestFind() test
	
	@Test
	void SinglyListDictionaryTestFind() 
	{
		Dict_Singly.clear();
		Dict_Singly.insert(0, "red");
		Dict_Singly.insert(1, "blue");
		Dict_Singly.insert(2,"yellow");
		Dict_Singly.insert(3, "grey");	
		assertEquals("yellow", Dict_Singly.find(2), "find failed"); 
	}

	

	//DoubleListDictionaryTestFind() test
	@Test
	void DoubleListDictionaryTestFind() 
	{
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");	
		assertEquals("yellow", Dict_Double.find(2), "find failed"); 
	}

	//WarehouseInventoryTestFind() test
	
	@Test
	void WarehouseInventoryTestFind() 
	{
		
		WarehouseDict.clear();
		InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
		InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
		InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
		InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
		InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
		InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");
		WarehouseDict.insert(R1.getID(), R1);
		WarehouseDict.insert(R2.getID(), R2);
		WarehouseDict.insert(R3.getID(), R3);
		WarehouseDict.insert(R4.getID(), R4);
		WarehouseDict.insert(R5.getID(), R5);
		WarehouseDict.insert(R6.getID(), R6);
		assertEquals(R5, WarehouseDict.find("IN0005"), "find failed"); 	
	}

	//SinglyListDictionaryTestSize() test
	@Test
	void SinglyListDictionaryTestSize() 
	 {
		 Dict_Singly.clear();
		 Dict_Singly.insert(0, "red");
		 Dict_Singly.insert(1, "blue");
		 Dict_Singly.insert(2,"yellow");
		 Dict_Singly.insert(3, "grey");	
		assertEquals(4, Dict_Singly.size(), "size failed, size is not as expected");
	}
	//DoubleListDictionaryTestSize() test
	@Test
	void DoubleListDictionaryTestSize() 
	 {
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");	
		assertEquals(4, Dict_Double.size(), "size failed, size is not as expected");
	}
	//WarehouseInventoryTestSize() test
	@Test
	void WarehouseInventoryTestSize() 
	 {
		WarehouseDict.clear();
		InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
		InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
		InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
		InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
		InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
		InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");
		WarehouseDict.insert(R1.getID(), R1);
		WarehouseDict.insert(R2.getID(), R2);
		WarehouseDict.insert(R3.getID(), R3);
		WarehouseDict.insert(R4.getID(), R4);
		WarehouseDict.insert(R5.getID(), R5);
		WarehouseDict.insert(R6.getID(), R6);
		assertEquals(6, WarehouseDict.size(), "size failed, size is not as expected");
	}
}