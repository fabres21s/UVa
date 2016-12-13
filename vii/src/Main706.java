import java.io.IOException;
import java.util.Scanner;

/**
*	706 - LC-Display
*
*
*	Submision:	9296232
*	Date:		2011-09-24 22:31:27
*	Runtime:	0.520
*	Ranking:	6701
*/
public class Main706 {

	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		char[][] tablero = new char[][] {
		/* 0 1 2 3 4 5 6 */
		/* 0 */{ '-', '|', '|', ' ', '|', '|', '-' },
		/* 1 */{ ' ', '|', ' ', ' ', '|', ' ', ' ' },
		/* 2 */{ '-', '|', ' ', '-', ' ', '|', '-' },
		/* 3 */{ '-', '|', ' ', '-', '|', ' ', '-' },
		/* 4 */{ ' ', '|', '|', '-', '|', ' ', ' ' },
		/* 5 */{ '-', ' ', '|', '-', '|', ' ', '-' },
		/* 6 */{ '-', ' ', '|', '-', '|', '|', '-' },
		/* 7 */{ '-', '|', ' ', ' ', '|', ' ', ' ' },
		/* 8 */{ '-', '|', '|', '-', '|', '|', '-' },
		/* 9 */{ '-', '|', '|', '-', '|', ' ', '-' }

		};

		int s, i, j, k;
		String aux;
		while (input.hasNext()) {
			s = input.nextInt();
			// numero=input.nextInt();
			if (s == 0) {
				break;
			}
			aux = input.next();
			char[] tokens = new char[aux.length()];
			for (int xx = 0; xx < aux.length(); xx++) {
				tokens[xx] = aux.charAt(xx);
			}
			int n = aux.length();
			int digito = 0;
			StringBuffer xxx = new StringBuffer();
			for (i = 0; i < 2 * s + 3; i++) {
				for (j = 0; j < n; j++) {

					digito = tokens[j] - '0';

					/* upper, middle and lower parts */
					if ((i % (s + 1)) == 0) {
						xxx.append(' ');
						// System.out.print(' ');
						for (k = 0; k < s; k++) {
							xxx.append(tablero[digito][(i / (s + 1)) * 3]);
							// System.out.print(tablero[digito][(i / (s + 1)) *
							// 3]);
						}
						xxx.append(' ');
						// System.out.print(' ');
					}

					/* between upper and middle parts */
					if (i > 0 && i < (s + 1)) {
						xxx.append(tablero[digito][2]);
						// System.out.print(tablero[digito][2]);
						for (k = 0; k < s; k++) {
							xxx.append(' ');
							// System.out.print(' ');
						}
						xxx.append(tablero[digito][1]);
						// System.out.print( tablero[digito][1]);
					}

					/* between middle and lower parts */
					if (i > (s + 1) && i < (2 * s + 2)) {
						xxx.append(tablero[digito][5]);
						// System.out.print(tablero[digito][5]);
						for (k = 0; k < s; k++) {
							xxx.append(' ');
							// System.out.print(' ');
						}
						xxx.append(tablero[digito][4]);
						// System.out.print(tablero[digito][4]);
					}

					/* if not the last number */
					if (j != n - 1) {
						xxx.append(' ');
						// System.out.print(' ');
					}

				}
				xxx.append('\n');
				// System.out.print('\n');

			}
			System.out.println(xxx);
			// System.out.println();
		}
		input.close();


	}

}