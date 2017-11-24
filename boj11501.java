/*
 * 주식
 * https://www.acmicpc.net/problem/11501
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] stock = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}

			int newHigh = 0;
			long income = 0;
			for (int i = N; i >= 1; i--) {
				newHigh = Math.max(newHigh, stock[i]);
				if (newHigh > stock[i])
					income += newHigh - stock[i];
			}
			System.out.println(income);
		}
	}
}
