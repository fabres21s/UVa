import java.util.Scanner;

/*
 *   Fabio Andrés Sierra Jaraba
 *   In Braille
 *   UVa:  12364
 */

public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String nums[]={".*\n**\n..\n","*.\n..\n..\n","*.\n*.\n..\n","**\n..\n..\n","**\n.*\n..\n","*.\n.*\n..\n","**\n*.\n..\n","**\n**\n..\n","*.\n**\n..\n",".*\n*.\n..\n"};

		int digits=0,i,j;
		Scanner input=new Scanner (System.in);
		while((digits=input.nextInt())!=0)
		{
			String letra=input.next();
	        StringBuffer buf=new StringBuffer();
	       
	        if(letra.equals("S"))
	        {
	        	String tokens[]=input.next().split("");
	        	for( i=1;i<4;i++)
	        	{
	        		for( j=1;j<tokens.length;j++ )
	        		{
	        			//System.out.println(tokens[j]);
	        			if(i==1)
	        			{
	        				if(tokens[j].equals("1") || tokens[j].equals("2") || tokens[j].equals("5") || tokens[j].equals("8"))
	        				{
	        					buf.append("*. ");
	        				}
	        				else if(tokens[j].equals("3") || tokens[j].equals("4") || tokens[j].equals("6") || tokens[j].equals("7"))
	        				{
	        					buf.append("** ");
	        				}
	        				else
	        				{
	        					buf.append(".* ");
	        				}
	        			}
	        			else if(i==2)
	        			{
	        				if(tokens[j].equals("1") || tokens[j].equals("3"))
	        				{
	        					buf.append(".. ");
	        				}
	        				if(tokens[j].equals("4") || tokens[j].equals("5"))
	        				{
	        					buf.append(".* ");
	        				}
	        				if(tokens[j].equals("2") || tokens[j].equals("6") || tokens[j].equals("9"))
	        				{
	        					buf.append("*. ");
	        				}
	        				if(tokens[j].equals("7") || tokens[j].equals("8") || tokens[j].equals("0"))
	        				{
	        					buf.append("** ");
	        				}
	        			}
	        			else
	        			{
	        				buf.append(".. ");
	        			}
	        			
	        			//buf.trimToSize();
	        		}
	        		letra=buf.toString().trim()+"\n";
	        		buf=new StringBuffer();
	        		buf.append(letra);
	        	}
	        	
	        }
	        else
	        {
	        	String arreglo[]=new String[digits];
	        	for( j=0;j<digits;j++)
	        	{
	        		arreglo[j]="";
	        	}
	        	for( i=0;i<3;i++)
	        	{
	        	   	for( j=0;j<digits;j++)
	        	   	{
	        	   		arreglo[j]+=input.next()+"\n";
	        	   	}
	        	}

	        	//comparar
	        	for( i=0;i<digits;i++)
	        	{
	        		//System.out.println("arreglo "+arreglo[i]);
	        		for( j=0;j<=9;j++)
	        		{
	        			//System.out.println("nums "+nums[j]);
	        			if(arreglo[i].equals(nums[j]))
	        			{
	        				buf.append(j);
	        			}
	        		}
	        	}
	        	buf.append("\n");
	        }
	        System.out.print(buf);
		}
		// TODO Auto-generated method stub

	}

}

