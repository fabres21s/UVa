
/**
*	291 - The House Of Santa Claus
*
*
*	Submision:	9581986
*	Date:		2011-12-21 20:33:05
*	Runtime:	0.312
*	Ranking:	4944
*/
public class Main291 {
	static int V[][] = new int[7][7];
	static int[] B = new int[10];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		makelink();
		cal(1, 0);
		// TODO Auto-generated method stub
	}

	static void print() {
		int i;
		System.out.printf("1");
		for (i = 0; i < 8; i++) {
			System.out.print(B[i]);
		}
		System.out.println();
	}

	static void makelink() {
		V[1][2] = 1;
		V[2][1] = 1;
		V[2][3] = 1;
		V[3][2] = 1;
		V[5][2] = 1;
		V[2][5] = 1;
		V[3][5] = 1;
		V[5][3] = 1;
		V[1][5] = 1;
		V[5][1] = 1;
		V[1][3] = 1;
		V[3][1] = 1;
		V[5][4] = 1;
		V[4][5] = 1;
		V[3][4] = 1;
		V[4][3] = 1;
	}

	static void cal(int r, int level) {
		int j, k;
		if (level == 8) {
			print();
			return;
		}
		for (int i = 1; i <= 5; i++)

			if (V[r][i] > 0 && V[i][r] > 0) {
				B[level] = i;
				V[i][r] = V[r][i] = 0;
				cal(i, level + 1);
				j = level;
				k = B[j];
				V[k][r] = 1;
				V[r][k] = 1;
			}
		j = level - 2;
		if (j >= 0) {
			k = B[j];
			V[k][r] = 1;
			V[r][k] = 1;
		}

	}
}
