import java.util.Scanner;


/**
*	489 - Hangman Judge
*
*
*	Submision:	9526905
*	Date:		2011-12-02 14:47:08
*	Runtime:	2.960
*	Ranking:	5954
*/
public class Main489 {

	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		
		char []puzzle;
		   char[] guess;
		   int round;
		   while((round=input.nextInt())!=-1)
		   {
		      puzzle=input.next().toCharArray();
		      guess=input.next().toCharArray();
		      System.out.println("Round "+round);
		      switch(game(puzzle,guess)){
		         case 0: System.out.println( "You win.");// << endl;
		            break;
		         case 1: System.out.println( "You chickened out.");// << endl;
		            break;
		         case 2: System.out.println("You lose.");// << endl;
		            break;

		      }
		   }

		
		
		
		/*int n,i,equivocados;
		boolean lose;
		Vector <String>ans ,prop;
		while((n=input.nextInt())!=-1)
		{
			ans=new Vector<String>();
			System.out.printf("Round %d \n",n);
			equivocados=0;
			prop=new Vector<String>();
			String []tokens=input.next().split("");
			for(i=1;i<tokens.length;i++)
			{
				if(!ans.contains(tokens[i]))
				{
					ans.add(tokens[i]);
				}
			}
			lose=false;
			tokens=input.next().split("");
			for(i=1;i<tokens.length;i++)
			{
				if(!prop.contains(tokens[i]))
				{
					prop.add(tokens[i]);
				}
			}
			for(i=0;i<prop.size();i++)
			{
				if(ans.contains(prop.get(i)))
				{
					ans.remove(prop.get(i));
					if(ans.size()==0)
					{
						break;
					}
				}
				else
				{
					equivocados++;
					if(equivocados==7)
					{
						lose=true;
						break;
					}
				}
			}
			if(lose)
			{
				System.out.println("You lose.");
			}
			else
			{
				if(ans.size()==0)
				{
					System.out.println("You win.");
				}
				else
				{
					System.out.println("You chickened out.");
				}
			}
		}*/
		/*int n,h1,h2,stroke,happy;		
		char p1[], p2[];
		while((n=input.nextInt())!=-1) 
		{			
			System.out.printf("Round %d\n",n);
			p1=input.next().toCharArray();
			p2=input.next().toCharArray();
			h1 = p1.length; h2 = p2.length; stroke = 0; happy = 0;
			for(int i = 0; i < h2; i++) {
				int v = 0;
				for(int j = 0; j < h1; j++) {
					if(p1[j] == p2[i]) {
						p1[j] = 0;
						v = 1;
						happy++;
					}
				}
				if(v==0) 
					stroke++;
				if(stroke == 7 || happy == h1) 
					break;
			}
			if(stroke == 7) 
				System.out.println("You lose.");
			else if(happy == h1) 
				System.out.println("You win.");
			else
				System.out.println("You chickened out.");
		}*/
		/*int n, x;
		String abc="abcdefghijklmnopqrstuvwxyz";
		String p1;
		String p2;
		String [] tokens;
		boolean lose;
		while((n=input.nextInt())!=-1)
		{
			int arreglo[]=new int[26];
			p1=input.next();
			p2=input.next();
			tokens=p2.split("");
			lose=false;
			System.out.println("Round "+n);
			n=0;//n pasa a contar los equivocados
			int i=1;
			while(p1.length()>0 && p2.length()>0)
			{
				x=abc.indexOf(tokens[i]);
				if(arreglo[x]==0)
				{
					if(p1.contains(tokens[i]))
					{						
						p1=p1.replaceAll(tokens[i], "");
						arreglo[x]=1;
					}
					else
					{
						n++;
						if(n==7)
						{
							lose=true;
							break;
						}				
					}
				}
				p2=p2.replaceAll(tokens[i], "");
				tokens=p2.split("");
			}
			if(lose)
			{
				System.out.println("You lose.");
				continue;
			}
			if(p1.length()==0)
			{
				System.out.println("You win.");
			}
			else
			{
				System.out.println("You chickened out.");
			}			
		}*/
		   input.close();

	}
	
	static int game(char[] s, char[] g)
	{
		int i;
		   int j;
		   int table[] =new int[256];
		   int hit = 0;
		   int hang = 0;
		   for(i=0;i<g.length;i++){
		      if(table[g[i]]==0){
		         int find = 0;
		         for(j=0;j<s.length;j++){
		            if(g[i]==s[j])find++;
		         }
		         if(find==0)hang++;
		         hit += find;
		      }
		      table[g[i]]=1;
		      if(hang>=7)return 2;
		      if(hit==s.length)return 0;
		   }
		   return 1;
	}

}
