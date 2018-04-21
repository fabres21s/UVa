import java.util.Scanner;

/**
*	11616 - Roman Numerals
*
*
*	Submission:	9481793
*	Date:		2011-11-18 01:44:33
*	Runtime:	0.896
*	Ranking:	1141
*/
public class Main11616 {

	/**
	 * - N�meros Romanos
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String p;
		while (input.hasNext()) {
			p = input.next();
			if (Character.isLetter(p.charAt(0))) {
				ToDecimal(p.toUpperCase());
			} else {
				ToRoman(Integer.parseInt(p));
			}
		}
		input.close();

	}

	static void ToDecimal(String caracter) {

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
		System.out.println(resultado);
		/*
		 * palabra+="                   "; boolean found=false; char
		 * []p=palabra.toCharArray(); int i=0; while(p[i]=='M') { i++; } int
		 * num=1000*i; System.out.println(p[i]+"   "+p[i+1]); if(p[i]=='C' &&
		 * p[i+1]=='M') { num+=900; found=true; } else if(p[i]=='C' &&
		 * p[i+1]=='D') { num+=400; found =true; } else if(p[i]=='D') {
		 * num+=500; } //i=i+1; int aux=i; while(p[i]=='C' && !found) { i++; }
		 * num+=(i-aux)*100; found=false; if(p[i]=='X' && p[i+1]=='C') {
		 * num+=90; found=true; } else if(p[i]=='X' && p[i+1]=='L') { num+=40;
		 * found=true; } else if(p[i]=='L') { num+=50; } //i=i+1; aux=i;
		 * while(p[i]=='X' && !found) { i++; } num+=(i-aux)*10; found=false;
		 * if(p[i]=='I' && p[i+1]=='X') { num+=9; found=true; } else
		 * if(p[i]=='I' && p[i+1]=='V') { num+=4; found=true; } else
		 * if(p[i]=='V') { num+=5; } //i=i+1; aux=i; while(p[i]=='I' && !found)
		 * { i++; } num+=i-aux; System.out.println(num);
		 */

	}

	static void ToRoman(int valor) {
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
		System.out.println(buf);
	}

}
