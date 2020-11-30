import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10664 - Luggage
*
*	Submission:	20453465
*	Date:		2017-12-06 23:57:23	
*	Runtime:	0.040
*	Ranking:	4061 / 4504
*/
public class Main10664 {

	static int array[] = { 3, 5, 2, 7, 1, 7, 5, 2, 8, 9, 1, 25, 15, 8, 3, 1, 38, 45, 8, 1 };
	static boolean found = false;
	static int half = 0;

	
	/**
	 * - Recursividad
	 * 
	 *  Hacer todas las posibles sumas en combinación en un arreglo
	 *  y encontrar si en esas sumas está la mitad de la sumatoria de ellos
	 *  
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		StringBuffer output = new StringBuffer();

		while (testCases-- > 0) {

			found = false;
			args = br.readLine().split(" ");
			array = new int[args.length];

			int sum = 0, index = 0;
			for (String s : args) {
				array[index] = Integer.parseInt(s);
				sum += array[index];
				index++;
			}

			if (sum % 2 == 0) {
				half = sum / 2;

				solve(0, 0);
			}
			output.append(found ? "YES" : "NO");
			output.append("\n");
		}
		System.out.print(output);
	}

	private static void solve(int start, int sum) {

		if (!found) {
			if (sum == half) {
				found = true;
				return;
			}
			for (int i = start; i < array.length; i++) {
				solve(i + 1, sum + array[i]);
			}
		}
	}

}
