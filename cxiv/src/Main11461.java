import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int []cuadrados=new int [1000001];
		for(int i=1;i<=1000;i++)		
			cuadrados[i*i]=i*i;
		int a,b,i,cont;
		while(input.hasNext())
		{
			a=input.nextInt();
			b=input.nextInt();
			if(a==0 && b==0)
			{
				break;
			}
			cont=0;
			for(i=a;i<=b;i++)
			{
				if(cuadrados[i]!=0)
				{
					cont++;
				}
			}
			System.out.println(cont);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
