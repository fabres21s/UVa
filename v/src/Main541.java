import java.util.Scanner;

/**
*	541 - Error Correction
*
*
*	Submision:	16455949
*	Date:		2015-11-18 17:11:53
*	Runtime:	0.482
*	Ranking:	8797
*/
public class Main541 {

	/*
	 * verificar si la suma de los valores en un arreglo por filas y columnas es
	 * par, o si se puede arreglar cambiando un valor
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt(), x;
		do {
			int arreglo[][] = new int[n][n];

			int column = -1, row = -1, sum;
			boolean corrupt = false;

			for (int i = 0; i < n; i++) {
				sum = 0;
				for (int j = 0; j < n; j++) {
					x = input.nextInt();
					arreglo[i][j] = x;
					sum += x;
				}
				if (sum % 2 != 0) {
					if (row == -1) {
						row = i + 1;
					} else {
						corrupt = true;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				sum = 0;
				for (int j = 0; j < n; j++) {

					sum += arreglo[j][i];
				}
				if (sum % 2 != 0) {
					if (column == -1) {
						column = i + 1;
					} else {
						corrupt = true;
					}
				}
			}

			if (corrupt) {
				System.out.println("Corrupt");
			} else if (column == -1 && row == -1) {
				System.out.println("OK");
			} else {
				System.out.printf("Change bit (%d,%d)\n", row, column);
			}

			n = input.nextInt();
		} while (n != 0);
	}

}
