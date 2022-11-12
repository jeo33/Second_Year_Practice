package Mylist;

public class InventoryRecord{
	// Data members
	String ID;
	String name;
	String description;
	double unitPrice;
	int qtyInStock;
	double inventoryValue;
	int reorderLevel;
	int reorderTime;
	int reorderQty;
	String discontinued;
	
	// Constructor
	InventoryRecord(String id, String nm, String des, double up, int qs, double iv, int rl, int rt, int rq, String dis)
	{
		ID = id;
		name = nm;
		description = des;
		unitPrice = up;
		qtyInStock = qs;
		inventoryValue = iv;
		reorderLevel = rl;
		reorderTime = rt;
		reorderQty = rq;
		discontinued = dis;
	}
	InventoryRecord()
	{
		ID = "";
		name = "";
		description = "";
		unitPrice = 0;
		qtyInStock = 0;
		inventoryValue =0;
		reorderLevel = 0;
		reorderTime = 0;
		reorderQty = 0;
		discontinued = "";
	}
	
	// Getter and setter
	public String getID() {return ID;}
	public String getName() {return name;}
	public String getDescription() {return description;}
	public double getUnitPrice() {return unitPrice;}
	public int getQtyInStock() {return qtyInStock;}
	public double getInventoryValue() {return inventoryValue;}
	public int getReorderLevel() {return reorderLevel;}
	public int getReorderTime() {return reorderTime;}
	public int getReorderQty() {return reorderQty;}
	public String getDiscontinuity() {return discontinued;}
	
	public void setID(String id) {ID = id;}
	public void setName(String nm) {name = nm;}
	public void setDescription(String des) { description = des;}
	public void setUnitPrice(double up) {unitPrice = up;}
	public void setQtyInStock(int qs) {qtyInStock = qs;}
	public void setInventoryValue(double iv) {inventoryValue = iv;}
	public void setReorderLevel(int rl) {reorderLevel = rl;}
	public void setReorderTime(int rt) {reorderTime = rt;}
	public void setReorderQty(int rq) {reorderQty = rq;}
	public void setDiscontinuity(String dis) {discontinued = dis;}
	
	public int compareName(InventoryRecord ir) { return this.name.compareTo(ir.getName()); }
	public int compareDescription(InventoryRecord ir) { return this.description.compareTo(ir.getDescription()); }
	public double compareUnitPrice(InventoryRecord ir) { return (this.unitPrice - ir.getUnitPrice()); }
	public int compareQtyInStock(InventoryRecord ir) { return (this.qtyInStock - ir.getQtyInStock()); }
	public double compareInventoryValue(InventoryRecord ir) { return (this.inventoryValue - ir.getInventoryValue()); }
	public int compareReorderLevel(InventoryRecord ir) { return (this.reorderLevel - ir.getReorderLevel()); }
	public int compareReorderTime(InventoryRecord ir) { return (this.reorderTime - ir.getReorderTime()); }
	public int compareReorderQty(InventoryRecord ir) { return (this.reorderQty - ir.getReorderQty()); }
	public int compareDiscontinuity(InventoryRecord ir) { return this.discontinued.compareTo(ir.getDescription()); }
	
	// Utility print function
	public void printRecord() {
		System.out.println("***************************");
		System.out.println("ID: " + ID);
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Unit Price: " + unitPrice);
		System.out.println("Quantity in Stock: " + qtyInStock);
		System.out.println("Inventory Value: " + inventoryValue);
		System.out.println("Reroder Level: " + reorderLevel);
		System.out.println("Reorder Time in Days: " + reorderTime);
		System.out.println("Quantity in Reorder: " + reorderQty);
		System.out.println("Discontinued?: " + discontinued);
		System.out.println("***************************");
	}
	
	
}