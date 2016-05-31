import java.util.Scanner;

/**
*	10026 - Shoemaker's Problem
*
*
*	Submision:	9290346
*	Date:		2011-09-22 19:33:05
*	Runtime:	0.648
*	Ranking:	4923
*/
public class Main10026 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		for (int i = 0; i < test; i++) {
			int n = input.nextInt();
			double[][] arreglo = new double[n][4];
			for (int j = 0; j < n; j++) {
				arreglo[j][0] = input.nextDouble();
				arreglo[j][1] = input.nextDouble();
				arreglo[j][2] = arreglo[j][0] / arreglo[j][1];
				arreglo[j][3] = j + 1;
			}
			ordenar(arreglo);
			if (i < test - 1)
				System.out.println();
		}
		input.close();
	}

	static void ordenar(double[][] arreglo) {
		int i, j;
		double aux, aux1;
		for (i = 1; i < arreglo.length; i++) {
			aux = arreglo[i][2];
			aux1 = arreglo[i][3];
			j = i - 1;
			while (arreglo[j][2] > aux) {
				arreglo[j + 1][2] = arreglo[j][2];
				arreglo[j + 1][3] = arreglo[j][3];
				j--;
				if (j < 0)
					break;
			}
			arreglo[j + 1][2] = aux;
			arreglo[j + 1][3] = aux1;
		}
		for (i = 0; i < arreglo.length; i++) {
			System.out.print((int) (arreglo[i][3]));
			if (i < arreglo.length - 1)
				System.out.print(" ");
		}
		System.out.println();
	}
}
