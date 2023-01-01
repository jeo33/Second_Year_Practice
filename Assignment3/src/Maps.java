import java.util.HashMap;

public class Maps  {
	private String[] Courses;
	private int size=35;
	Maps()
	{
		Courses=new String[size];
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
		Courses[34]="Permission of the Department";
		size=Courses.length;
	}
	
	int getCourseMark(String s)
	{
		for(int i=0;i<size;i++)
		{
			if(Courses[i]==s)return i;
			
		}
		return Integer.MAX_VALUE;
	}
	
	String getCourseName(int s)
	{
		if(s<=size-1&s>=0)return Courses[s];
		return null;
	}
}
