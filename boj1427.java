/*
 * 소트인사이드
 * https://www.acmicpc.net/problem/1427
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] N = sc.next().split("");
		Arrays.sort(N);
		for (int i = N.length - 1; i >= 0; i--) {
			System.out.print(N[i]);
		}
	}
}
