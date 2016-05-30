import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean arreglo[]=new boolean[5005];
		for(int i=0;i<5002;i++){
			arreglo[i]=diferente(i);
		}
		int x,y,c,i;
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			x=input.nextInt();
			y=input.nextInt();
			c=0;
			for(i=x;i<=y;i++){
				if(arreglo[i])
					c++;
			}
			System.out.println(c);
		}
		input.close();
	}

	private static boolean diferente(int i) {
		int arreglo[]=new int[10];
		while(i>0){
			arreglo[i%10]++;
			i=i/10;
		}
		for(i=0;i<10;i++)
			if(arreglo[i]>1)
				return false;
		return true;
	}

}
