import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder output = new StringBuilder();
		int testCases = Integer.parseInt(br.readLine());

		int x1, x2, y1, y2, z1, z2;

		char s1[];
		String s2;

		while (testCases-- > 0) {
			s1 = br.readLine().toCharArray();
			s2 = br.readLine();

			x1 = x2 = y1 = y2 = z1 = -1;
			z2 = s1.length - 1;

			for (int i = 0; i < s1.length; i++) {
				if (s1[i] == '<') {
					if (x1 == -1) {
						x1 = i;
					} else {
						y1 = i;
					}
				} else if (s1[i] == '>') {
					if (x2 == -1) {
						x2 = i;
					} else {
						y2 = i;
					}
				} else if (s1[i] == ' ') {
					if (x2 > -1 && z1 == -1) {
						z1 = i - 1;
					} else if (y2 > -1 && z2 == s1.length - 1) {
						z2 = i - 1;
					}
				}
			}

			String seq1 = (String.copyValueOf(s1).subSequence(x1, x2 + 1)).toString();
			String seq2 = (String.copyValueOf(s1).subSequence(y1, y2 + 1)).toString();

			String word1 = (String.copyValueOf(s1).subSequence(x1, z1 + 1)).toString();
			String word2 = (String.copyValueOf(s1).subSequence(y1, z2 + 1)).toString();

			String toReplace = (String.copyValueOf(s1).subSequence(x1, z2 + 1)).toString();

			String t1 = (String.copyValueOf(s1).subSequence(x1, z1 + 1).toString().replace(seq1, seq2));
			String t2 = (String.copyValueOf(s1).subSequence(y1, z2 + 1).toString().replace(seq2, seq1));

			output.append(String.copyValueOf(s1).replaceAll("[<|>]", "") + "\n");
			output.append(
					s2.replace("...", toReplace.replace(word2, t2.replaceAll("[<|>]", "")).replace(word1, t1.replaceAll("[<|>]", ""))) + "\n");

		}
		
		System.out.print(output);

	}

}
