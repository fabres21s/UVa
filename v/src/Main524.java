import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	524 - 	Prime Ring Problem
*
*	Submission:	21928268
*	Date:		2018-09-08 17:57:59
*	Runtime:	0.410
*	Ranking:	4189
*/
public class Main524 {

	static int n, T = 0;
	static int circle[] = new int[20];
	static boolean used[] = new boolean[20];
	static StringBuffer output = new StringBuffer();

	/**
	 * - Simulación
	 * - Números primos
	 * 
	 * De los números del 1 al 16, ponerlos en un aro en el que 
	 * la suma de los números adyacentes sean primos 
	 * 
	 * Sacado de //https://saicheems.wordpress.com/2013/08/09/uva-524-prime-ring-problem/
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			n = Integer.parseInt(line);
			T++;
			if (T > 1)
				System.out.println();
			circle[0] = circle[n] = 1;
			System.out.printf("Case %d:\n", T);

			output = new StringBuffer();
			search(0);
			System.out.print(output);
		}
	}

	static boolean is_prime(int p) {
		for (int i = 2; i <= Math.sqrt(p); i++)
			if (p % i == 0)
				return false;
		return true;
	}

	static void search(int m) {
		if (m == n - 1 && is_prime(circle[n - 1] + circle[n])) {
			for (int i = 0; i < n; i++) {
				if (i == n - 1) {
					output.append(circle[i]);
				} else {
					output.append(circle[i] + " ");
				}
			}
			output.append("\n");
			return;
		}
		for (int i = 2; i <= n; i++)
			if (!used[i] && is_prime(circle[m] + i)) {
				used[i] = true;
				circle[m + 1] = i;
				search(m + 1);
				used[i] = false;
			}
	}

}
