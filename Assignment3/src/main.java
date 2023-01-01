import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) throws IOException  {
		tool t=new tool();
		StringBuffer s=new StringBuffer() ;
		BufferedReader f;
		f=new BufferedReader(new InputStreamReader(new FileInputStream("coen_course.gph")));
		GraphS G=new GraphS();
		t.createGraph(f,G);
		COEN c=new COEN(G);
		System.out.println(c.getPrerequisistePath("COEN 352"));
		c=new COEN(G);
		System.out.println(c.getPrerequisistePath("COEN 490"));
		c=new COEN(G);
		System.out.println(c.getPrerequisistePath("COEN 433"));
		System.out.println(c.isPrerequisite("COEN 243", "COEN 352"));
		System.out.println(c.isPrerequisite("COEN 212", "COEN 352"));
		
		/*
		 * HERE IS THE COURSE NAME MAP;
		 * getPrerequisistePath(String s),s HAS TO BE EXACTLY SAME STRING;
		Courses[0]="MATH 204";
		Courses[1]="ENGR 290";
		Courses[2]="ELEC 311";
		Courses[3]="SOEN 341";
		Courses[4]="ELEC 372";
		Courses[5]="ENGR 301";
		Courses[6]="ENGR 371";
		Courses[7]="COEN 212";
		Courses[8]="COEN 231";
		Courses[9]="COEN 243";
		Courses[10]="COEN 244";
		Courses[11]="COEN 311";
		Courses[12]="COEN 313";
		Courses[13]="COEN 316";
		Courses[14]="COEN 317";
		Courses[15]="COEN 320";
		Courses[16]="COEN 346";
		Courses[17]="COEN 352";
		Courses[18]="COEN 366";
		Courses[19]="COEN 390";
		Courses[20]="COEN 413";
		Courses[21]="COEN 415";
		Courses[22]="COEN 421";
		Courses[23]="COEN 422";
		Courses[24]="COEN 424";
		Courses[25]="COEN 432";
		Courses[26]="COEN 433";
		Courses[27]="COEN 434";
		Courses[28]="COEN 446";
		Courses[29]="COEN 447";
		Courses[30]="COEN 448";
		Courses[31]="COEN 451";
		Courses[32]="COEN 490";
		Courses[33]="COEN 498";
		 */
	}
	
}
