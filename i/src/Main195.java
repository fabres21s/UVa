import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//TODO - Poner información
public class Main195 {

	static StringBuffer output = new StringBuffer();
	public static HashMap<String, Boolean> generated;

	public static void main(String[] args) throws NumberFormatException, IOException {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		map.put('A', 1);
		map.put('a', 2);
		map.put('B', 3);
		map.put('b', 4);
		map.put('C', 5);
		map.put('c', 6);
		map.put('D', 7);
		map.put('d', 8);
		map.put('E', 9);
		map.put('e', 10);
		map.put('F', 11);
		map.put('f', 12);
		map.put('G', 13);
		map.put('g', 14);
		map.put('H', 15);
		map.put('h', 16);
		map.put('I', 17);
		map.put('i', 18);
		map.put('J', 19);
		map.put('j', 20);
		map.put('K', 21);
		map.put('k', 22);
		map.put('L', 23);
		map.put('l', 24);
		map.put('M', 25);
		map.put('m', 26);
		map.put('N', 27);
		map.put('n', 28);
		map.put('O', 29);
		map.put('o', 30);
		map.put('P', 31);
		map.put('p', 32);
		map.put('Q', 33);
		map.put('q', 34);
		map.put('R', 35);
		map.put('r', 36);
		map.put('S', 37);
		map.put('s', 38);
		map.put('T', 39);
		map.put('t', 40);
		map.put('U', 41);
		map.put('u', 42);
		map.put('V', 43);
		map.put('v', 44);
		map.put('W', 45);
		map.put('w', 46);
		map.put('X', 47);
		map.put('x', 48);
		map.put('Y', 49);
		map.put('y', 50);
		map.put('Z', 51);
		map.put('z', 52);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		char array[];
		for (int i = 0; i < testCases; i++) {

			array = br.readLine().toCharArray();

			Character c[] = new Character[array.length];

			int x = 0;
			for (char mander : array) {
				c[x++] = Character.valueOf(mander);
			}

			Arrays.sort(c, new Comparator<Character>() {

				@Override
				public int compare(Character o1, Character o2) {

					return map.get(o1) - map.get(o2);
				}
			});

			generated = new HashMap<>();
			permutate(c, new boolean[array.length], "");
		}
		System.out.print(output);

	}

	public static void permutate(Character[] c, boolean[] flag, String result) {
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
