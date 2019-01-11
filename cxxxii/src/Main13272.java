import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//TODO - TLE 13272 - Bracket Sequence
public class Main13272 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(br.readLine());
		StringBuffer output = new StringBuffer();
		String line;

		for (int cc = 1; cc <= casos; cc++) {
			line = br.readLine();
			char array[] = line.toCharArray();
			output.append(String.format("Case %d:\n", cc));
			int sol[] = evaluate(array);
			for (int x : sol) {
				output.append(String.format("%d\n", x));
			}

		}
		System.out.print(output);

	}

	private static int[] evaluate(char[] cs) {

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stackPositions = new Stack<Integer>();
		int[] positions = new int[cs.length];

		int x, y, p;
		for (int i = 0; i < cs.length; i++) {
			x = cs[i];

			if (x == 40 || x == 91 || x == 123 || x == 60) {
				stack.push(x);
				stackPositions.push(i);
			} else {

				if (stack.size() > 0) {
					y = stack.pop();
					p = stackPositions.pop();
					if (x == 41 && y == 40) {
						positions[p] = i - p + 1;
					} else if (x == 93 && y == 91) {
						positions[p] = i - p + 1;
					} else if (x == 125 && y == 123) {
						positions[p] = i - p + 1;
					} else if (x == 62 && y == 60) {
						positions[p] = i - p + 1;
					}
				}
			}
		}
		for (int i = 0; i < positions.length; i++) {

			if (positions[i] > 0) {
				positions[i] += recursive(positions, positions[i] + i);
			}
		}
		return positions;

	}

	private static int recursive(int[] positions, int position) {
		if (position < positions.length) {
			if (positions[position] > 0) {
				return positions[position] + recursive(positions, positions[position] + position);
			}
		}
		return 0;
	}

}
