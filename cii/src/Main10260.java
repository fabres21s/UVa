import java.util.Scanner;

/**
*	10260 - Soundex
*
*
*	Submission:	9974218
*	Date:		2012-04-09 16:48:39
*	Runtime:	0.196
*	Ranking:	8389 / 8488
*/
public class Main10260 {

	/**
	 * - Cadena de caracteres
	 */
	public static void main(String[] args) {
		char p[];
		int i;
		Scanner input = new Scanner(System.in);
		String A1 = "BFPV";
		String A2 = "CGJKQSXZ";
		String A3 = "DT";
		String A4 = "L";
		String A5 = "MN";
		String A6 = "R";
		StringBuffer buffer = new StringBuffer();
		while (input.hasNext()) {
			p = input.next().toCharArray();
			for (i = 0; i < p.length; i++) {
				if (A1.indexOf(p[i]) > -1)
					buffer.append("1");
				else if (A2.indexOf(p[i]) > -1)
					buffer.append("2");
				else if (A3.indexOf(p[i]) > -1)
					buffer.append("3");
				else if (A4.indexOf(p[i]) > -1)
					buffer.append("4");
				else if (A5.indexOf(p[i]) > -1)
					buffer.append("5");
				else if (A6.indexOf(p[i]) > -1)
					buffer.append("6");
				else
					buffer.append(" ");
			}
			p = buffer.toString().toCharArray();
			buffer = new StringBuffer();
			// System.out.println(p);
			for (i = 0; i < p.length - 1; i++)
				if (p[i] == p[i + 1])
					p[i] = ' ';
			// System.out.println(p);
			System.out.println(new String(p).toString().replaceAll(" ", ""));
			// buffer=new StringBuffer();
		}
		input.close();
	}
}
