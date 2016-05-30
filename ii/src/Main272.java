import java.util.Scanner;

/*
 272 - Tex Quotes
 - Cadena de caracteres, reemplazar
 Reemplazar la primer comilla por `` y la segunda por ''

 */

/**
*	272 - TEX Quotes
*
*
*	Submision:	9318633
*	Date:		2011-09-30 20:54:25
*	Runtime:	0.520
*	Ranking:	26474
*/
public class Main272 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			String cadena = "";

			// String cadena="";
			while (input.hasNext()) {
				cadena += input.nextLine() + "\n";
				char cadenachar[] = cadena.toCharArray();
				// System.out.println(cadena);
				int comillas = 0;
				String b = "";
				for (int i = 0; i < cadenachar.length; i++) {
					if (cadenachar[i] == '"') {

						comillas++;
						if (comillas % 2 == 1) {
							b += "``";
							// a.replace( "``","\"");
						} else {
							b += "''";
							// a.replace( "''","\"");
						}
					} else {
						b += cadenachar[i];
					}
				}
				// System.out.println("comillas "+comillas);
				if (comillas % 2 == 0) {
					System.out.print(b);
					break;
				}
			}

		}
		// TODO Auto-generated method stub

	}

}
