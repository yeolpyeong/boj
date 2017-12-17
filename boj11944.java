/*
 * NN
 * https://www.acmicpc.net/problem/11944
 */

package boj;

import java.util.Scanner;

public class boj11944 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String answer = "";
		for (int i = 1; i <= N; i++) {
			answer += N;
			if (answer.length() > M) {
				answer = answer.substring(0, M);
				break;
			}
		}
		System.out.print(answer);
	}
}
