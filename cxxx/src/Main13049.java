import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13046 - Combination Lock
*
*
*	Submision:	17623621
*	Date:		2016-07-05 16:39:38	
*	Runtime:	0.030
*	Ranking:	124
*/
public class Main13049 {

	/*
	 * - Simulación
	 * 
	 * Encontrar la mínima cantidad de movimientos para ir de una configuración inicial de un candado 
	 * de números a la configuración que abre el candado
	 * 
	 * Similar al 12468
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		StringBuffer output = new StringBuffer();
		int digits, moves, max, min;
		char [] numbers1, numbers2;
		for (int i = 1; i <= testCases; i++) {
			args = br.readLine().split(" ");
			digits = Integer.parseInt(args[0]);
			numbers1 = args[1].toCharArray();
			numbers2 = args[2].toCharArray();
			moves = 0;
			
			for ( int j = 0; j < digits; j++) {
				max = Math.max(numbers1[j], numbers2[j]);
				min = Math.min(numbers1[j], numbers2[j]);
				moves += Math.min((max-min), (10 + min - max));
			}
			output.append("Case "+i+": "+moves+"\n");
		}
		System.out.print(output);
	}

}
