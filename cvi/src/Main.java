
public class Main {

	static int array[] = { 3, 5, 2, 7, 1, 7, 5, 2, 8, 9, 1, 25, 15, 8, 3, 1, 38, 45, 8, 1 };
	static boolean found = false;
	static int half = 0;

	public static void main(String[] args) {
		int sum = 0;
		for (int index : array) {
			sum += index;
		}

		half = sum / 2;

		long t = System.currentTimeMillis();
		solve(0, 0);
		System.out.println("time = " + (System.currentTimeMillis() - t) + " :: " + found);
	}

	private static void solve(int start, int sum) {

		if (!found) {
			if (sum == half) {
				found = true;
				return;
			}
			for (int i = start; i < array.length; i++) {
				solve(i + 1, sum + array[i]);
			}
		}
	}

}
