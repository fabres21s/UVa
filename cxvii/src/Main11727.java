import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt();		
		int []arreglo=new int[3];
		for(int i=1;i<=casos;i++)
		{
			arreglo[0]=input.nextInt();
			arreglo[1]=input.nextInt();
			arreglo[2]=input.nextInt();
			Arrays.sort(arreglo);
			System.out.printf("Case %d: %d\n",i,arreglo[1]);
		}
		input.close();
		// TODO Auto-generated method stub
	}

}
