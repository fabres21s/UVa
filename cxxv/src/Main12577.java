import java.util.Scanner;

/**
*	12577 - Hajj-e-Akbar
*
*
*	Submision:	12306484
*	Date:		2013-09-06 16:30:28
*	Runtime:	0.172
*	Ranking:	6071
*/
public class Main12577 {

	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) {
		int casos = 1;
		Scanner input = new Scanner(System.in);
		String word;
		while (!(word = input.next()).equals("*")) {
			if (word.length() == 4) {
				System.out.printf("Case %d: Hajj-e-Akbar\n", casos);
			} else {
				System.out.printf("Case %d: Hajj-e-Asghar\n", casos);
			}
			casos++;
		}
		input.close();

	}

}
