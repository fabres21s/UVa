import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a,b,i,r,d, max, min;
        Scanner input=new Scanner(System.in);
        while(true)
        {
            a=input.nextInt();
            b=input.nextInt();
            max=Math.max(a, b);
            min=Math.min(a, b);
            if(a==0 && b==0)
                break;            
            r=(int)Math.sqrt(max);
            d=max-min;
            ArrayList <Integer>valores=new ArrayList<Integer>();
            for(i=1;i<=r;i++)
                if(a%i== b%i){
                    if(!valores.contains(i))
                    {
                        valores.add(i);

                    }
                    if(!valores.contains((d/i)))
                        valores.add(d/i);
                }
           // /System.out.println(valores.toString());
            System.out.println(valores.size());
        }

		// TODO Auto-generated method stub

	}

}
