package Mylist;

import java.util.Scanner;

import Mylist.WarehouseInventory;

public class WarehouseInventory extends SinglyListDictionary<String,InventoryRecord> {
		static // Data members
		public int cmd=0;
		InventoryRecord temp;
		public String temp_key;
		Scanner scanner_in= new Scanner(System.in);
		tool util=new tool();
	WarehouseInventory()//Constructor
	{
		this.clear();
	}
	
	
	public double[] createIndex(String attribute)
	{	
		double[] temp=new double[this.size()];
		switch(attribute)
		{
		case "unitprice":
			for(int i=0;i<this.getSize();i++)
			{
				temp[i]=vList.getValue().getUnitPrice();
				vList.next();
			}
			break;
		case "quantityinstock":
			for(int i=0;i<this.getSize();i++)
			{
				temp[i]=vList.getValue().getQtyInStock();
				vList.next();
			}
			break;
		case "inventroyvalue":
			for(int i=0;i<this.getSize();i++)
			{
				temp[i]=vList.getValue().getInventoryValue();
				vList.next();
			}
			break;
		case "recorderlevel":
			for(int i=0;i<this.getSize();i++)
			{
				temp[i]=vList.getValue().getReorderLevel();
				vList.next();
			}
			break;
		case "reordertime":
			for(int i=0;i<this.getSize();i++)
			{
				temp[i]=vList.getValue().getReorderTime();
				vList.next();
			}
			break;
		case "reorderqty":
			for(int i=0;i<this.getSize();i++)
			{
				temp[i]=vList.getValue().getReorderQty();
				vList.next();
			}
			break;
		}
		
		util.QS(temp,0,vList.size()-1);
		util.print(temp);
		return temp;
		
	}
	
	
	
	
	//return sum of all values
	double TotalIventoryValue(WarehouseInventory a)
	{
		double sum=0;
		a.vList.moveToStart();//start at the head
		for(int i=0;i<a.size();i++)//iterator to all elements
		{
			sum+=a.vList.getValue().getInventoryValue();//sum
			a.vList.next();
		}
		return sum;//return
	}
	//use iterator and prinRecord() to show all the data
	void printAllData(WarehouseInventory a)
	{
		
		a.vList.moveToStart();
		for(int i=0;i<a.size();i++)
		{
			a.vList.getValue().printRecord();
			a.vList.next();
		
		}
	}
	//main function 
	
	
	
	
	//initialization of WarehouseInventory
	void init()
	{
		InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
		InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
		InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
		InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
		InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
		InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");
		InventoryRecord R7=new InventoryRecord("IN0007"	,"Item 7","Desc 7",56.00 ,58,3248.00,109,7,100,"yes");
		InventoryRecord R8=new InventoryRecord("IN0008"	,"Item 8","Desc 8",38.00 ,101,3838.00,162,3,100,"null");
		InventoryRecord R9=new InventoryRecord("IN0009"	,"Item 9","Desc 9",59.00 ,122,7198.00,82,3,150,"null");
		InventoryRecord R10=new InventoryRecord("IN0010","Item 10","Desc 10",50.00 ,175,8750.00,283,8,150,"null");
		InventoryRecord R11=new InventoryRecord("IN0011","Item 11","Desc 11",59.00 ,176,10384.00,229,1,100,"null");
		InventoryRecord R12=new InventoryRecord("IN0012","Item 12","Desc 12",18.00 ,22,396.00,36,12,50,"null");
		InventoryRecord R13=new InventoryRecord("IN0013","Item 13","Desc 13",26.00 ,72,1872.00,102,9,100,"null");
		InventoryRecord R14=new InventoryRecord("IN0014","Item 14","Desc 14",42.00 ,62,2604.00,83,2,100,"null");
		InventoryRecord R15=new InventoryRecord("IN0015","Item 15","Desc 15",32.00 ,46,1472.00,23,15,50,"null");
		InventoryRecord R16=new InventoryRecord("IN0016","Item 16","Desc 16",90.00 ,96,8640.00,180,3,50,"null");
		InventoryRecord R17=new InventoryRecord("IN0017","Item 17","Desc 17",97.00 ,57,5529.00,98,12,150,"yes");
		InventoryRecord R18=new InventoryRecord("IN0018","Item 18","Desc 18",12.00 ,6,72.00,7,13,50,"null");
		InventoryRecord R19=new InventoryRecord("IN0019","Item 19","Desc 19",82.00 ,143,11726.00,164,12,50,"null");
		InventoryRecord R20=new InventoryRecord("IN0020","Item 20","Desc 20",16.00 ,124,1984.00,113,14,50,"null");
		InventoryRecord R21=new InventoryRecord("IN0021","Item 21","Desc 21",19.00 ,112,2128.00,75,11,50,"null");
		InventoryRecord R22=new InventoryRecord("IN0022","Item 22","Desc 22",24.00 ,182,4368.00,132,15,150,"null");
		InventoryRecord R23=new InventoryRecord("IN0023","Item 23","Desc 23",29.00 ,106,3074.00,142,1,150,"yes");
		InventoryRecord R24=new InventoryRecord("IN0024","Item 24","Desc 24",75.00 ,173,12975.00,127,9,100,"null");
		InventoryRecord R25=new InventoryRecord("IN0025","Item 25","Desc 25",14.00 ,28,392.00,21,8,50,"null");
		this.insert(R1.getID(), R1);
		this.insert(R2.getID(), R2);
		this.insert(R3.getID(), R3);
		this.insert(R4.getID(), R4);
		this.insert(R5.getID(), R5);
		this.insert(R6.getID(), R6);
		this.insert(R7.getID(), R7);
		this.insert(R8.getID(), R8);
		this.insert(R9.getID(), R9);
		this.insert(R10.getID(), R10);
		this.insert(R11.getID(), R11);
		this.insert(R12.getID(), R12);
		this.insert(R13.getID(), R13);
		this.insert(R14.getID(), R14);
		this.insert(R15.getID(), R15);
		this.insert(R16.getID(), R16);
		this.insert(R17.getID(), R17);
		this.insert(R18.getID(), R18);
		this.insert(R19.getID(), R19);
		this.insert(R20.getID(), R20);
		this.insert(R21.getID(), R21);
		this.insert(R22.getID(), R22);
		this.insert(R23.getID(), R23);
		this.insert(R24.getID(), R24);
		this.insert(R25.getID(), R25);
	}
	
