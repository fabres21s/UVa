import java.util.Scanner;

/**
*	10229 - Modular Fibonacci
*
*
*	Submision:	9411223
*	Date:		2011-10-26 15:17:25
*	Runtime:	0.288
*	Ranking:	2693
*/
public class Main10229 {
	static int mod;

	public static int[][] multiply(int[][] a, int[][] b) {
		int[][] res = new int[a.length][a.length];
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length; j++)
				for (int k = 0; k < a.length; k++)
					res[i][j] = ((res[i][j] + ((a[i][k] & mod) * (b[k][j] & mod))) & mod);
		return res;
	}

	public static int[][] matPow(int[][] mat, int pow) {
		int[][] res = new int[mat.length][mat.length];
		for (int i = 0; i < res.length; i++)
			res[i][i] = 1;
		while (pow > 0) {
			if (pow % 2 == 1)
				res = multiply(res, mat);
			mat = multiply(mat, mat);
			pow >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] init = { { 1, 1 }, { 1, 0 } };
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt() - 1;
			mod = (1 << in.nextInt()) - 1;
			if (n >= 0)
				System.out.println(matPow(init, n)[0][0] & mod);
			else
				System.out.println(0);
		}
		in.close();
	}
}