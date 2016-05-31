import java.util.Scanner;

/**
*	10055 - Hashmat the Brave Warrior
*
*
*	Submision:	9483585
*	Date:		2011-11-18 20:12:25
*	Runtime:	2.848
*	Ranking:	41518
*/
public class Main10055 {

	/*
	 * 10055 - Hashmat the Brave Warrior - Muy fácil Hallar el valor absoluto de
	 * la resta de dos números
	 */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long a, b;
		while (input.hasNext()) {
			a = input.nextLong();
			b = input.nextLong();
			System.out.println(Math.abs(a - b));
		}
		input.close();
	}
}
