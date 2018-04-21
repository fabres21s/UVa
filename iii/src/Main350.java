import java.util.Scanner;

/**
*	350 - Pseudo-Random Numbers
*
*
*	Submission:	9838437
*	Date:		2012-03-09 21:13:56
*	Runtime:	0.712
*	Ranking:	5202
*/
public class Main350 {
	static int casos = 1, n;
	static int[] arreglo;

	/**
	 * - Proceso matem�tico
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int z, m, i, l;
		while (input.hasNext()) {
			z = input.nextInt();
			i = input.nextInt();
			m = input.nextInt();
			l = input.nextInt();
			if (z == 0 && i == 0 && m == 0)
				break;
			arreglo = new int[m + 1];
			arreglo[0] = l;
			n = 1;
			while (true) {
				l = (z * l + i) % m;
				arreglo[n] = l;
				if (yaesta(l))
					break;
				n++;
			}
			casos++;
		}
		input.close();
	}

	private static boolean yaesta(int l) {
		for (int i = 0; i < n; i++) {
			if (arreglo[i] == l) {
				System.out.printf("Case %d: %d\n", casos, (n - i));
				return true;
			}
		}
		return false;
	}
}
