import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TODO TLE - Reodrnreig Lteetrs in Wrods
public class Main12641 {

	/**
	 * time limit - replantear
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int k=Integer.valueOf(input.nextLine());
		//input.close();
		//input=new Scanner(System.in);
		ArrayList< String> diccionario;
		StringBuffer buffer;
		char first, last,px,py;
		//Scanner texto=new Scanner(System.in);
		while(k-->0){
			diccionario=new ArrayList<String>();
			args=input.nextLine().split(" ");
			for(String string:args){
				diccionario.add(string);
			}
			args=input.nextLine().split(" ");
			buffer=new StringBuffer();
			for(String string:args){
				first=string.charAt(0);
				last=string.charAt(string.length()-1);
				boolean found=false;
				for(int i=0;i<diccionario.size();i++){
					String palabra=diccionario.get(i);
					px=palabra.charAt(0);
					py=palabra.charAt(palabra.length()-1);
					if(px==first && py==last){
						if(comparar(palabra,string)){
							found=true;
							//diccionario.remove(i);
							buffer.append(palabra+" ");
							break;
						}
					}
				}
				if(!found){
					buffer.append(string+" ");
				}
			}
			System.out.println(buffer.toString().trim());
		}
		input.close();
		//texto.close();
	}

	private static boolean comparar(String palabra, String string) {
		if(palabra.length()==string.length()){
			char c1[]=palabra.toCharArray();
			char c2[]=string.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			return Arrays.equals(c1, c2);
		}
		return false;
	}

}
/*
 2
make me programming rich will
pagmrnmorig will mkae me rcih

dreaming drinaemg yeah
yaeh right keep drinaemg
*/
