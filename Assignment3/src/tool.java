import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class tool {
	
	
	

	
	static final int UNVISITED = 0;
	static final int VISITED = 1;
	
	
	
	
	// Create a graph from file
	static GraphS createGraph(BufferedReader file, GraphS G) 
			throws IOException 
			{
					  String line = null;
					  StringTokenizer token;
					  boolean undirected = false;
					  int i, v1, v2, weight;
					
					  line = file.readLine();
					  while(line.charAt(0) == '#')
					  line = file.readLine();
					  token = new StringTokenizer(line);
					  
					  int n = Integer.parseInt(token.nextToken());
					  G.Init(n);
					  
					  for (i=0; i<n; i++)
					    G.setMark(i, UNVISITED);
					  
					 line = file.readLine();
					  
					  if (line.charAt(0) == 'U')
					    undirected = true;
					  else if (line.charAt(0) == 'D')
					    undirected = false;
					
					  // Read in edges
					  while((line = file.readLine()) != null) {
						token = new StringTokenizer(line);
					    v1 = Integer.parseInt(token.nextToken());
					    v2 = Integer.parseInt(token.nextToken());
					   
					    G.setEdge(v1, v2, 1);
					    if (undirected) // Put in edge in other direction
					      G.setEdge(v2, v1, 1);
					  }
					  return G;
			}
	static void print(GraphS G) {
		  int i, j;
		
		  for (i=0; i<G.n(); i++) {
		    for(j=0; j<G.n(); j++){
			      if(G.weight(i, j)==Integer.MAX_VALUE)System.out.print(0+" ");
			      else System.out.print(G.weight(i, j)+" ");
			  
		    }

	      System.out.println();
	
	}
	}
	
	
	
	
	
	
	static void Gprint(GraphS G, StringBuffer out) {
		  int i, j;
		
		  for (i=0; i<G.n(); i++) {
		    for(j=0; j<G.n(); j++)
		      if (G.weight(i, j) == Integer.MAX_VALUE)
		        out.append("0 ");
		      else
		        out.append(G.weight(i, j) + " ");
		  }
	
	}
	
	
	

}
