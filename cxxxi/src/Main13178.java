import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13178 - Is it multiple of 3?
*
*
*	Submission:	19664462
*	Date:		2017-07-14 23:28:57
*	Runtime:	0.070
*	Ranking:	116
*/
public class Main13178 {

	/*
	 * - Sumatoria de números
	 * 
	 * Encontrar si el número 12345678910...n es múltiplo de 3
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		StringBuffer output = new StringBuffer();
		int n;
		while (testCases --> 0) {
			n = Integer.parseInt(br.readLine());
			if (n % 3 == 1) {
				output.append("NO\n");
			} else {
				output.append("YES\n");
			}
		}
		System.out.print(output);
	}

}
