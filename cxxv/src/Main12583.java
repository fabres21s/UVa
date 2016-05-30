import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 12583 - Memory Overflow
 * Map
 * El rey sólo podía recordar a una persona si al presentarsela
 * se la volvían a presentar en un tiempo menor o igual a daysRemember
 */
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int cases = input.nextInt() + 1;
		
		for (int i = 1 ; i < cases; i++){
			int size = input.nextInt(); 
			int daysRemember = input.nextInt();
			char [] array = input.next().toCharArray();
			
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			int remember = 0;
			int index = 0;
			for (char c : array) {
				if (map.containsKey(c)) {
					
					if (index - map.get(c) <= daysRemember ){
						remember++;
					}
					
				} 
					map.put(c, index);
				
				index++;
			}
			System.out.printf("Case %d: %d\n", i,remember);
		}
	}

}
