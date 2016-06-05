import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	492 - Pig-Latin
*
*
*	Submision:	10732263
*	Date:		2012-10-14 00:16:58
*	Runtime:	0.428
*	Ranking:	4589
*/
public class Main492 {

	/**
	 * - Cadena de caracteres
	 */
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
       // String m="";
        StringBuilder temp=new StringBuilder("");
        while (true) {
            int car = br.read();
            if (car < 0) 
                 break;                    
            char c=(char) car;            
                if((c>='a' && c<='z')
                     ||(c>='A' &&c<='Z')){
                    temp.append(c);
                }
                else{
                    if(temp.length()>0)
                        sb.append(changeWord(temp.toString())); 
                    sb.append(c);
                    temp=new StringBuilder("");
                } 
            }
        System.out.print(sb);
    }
    static String changeWord(String x){
        if(x.charAt(0)=='a' ||
                x.charAt(0)=='e'||
                        x.charAt(0)=='o'||
                                x.charAt(0)=='u'||
                                        x.charAt(0)=='i'||
                x.charAt(0)=='A' ||
                    x.charAt(0)=='E'||
                            x.charAt(0)=='O'||
                                    x.charAt(0)=='U'||
                                            x.charAt(0)=='I')
            return x+"ay";
       return x.substring(1)+x.charAt(0)+"ay"; 
    }
}