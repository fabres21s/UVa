import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
*	13034 - Solve Everything :-)
*
*
*	Submision:	17620039
*	Date:		2016-07-05 01:32:05	
*	Runtime:	0.030
*	Ranking:	434
*/
public class Main13034 {

	/**
	 * - Muy fácil
	 * 
	 * Si hay un 0 en la secuencia de números
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		boolean answer;
		StringBuffer output = new StringBuffer();
		for (int i = 1; i <= testCases; i++) {
			args = br.readLine().split(" ");
			output.append("Set #"+i+": ");
			answer = true;
			for (String s : args) {
				if ( Integer.parseInt(s)  == 0) {
					answer = false;
				}
			}
			if (answer) {
				output.append("Yes\n");
			} else {
				output.append("No\n");
			}
		}
		System.out.print(output);
	}

}
