import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13244 - Space Happiness
*
*	Submision:	21634188
*	Date:		2018-07-19 20:34:12
*	Runtime:	0.050
*	Ranking:	98 / 128
*/
public class Main13244 {

	/**
	 * - Fórmula matemática
	 * 
	 * Ya no recuerdo cómo llegué a esa conclusión :|
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		
		int testCases = Integer.parseInt(br.readLine());
		long answer, s;
		
		while (testCases --> 0) {
			s = Long.parseLong(br.readLine());
			
			answer = (s/2) * (s/2) + ((s+1)/2) * ((s+1)/2);
			output.append(answer);
			output.append("\n");
		}
		
		System.out.print(output);

	}

}
