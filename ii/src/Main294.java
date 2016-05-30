import java.util.Scanner;


/**
*	294 - Divisors
*
*
*	Submision:	9338056
*	Date:		2011-10-05 21:22:59
*	Runtime:	0.536
*	Ranking:	5130
*/
public class Main294 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b, cont, mayor, nmayor;
		int casos = input.nextInt();

		for (int i = 0; i < casos; i++) {
			mayor = 0;
			nmayor = 0;
			a = input.nextInt();
			b = input.nextInt();
			mayor = Math.max(a, b);
			nmayor = Math.min(a, b);
			a = nmayor;
			b = mayor;
			mayor = 0;
			nmayor = 0;

			for (int j = a; j <= b; j++) {
				cont = 0;

				for (int k = 2; k < Math.sqrt(j); k++) {
					if (j % k == 0) {
						cont++;
					}
				}
				// if()
				cont = cont * 2 + 2;
				if ((int) Math.sqrt(j) * (int) Math.sqrt(j) == j) {
					cont++;
				}
				if (cont > mayor) {
					mayor = cont;
					nmayor = j;
				}
			}
			if (a == 1 && b == 1) {
				System.out
						.println("Between 1 and 1, 1 has a maximum of 1 divisors.");
				continue;
				// mayor--;
			}
			System.out.println("Between " + a + " and " + b + ", " + nmayor
					+ " has a maximum of " + mayor + " divisors.");
		}
		// TODO Auto-generated method stub

	}

}
