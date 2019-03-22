
/*
 * 소가 길을 건너간 이유 1
 * https://www.acmicpc.net/problem/14467
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj14467 {
	static final int MAX = 10;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		StringTokenizer st;
		int[] cow = new int[MAX + 1];
		for (int i = 1; i <= MAX; i++) {
			cow[i] = -1;
		}
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());

			if (pos != cow[idx]) {
				cow[idx] = pos;
				count++;
			}
		}

		for (int i = 1; i <= MAX; i++) {
			if (cow[i] > -1) {
				count--;
			}
		}

		System.out.print(count);
	}
}
