import java.util.Scanner;


/**
*	305 - Joseph
*
*
*	Submision:	9596026
*	Date:		2011-12-27 16:17:17
*	Runtime:	0.248
*	Ranking:	4110
*/
public class Main305 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] val = { 0, 2, 7, 5, 30, 169, 441, 1872, 7632, 1740, 93313,
				459901, 1358657, 2504881 };
		Scanner input = new Scanner(System.in);
		int n;
		while ((n = input.nextInt()) != 0) {
			System.out.println(val[n]);
		}

	}

}
