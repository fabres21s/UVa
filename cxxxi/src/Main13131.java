import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
*	13131 - Divisors
*
*
*	Submission:	18496655
*	Date:		2016-12-14 02:50:31
*	Runtime:	0.670
*	Ranking:	125
*/
public class Main13131 {

	/**
	 * - Proceso matemático
	 * 
	 * Hallar la suma de divisores de un número n 
	 * pero que estos no sean múltiplos de k
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		StringBuffer output = new StringBuffer();
		int n,k, x, sum;
		for (int i = 0; i < testCases; i++) {
			args = br.readLine().split(" ");
			 n = Integer.parseInt(args[0]);
			 k = Integer.parseInt(args[1]);
			
			 sum = 0;
			Set<Integer> divisors = new HashSet<Integer>();
			divisors.add(1);
			divisors.add(n);
			
			int sqrt = (int)Math.sqrt(n) + 1;
			for ( x = 2; x <= sqrt; x++) {
				if (n % x == 0) {
					divisors.add(x);
					divisors.add(n /x);
				}
			}
			
			for (Integer divisor : divisors) {
				if (divisor % k != 0) {
					sum += divisor;
				}
			}
			output.append(sum+"\n");
		}
		System.out.print(output);
	}

}
