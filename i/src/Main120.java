import java.io.*;
import java.util.*;

/**
*	120 - Stacks of Flapjacks
*
*
*	Submision:	9309229
*	Date:		2011-09-28 15:23:45
*	Runtime:	1.416
*	Ranking:	8091
*/
public class Main120 {
	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			Scanner stream = new Scanner(s);
			int[] a = new int[s.split(" ").length];
			for (int i = 0; i < a.length; i++) {
				a[i] = stream.nextInt();
			}
			System.out.println(s);
			List<Integer> flips = flips(a);
			for (int e : flips) {
				System.out.print((e + 1) + " ");
			}
			System.out.println("0");
			stream.close();
		}
		
	}

	private static List<Integer> flips(int[] a) {
		List<Integer> flips = new ArrayList<Integer>();
		for (int i = a.length - 1; i > 0; i--) {
			int maxI = maxIndex(a, i);
			if (maxI == i)
				continue;
			reverse(a, maxI);
			if (maxI != 0)
				flips.add(a.length - 1 - maxI);
			reverse(a, i);
			flips.add(a.length - i - 1);
		}
		return flips;
	}

	public static int maxIndex(int[] a, int end) {
		int j = 0, index = 0;
		for (; j <= end; index = a[j] > a[index] ? j : index, j++)
			;
		return index;
	}

	public static void reverse(int[] a, int end) {
		for (int i = 0, j = end; i < j; a[i] = a[i] ^ a[j], a[j] = a[i] ^ a[j], a[i] = a[i++]
				^ a[j--])
			;
	}
}
