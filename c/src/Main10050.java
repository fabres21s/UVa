import java.util.Scanner;

/**
*	10050 - Hartals
*
*
*	Submission:	9281650
*	Date:		2011-09-20 16:32:24
*	Runtime:	0.404
*	Ranking:	10522
*/
public class Main10050 {

	/**
	 * - Arreglos
	 * 
	 * Dados unos días de huelga en el mes, determinar cuántos días se trabaja
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- != 0) {
			int D = in.nextInt(), P = in.nextInt(), h, d = -1;
			boolean strikes[] = new boolean[D];
			for (int i = 0; i < P; d = -1, i++) {
				h = in.nextInt();
				for (int j = 0; j < D; j++) {
					d = (d + 1) % (h);
					strikes[j] |= (d == (h - 1));
				}
			}
			int count = 0;
			for (int i = 0; i < D; i++)
				if (strikes[i] && (i % 7 < 5))
					count++;
			System.out.println(count);
		}
		in.close();
		/*
		 * Scanner input=new Scanner(System.in); int t=input.nextInt(); for(int
		 * i=0; i<t;i++) { int dias=input.nextInt(); int pp=input.nextInt();
		 * Vector <Integer> solucion=new Vector<Integer>(); for(int
		 * j=0;j<pp;j++) { int ph=input.nextInt(); int mul=1;
		 * while(dias/mul>=ph) { if(!solucion.contains(ph*mul)) {
		 * solucion.add(ph*mul); } mul++; } } int sabado=7; while(sabado<=dias)
		 * { if(solucion.contains(sabado)) { solucion.remove(0); }
		 * if(solucion.contains(sabado-1)) { solucion.remove(0); } sabado+=7; }
		 * System.out.println(solucion.size()); }
		 */
	}
}
