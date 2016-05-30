import java.util.Scanner;

public class Main {

	/*
	Logaritmos,  simulacion un poco complicado de entender
	los casos de prueba no son de mucha ayuda
	inicialmente daba tle, estando correcto 
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n;
		while (input.hasNext()) {
			n = input.nextInt();
			if (n == 0) {
				break;
			}

			
			double x = Math.log(n+1)/Math.log(2);
			n = (int)x;
			if (n ==x){
				System.out.println("Bob");
			} else {
				System.out.println("Alice");
			}
//			while (n != 1) {
//
//				if (count % 2 == 0) {
//
//					if (n % 2 == 0) {
//						n--;
//					} else {
//						n = n / 2 + 1;
//					}
//
//				} else {
//					// bob
//					n--;
//
//				}
//				count++;
//
//				// System.out.println(n);
//			}

		}

		input.close();
	}

}
