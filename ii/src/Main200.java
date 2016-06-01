import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TODO No enviado - Rare Order
//Aparentemente topological sort
public class Main200 {
	
	/*
	 * NO ENVIADO
	 */

	public static void main(String[] args) {
		ArrayList<char []> list=new ArrayList<char[]>();
		Scanner input=new Scanner(System.in);
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		Map<Integer, Character> answer=new HashMap<Integer, Character>();
		String w;
		int max=0;
		while(!(w=input.next()).equals("#")){
			list.add(w.toCharArray());
			if(w.length()>max){
				max=w.length();
			}
		}
		
		int c=0;
		//char arreglo[];
		for(int i=0;i<max;i++){
			for(char [] p:list){
				if(p.length>i){
					if(map.get(p[i])==null){
						map.put(p[i], c);
						answer.put(c, p[i]);
						c++;
					}
				}
			}
		}
		for(int i=0;i<c;i++){
			System.out.print(answer.get(i));
		}
		System.out.println();
		
	}

}
