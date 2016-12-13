import java.util.Scanner;


/**
*	484 - The Department of Redundancy Department
*
*
*	Submision:	9392904
*	Date:		2011-10-21 01:02:47
*	Runtime:	2.784
*	Ranking:	6805
*/
public class Main484 {

	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args)
	{
		int MAX=1000002;
		int c[]=new int[2*MAX];
		int Ns[]=new int[2*MAX];
		int N, S = -1, i;
		Scanner input=new Scanner(System.in);
		while(true)
		{
			try
			{
				N=input.nextInt();
				Ns[++S] = N + MAX;
				++c[N + MAX];
			}
			catch(Exception e)
			{
				break;
			}
		}
		for (i = 0; i <= S; ++i) {
			if (c[Ns[i]]==0) continue;
			System.out.printf("%d %d\n", Ns[i] - MAX, c[Ns[i]]);
			c[Ns[i]] = 0;
		}
		input.close();
	}

}
