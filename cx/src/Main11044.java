import java.util.Scanner;


public class Main {

	/**
	 * @param args
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
		// TODO Auto-generated method stub
	}
}
