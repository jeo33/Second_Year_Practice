import java.util.ArrayDeque;
import java.util.Queue;

public class GraphS implements Graph {
	private int[][] matrix;  // The edge matrix
	  private int numEdge;                   // Number of edges
	  public int[] Mark;                     // The mark array
	  public int[] Count;
	  Maps m=new Maps();
	  
	  public GraphS() {}
	  public GraphS(int n) {                 // Constructor
	    Init(n);
	  }

	  public void Init(int n) {
	    Mark = new int[n];
	    Count = new int[n];
	    matrix = new int[n][n];
	    numEdge = 0;
	  }

	  public int n() { return Mark.length; } // # of vertices

	  public int e() { return numEdge; }     // # of edges

	  public int first(int v) { // Get v's first neighbor
	    for (int i=0; i<Mark.length; i++)
	      if (matrix[v][i] != 0) return i;
	    return Mark.length;  // No edge for this vertex
	  }

	  public int next(int v, int w) { // Get v's next edge
	    for (int i=w+1; i<Mark.length; i++)
	      if (matrix[v][i] != 0)
	        return i;
	    return Mark.length;  // No next edge;
	  }
	  
	  
	  public int firstIn(int v) { // Get v's first neighbor
		    for (int i=0; i<Mark.length; i++)
		      if (matrix[i][v] != 0) return i;
		    return Mark.length;  // No edge for this vertex
		  }

	  public int nextIn(int v, int w) { // Get v's next edge
		    for (int i=w+1; i<Mark.length; i++)
		      if (matrix[i][v] != 0)
		        return i;
		    return Mark.length;  // No next edge;
		  }
	  
	  
	  

	  public boolean isEdge(int i, int j) // Is (i, j) an edge?
	    { return matrix[i][j] != 0; }
	  
	  // Set edge weight
	  public void setEdge(int i, int j, int wt) {
	    assert wt!=0 : "Cannot set weight to 0";
	    if (matrix[i][j] == 0) numEdge++;
	    matrix[i][j] = wt;
	  }

	  public void delEdge(int i, int j) { // Delete edge (i, j)
	    if (matrix[i][j] != 0) {
	      matrix[i][j] = 0;
	      numEdge--;
	    }
	  }

	  public int weight(int i, int j) { // Return edge weight
	    if (i == j) return 0;
	    if (matrix[i][j] == 0) return Integer.MAX_VALUE;
	    return matrix[i][j];
	  }

	 // Get and set marks
	  public void setMark(int v, int val) { Mark[v] = val; }
	  public int getMark(int v) { return Mark[v]; }
	  
	  public int incrCount(int w) {return ++Count[w];}
	  
	  
		static void Gprint(Graph G) {
			  int i, j;
			
			  for (i=0; i<G.n(); i++) {
			    for(j=0; j<G.n(); j++)
			    {
			    	 if (G.weight(i, j) == Integer.MAX_VALUE)
				    	  System.out.print(1+" ");
				      else
				    	  System.out.print(G.weight(i, j)+" ");
			    }
			    System.out.println();
			  }
		
		}
	  
	 
		
		 public String getPrerequisistePath() {
			 
			 StringBuffer s=new StringBuffer() ;
			  Queue<Integer> Q = new ArrayDeque<Integer>(this.n());
			  int[] Count = new int[this.n()];
			  int v, w;
			  for (v=0; v<this.n(); v++) Count[v] = 0;
			  for (v=0; v<this.n(); v++)
			    for (w=this.first(v); w<this.n(); w=this.next(v, w))
			       Count[w]++; //how many edges for each node;
			  for (v=0; v<this.n(); v++)
			    if (Count[v] == 0) Q.add(v);//no prerequisite vertex
			  while (!Q.isEmpty()) {
			    v = Q.remove().intValue();
			    
			    	if(this.Mark[v]==1)
			    		s.append(m.getCourseName(v)+"  ");
			    		System.out.print(m.getCourseName(v)+" ?? ");
			   
			    for (w=this.first(v); w<this.n(); w=this.next(v, w)) {
			      Count[w]--;
			      if (Count[w] == 0) // enqueue the next level vertex
			        Q.add(w); 
			    }
			  }
			  return s.toString();
			}
	  
	  
	  
	  public boolean isPrerequisite(String sourceCourse, String destinationCourse )
	  {
		
		  
		  
		  
		  return false;
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
