import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int i,n,diff,N,max,T=input.nextInt();
		while(T>0)
		{
			T--;
			N=input.nextInt();
			diff=-1600;
			max=input.nextInt();
			for(i=1;i<N;i++)
			{
				n=input.nextInt();
				diff=Math.max(diff, (max-n));
				max=Math.max(max, n);
			}
			System.out.println(diff);
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
