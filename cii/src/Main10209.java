import java.util.Scanner;

/**
*	10209 - Is This Integration?
*
*
*	Submision:	17579959
*	Date:		2016-06-26 23:55:19
*	Runtime:	1.130
*	Ranking:	3931
*/
public class Main10209 {
//fuente http://lbv-pc.blogspot.com.co/2012/11/is-this-integration.html
	/*
	 * - Fórmula matemática
	 * 
	 * Encontrar cada una de las áreas definidas en el ejercicio
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double a;
		while (input.hasNext()) {
			a = input.nextDouble();
			
			System.out.printf("%.3f %.3f %.3f\n", (a*a*(1-Math.sqrt(3)+Math.PI/3)), 
					a*a*(2*Math.sqrt(3)-4+Math.PI/3), a*a*(4-2*Math.PI/3-Math.sqrt(3)));
		}
	}

}
