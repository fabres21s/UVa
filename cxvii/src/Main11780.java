import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int n;
		while((n=input.nextInt())!=0)
		{
			double a=(int)(1.6*n);
			double b=a+1;
			System.out.printf("%.2f\n",Math.min(1.6*n-a, b-1.6*n));
		}
		input.close();
		// TODO Auto-generated method stub
	}
}