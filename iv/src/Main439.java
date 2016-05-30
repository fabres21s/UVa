import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/**
*	439 - Knight Moves
*
*
*	Submision:	9366655
*	Date:		2011-10-13 14:14:07
*	Runtime:	0.404
*	Ranking:	6382
*/
class Main 
{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	static String readLn() 
	{
        try 
        {
			return br.readLine();
		}
        catch (IOException e) 
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void main( String args[] ) 
	{
		//Inicializa os vertices do grafo
		int graph[][] = new int[64][];
		for ( int i = 0; i < 64; i++ ) 
		{
			graph[i] = new int[64];
		}
		
		//Inicializa as arestas
		for ( int l = 0; l < 8; l++ ) 
		{			
			for ( int c = 0; c < 8; c++ ) 
			{
				//Explora as 8 possibilidades
				addEdge(graph, c, l, c+1, l+2);
				addEdge(graph, c, l, c+2, l+1);
				addEdge(graph, c, l, c+2, l-1);
				addEdge(graph, c, l, c+1, l-2);
				addEdge(graph, c, l, c-1, l-2);
				addEdge(graph, c, l, c-2, l-1);
				addEdge(graph, c, l, c-2, l+1);
				addEdge(graph, c, l, c-1, l+2);
			}
		}
		
		//Executa o Floyd Varshal
		int path[][] = new int[64][];
		for ( int i = 0; i < 64; i++ ) 
		{
			path[i] = new int[64];
			for ( int j = 0; j < 64; j++ ) 
			{
				path[i][j] = edgeCost( graph, i, j );
			}
		}		
		for ( int k = 0; k < 64; k++ ) 
		{
			for ( int i = 0; i < 64; i++ ) 
			{
				for ( int j = 0; j < 64; j++ ) 
				{
					int candidate = path[i][k]+path[k][j];
					if ( candidate < path[i][j] ) 
					{
						path[i][j] = candidate;
					}
				}
			}
		}
		
		//Comeca a ler as entradas e "postar" as saidas
		String input = readLn();
		while ( input != null ) 
		{
			StringTokenizer st = new StringTokenizer( input );
			String casaOrigem = st.nextToken();
			String casaDestino = st.nextToken();
			int o = getIdx( casaOrigem );
			int d = getIdx( casaDestino );
			System.out.println("To get from "+casaOrigem+" to "+casaDestino+" takes "+path[o][d]+" knight moves.");
			input = readLn();
		}
	}

	private static int getIdx(String casaOrigem) 
	{
		int c = casaOrigem.charAt(0) - (int)'a';
		int l = casaOrigem.charAt(1) - (int)'1';
		return getIdx(c, l);
	}

	private static void addEdge(int[][] graph, int c, int l, int i, int j) 
	{
		//Verifica se i e j esto dentro do tabuleiro
		if ( i >= 0 && i < 8 && j >= 0 && j < 8 ) 
		{
			int o = getIdx( c, l );
			int d = getIdx( i, j );
			graph[o][d] = 1;
		}
	}

	private static int getIdx(int c, int l) 
	{
		return l*8+c;
	}

	private static int edgeCost(int[][] graph, int o, int d) 
	{
		if ( o == d ) 
		{
			return 0;
		}
		else if ( graph[o][d] == 1 ) 
		{
			return 1;
		} 
		else
		{
			return 1000;
		}
	}	
}