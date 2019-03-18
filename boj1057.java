
/*
 * 토너먼트
 * https://www.acmicpc.net/problem/1057
 */

import java.util.Scanner;

class boj1057 {
	static int next(int R) {
		return R % 2 == 0 ? R / 2 : R / 2 + 1;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int jimin = sc.nextInt();
		int hansoo = sc.nextInt();

		if (jimin > hansoo) {
			int temp = jimin;
			jimin = hansoo;
			hansoo = temp;
		}

		int round = 0;
		while (true) {
			round++;

			if (jimin % 2 == 1 && jimin + 1 == hansoo) {
				break;
			}

			N = next(N);
			jimin = next(jimin);
			hansoo = next(hansoo);
		}

		System.out.print(round);
	}
}
