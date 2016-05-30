import java.util.Scanner;

/**
*	444 - Encoder and Decoder
*
*
*	Submision:	10714903
*	Date:		2012-10-11 02:11:10
*	Runtime:	0.136
*	Ranking:	4663
*/
public class Main444 {

	public static void main(String[] args) {
		StringBuffer buffer;
		char[] p;
		int i, x;
		String linea;
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			linea = input.nextLine();
			if (linea.length() == 1 || linea.equals("")) {
				System.out.println("");
				continue;
			}
			p = linea.toCharArray();
			buffer = new StringBuffer();
			if (p[0] < 48 || p[0] > 57) {// letras
				for (i = 0; i < p.length; i++)
					buffer.append((int) p[i]);
			} else {// numeros
				buffer.append(new String(p));
				buffer.reverse();
				p = buffer.toString().toCharArray();
				// System.out.println(Arrays.toString(p));
				buffer = new StringBuffer();
				for (i = 0; i < p.length; i += 2) {

					x = p[i] - 48;
					if (x > 1) {
						buffer.append(letra(x * 10 + p[i + 1] - 48));
					} else {
						// System.out.println("else "+(x*100+(p[i+1]-48)*10+p[i+2]-48));
						buffer.append(letra(x * 100 + (p[i + 1] - 48) * 10
								+ p[i + 2] - 48));
						i++;
					}

				}
				buffer.reverse();
			}
			System.out.println(buffer.reverse());
		}
		input.close();

	}

	static String letra(int x) {
		// System.out.println(x);
		switch (x) {
		case 32:
			return " ";
		case 33:
			return "!";
		case 44:
			return ",";
		case 46:
			return ".";
		case 58:
			return ":";
		case 59:
			return ";";
		case 63:
			return "?";
		case 65:
			return "A";
		case 66:
			return "B";
		case 67:
			return "C";
		case 68:
			return "D";
		case 69:
			return "E";
		case 70:
			return "F";
		case 71:
			return "G";
		case 72:
			return "H";
		case 73:
			return "I";
		case 74:
			return "J";
		case 75:
			return "K";
		case 76:
			return "L";
		case 77:
			return "M";
		case 78:
			return "N";
		case 79:
			return "O";
		case 80:
			return "P";
		case 81:
			return "Q";
		case 82:
			return "R";
		case 83:
			return "S";
		case 84:
			return "T";
		case 85:
			return "U";
		case 86:
			return "V";
		case 87:
			return "W";
		case 88:
			return "X";
		case 89:
			return "Y";
		case 90:
			return "Z";
		case 97:
			return "a";
		case 98:
			return "b";
		case 99:
			return "c";
		case 100:
			return "d";
		case 101:
			return "e";
		case 102:
			return "f";
		case 103:
			return "g";
		case 104:
			return "h";
		case 105:
			return "i";
		case 106:
			return "j";
		case 107:
			return "k";
		case 108:
			return "l";
		case 109:
			return "m";
		case 110:
			return "n";
		case 111:
			return "o";
		case 112:
			return "p";
		case 113:
			return "q";
		case 114:
			return "r";
		case 115:
			return "s";
		case 116:
			return "t";
		case 117:
			return "u";
		case 118:
			return "v";
		case 119:
			return "w";
		case 120:
			return "x";
		case 121:
			return "y";
		case 122:
			return "z";

		}
		return "";
	}

}
