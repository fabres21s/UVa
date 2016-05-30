import java.util.Scanner;

/*
 * Fabio Andrés Sierra
 * Beat the Spread!
 * UVa: 10812
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int x,y,k,z;
		Scanner input=new Scanner(System.in);
		k=input.nextInt();
		while(k>0)
		{
			k--;
			x=input.nextInt();
			y=input.nextInt();
			z=x+y;
			if(x<y || z%2==1)
				System.out.print("impossible\n");
			else
				System.out.printf("%d %d\n",z/2,(x-z/2));
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
