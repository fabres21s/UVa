import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	482 - Permutation Arrays
*
*
*	Submission:	25143367
*	Date:		2020-06-15 19:10:48
*	Runtime:	0.080
*	Ranking:	4924
*/
public class Main482 {

	/**
	 * - Arreglos
	 * 
	 * -Reordenar un arreglo de acuerdo a las posiciones que se indican
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int testCases = Integer.valueOf(br.readLine());
		
		while (testCases --> 0) {
			br.readLine();
			
			
			
			args = br.readLine().split(" ");
			int positions [] = new int[args.length ];
			
			for (int i = 0; i < args.length; i++) {
				positions[i] = Integer.valueOf(args[i]) - 1;
			}
			
			args = br.readLine().split(" ");
			String ans [] = new String[args.length];
			
			for (int i = 0; i < args.length; i++) {
				ans[positions[i]] = args[i];
			}
			
			for(String s: ans) {
				output.append(s+"\n");
			}
			if (testCases > 0) {
				output.append("\n");
			}
		}
		System.out.print(output);
	}

}
