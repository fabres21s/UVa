import java.util.Arrays;
import java.util.Scanner;

/*
 * Fabio Andrés Sierra
 * Brick Game
 * UVa: 11875
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt(), tam,j;		
		for(int i=1;i<=casos;i++)
		{
			tam=input.nextInt();
			int arreglo []=new int[tam];
			for(j=0;j<tam;j++)
			{
				arreglo[j]=input.nextInt();
			}
			Arrays.sort(arreglo);
			System.out.printf("Case %d: %d\n",i,arreglo[tam/2]);
		}
		// TODO Auto-generated method stub

	}

}
