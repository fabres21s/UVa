import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
*	10194 - Football (aka Soccer)
*
*	Submission:	21161139
*	Date:		2018-04-18 15:03:04
*	Runtime:	0.160
*	Ranking:	3572 / 3788
*/
public class Main10194 {

	/**
	 * - Sort
	 * 
	 * Mostrar la tabla de posiciones en un torneo con sus respectivos partidos, 
	 * teniendo en cuenta los ítems de desempate establecidos
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in, "ISO-8859-1");
		PrintWriter cout = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 0; t < T; t++) {
			String tName = sc.nextLine();
			int n = Integer.parseInt(sc.nextLine());
			Contestant[] con = new Contestant[n];
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				String temp = sc.nextLine();
				con[i] = new Contestant(temp);
				map.put(temp, i);
			}
			n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; i++) {
				String[] temp = sc.nextLine().split("@");
				String[] a = temp[0].split("#");
				String[] b = temp[1].split("#");
				int indA = map.get(a[0]);
				int A = Integer.parseInt(a[1]);
				int indB = map.get(b[1]);
				int B = Integer.parseInt(b[0]);
				if (A > B) {
					con[indA].win++;
					con[indA].point += 3;
					con[indA].play++;
					con[indA].gs += A;
					con[indA].ga += B;
					con[indA].gd = con[indA].gs - con[indA].ga;

					con[indB].lose++;
					con[indB].play++;
					con[indB].gs += B;
					con[indB].ga += A;
					con[indB].gd = con[indB].gs - con[indB].ga;
				} else if (A == B) {
					con[indA].point++;
					con[indA].tie++;
					con[indA].play++;
					con[indA].gs += A;
					con[indA].ga += B;
					con[indA].gd = con[indA].gs - con[indA].ga;

					con[indB].point++;
					con[indB].tie++;
					con[indB].play++;
					con[indB].gs += B;
					con[indB].ga += A;
					con[indB].gd = con[indB].gs - con[indB].ga;
				} else {
					con[indB].win++;
					con[indB].point += 3;
					con[indB].play++;
					con[indB].gs += B;
					con[indB].ga += A;
					con[indB].gd = con[indB].gs - con[indB].ga;

					con[indA].lose++;
					con[indA].play++;
					con[indA].gs += A;
					con[indA].ga += B;
					con[indA].gd = con[indA].gs - con[indA].ga;
				}
			}
			Arrays.sort(con);
			cout.println(tName);
			for (int i = 0; i < con.length; i++) {
				cout.println((i + 1) + ") " + con[i].name + " " + con[i].point + "p, " + con[i].play + "g ("
						+ con[i].win + "-" + con[i].tie + "-" + con[i].lose + "), " + con[i].gd + "gd (" + con[i].gs
						+ "-" + con[i].ga + ")");
			}
			if (t < T - 1) {
				cout.println();
			}
		}
		cout.flush();
	}
}

class Contestant implements Comparable<Contestant> {

	public String name;
	public int play;
	public int win;
	public int tie;
	public int lose;
	public int point;
	public int gs;
	public int ga;
	public int gd;

	public Contestant(String name) {
		this.name = name;
		this.play = 0;
		this.win = 0;
		this.tie = 0;
		this.lose = 0;
		this.point = 0;
		this.gs = 0;
		this.ga = 0;
		this.gd = 0;
	}

	public int compareTo(Contestant o) {
		if (this.point > o.point) {
			return -1;
		} else if (this.point == o.point) {
			if (this.win > o.win) {
				return -1;
			} else if (this.win == o.win) {
				if (this.gd > o.gd) {
					return -1;
				} else if (this.gd == o.gd) {
					if (this.gs > o.gs) {
						return -1;
					} else if (this.gs == o.gs) {
						if (this.play < o.play) {
							return -1;
						} else if (this.play == o.play) {
							String a = this.name.toUpperCase();
							String b = o.name.toUpperCase();
							if (a.compareTo(b) < 0) {
								return -1;
							}
						}
					}
				}
			}
		}
		return 1;
	}
}
