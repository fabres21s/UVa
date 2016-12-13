import java.util.Scanner;

/**
*	1585 - Score
*
*
*	Submision:	16788203
*	Date:		2016-02-01 15:49:18
*	Runtime:	0.063
*	Ranking:	3783
*/
public class Main1585 {
	
	/**
	 * - Validaciones
	 * 
	 *	Se tiene ej, OOOOOOXOXOXOX
	 *	por la primera O se suma 1, por la segunda 2 y así
	 *	al encontrar una x, se vuelve a empezar de 0
	 */
	
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		int test = Integer.valueOf(input.nextLine());
		
		//No entiendo por qué el input.nextInt() e input.next() generaban RE - Tocó pasarlo a input.nextLine() - debe ser por el package
		char [] array;
		int sum, acum;
		while (test -- > 0){
			array = input.nextLine().toCharArray();
			sum =0;
			acum = 0;
			for (char c: array){
				if (c == 'O') {
					acum ++;
				} else {
					acum =0;
				}
				sum +=acum;
			}
			System.out.println(sum);
		}
		input.close();
	}
 
}
