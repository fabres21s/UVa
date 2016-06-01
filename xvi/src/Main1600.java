import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TODO No enviado - Patrol Robot
//como el 929 con algunas diferencias
public class Main1600 {

	public static int k = 0;
	private static List<Integer> solucionados;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();

		int m, n;
		while (cases-- > 0) {
			m = input.nextInt();
			n = input.nextInt();
			k = input.nextInt();

			solucionados = new ArrayList<Integer>();
			boolean grid3d[][][] = new boolean[m + 2][n + 2][2];
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					grid3d[i][j][0] = input.nextInt() == 0;
				}
			}

			solve(grid3d, 1, 1, m, n, 1, 0);

			int menor = -1;
			if (solucionados.size() > 0) {
				menor = solucionados.get(0);
			}
			for (int x : solucionados) {
				if (x < menor) {
					menor = x;
				}
			}
			System.out.println(menor);

		}
		input.close();
	}

	private static void solve(boolean[][][] grid3d, int i, int j, int m, int n,
			int step, int rompe) {

		System.out.println("i = "+i+ "\tj = "+j+"\tstep = "+step);
		if (i > m || j > n) {
			System.out.println("me sali del grid");

		} else if (i > 0 && j > 0) {
			if (i == m && j == n) {
				solucionados.add(step);
				System.out.println("solucionado en " + step);
			} else {

				boolean puedoseguir = false;
				int r = 0;
				if (grid3d[i][j][0]) {
					// validamos que no esté visitado
					if (!grid3d[i][j][1]) {
						System.out.println("no es necesario romper");
						puedoseguir = true;

					}
				} else {

					if (rompe < k && k > 0) {
						System.out.println("pude romper");
						grid3d[i][j][0] = true;

						puedoseguir = true;
						r = rompe + 1;
				
						
					/*	solve(grid3d, i + 1, j, m, n, step + 1, rompe + 1);
						solve(grid3d, i - 1, j, m, n, step + 1, rompe + 1);
						solve(grid3d, i, j + 1, m, n, step + 1, rompe + 1);
						solve(grid3d, i, j - 1, m, n, step + 1, rompe + 1);*/
					} 
					
					if (puedoseguir){
						grid3d[i][j][1] = true;
						
						solve(grid3d, i + 1, j, m, n, step + 1, rompe + 1);
						solve(grid3d, i, j + 1, m, n, step + 1, rompe + 1);
						solve(grid3d, i - 1, j, m, n, step + 1, rompe + 1);
						
						solve(grid3d, i, j - 1, m, n, step + 1, rompe + 1);
					/*	if (i < m){
							solve(grid3d, i + 1, j, m, n, step + 1, r);
						}  else 						if ( j < n){
							solve(grid3d, i, j + 1, m, n, step + 1, r);
						} else 
						if (i > 0){
							solve(grid3d, i - 1, j, m, n, step + 1, r);
						} else
						

						if (j > 0){
							solve(grid3d, i, j - 1, m, n, step + 1, r);
						}*/
					}
				}
			}
		}

	}

}


/*
 * 
 1
10 20
11
1 1 1 1 0 1 1 1 0 0 1 1 1 0 0 1 1 1 1 0 
1 1 0 1 0 1 1 1 1 0 1 1 1 1 0 1 0 1 0 0 
1 0 0 1 1 1 0 1 0 1 0 0 1 1 1 0 0 0 0 0 
0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 1 1 1 1 
0 0 0 1 1 1 1 1 1 1 0 0 0 0 0 1 0 1 1 0 
1 0 0 1 1 0 0 1 1 1 0 0 1 0 0 1 1 0 0 0 
1 0 1 1 0 1 0 0 0 1 1 1 1 0 0 0 0 1 1 1 
0 1 1 1 1 1 0 0 0 0 1 1 0 1 0 0 0 0 1 0 
1 1 0 0 1 0 0 0 1 0 0 1 1 1 0 0 1 1 0 0 
1 1 1 1 0 1 1 0 0 0 0 1 1 1 1 1 0 0 1 0 

*/
