import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//TODO TLE - Frequent Values - En C++ también
public class Main11235 {

	
	/*
	 * Pasarlo a C++ - Igual TLE
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n, xx, x, i, inf, sup, acum, max;
		StringBuffer answer = new StringBuffer();

		Set<Integer> treeSet = new TreeSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		while ((n = input.nextInt()) != 0) {
			int querys = input.nextInt();

			int arreglo[] = new int[100000 * 2 + 1];

			treeSet.clear();
			for (i = 0; i < n; i++) {
				xx = input.nextInt() + 100000;
				treeSet.add(xx);
				arreglo[xx]++;
			}

			list.clear();
			for (int y : treeSet) {
				list.add(arreglo[y]);
			}

			for (i = 0; i < querys; i++) {
				inf = input.nextInt() - 1;
				sup = input.nextInt();
//				if (inf == sup) {
//					answer.append("1\n");
//					continue;
//				}

				max = 0;
				acum = 0;
				for (int xyz : list) {
					x = xyz;

					acum += x;
					
					
					if (inf > 0) {
						// list.remove(j);
						// list.add(j, x -inf);

						xx = x - inf;
						inf = inf - x;
						x = xx;
					}

					if (acum > sup) {
						// list.remove(j);
						// list.add(j, x + sup -acum);
						x = x + sup - acum;
						if (x > max) {
							max = x;
						}

						break;
					}

					if (x > max) {
						max = x;
					}

				}
				answer.append(max + "\n");
			}

		}
		input.close();
		System.out.print(answer);
	}

}
