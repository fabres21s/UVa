import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TODO WA - Da Vinci Code
public class Main11385 {

	/**
	 * Wrong Answer - No tengo idea acerca de qué está mal
	 * pruebo los ejercicios propuestos y están todos bien
	 */
	public static void main(String[] args) {
		long fibos[]=new long [50];
		fibos[0]=1;
		fibos[1]=2;
		String r = "     A";
		for(int i=2;i<50;i++){
			fibos[i]=fibos[i-1]+fibos[i-2];
			//System.out.println(fibos[i]);
		}
		//System.out.println(r.replaceAll(" ", "x"));


		//System.out.println(fibos[45]);
		Scanner input=new Scanner(System.in);
		int k=Integer.valueOf(input.nextLine()),n,i,x,y;
		Map <Long,Character> map;
		StringBuffer buffer;
		while(k-->0){
			map=new HashMap<Long, Character>();
			n=Integer.valueOf(input.nextLine());
			long arreglo[]=new long[n];
			args=input.nextLine().split(" ");
			long max=0;
			for(i=0;i<n;i++){
				arreglo[i]=Integer.valueOf(args[i]);
				if (arreglo[i] > max){
					max = arreglo[i];
				}
			}
		//	Scanner texto=new Scanner(System.in);
			char c[]=input.nextLine().toCharArray();
			x=0;
			for(i=0;i<c.length;i++){
				if(c[i]>64 && c[i]<90){
				
					map.put(arreglo[x], c[i]);
					x++;
					
				}
				if (x == arreglo.length){
					break;
				}

			}
			x =0;
			Character s;
			 buffer = new StringBuffer();
			 while ( fibos[x] <=max){
				 s = map.get(fibos[x]);
				 if (s == null)
					buffer.append("*");
				 else {
					 buffer.append(s);
				 }
				 x++;
			 }
			 System.out.println(buffer.toString().trim());
			

		}

	}

}