import java.util.Scanner;

/**
*	10003 - Cutting Sticks
*
*	Submission:	19558533
*	Date:		2017-06-23 04:24:03
*	Runtime:	0.560
*	Ranking:	7548 / 11743
*/
class Main10003 {
	
	/**
	 * - Arreglos
	 * 
	 *  El corte de una vara es cobrado de acuerdo al tamaño,
	 *  hallar el mínimo coste a pagarss
	 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int stickSize = scan.nextInt();
            if (stickSize == 0)
                break;
            
            int n = scan.nextInt();
            int[] cuts = new int[n + 2];

            for (int k = 1; k <= n; k++)
                cuts[k] = scan.nextInt();
            cuts[n + 1] = stickSize;
            
            // m[i][j] = the cost of cutting the sub-stick from the ith cut in cuts to the jth cut
            // in cuts
            int m[][] = new int[n + 2][n + 2];
            
            for (int d = 2; d < cuts.length; d++) {
                for (int i = 0; i < cuts.length - d; i++) {
                    int j = d + i;
                    
                    int cutMin = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++)
                        cutMin = Math.min(cutMin, m[i][k] + m[k][j]);
                    
                    m[i][j] = cutMin + cuts[j] - cuts[i];
                }
            }

            System.out.println("The minimum cutting is " + m[0][n + 1] + ".");            
        }
    }
}