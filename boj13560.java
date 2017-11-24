/*
 * 축구 게임
 * https://www.acmicpc.net/problem/13560
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj13560 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(score);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += score[i];
			if (sum < i * (i + 1) / 2) {
				System.out.print(-1);
				return;
			}
		}
		if (sum != n * (n - 1) / 2) {
			System.out.print(-1);
			return;
		}
		System.out.print(1);
	}
}
