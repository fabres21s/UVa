import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt()+1,i;
		int a,b,c;
		for(i=1;i<casos;i++)
		{
			a=input.nextInt();
			b=input.nextInt();
			c=input.nextInt();
			if(a>20 || b>20 || c>20)
				System.out.printf("Case %d: bad\n",i);
			else
				System.out.printf("Case %d: good\n",i);
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
