import java.util.ArrayList;
import java.util.Scanner;


//TODO TLE - Cinema-Cola
public class Main12516 {

	/**
	 * time limit - replantear  o pasar a C++
	 */
	public static void main(String[] args) {
		String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ", dir,pos;
		ArrayList <String> sinasignar;
		Scanner input=new Scanner(System.in);
		int row,column,persons,friends,r,c,i;
		StringBuffer output=new StringBuffer();
		int [][] cinema;
		boolean correcto;
		while(input.hasNext()){
			row=input.nextInt();
			column=input.nextInt();
			if(row==column && row==0)
				break;
			cinema=new int[row][2*column+1];
			persons=input.nextInt();
			while(persons-->0){
				dir=input.next();
				pos=input.next();
				r=abc.indexOf(dir.charAt(0));
				c=Integer.valueOf(dir.substring(1));
				c=2*c-1;
				if(pos.equals("-"))
					c--;
				else
					c++;
				cinema[r][c]=1;
			}
			friends=input.nextInt();
			correcto=true;
			sinasignar=new ArrayList<String>();
			while(friends-->0){
				dir=input.next();
				r=abc.indexOf(dir.charAt(0));
				c=Integer.valueOf(dir.substring(1));
				c=2*c-1;
				if(cinema[r][c+1]==0 && cinema[r][c-1]==1)
					cinema[r][c+1]=1;
				else if(cinema[r][c+1]==1 && cinema[r][c-1]==0)
					cinema[r][c-1]=1;
				else if(cinema[r][c+1]==1 && cinema[r][c-1]==1)
					correcto=false;
				else
					sinasignar.add(dir);
			}
			for(i=sinasignar.size()-1;i>-1;i--){
				dir=sinasignar.get(i);
				r=abc.indexOf(dir.charAt(0));
				c=Integer.valueOf(dir.substring(1));
				c=2*c-1;
				if(cinema[r][c+1]==0 && cinema[r][c-1]==1)
					cinema[r][c+1]=1;
				else if(cinema[r][c+1]==1 && cinema[r][c-1]==0)
					cinema[r][c-1]=1;
				else if(cinema[r][c+1]==1 && cinema[r][c-1]==1)
					correcto=false;
			}
			if(correcto)
				output.append("YES\n");
			else
				output.append("NO\n");

		}
		System.out.print(output);
	}

}
