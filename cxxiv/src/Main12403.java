import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt(),total=0;		
		while(n>0)
		{
			n--;
			if(input.next().equals("donate"))
				total+=input.nextInt();
			else
				System.out.println(total);
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
