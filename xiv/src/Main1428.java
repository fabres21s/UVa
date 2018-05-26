import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1428 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int testCases = Integer.parseInt(br.readLine());
		int a[], c[];

		int n;
		while (testCases-- > 0) {
			args = br.readLine().split(" ");
			n = Integer.parseInt(args[0]);

			a = new int[n];

			c = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(args[i + 1]);
			}

			FenwickTree f = new FenwickTree(100000);
			for (int i = 0; i < n; i++) {
				f.modify(a[i], 1);
				c[i] = (int) f.sum(a[i] - 1);
			}
			int[] d = new int[n];
			f = new FenwickTree(100000);
			for (int i = n - 1; i >= 0; i--) {
				f.modify(a[i], 1);
				d[i] = (int) f.sum(a[i] - 1);
			}
			long result = 0;
			for (int i = 0; i < n; i++) {
				result += c[i] * (n - i - 1 - d[i]);
				result += (i - c[i]) * d[i];
			}

			output.append(result);
			output.append("\n");

		}
		System.out.print(output);
	}

}

class FenwickTree {

	private static int lowbit(int x) {
		return x & -x;
	}

	private final int n;
	private final long[] f;

	/**
	 * @param n
	 */
	public FenwickTree(int n) {
		this.n = n;
		f = new long[n + 1];
	}

	/**
	 * @param x
	 * @param delta
	 */
	public void modify(int x, long delta) {
		if (x < 1 || x > n)
			throw new IllegalArgumentException();
		while (x <= n) {
			f[x] += delta;
			x += lowbit(x);
		}
	}

	/**
	 * 詢問 f[1] 至 f[x] 共 x 個元素之和.
	 * 
	 * @param x
	 * @return 0 若 x 爲 0, 否則 f[1] 至 f[x] 共 x 個元素之和.
	 */
	public long sum(int x) {
		if (x < 0 || x > n)
			throw new IllegalArgumentException();
		long result = 0;
		while (x > 0) {
			result += f[x];
			x -= lowbit(x);
		}
		return result;
	}

	/**
	 * @param from
	 * @param to
	 * @return
	 */
	public long sum(int from, int to) {
		if (from < 1 || from > to || to > n)
			throw new IllegalArgumentException();
		return sum(to) - sum(from - 1);
	}

}
