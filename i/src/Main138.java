
/**
*	138 - Street Numbers
*
*
*	Submision:	9595927
*	Date:		2011-12-27 15:29:45
*	Runtime:	0.132
*	Ranking:	4787
*/
public class Main138 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int R[] = { 6, 8, 35, 49, 204, 288, 1189, 1681, 6930, 9800, 40391,
				57121, 235416, 332928, 1372105, 1940449, 7997214, 11309768,
				46611179, 65918161 };
		for (int i = 0; i < 20; i += 2) {
			System.out.printf("%10d%10d\n", R[i], R[i + 1]);
		}

	}

}
