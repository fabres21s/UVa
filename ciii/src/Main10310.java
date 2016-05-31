import java.util.Scanner;

/**
*	10310 - Dog and Gopher
*
*
*	Submision:	9289768
*	Date:		2011-09-22 16:12:58
*	Runtime:	1.036
*	Ranking:	3652
*/
public class Main10310 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double xx = 0, yy = 0;
		while (input.hasNext()) {
			// System.out.println("valores");
			double toperas = input.nextDouble();
			double tx = input.nextDouble();
			double ty = input.nextDouble();
			double px = input.nextDouble();
			double py = input.nextDouble();
			int aux = 0;
			for (double i = 0; i < toperas; i++) {
				// System.out.println("coordenadas");
				double x = input.nextDouble();
				double y = input.nextDouble();
				if (aux == 0) {
					double dt = distancia(x, tx, y, ty);
					double dp = distancia(x, px, y, py);
					// System.out.println(dt+"  "+dp);
					if (4 * dt <= dp) {
						aux = 1;
						xx = x;
						yy = y;
					}
				}
			}
			if (aux == 1) {
				System.out
						.printf("The gopher can escape through the hole at (%.3f,%.3f).\n",
								xx, yy);
			} else {
				System.out.println("The gopher cannot escape.");
			}
			// input.next();
		}
		input.close();
	}

	static double distancia(double x1, double x2, double y1, double y2) {
		return ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

}
