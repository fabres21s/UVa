import java.util.Scanner;


/**
*	1225 - Digit Counting
*
*
*	Submision:	12370734
*	Date:		2013-09-19 19:08:51
*	Runtime:	0.182
*	Ranking:	4587
*/
public class Main1225 {
	/**
	 * 1225 - Digit Counting Recursividad, Proceso matemático Encontrar cuantos
	 * 0, 1, 2 , 3,4,5,6,7,8,9 hay hasta n
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while (k-- > 0) {
			int[] digita = new int[10];
			int[] digitb = new int[10];
			// int a=sc.nextInt();
			int b = sc.nextInt();

			recurse(digita, 0, 1);
			recurse(digitb, b, 1);
			int i;
			for (i = 0; i < 9; i++) {

				System.out.print(Math.abs(digitb[i] - digita[i]) + " ");
			}
			System.out.println(Math.abs(digitb[i] - digita[i]));
		}
		// TODO Auto-generated method stub
	}

	static void recurse(int[] digit, int n, int count) {
		if (n <= 0)
			return;
		int oneNo = n % 10, tenNo;
		int m = n / 10;
		tenNo = m;
		for (int i = 0; i <= oneNo; i++) {
			digit[i] += count;
		}
		while (tenNo != 0) {
			digit[tenNo % 10] += (oneNo + 1) * count;
			tenNo /= 10;
		}
		for (int i = 0; i < 10; i++) {
			digit[i] += count * m;
		}
		digit[0] -= count;
		recurse(digit, m - 1, 10 * count);
	}
}
