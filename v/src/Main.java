import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		double[] values = new double[2];
		for (int i = 1; i <= testCases; i++) {
			//String line = br.readLine();
			double P = -1, U = -1, I = -1;
			Pattern p = Pattern.compile("[0-9]+.[0-9]*|[0-9]*.[0-9]+|[0-9]+");
			Matcher m = p.matcher(br.readLine());
			int index = 0;
			while (m.find()) {
				//values[index++] = Double.valueOf(m.group().replace("=", ""));
				System.out.println(m.group());
			}
//			args = line.split(" ");
//
//			for (String s : args) {
//				if (s.startsWith("U=")) {
//					if (I == -1 && P == -1) {
//						U = values[0];
//					} else {
//						U = values[1];
//					}
//				} else if (s.startsWith("I=")) {
//					if (U == -1 && P == -1) {
//						I = values[0];
//					} else {
//						I = values[1];
//					}
//				} else if (s.startsWith("P=")) {
//					if (I == -1 && U == -1) {
//						P = values[0];
//					} else {
//						P = values[1];
//					}
//				}
//			}
//
//			if (I == -1) {
//				I = P / U;
//				System.out.println("I=" + I + "A");
//			} else if (P == -1) {
//				P = I * U;
//				System.out.println("P=" + P + "W");
//			} else {
//				U = P / I;
//				System.out.println("U=" + I + "V");
//			}
		}

	}

}
