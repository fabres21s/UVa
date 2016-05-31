import java.util.Scanner;

/**
*	12318 - Digital Roulette
*
*
*	Submision:	16512276
*	Date:		2015-11-29 19:26:55
*	Runtime:	2.092
*	Ranking:	173
*/
public class Main12318 {

	/**
	 * Time Limit en Java Exactamente el mismo algoritmo en C++ es Aceptado
	 * -Modular -Proceso matemático
	 * 
	 * Encontrar la cantidad de residuos generados tras ejecutar un polinomio
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long sum;
		int k, n, m, i, j;
		long[] arreglo, solucion;
		StringBuffer buffer = new StringBuffer();
		while (true) {
			n = input.nextInt() + 1;
			m = input.nextInt();
			if ((n - 1) == 0 && m == 0) {
				break;
			}
			k = input.nextInt();
			arreglo = new long[k + 1];
			solucion = new long[n];
			for (i = 0; i <= k; i++) {
				arreglo[i] = input.nextInt();
			}
			// System.out.println(Arrays.toString(arreglo));
			long t = System.currentTimeMillis();
			for (i = 0; i <= m; i++) {
				sum = 0;
				for (j = k; j > -1; j--) {
					sum += (modular(i, j, n) * arreglo[j]) % n;
				}
				solucion[(int) (sum % n)] = 1;
			}
			sum = 0;
			for (i = 0; i < n; i++) {
				if (solucion[i] > 0) {
					sum++;
				}
			}
			System.out.println((System.currentTimeMillis() - t));
			buffer.append(sum + "\n");
		}
		System.out.print(buffer);
		input.close();
	}

	private static long modular(long x, long y, long z) {
		// System.out.printf("x = %d , y = %d , z = %d \n",x,y,z);
		long residuos[][] = new long[2][500];
		int i = -1, j;
		if (y == 0)
			return z;
		do {
			i++;
			residuos[0][i] = (int) Math.pow(2, i);
		} while (residuos[0][i] <= y);
		residuos[1][0] = x % z;
		i = 1;
		while (residuos[0][i] <= y) {
			residuos[1][i] = (residuos[1][i - 1] * residuos[1][i - 1]) % z;
			i++;
		}
		i--;
		if (residuos[0][1] == y) {
			return (residuos[1][i]);
		}
		y -= residuos[0][i];
		while (y > 0) {
			j = 0;
			while (residuos[0][j] <= y) {
				j++;
			}
			j--;
			i++;
			residuos[0][i] = residuos[0][j] + residuos[0][i - 1];
			residuos[1][i] = (residuos[1][j] * residuos[1][i - 1]) % z;
			y -= residuos[0][j];
		}
		return (residuos[1][i]);
	}
}
