import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String abc="`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
		abc=abc.toLowerCase();
		Scanner input=new Scanner(System.in);
		String  frase="";
		String [] tokens;
		while(input.hasNext())
		{
			frase="";
			tokens=input.nextLine().toLowerCase().split("");
			for(int i=1; i<tokens.length; i++)
			{
				if(tokens[i].equals(" "))
				{
					frase+=" ";
				}
				else
				{
					frase+=abc.charAt(abc.indexOf(tokens[i])-2);
				}
			}
			System.out.println(frase);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
