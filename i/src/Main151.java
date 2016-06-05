import java.util.Scanner;

/**
*	151 - Power Crisis
*
*
*	Submision:	9395230
*	Date:		2011-10-21 17:02:02
*	Runtime:	0.176
*	Ranking:	8591
*/
public class Main151 {
	static boolean k[] = new boolean[100];

	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) {
		int N, count;

		Scanner input = new Scanner(System.in);
		boolean t;

		while (input.hasNext()) {
			N = input.nextInt();
			if (N == 0)
				break;
			for (int i = 1; i < N; i++) {
				init(k);
				int j = 1;
				count = 0;
				t = true;
				for (;;) {
					if (j > N)
						j -= N;
					if (k[j] == false) {
						if (count == i) {
							k[j] = true;
							count = 0;
						}
						j++;
						count++;
						k[1] = true;
					} else
						j++;
					if (k[13] == true)
						break;
				}
				for (int m = 1; m <= N; m++) {
					if (k[m] == false) {
						t = false;
						break;
					}
				}
				if (t == true) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	static void init(boolean k[]) {
		for (int i = 1; i < 100; i++)
			k[i] = false;
	}

}
