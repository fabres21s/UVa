import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
*	10131 - Is Bigger Smarter?
*	Submission:	20418640
*	Date:		2017-11-29 16:53:34
*	Runtime:	0.070
*	Ranking:	5976
*/
public class Main10131 {

	/**
	 * - Programación Dinámica
	 * 
	 * No entendí muy bien el ejercicio, además de no tener una salida única
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Elephant> list = new ArrayList<>();
		int idCount = 1;

		String s;
		while (true) {
			s = br.readLine();
			if (s == null || s.equals("")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(s);
			Elephant e = new Elephant();
			e.weight = Integer.parseInt(st.nextToken());
			e.iq = Integer.parseInt(st.nextToken());
			e.id = idCount++;
			list.add(e);
		}

		Elephant[] ele = list.toArray(new Elephant[list.size()]);
		Arrays.sort(ele);

		int[] lis = new int[ele.length];
		lis[0] = 1;
		for (int i = 1; i < lis.length; i++) {
			lis[i] = Math.max(1, lis[i]);
			for (int i2 = 0; i2 < i; i2++) {
				if (ele[i].iq < ele[i2].iq && ele[i].weight > ele[i2].weight) {
					lis[i] = Math.max(lis[i2] + 1, lis[i]);
				}
			}
		}

		int max = 0;
		for (int i : lis) {
			max = Math.max(i, max);
		}

		System.out.println(max);
		int[] solution = new int[max];

		boolean first = true;
		int last = 0;
		for (int i = lis.length - 1; i >= 0 && max > 0; i--) {
			if (lis[i] == max && (first || last < ele[i].iq)) {
				last = ele[i].iq;
				solution[--max] = ele[i].id;
				first = false;
			}
		}

		for (int i = 0; i < solution.length; i++) {
			System.out.println(solution[i]);
		}
	}

}

class Elephant implements Comparable<Elephant> {
	int weight, iq, id;

	public int compareTo(Elephant e) {
		return this.weight - e.weight;
	}
}