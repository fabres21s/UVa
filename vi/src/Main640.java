
/**
*	640 - Self Numbers
*
*
*	Submision:	9887071
*	Date:		2012-03-20 14:51:14
*	Runtime:	1.156
*	Ranking:	3837
*/
public class Main640 {
	static int n;

	/**
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		int i;
		// long t=System.currentTimeMillis();
		int numeros[] = new int[1500000];
		for (i = 1; i <= 1000000; i++) {
			numeros[d(i)] = 1;
		}
		for (i = 1; i <= 1000000; i++) {
			if (numeros[i] == 0)
				System.out.println(i);
		}
		// t=System.currentTimeMillis()-t;
		// System.out.println(t);

	}

	private static int d(int i) {
		// System.out.println("para "+i);
		n = i;
		while (i > 0) {
			n += i % 10;
			i /= 10;
		}
		// System.out.println("retorna "+n);
		return n;
	}

}
