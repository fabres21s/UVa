import java.util.Scanner;

/*
 *   Fabio Andrés Sierra Jaraba
 *   Doom's Day Algorithm
 *   UVa:  12019
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String days[]={"Sunday", "Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int nums[]={0,5,1,1,4,6,2,4,0,3,5,1,3};
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt(), dia, mes;
		while(casos>0)
		{
			casos--;
			mes=input.nextInt();
			dia=input.nextInt();
			System.out.println(days[(dia+nums[mes])%7]);
		}
		// TODO Auto-generated method stub

	}

}
