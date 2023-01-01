import java.io.*;
import java.util.*;

public class COEN  {
	public GraphS subGraph;
	public StringBuffer out=new StringBuffer() ;
	public Maps m=new Maps();
	public GraphS mainGraph;
	
	static final int UNVISITED = 0;
	static final int VISITED = 1;
	
	COEN(GraphS g)
	{
		mainGraph=g;
		subGraph=new GraphS (g.n());
	}
	public COEN() {
		// TODO Auto-generated constructor stub
	}
	public void GetSubGraph(String s)
	{	
		
		int x=m.getCourseMark(s);
		subGraph.Mark[x]=1;
		for (int w = mainGraph.firstIn(x); w < mainGraph.n();w = mainGraph.nextIn(x, w))
		{
			subGraph.Mark[w]=1;
			GetSubGraphHelper(w);
		}
	}
	
	
	public void GetSubGraphHelper(int x)
	{
		for (int w = mainGraph.firstIn(x); w < mainGraph.n();w = mainGraph.nextIn(x, w))
		{
			subGraph.Mark[w]=1;
			GetSubGraphHelper(w);
		}
	}
	

	 public String getPrerequisistePath(String s) {
		 out=new StringBuffer() ;
		 
		 GetSubGraph(s);
		  Queue<Integer> Q = new ArrayDeque<Integer>(mainGraph.n());
		  int[] Count = new int[mainGraph.n()];
		  int v, w;
		  for (v=0; v<mainGraph.n(); v++) Count[v] = 0;
		  for (v=0; v<mainGraph.n(); v++)
		    for (w=mainGraph.first(v); w<mainGraph.n(); w=mainGraph.next(v, w))
		       Count[w]++; //how many edges for each node;
		  for (v=0; v<mainGraph.n(); v++)
		    if (Count[v] == 0) Q.add(v);//no prerequisite vertex
		  while (!Q.isEmpty()) {
		    v = Q.remove().intValue();
		    
		    	if(subGraph.Mark[v]==1)
		    		out.append(m.getCourseName(v)+"  ");
		    		//System.out.print(m.getCourseName(v)+"  ");
		   
		    for (w=mainGraph.first(v); w<mainGraph.n(); w=mainGraph.next(v, w)) {
		      Count[w]--;
		      if (Count[w] == 0) // enqueue the next level vertex
		        Q.add(w); 
		    }
		  }
		  return out.toString();
		}
	 
	 public boolean isPrerequisite(String sourceCourse, String destinationCourse )
	 {
		 String temp=getPrerequisistePath(destinationCourse);
		 if(temp.contains(sourceCourse))return true;
		 else return false;
		 
	 }
	

}
