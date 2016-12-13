import java.util.Scanner;

/**
*	102 - Ecological Bin Packing
*
*
*	Submision:	9573517
*	Date:		2011-12-19 00:48:08
*	Runtime:	2.120
*	Ranking:	22577
*/

public class Main102 {
	static int Bin[][] = new int[3][3];
	static int menor;
	static String[] gla = new String[3];
	static String res;

	/**
	 * - Simulación
	 * - Proceso matemático
	 * 
	 * Mínimos movimientos necesarios para
	 * intercambiar botellas de tres colores Brown, Clear y Gray
	 * en tres cajas diferentes.
	 * Inicialmente en desorden
	 */
	public static void main(String[] args) {
		gla[0] = "B";
		gla[1] = "C";
		gla[2] = "G";
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			Bin[0][0] = input.nextInt();
			Bin[0][2] = input.nextInt();
			Bin[0][1] = input.nextInt();
			Bin[1][0] = input.nextInt();
			Bin[1][2] = input.nextInt();
			Bin[1][1] = input.nextInt();
			Bin[2][0] = input.nextInt();
			Bin[2][2] = input.nextInt();
			Bin[2][1] = input.nextInt();
			menor = 2147483647;
			calcular(0, 1, 2);
			calcular(0, 2, 1);
			calcular(1, 0, 2);
			calcular(1, 2, 0);
			calcular(2, 0, 1);
			calcular(2, 1, 0);
			System.out.printf("%s %d\n", res, menor);
		}
		input.close();
	}

	static void calcular(int a, int b, int c) {
		int x = 0;
		x += Bin[1][a] + Bin[2][a] + Bin[0][b] + Bin[2][b] + Bin[0][c]
				+ Bin[1][c];
		if (x < menor) {
			res = gla[a] + gla[b] + gla[c];
			menor = x;
		}
	}
}
