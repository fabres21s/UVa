import java.util.Scanner;

/**
*	12522 - The Imperial Problem
*
*
*	Submission:	12331176
*	Date:		2013-09-11 18:20:24
*	Runtime:	0.998
*	Ranking:	79
*/
public class Main12522 {

	/**
	 * - N�meros Romanos
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s;
		int pos, aux, i, coincidencia, x, j, e, c;
		while (!(s = input.next()).equals("*")) {

			char[] w = s.toCharArray();
			char[] real = toRoman(toDecimal(s)).toCharArray();

			aux = 0;
			pos = 0;
			coincidencia = 0;
			for (i = 0; i < w.length; i++) {
				coincidencia = 0;
				x = i;
				for (j = 0; j < real.length; j++) {
					// System.out.println("w["+x+"]="+w[x]);
					// System.err.println("real["+j+"]="+real[j]);
					if (x < w.length) {
						if (w[x] == real[j]) {
							coincidencia++;
						}
					}
					x++;
				}
				// System.out.println();
				if (coincidencia > pos) {
					pos = coincidencia;
					aux = i;
				}
			}
			e = w.length - pos;
			// System.out.println("COINCIDEN "+pos);
			c = 0;
			for (i = 0; i < real.length; i++) {
				if (real[i] != w[aux]) {
					c++;
				}
				aux++;
			}
			System.out.println(e + " " + c);
		}
		input.close();

	}

	static String toRoman(int valor) {
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

	static int toDecimal(String caracter) {

		int resultado = 0;
		int longitud = caracter.length();
		char p[] = caracter.toCharArray();
		for (int carac = 0; carac < longitud; carac++) {
			// System.out.println(caracter.charAt(carac));
			switch (p[carac]) {
			case 'M':
				resultado += 1000;
				break;

			case 'D':

				resultado += 500;

				break;

			case 'C':
				if ((carac < longitud - 1)
						&& (caracter.charAt(carac + 1) == 'M'))
					resultado -= 100;
				else if ((carac < longitud - 1)
						&& (caracter.charAt(carac + 1) == 'D'))
					resultado -= 100;
				else
					resultado += 100;

				break;

			case 'L':

				resultado += 50;

				break;
			case 'X':

				if ((carac < longitud - 1)
						&& (caracter.charAt(carac + 1) == 'C'))
					resultado -= 10;
				else if ((carac < longitud - 1)
						&& (caracter.charAt(carac + 1) == 'L'))
					resultado -= 10;
				else
					resultado += 10;

				break;
			case 'V':

				resultado += 5;

				break;
			case 'I':
				if ((carac < longitud - 1)
						&& (caracter.charAt(carac + 1) == 'X'))
					resultado -= 1;
				else if ((carac < longitud - 1)
						&& (caracter.charAt(carac + 1) == 'V'))
					resultado -= 1;
				else
					resultado += 1;

				break;

			}
		}
		return resultado;

	}
}
