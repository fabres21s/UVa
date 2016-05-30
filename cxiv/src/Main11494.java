import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x1,y1,x2,y2, moves;
		Scanner input=new Scanner(System.in);
		while(true){
			x1=input.nextInt();
			y1=input.nextInt();
			x2=input.nextInt();
			y2=input.nextInt();
			if(x1==0)
				break;
			if(x1==x2 && y1==y2)
				moves=0;
			else if(x1==x2 || y1==y2)
				moves=1;
			else if(Math.abs(x1-x2)==Math.abs(y1-y2))
				moves=1;
			else
				moves=2;
			System.out.println(moves);
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
