import java.util.Scanner;

/**
*	10127 - Ones
*
*
*	Submision:	9215632
*	Date:		2011-09-02 17:30:03
*	Runtime:	0.124
*	Ranking:	7348
*/
public class Main10127 {
	/**
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, cont, valor;
		while (input.hasNext()) {
			n = input.nextInt();
			cont = 2;
			valor = 11;
			while (valor % n != 0) {

				valor = valor % n;
				valor = valor * 10 + 1;
				cont++;
			}
			System.out.println(cont);
		}
		input.close();
	}
}
