import java.math.BigInteger;
import java.util.Scanner;

/**
*	465 - Overflow
*
*
*	Submission:	17186363
*	Date:		2016-04-11 23:11:32
*	Runtime:	0.060
*	Ranking:	3511
*/
public class Main465 {

	/**
	 * - Grandes números
	 * Dados dos números y una operación, determinar si cada uno es mayor que 2^32 y si el resultado también lo es 
	 */
	public static void main(String[] args) {

		BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);
		Scanner input = new Scanner(System.in);
		BigInteger n1, n2, result;
		String op = "";
		while (input.hasNext()) {
			String line = input.nextLine();
			args = line.split(" ");
			n1 = new BigInteger(args[0]);
			op = args[1];
			n2 = new BigInteger(args[2]);
			if (op.equals("+")) {
				result = n1.add(n2);
			} else {
				result = n1.multiply(n2);
			}
			
			System.out.println(line);
			
			
			
			int c1 = n1.compareTo(max);
			int c2 = n2.compareTo(max);
			if (c1 > 0 ) {
				System.out.println("first number too big");
			} 
			
			if (c2 > 0) {
				System.out.println("second number too big");
			}
			if (result.compareTo(max) > 0) {
				System.out.println("result too big");
			}
		}
		input.close();
	}

}
