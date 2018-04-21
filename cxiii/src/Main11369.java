import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
*	11369 - Shopaholic
*
*	Submission:	20333132
*	Date:		2017-11-11 19:34:52
*	Runtime:	0.190
*	Ranking:	2863
*/
public class Main11369 {

	/**
	 * - Simulación
	 * 
	 * En una tienda, de cada 3 artículos, el de menor valor es gratis.
	 * Encontrar el mayor valor que se puede llevar gratis
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		
		int testCases = Integer.parseInt(br.readLine());
		int products, index, sum;
		while ( testCases --> 0) {
			
			products = Integer.parseInt(br.readLine());
			
			int array[] = new int[products];
			args = br.readLine().split(" ");
			for (index = 0; index < products; index++) {
				array[index] = Integer.parseInt(args[index]);
			}
			
			Arrays.sort(array);
			sum = 0;
			for (index = products - 3; index >= 0; index -= 3) {
				sum += array[index];
			}
			output.append(sum);
			output.append("\n");
		}
		System.out.print(output);
	}

}
