import java.util.Arrays;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int sum;
		Scanner input=new Scanner(System.in);
		int k=input.nextInt();
		
		for(int i=1;i<=k;i++){
			sum=input.nextInt();
			sum+=input.nextInt();
			sum+=input.nextInt();
			sum+=input.nextInt();
			sum+=promedio2mayores(input.nextInt(),input.nextInt(), input.nextInt());
			System.out.printf("Case %d: %s\n",i,calificacion(sum));
		}
		input.close();
		// TODO Auto-generated method stub

	}

	private static String calificacion(int sum) {
		if(sum<60){
			return "F";
		}else if(sum<70){
			return "D";
		}else if(sum<80){
			return "C";
		}else if(sum<90){
			return "B";
		}else{
			return "A";
		}
	}

	private static int promedio2mayores(int a, int b, int c) {
		int arreglo[]=new int[3];
		arreglo[0]=a;
		arreglo[1]=b;
		arreglo[2]=c;
		Arrays.sort(arreglo);
		return (arreglo[1]+arreglo[2])/2;
	}

}