	//command for menu
	void command(WarehouseInventory a)
	{
		
		do
		{	
			menuDidsplay();
			System.out.println("Please type command ");
			cmd=scanner_in.nextInt();
			switch(cmd)
			{
			case 1:
				temp=newRecord();
				a.insert(temp.getID(), temp);
				break;
			case 2:
				System.out.println("Please type the ID for the item ");
				temp_key = scanner_in.next();
				a.remove(temp_key).printRecord();
				break;
			case 3:
				this.clear();
				if(a.size()==0)System.out.println("->>>>>>>>>>>Clear all");
				else System.out.println("fail to removeAll");
					
				break;
			case 4:
				System.out.println("Please type the ID for the item ");
				temp_key = scanner_in.next();
				a.find(temp_key).printRecord();
				break;
			case 5:
				System.out.println(a.getSize());
				break;
			case 6:
				System.out.println("total value: "+TotalIventoryValue(a));
				break;
			case 7:
				System.out.println("Please type the attributes for the item ");
				String ID1 = scanner_in.next();
				createIndex(ID1);
				break;
			case 8:
				a.printAllData(a);
				break;
			}
		}while(cmd!=0);
	}

	//take input function
	InventoryRecord newRecord()
	{
		
			System.out.println("Please type the ID for the item ");
			String ID1 = scanner_in.next();
			while(kList.checkIn(ID1))
			{
				System.out.println("ID duplicated,Please type the ID for the item ");
				 ID1 = scanner_in.next();
			}
			System.out.println("Please type the name  for the item ");
			String name = scanner_in.next();
			System.out.println("Please type the description for the item");
			String description = scanner_in.next();
			System.out.println("Please type the Unit price for the item ");
			double unitprice = scanner_in.nextDouble();
			System.out.println("Please type the quntity in stock  for the item ");
			int quantityinstock = scanner_in.nextInt();
			System.out.println("Please type the inventory value for the item ");
			double inventroyvalue = scanner_in.nextDouble();
			System.out.println("Please type the recorder level for the item ");
			int recorderlevel = scanner_in.nextInt();
			System.out.println("Please type the Recorder TIme in day for the item ");
			int RecorderTimeinDay = scanner_in.nextInt();
			System.out.println("Please type the quantity in order for the item ");
			int quantityinorder = scanner_in.nextInt();
			System.out.println("Please type the Dsiscontinued for the item ");
			String Dsiscontinued = scanner_in.next();
			
			InventoryRecord s = new InventoryRecord( ID1,  name,  description, 
					unitprice,  quantityinstock,  inventroyvalue,  recorderlevel,
					RecorderTimeinDay,  quantityinorder,  Dsiscontinued);
			
			System.out.println("Success！");
			return s;
		
	}
	
	//show menu
	static void menuDidsplay() 
	{
		System.out.println("************** WarehouseInventory ******" );
		System.out.println("1. Insert a record");
		System.out.println("2. Remove a record given a key");
		System.out.println("3. Clear the database (removeAll)");
		System.out.println("4. Find a record given a key");
		System.out.println("5. Return the number of inventories in the database");
		System.out.println("6. Return the total value of all the inventories ");
		System.out.println("0. Exit");
		System.out.println("*****************************************");
	}
}