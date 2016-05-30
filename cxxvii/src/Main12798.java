import java.util.Scanner;


public class Main {

	/**
	 * Muy fácil
	 * En un arreglo bidimensional, encontrar en cuantas filas todos los números son mayores que 0
	 * @param args
	 */
	public static void main(String[] args) {

		
		Scanner input = new Scanner(System.in);
		int n, m, i, j, count;
		boolean success;
		while ( input.hasNext() ) {
			n = input.nextInt();
			m = input.nextInt();
			
			count = 0;
			for (i = 0; i < n; i ++){
				success = true;
				for (j = 0; j < m; j++){
					if (input.nextInt() == 0){
						success = false;
					}
				}
				if (success){
					count++;
				}
			}
			System.out.println(count);
		}
		input.close();
	}

}
