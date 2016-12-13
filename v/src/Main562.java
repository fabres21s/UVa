import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
*	562 - Dividing coins
*
*
*	Submision:	16605869
*	Date:		2015-12-19 13:31:25
*	Runtime:	0.146
*	Ranking:	3553
*/
public class Main562 {

	/**
	 * - Proceso matemático
	 * 
	 * Hallar la mínima diferencia posible entre un grupo de monedas a ser
	 * repartidas entre dos personas
	 */

	public static Set<Integer> numeros = new HashSet<Integer>();
	public static int ciclo = 0;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		while (n-- > 0) {

			int size = input.nextInt(), sum = 0;
			int arreglo[] = new int[size * size];
			for (int i = 0; i < size; i++) {
				arreglo[i] = input.nextInt();
				sum += arreglo[i];
			}

			int target = sum / 2;

			int F[] = new int[50005];
			F[0] = 1;
			int i = 0, j = 0;
			for (i = 0; i < size; i++) {
				if (arreglo[i] > target)
					continue;
				for (j = target - arreglo[i]; j >= 0; j--)
					if (F[j] > 0)
						F[j + arreglo[i]] = 1;
				if (F[target] > 0)
					break;
			}
			for (i = target; i >= 0; i--)
				if (F[i] > 0)
					break;
			j = (sum - i);
			j = j - i;
			System.out.println(j);

		}
		input.close();
	}

}
