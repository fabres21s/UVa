import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main1062 {

	
	
	//TODO poner categoria e id
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		int testCases = 1;
		while ( !(line = br.readLine()).equals("end")) {
			char array [] = line.toCharArray();
			
			List<Stack<Character>> list = new ArrayList<Stack<Character>>();
			
			for (char c : array) {
				boolean puesto = false;
				for (Stack<Character> stack : list) {
					if (stack.peek() >= c) {
						puesto = true;
						stack.add(c);
						break;
					}
				}
				if (!puesto) {
					Stack<Character> stack = new Stack<Character>();
					stack.add(c);
					list.add(stack);
				}
			}
			
			System.out.println("Case "+testCases+": "+list.size());
			testCases++;
		}
	}

}
