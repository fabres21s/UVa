import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	993 - Product of digits
*
*
*	Submission:	25146490
*	Date:		2020-06-16 23:33:50
*	Runtime:	0.050
*	Ranking:	3598
*/
public class Main993 {

	/**
	 * - Divisiones 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.valueOf(br.readLine().trim());
		StringBuffer output = new StringBuffer();
		
		while (testCases -- > 0) {
			int n = Integer.valueOf(br.readLine().trim());
			
			
			if (n == 1 || n == 0) {
				output.append(n);
			} else {
				int array[] = new int[10];
				
				for (int i = 9; i > 1; i--) {
					while (n % i == 0) {
						n/= i;
						array[i]++;
					}
				}
				if (n == 1) {
					for (int i = 2; i < 10; i++) {
						for (int j = 0; j < array[i]; j++) {
							output.append(i);
						}
					}
				} else {
					output.append("-1");
				}
			}
			
			output.append("\n");
		}
		System.out.print(output);
	}

}
