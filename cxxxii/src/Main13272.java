import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

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
			List<Integer> positions = findPositions(array);
			for (int i = 0; i < array.length; i++) {

				final int zzz = i;

				List<Integer> positionsToEvaluate = positions.stream().filter(c -> c > zzz)
						.collect(Collectors.toList());
				Collections.reverse(positionsToEvaluate);
				
				if (positionsToEvaluate.size() > 1000) {
					break;
				}

				int answer = 0;

				for (int x : positionsToEvaluate) {
					answer = evaluate(array, i, x + 1);
					if (answer > 0) {
						break;
					}
				}
				output.append(String.format("%d\n", answer));

			}

		}
		System.out.print(output);

	}

	private static List<Integer> findPositions(char[] cs) {
		List<Integer> listPositions = new ArrayList<Integer>();

		for (int x = 0; x < cs.length; x++) {

			switch ((int) cs[x]) {
			case 41:
			case 93:
			case 125:
			case 62:
				listPositions.add(x);
				break;
			}

		}

		return listPositions;
	}

	private static int evaluate(char[] cs, int start, int end) {

		Stack<Integer> stack = new Stack<Integer>();
		boolean answer = true;
		int x, y;
		for (int xx = start; xx < end; xx++) {
			x = cs[xx];

			if (x == 40 || x == 91 || x == 123 || x == 60) {
				stack.push(x);
			} else {

				if (stack.size() > 0) {
					y = stack.pop();
					if (x == 41 && y != 40) {// )
						return 0;
					} else if (x == 93 && y != 91) {
						return 0;
					} else if (x == 125 && y != 123) {
						return 0;
					} else if (x == 60 && y != 62) {
						return 0;
					}
				} else {
					return 0;
				}

			}
		}
		if (stack.size() > 0) {
			return 0;
		}
		if (answer) {
			return end - start;
		}

		return 0;

	}

}
