import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class test {static String Out;

@BeforeEach
public void setUp()
{
  Out = null;
}


@Test
public void testgetPrerequisistePath1() throws IOException {
	  tool t=new tool();
		StringBuffer s=new StringBuffer() ;
		BufferedReader f;
		f=new BufferedReader(new InputStreamReader(new FileInputStream("coen_course.gph")));
		GraphS G=new GraphS();
		COEN c=new COEN(t.createGraph(f,G));
		
		 
		 Out=c.getPrerequisistePath("COEN 490");
		 System.out.println(Out);
		 
		 assertEquals(Out,"MATH 204  ENGR 290  SOEN 341  ENGR 301  ENGR 371  "
		 		+ "COEN 212  COEN 231  COEN 243  COEN 244  "
		 		+ "COEN 311  COEN 352  COEN 390  COEN 490  ");
			
		 
}



@Test
public void testgetIsPrerequisiste1() throws IOException {
	  tool t=new tool();
		StringBuffer s=new StringBuffer() ;
		BufferedReader f;
		f=new BufferedReader(new InputStreamReader(new FileInputStream("coen_course.gph")));
		GraphS G=new GraphS();
		COEN c=new COEN(t.createGraph(f,G));
		 assertEquals(c.isPrerequisite("ENGR 371", "COEN 490"),true);
		 assertEquals(c.isPrerequisite("SOEN 341", "COEN 490"),true);
		 assertEquals(c.isPrerequisite("ENGR 301", "COEN 490"),true);
		 assertEquals(c.isPrerequisite("COEN 231", "COEN 490"),true);
		 assertEquals(c.isPrerequisite("COEN 243", "COEN 490"),true);
}

@Test
public void testgetPrerequisistePath2() throws IOException {
	  tool t=new tool();
		StringBuffer s=new StringBuffer() ;
		BufferedReader f;
		f=new BufferedReader(new InputStreamReader(new FileInputStream("coen_course.gph")));
		GraphS G=new GraphS();
		COEN c=new COEN(t.createGraph(f,G));
		
		 
		 Out=c.getPrerequisistePath("COEN 352");
		 System.out.println(Out);
		 assertTrue(Out.contains("COEN 243"));
	
		 assertTrue(Out.contains("COEN 244"));
	
		 assertTrue(Out.contains("MATH 204"));
	
		 assertTrue(Out.contains("COEN 231"));
}



@Test
public void testgetIsPrerequisiste2() throws IOException {
	  tool t=new tool();
		StringBuffer s=new StringBuffer() ;
		BufferedReader f;
		f=new BufferedReader(new InputStreamReader(new FileInputStream("coen_course.gph")));
		GraphS G=new GraphS();
		COEN c=new COEN(t.createGraph(f,G));
		 assertEquals(c.isPrerequisite("COEN 243", "COEN 352"),true);
		 assertEquals(c.isPrerequisite("COEN 311", "COEN 352"),false);
		 assertEquals(c.isPrerequisite("COEN 244", "COEN 352"),true);
		 assertEquals(c.isPrerequisite("MATH 204", "COEN 352"),true);
		 assertEquals(c.isPrerequisite("ENGR 290", "COEN 352"),false);
}
	

}
