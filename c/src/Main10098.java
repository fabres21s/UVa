import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main10098 {

	//TODO PONER INFORMACION
	static StringBuffer output = new StringBuffer();
	public static HashMap<String, Boolean> generated;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		char array[];
		for (int i = 0; i < testCases; i++) {

			array = br.readLine().toCharArray();

			Arrays.sort(array);
			generated = new HashMap<>();
			permutate(array, new boolean[array.length], "");
			output.append("\n");
		}
		System.out.print(output);

	}

	public static void permutate(char[] c, boolean[] flag, String result) {
		if (result.length() == c.length) {
			output.append(result);
			output.append("\n");
		} else {
			for (int i = 0; i < c.length; i++) {
				if (!flag[i]) {
					String s = result + c[i];
					if (generated.get(s) == null) {
						flag[i] = true;
						generated.put(s, true);
						permutate(c, flag, s);
						flag[i] = false;
					}
				}
			}
		}
	}

}
