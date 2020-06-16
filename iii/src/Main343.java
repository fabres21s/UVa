import java.math.BigInteger;
import java.util.Scanner;

/**
*	343 - What Base Is This?
*
*
*	Submission:	9841674
*	Date:		2012-03-10 15:50:21
*	Runtime:	1.948
*	Ranking:	2665
*/
public class Main343 {

	/**
	 * - Sistemas de numeración
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String v1, v2, x, y;
		BigInteger a, b;
		boolean flag;
		int i, j = 1, k;
		while (input.hasNext()) {
			v1 = input.next();
			v2 = input.next();
			flag = false;
			k = findminbase(v2);
			ciclo: for (i = findminbase(v1); i <= 36 && !flag; i++) {
				for (j = k; j <= 36; j++) {
					try {
						a = new BigInteger(v1, i);
						b = new BigInteger(v2, j);
					} catch (Exception ex) {
						continue;
					}
					x = a.toString(10);
					y = b.toString(10);
					if (x.compareTo(y) == 0) {
						flag = true;
						break ciclo;
					}
				}
				/*
				 * try { a=new BigInteger(v1,i); x=a.toString(10).toUpperCase();
				 * for(j=k;j<36;j++) { try { b=new BigInteger(v2,j);
				 * y=b.toString(10).toUpperCase(); if(x.equals(y)) { flag=true;
				 * break; } } catch(Exception ex){} } } catch(Exception e){}
				 */
			}
			if (flag)
				System.out
						.printf("%s (base %d) = %s (base %d)\n", v1, i, v2, j);
			else
				System.out.printf("%s is not equal to %s in any base 2..36\n",
						v1, v2);
		}
		input.close();
	}

	static int findminbase(String s) {
		int i = 1, j;
		for (char c : s.toCharArray()) {
			if (c >= 'A')
				j = c - 'A' + 10;
			else
				j = c - '0';
			if (i < j)
				i = j;
		}
		i++;
		return i;
	}
}
