import java.util.ArrayList;
import java.util.Scanner;

//TODO TLE - Secret Word
public class Main12467 {

	/**
	 * time limit - replantear o pasar a C
	 */
	public static void main(String[] args) {
		Scanner dato = new Scanner(System.in);
		int casos,pos,  aux,z=1,x,j,k;
		String c,words;
		casos = dato.nextInt();
		String solucion="";
		//int aux;
		for(int i=0; i<casos; i++){
			solucion="";
			ArrayList <Integer>valores=new ArrayList<Integer>();
			z=1;
			words=dato.next();
			if(palindromo(words))
				System.out.println(words);
			else
			{		
				
				for( x=1;x<words.length();x++){
					if(words.charAt(0)==words.charAt(x))
						valores.add(x);
				}		
				if(valores.size()==0){
					System.out.println(words.charAt(0));					
				}
				else{
				for( x=0;x<valores.size();x++){		
					c="";
					pos=valores.get(x);
					for ( j = 0; j <= valores.get(x)/2; j++) 
					{
						for ( k = pos; k >=pos/2 ; k--) 
						{
							aux=0;	
							if(words.charAt(j)==words.charAt(k) )
							{
								pos=k-1;
								c+=words.charAt(j);
								aux=1;
								break;
							}
							if(c.length()>0 && aux==0)
							{
								z=-1;
								break;
							}	
						}
						if(z==-1)
							break;
						if(c.length()==0)
						{
							c=String.valueOf(words.charAt(0));
							break;						
						}
		
					}
					StringBuffer buffer=new StringBuffer(c);	
					buffer.reverse();
					if(solucion.length()<buffer.length())
						solucion=buffer.toString();
				}
				System.out.println(solucion);
			}
			}
			
		}
		dato.close();
	}
	
	static boolean palindromo(String palabra)
	{
		for(int i=0;i<=palabra.length()/2;i++)
			if(palabra.charAt(i)!=palabra.charAt(palabra.length()-i-1))
				return false;
		return true;
	}
}
