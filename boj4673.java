/*
 * 셀프 넘버
 * https://www.acmicpc.net/problem/4673
 */

package boj;

public class boj4673 {
	static int[] check = new int[10001];

	public static void main(String[] args) {
		for (int i = 1; i <= 10000; i++) {
			boj4673(i);
			if (check[i] == 0)
				System.out.println(i);
		}
	}

	public static void boj4673(int n) {
		int dn = n;
		while (n > 0) {
			dn += n % 10;
			n = n / 10;
		}
		if (dn <= 10000)
			check[dn] = 1;
	}
}
