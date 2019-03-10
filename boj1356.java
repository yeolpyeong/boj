
/*
 * 유진수
 * https://www.acmicpc.net/problem/1356
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

class boj1356 {
	static int calculate(String n) {
		int res = 1;
		for (int i = 0; i < n.length(); i++) {
			res *= n.charAt(i) - '0';
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		boolean flag = false;
		for (int i = 1; i < N.length(); i++) {
			String A = N.substring(0, i);
			String B = N.substring(i, N.length());

			if (calculate(A) == calculate(B)) {
				flag = true;
				break;
			}
		}

		System.out.print(flag ? "YES" : "NO");
	}
}
