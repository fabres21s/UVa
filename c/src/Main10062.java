import java.util.Scanner;

/**
*	10062 - Tell me the frequencies!
*
*
*	Submision:	9728732
*	Date:		2012-02-10 15:24:40
*	Runtime:	0.188
*	Ranking:	5938
*/
public class Main10062 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		char p[];
		int i, max, j;
		int aux = 0;
		while (input.hasNext()) {
			int arreglo[] = new int[130];
			p = input.nextLine().toCharArray();
			if (aux > 0)
				System.out.println();
			for (i = 0; i < p.length; i++)
				arreglo[p[i]]++;
			max = 0;
			for (i = 0; i < 130; i++) {
				if (arreglo[i] > max)
					max = arreglo[i];
			}
			for (i = 1; i <= max; i++)
				for (j = 129; j >= 0; j--)
					if (arreglo[j] == i)
						System.out.printf("%d %d\n", j, i);
			aux++;
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
