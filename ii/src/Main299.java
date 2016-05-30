import java.util.Scanner;

/**
*	299 - Train Swapping
*
*
*	Submision:	9496831
*	Date:		2011-11-22 19:38:10
*	Runtime:	0.256
*	Ranking:	17882
*/

public class Main299 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt(), t, x;
		int[] arreglo;
		for (int i = 0; i < casos; i++) {
			t = input.nextInt();
			arreglo = new int[t];
			for (x = 0; x < t; x++) {
				arreglo[x] = input.nextInt();
			}
			bubblesort(arreglo);
		}
		// TODO Auto-generated method stub

	}

	static void bubblesort(int[] arreglo) {
		int aux, swaps = 0;
		for (int i = 1; i < arreglo.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arreglo[i] < arreglo[j]) {
					aux = arreglo[i];
					arreglo[i] = arreglo[j];
					arreglo[j] = aux;
					swaps++;
				}
			}
		}
		System.out.printf("Optimal train swapping takes %d swaps.\n", swaps);
	}

}
