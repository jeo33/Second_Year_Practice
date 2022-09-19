package Mylist;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Mylist.SinglyList;

public class test {
	
	
	public static void main(String[] args)
	{

		SinglyListDictionary<Integer, String> dict = new SinglyListDictionary<Integer, String>(10);
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		System.out.println(dict.find(3));
		dict.show();
		
		
	}}