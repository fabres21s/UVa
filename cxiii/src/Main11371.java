import java.util.Arrays;
import java.util.Scanner;

/**
*	11371 - Number Theory for Newbies
*
*
*	Submission:	10299565
*	Date:		2012-07-06 23:58:03
*	Runtime:	0.132
*	Ranking:	1520
*/
public class Main11371 {

	/**
	 * - Proceso matem�tico
	 */
	public static void main(String[] args) {
		long n1, n2, n, arreglo[];
		int digitos, i;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			n = input.nextLong();
			digitos = (int) Math.ceil(Math.log10((double) n + 1));
			arreglo = new long[digitos];
			for (i = digitos - 1; i > -1; i--) {
				arreglo[i] = n % 10;
				n /= 10;
			}
			n2 = getvalor(arreglo, 1);
			n1 = getvalor(arreglo, 0);
			n = n2 - n1;
			System.out.printf("%d - %d = %d = 9 * %d\n", n2, n1, n, n / 9);
		}
		input.close();
	}

	private static long getvalor(long[] arreglo, int i) {
		Arrays.sort(arreglo);
		int x = 0;
		long n = 0;
		if (i == 1)
			arreglo = reverse(arreglo);
		else {
			if (arreglo[0] == 0) {
				while (arreglo[x] == 0)
					x++;
				arreglo[0] = arreglo[x];
				arreglo[x] = 0;
			}
		}
		for (i = 0; i < arreglo.length; i++)
			n = n * 10 + arreglo[i];
		return n;
	}

	private static long[] reverse(long[] arreglo) // devuelve al mayor
	{
		long temp;
		int size = arreglo.length;
		for (int i = 0; i < size / 2; i++) {
			temp = arreglo[i];
			arreglo[i] = arreglo[size - 1 - i];
			arreglo[size - i - 1] = temp;
		}
		return arreglo;
	}
}
