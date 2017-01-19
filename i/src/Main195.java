import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main195 {

	// TODO TLE - 195 - Anagram
	//Intentarlo en C++

	static StringBuffer output = new StringBuffer();
	static SortedSet<String> set = new TreeSet<String>();

	static Map<Character, Character> convert = new HashMap<Character, Character>();
	static Map<Character, Character> reverse = new HashMap<Character, Character>();

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		convert.put('A', 'A');
		convert.put('B', 'C');
		convert.put('C', 'E');
		convert.put('D', 'G');
		convert.put('E', 'I');
		convert.put('F', 'K');
		convert.put('G', 'M');
		convert.put('H', 'O');
		convert.put('I', 'Q');
		convert.put('J', 'S');
		convert.put('K', 'U');
		convert.put('L', 'W');
		convert.put('M', 'Y');
		convert.put('N', 'a');
		convert.put('O', 'c');
		convert.put('P', 'e');
		convert.put('Q', 'g');
		convert.put('R', 'i');
		convert.put('S', 'k');
		convert.put('T', 'm');
		convert.put('U', 'o');
		convert.put('V', 'q');
		convert.put('W', 's');
		convert.put('X', 'u');
		convert.put('Y', 'w');
		convert.put('Z', 'y');

		convert.put('a', 'B');
		convert.put('b', 'D');
		convert.put('c', 'F');
		convert.put('d', 'H');
		convert.put('e', 'J');
		convert.put('f', 'L');
		convert.put('g', 'N');
		convert.put('h', 'P');
		convert.put('i', 'R');
		convert.put('j', 'T');
		convert.put('k', 'V');
		convert.put('l', 'X');
		convert.put('m', 'Z');
		convert.put('n', 'b');
		convert.put('o', 'd');
		convert.put('p', 'f');
		convert.put('q', 'h');
		convert.put('r', 'j');
		convert.put('s', 'l');
		convert.put('t', 'n');
		convert.put('u', 'p');
		convert.put('v', 'r');
		convert.put('w', 't');
		convert.put('x', 'v');
		convert.put('y', 'x');
		convert.put('z', 'z');

		// reverse
		reverse.put('A', 'A');
		reverse.put('C', 'B');
		reverse.put('E', 'C');
		reverse.put('G', 'D');
		reverse.put('I', 'E');
		reverse.put('K', 'F');
		reverse.put('M', 'G');
		reverse.put('O', 'H');
		reverse.put('Q', 'I');
		reverse.put('S', 'J');
		reverse.put('U', 'K');
		reverse.put('W', 'L');
		reverse.put('Y', 'M');
		reverse.put('a', 'N');
		reverse.put('c', 'O');
		reverse.put('e', 'P');
		reverse.put('g', 'Q');
		reverse.put('i', 'R');
		reverse.put('k', 'S');
		reverse.put('m', 'T');
		reverse.put('o', 'U');
		reverse.put('q', 'V');
		reverse.put('s', 'W');
		reverse.put('u', 'X');
		reverse.put('w', 'Y');
		reverse.put('y', 'Z');

		reverse.put('B', 'a');
		reverse.put('D', 'b');
		reverse.put('F', 'c');
		reverse.put('H', 'd');
		reverse.put('J', 'e');
		reverse.put('L', 'f');
		reverse.put('N', 'g');
		reverse.put('P', 'h');
		reverse.put('R', 'i');
		reverse.put('T', 'j');
		reverse.put('V', 'k');
		reverse.put('X', 'l');
		reverse.put('Z', 'm');
		reverse.put('b', 'n');
		reverse.put('d', 'o');
		reverse.put('f', 'p');
		reverse.put('h', 'q');
		reverse.put('j', 'r');
		reverse.put('l', 's');
		reverse.put('n', 't');
		reverse.put('p', 'u');
		reverse.put('r', 'v');
		reverse.put('t', 'w');
		reverse.put('v', 'x');
		reverse.put('x', 'y');
		reverse.put('z', 'z');

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		char array[];
		for (int i = 0; i < testCases; i++) {

			array = br.readLine().toCharArray();

			 //long t = System.currentTimeMillis();
//			for (char c : array) {
//				letters.add((c));
//			}
			permutar("", array, new boolean [array.length]);

			for (String s : set) {
				// array = s.toCharArray();
				//
				// for (char c: array){
				// output.append(reverse.get(c));
				// }
				output.append(s + "\n");
			}
			//System.out.println(System.currentTimeMillis() - t);

			set = new TreeSet<String>();
		}
		System.out.print(output);

	}

	private static void permutar(String cadena, char[] letters,
			boolean visited[]) {
		if (cadena.length() == visited.length ) {
			set.add(cadena);
		}

		for (int i = 0; i < letters.length; i++) {
			if (!visited[i]) {
				Character c = letters[i];
				visited[i] = true;
				permutar(cadena + c, letters, visited);
				visited[i] = false;
			}
			// letters.add(i, c);
		}
	}

}
