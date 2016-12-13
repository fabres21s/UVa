import java.util.Scanner;

/**
*	12397 - Roman Numerals
*
*
*	Submision:	10679332
*	Date:		2012-10-03 01:04:41
*	Runtime:	0.180
*	Ranking:	395
*/

public class Main12397 {

	/**
	 * - Números Romanos
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, c, i;
		char[] p;
		while (input.hasNext()) {
			n = input.nextInt();

			p = ToRoman(n).toCharArray();
			c = 0;
			for (i = 0; i < p.length; i++) {
				switch (p[i]) {
				case 'I':
					c++;
					break;
				case 'V':
					c += 2;
					break;
				case 'X':
					c += 2;
					break;
				case 'L':
					c += 2;
					break;
				case 'C':
					c += 2;
					break;
				case 'D':
					c += 3;
					break;
				case 'M':
					c += 4;
					break;
				}

			}
			System.out.println(c);

		}
		input.close();
	}

	static String ToRoman(int valor) {
		int aux = valor / 1000;
		StringBuffer buf = new StringBuffer();
		switch (aux) {
		case 1:
			buf.append("M");
			break;

		case 2:
			buf.append("MM");
			break;

		case 3:
			buf.append("MMM");
			break;
		}
		valor = valor % 1000;
		// System.out.println("1. "+valor);
		aux = valor / 100;
		switch (aux) {
		case 1:
			buf.append("C");
			break;

		case 2:
			buf.append("CC");
			break;

		case 3:
			buf.append("CCC");
			break;

		case 4:
			buf.append("CD");
			break;

		case 5:
			buf.append("D");
			break;

		case 6:
			buf.append("DC");
			break;

		case 7:
			buf.append("DCC");
			break;

		case 8:
			buf.append("DCCC");
			break;

		case 9:
			buf.append("CM");
			break;
		}
		valor = valor % 100;
		aux = valor / 10;
		switch (aux) {
		case 1:
			buf.append("X");
			break;

		case 2:
			buf.append("XX");
			break;

		case 3:
			buf.append("XXX");
			break;

		case 4:
			buf.append("XL");
			break;

		case 5:
			buf.append("L");
			break;

		case 6:
			buf.append("LX");
			break;

		case 7:
			buf.append("LXX");
			break;

		case 8:
			buf.append("LXXX");
			break;

		case 9:
			buf.append("XC");
			break;
		}
		valor = valor % 10;
		switch (valor) {
		case 1:
			buf.append("I");
			break;

		case 2:
			buf.append("II");
			break;

		case 3:
			buf.append("III");
			break;

		case 4:
			buf.append("IV");
			break;

		case 5:
			buf.append("V");
			break;

		case 6:
			buf.append("VI");
			break;

		case 7:
			buf.append("VII");
			break;

		case 8:
			buf.append("VIII");
			break;

		case 9:
			buf.append("IX");
			break;
		}
		return buf.toString();
	}

}
