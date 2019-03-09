
/*
 * 수 정렬하기 3
 * https://www.acmicpc.net/problem/10989
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class boj10989 {
	static final int MAX = 10000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[MAX + 1];
		for (int i = 0; i < N; i++) {
			numbers[Integer.parseInt(br.readLine())]++;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= MAX; i++) {
			while (numbers[i]-- > 0) {
				bw.write(i + "\n");
			}
		}

		bw.flush();
	}
}
