import java.util.Arrays;
import java.util.Scanner;

/*
 *   Fabio Andrés Sierra Jaraba
 *   Egypt
 *   UVa:  11854
 *    
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		//double a,b,c;
		int [] valores=new int[3];
		while(input.hasNext())
		{
			valores[0]=input.nextInt();
			valores[1]=input.nextInt();
			valores[2]=input.nextInt();
			if(valores[0]==0 && valores[1]==0 && valores[2]==0)
			{
				break;
			}
			Arrays.sort(valores);
			if((valores[0]*valores[0]+valores[1]*valores[1])==(valores[2]*valores[2]))
			{
				System.out.println("right");
			}
			else
			{
				System.out.println("wrong");
			}
			
		}
		// TODO Auto-generated method stub

	}

}
