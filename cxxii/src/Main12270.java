import java.util.Scanner;

public class Main {

	
	/**

	Muy fácil
	 *Si un número es positivo, aumentar un contador, sino, disminuirlo
	 *En el enuncuado no lo tuve muy claro que digamos 
	 */
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		int cases = 0;
		int n ;//= input.nextInt();
		
		
		while ( (n = input.nextInt()) != 0){
			
			int count = 0;
			for (int i = 0; i<n; i++){
				if (input.nextInt() > 0){
					count++;
				} else {
					count--;
				}
			}
			cases++;
			System.out.printf("Case %d: %d\n", cases, count);
		}
	
		
		
		
		
	}

}
