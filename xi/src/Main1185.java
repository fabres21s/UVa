import java.util.Scanner;

/**
*	1185 - Big Number
*
*
*	Submission:	17017840
*	Date:		2016-03-14 21:31:57
*	Runtime:	0.262
*	Ranking:	153
*/
public class Main1185 {

	/**
	 * - Pregenerados
	 * - Factorial
	 * - Logaritmos
	 * 
	 * Encontrar la cantidad
	 * de digitos de n! siendo n hasta 10^7 Se hizo uso de los conceptos que, para
	 * saber los digitos de un n�mero es
	 * 
	 * log(n) + 1
	 * 
	 * as�, para n! ser�a
	 * 
	 * log(n!) +1
	 * 
	 * pero como no podemos calcular n! y n! = 1*2*3*4*...*n nos valemos de la
	 * propiedad de los logaritmos log (a*b) = log(a) + log(b)
	 */
	public static void main(String[] args) {

		double digits = 0;
		int arreglo[] = new int[10000006];
		double log;
		for (int i = 1; i < 10000002; i++) {
			log = (Math.log10(i));
			digits += log;
			arreglo[i] = (int) digits + 1;
			// System.out.println(i+"  >> "+log+" \t"+(int)(digits+1));
		}

		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		while (testCases-- > 0) {
			System.out.printf("%d\n", (arreglo[input.nextInt()]));
		}
		input.close();
	}

}
