import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int y,i;
		double w,f;
		Scanner input=new Scanner(System.in);
		while((y=input.nextInt())!=0)
		{
			w=Math.log(4);
			for(i=1960;i<=y;i+=10)
			{
				w*=2;
			}
			f=0;
			i=1;
			while(f<w)
			{
				f+=Math.log((double)++i);
			}
			System.out.println((i-1));
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
