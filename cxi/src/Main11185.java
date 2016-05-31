import java.math.BigInteger;
import java.util.Scanner;

/**
*	11185 - Ternary
*
*
*	Submision:	9714753
*	Date:		2012-02-06 13:30:40
*	Runtime:	0.128
*	Ranking:	6279
*/
public class Main11185 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String n;
		BigInteger a;
		while (!(n = input.next()).contains("-")) {
			// casos--;
			// valor=input.next();
			a = new BigInteger(n, 10);
			// base3=a.toString(3);
			System.out.println(a.toString(3));
			// a=new BigInteger(valor,16);
			/*
			 * hexa=a.toString(2).toCharArray(); dec=hex=0;
			 * for(i=0;i<decimal.length;i++) { if(decimal[i]=='1') { dec++; } }
			 * for(i=0;i<hexa.length;i++) { if(hexa[i]=='1') { hex++; } }
			 * System.out.printf("%d %d\n",dec,hex);
			 */
		}
		input.close();
	}

}
