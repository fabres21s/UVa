import java.util.Scanner;


/**
*	100 - The 3n + 1 Problem
*
*
*	Submission:	9281686
*	Date:		2011-09-20 16:46:08
*	Runtime:	1.036
*	Ranking:	66171
*/
public class Main100 {

	/**
	 *  - Proceso matem�tico
	 * 	Si n es par, dividirlo entre dos, si no multiplicarlo por 3 y sumarle uno
	 *	Hallar el n�mero al cual hay que hacerle m�s veces ese proceso en un rango dado
	 *	
	 *
	 */
	public static void main(String[] args) {
		int a, b;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			a = input.nextInt();
			b = input.nextInt();
			System.out.println(a + " " + b + " " + numCicloMax(a, b));
		}
		input.close();
	}

	static int numCicloMax(int a, int b) {
		int cicloMax = -1;
		for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
			int con = numIteraciones(i);
			if (con > cicloMax) {
				cicloMax = con;
			}
		}
		return cicloMax;
	}

	static int numIteraciones(int n) {
		int cont = 1;
		while (n > 1) {
			if (n % 2 == 1) {
				n = (3 * n) + 1;
			} else {
				n = n / 2;
			}
			cont++;
		}
		return cont;
	}
}
