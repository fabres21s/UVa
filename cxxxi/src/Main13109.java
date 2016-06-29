import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
*	13109 - Elephants
*
*
*	Submision:	17580008
*	Date:		2016-06-27 00:16:52
*	Runtime:	0.440
*	Ranking:	106
*/
public class Main13109 {

	/*
	 * - Arreglos
	 * - Fácil
	 * 
	 * Encontrar cuántos elefantes se pueden balancear en la tela de una araña
	 * dados los pesos de los elefantes y el peso que resiste la telaraña
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		int elephants, maxWeight;
		for (int i = 0; i < testCases; i++) {
			args = br.readLine().split(" ");
			
			elephants = Integer.parseInt(args[0]);
			maxWeight = Integer.parseInt(args[1]);
			
			int x = 0;
			long sumWeight = 0;
			args = br.readLine().split(" ");
			long [] array = new long[elephants];
			for (x = 0; (x < elephants && sumWeight < maxWeight); x++) {
				array[x] = Long.valueOf(args[x]);
			}
			
			Arrays.sort(array);
			for (x = 0; x < elephants; x ++) {
				sumWeight += array[x];
				if (sumWeight > maxWeight) {
					break;
				}
			}
			
			System.out.println(x);
		}
	}

}
