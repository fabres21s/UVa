import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
*	10038 - Jolly Jumpers
*
*
*	Submission:	9210845
*	Date:		2011-09-01 02:57:41
*	Runtime:	0.488
*	Ranking:	31256 / 32326
*/
public class Main10038 {

	/**
	 * - Vector
	 * 
	 * La diferencia absoluta entre valores
	 * sucesivos de un conjunto de n n�meros tenga los valores desde 1 hasta (n
	 * -1) Si hay un solo valor, la secuencia se marca como saltarina
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int n, i;
		boolean jolly;
		Vector<Integer> v = new Vector<Integer>();
		while (input.hasNext()) {
			v.removeAll(v);
			n = input.nextInt();
			int[] valores = new int[n];
			for (i = 0; i < n; i++)
				valores[i] = input.nextInt();
			for (i = 1; i < n; i++)
				v.add(Math.abs(valores[i] - valores[i - 1]));
			jolly = true;
			for (i = 1; i < n; i++) {
				if (!v.contains(i)) {
					jolly = false;
					break;
				}
			}
			if (jolly)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
		}
		input.close();
	}
}
