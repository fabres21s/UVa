import java.util.Scanner;

/**
*	11192 - Group Reverse
*
*
*	Submission:	16284853
*	Date:		2015-10-17 20:40:06
*	Runtime:	0.085
*	Ranking:	4958
*/
public class Main11192 {

	/**
	 * - Cadena de caracteres
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int group, size, length;
		String cadena;
		StringBuffer output = new StringBuffer();
		while (input.hasNext()) {

			StringBuffer aux = new StringBuffer("qqq");
			group = input.nextInt();
			size = 0;
			if (group > 0) {
				cadena = input.next();
				length = cadena.length();
				group = length / group;
				while (size < length) {
					aux = new StringBuffer(cadena.subSequence(size, size
							+ group));
					output.append(aux.reverse().toString());
					size = size + group;
				}
				output.append("\n");
			} else {
				break;
			}
		}
		// ATE0AFGHANISTAN0IRAQ0NOW0IRAN0
		// 5 FA0ETASINAHGRI0NATWON0QA0NARI0
		System.out.print(output);
		input.close();
	}

}

/*
 * ABC ABC XWVUTSRQPONMLKJIHGFEDCBA LKJIHGFEDCBAXWVUTSRQPONM
 * HGFEDCBAPONMLKJIXWVUTSRQ FEDCBALKJIHGRQPONMXWVUTS DCBAHGFELKJIPONMTSRQXWVU
 * CBAFEDIHGLKJONMRQPUTSXWV
 * pstupnilacitircemosemeviguoynacriSyhWAWtuBenifskroWedocymsiereHesael
 * iScrnaoyguvimesemoceiritacilpntupselsaHereiemscydoWeroskifenuBWtWAyh
 * iScrnaoyguvimesemoceiritacilpntupselsaHereiemscydoWeroskifenuBWtWAyh
 * hesreveRpuorG29111SBaaBnmocenoediptt eRpuorG29111ediptthesrevSBaaBnmoceno
 * eRpuorG29111ediptthesrevSBaaBnmoceno uorG29111hesreveRpenoedipttSBaaBnmoc
 * G29111eRpuorhesrevedipttmocenoSBaaBn 9111orG2eRpusrevttheedipcenoBnmoSBaa
 * 9111orG2eRpusrevttheedipcenoBnmoSBaa 111G29uoreRprevhespttedienomocaBnSBa
 * 1191G2orpueRevsrhettipednocemoBnaaSB
 */
/*
 * ABC ABC XWVUTSRQPONMLKJIHGFEDCBA LKJIHGFEDCBAXWVUTSRQPONM
 * HGFEDCBAPONMLKJIXWVUTSRQ FEDCBALKJIHGRQPONMXWVUTS DCBAHGFELKJIPONMTSRQXWVU
 * CBAFEDIHGLKJONMRQPUTSXWV
 * pstupnilacitircemosemeviguoynacriSyhWAWtuBenifskroWedocymsiereHesael
 * hesreveRpuorG29111SBaaBnmocenoediptt uorG29111hesreveRpenoedipttSBaaBnmoc
 * G29111eRpuorhesrevedipttmocenoSBaaBn 111G29uoreRprevhespttedienomocaBnSBa
 * 1191G2orpueRevsrhettipednocemoBnaaSB
 */
