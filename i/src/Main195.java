import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main195 {

	//195 TODO COMPLETAR
	
	static StringBuffer output = new StringBuffer();
	static SortedSet<String> set = new TreeSet<String>();
	
	static Map<Character, Character> convert = new HashMap<Character, Character>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		
		convert.put('A', 'A');
		convert.put('B', 'C');
		convert.put('C', 'E');
		convert.put('D', 'A');
		convert.put('E', 'A');
		convert.put('F', 'A');
		convert.put('G', 'A');
		convert.put('H', 'A');
		convert.put('I', 'A');
		convert.put('J', 'A');
		convert.put('K', 'A');
		convert.put('L', 'A');
		convert.put('M', 'A');
		convert.put('N', 'A');
		convert.put('O', 'A');
		convert.put('P', 'A');
		convert.put('Q', 'A');
		convert.put('R', 'A');
		convert.put('S', 'A');
		convert.put('T', 'A');
		convert.put('U', 'A');
		convert.put('V', 'A');
		convert.put('W', 'A');
		convert.put('X', 'A');
		convert.put('Y', 'A');
		convert.put('Z', 'y');
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCases; i++) {
			LinkedList<Character> letters = new LinkedList<Character>();
			
			char array[] = br.readLine().toCharArray();
			
			for (char c : array) {
				letters.add(c);
			}
			permutar("", letters);
			
			for (String s: set) {
				output.append(s+"\n");
			}
			
			set  = new TreeSet<String>();
		}
		System.out.print(output);
		
	}

	private static void permutar(String cadena, LinkedList<Character> letters) {
		if (letters.size() == 1) {
			cadena += letters.get(0);
			set.add(cadena);
		}
		
		for (int i = 0; i < letters.size(); i++) {
			Character c = letters.remove(i);
			permutar(cadena + c, letters);
			letters.add(i, c);
		}
	}

	

}
