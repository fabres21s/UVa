import java.util.Scanner;


/**
*	11044 - Searching for Nessy
*
*
*	Submision:	9560240
*	Date:		2011-12-14 13:27:37
*	Runtime:	0.176
*	Ranking:	8570
*/
public class Main11044 {

	/**
	 * - Simulación
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int n,m,casos;
		casos=input.nextInt();
		while(casos>0)
		{
			casos--;
			n=input.nextInt()/3;
			m=input.nextInt()/3;
			System.out.println(n*m);
		}
		input.close();
	}
}
