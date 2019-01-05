import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern p = Pattern.compile("[0-9]+.[0-9]*|[0-9]*.[0-9]+|[0-9]+");
		StringBuffer output = new StringBuffer();
		
		int testCases = Integer.parseInt(br.readLine());
		double[] values = new double[2];
		for (int i = 1; i <= testCases; i++) {
			String line = br.readLine();
			double P = -1, U = -1, I = -1;

			Matcher m = p.matcher(line);

			StringBuffer sBuffer = new StringBuffer();
			while (m.find()) {
				sBuffer.append(m.group().replace("=", " "));
			}

			args = sBuffer.toString().trim().split(" ");
			values[0] = Double.valueOf(args[0]);
			values[1] = Double.valueOf(args[1]);

			args = line.split(" ");

			for (String s : args) {
				if (s.startsWith("U=")) {
					if (I == -1 && P == -1) {
						U = values[0];
					} else {
						U = values[1];
					}

					U = getValueFromPrefix(U, s);

				} else if (s.startsWith("I=")) {
					if (U == -1 && P == -1) {
						I = values[0];
					} else {
						I = values[1];
					}
					I = getValueFromPrefix(I, s);
				} else if (s.startsWith("P=")) {
					if (I == -1 && U == -1) {
						P = values[0];
					} else {
						P = values[1];
					}
					P = getValueFromPrefix(P, s);
				}
			}
			
			
			output.append(String.format("Problem #%d\n", i));
			if (I == -1) {
				I = P / U;
				output.append(String.format("I=%.2fA\n\n", I));
			} else if (P == -1) {
				P = I * U;
				output.append(String.format("P=%.2fW\n\n",P));
			} else {
				U = P / I;
				output.append(String.format("U=%.2fV\n\n",U));
			}
		}
		System.out.print(output);

	}

	private static double getValueFromPrefix(double value, String s) {
		if (s.contains("m")) {
			return value / 1000;
		} else if (s.contains("k")) {
			return value * 1000;
		} else if (s.contains("M")) {
			return value * 1000000;
		}
		return value;
	}

}

/*
16
U=120V and I=5.36A. What is the reason for calculating p? I cant understand ?
There was a p who has P=560W Which was destroyed by U=291.89V.
No chance if P=111.11W and I=3.004A.
U=200VI=4.5A.
U=220VP=100.00W.
P=2.5MWI=2A.
bla bla bla lightning strike I=2A bla bla bla P=2.5MW bla bla voltage?
If the voltage is U=200V and the current is I=4.5A, which power is generated?
A light-bulb yields P=100W and the voltage is U=220V. Compute the current, please.
gU=200VI=4.5A.
gU=220VP=100.00W.
tP=2.5MWI=2A.
PU=200VUI=4.5A.5W --
A light-bulb yields P=0W and the voltage is U=220V. Compute the current, please.
I light-bulb yields P=1W and the voltage is U=2V. Compute the current, please.
A light-bulb yields I=-1A and the voltage is U=-2V. Compute the current, please.Exception in thread "main" java.lang.NumberFormatException: multiple points



 */
