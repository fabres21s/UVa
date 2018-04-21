import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	11689 - Soda Surpler
*
*	Submission:	21162641
*	Date:		2018-04-18 19:30:42
*	Runtime:	0.030
*	Ranking:	5243
*/
public class Main11689 {

	/**
	 * - Simulación
	 * 
	 *  Dadas unas botellas vacias iniciales, e y f, y la cantidad de botellas
	 *  vacias necesarias para cambiarlas por una llena,
	 *  determinar cuántas gaseosas se pueden tomar
	 *  
	 *  Generalización del 11877
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		int e, f, c;
		StringBuffer output = new StringBuffer();
		while (testCases-- > 0) {
			args = br.readLine().split(" ");

			e = Integer.parseInt(args[0]);
			f = Integer.parseInt(args[1]);
			c = Integer.parseInt(args[2]);
			output.append(calculate(e + f, c));
			output.append("\n");
		}
		System.out.print(output);

	}

	public static int calculate(int total, int div) {
		int sum = 0;
		while (total >= div) {
			sum += total / div;

			total = total / div + total % div;
		}
		return sum;
	}

}
