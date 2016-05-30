import java.util.Scanner;

public class Main {

	/*
	 * validaciones
	 */
	public static void main(String[] args) {
		// b y s s/b
		Scanner input = new Scanner(System.in);
		double b, s;
		double r1, r2 = 0;
		int casos = 0;
		while (input.hasNext()) {
			b = input.nextDouble();
			s = input.nextDouble();
			
			if (b == 0 && s == 0) {
				break;
			}
			casos++;
			r1 = s / b;

			if (b > 1) {
				r2 = (s - 1) / (b - 1);
			} else {
				System.out.println("Case " + casos + ": :-\\");
				continue;
			}
			if (r2 > r1 || r2 == r1) {
				System.out.println("Case " + casos + ": :-|");
			} else {
				System.out.println("Case " + casos + ": :-(");
			}
			
		}
		input.close();
	}

}






