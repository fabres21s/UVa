import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	12918 - Lucky Thief
*
*
*	Submision:	17624130
*	Date:		2016-07-05 18:47:46	
*	Runtime:	0.280
*	Ranking:	142
*/
public class Main12918 {

	/*
	 * - Sumatoria de números
	 * 
	 * Dadas n llaves, que abren m casas, encontrar la máxima cantidad de veces que es posible 
	 * insertar la llave en una puerta incorrecta
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		long n,m;
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < testCases; i++) {
			args  = br.readLine().split(" ");
			n = Long.parseLong(args[0]);
			m = Long.parseLong(args[1]);
			output.append((sumatoria(m - 1) - sumatoria(m - n-1)) + "\n");
		}
		System.out.print(output);
	}

	private static long sumatoria(long n) {
		return n * (n+1) /2 ;
	}

}
