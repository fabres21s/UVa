import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		double div=Math.log10(2),v;
		int i=1;
		while((v=input.nextDouble())>-1)
		{
			v=Math.log10(v)/div;
			if(v%1!=0)
				v++;
			System.out.printf("Case %d: %d\n",i,(int)v);
			i++;
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
