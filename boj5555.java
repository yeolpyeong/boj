/*
 * 반지
 * https://www.acmicpc.net/problem/5555
 */

package boj;

import java.util.Scanner;

public class boj5555 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int N = sc.nextInt();
		int count = 0;
		while (N-- > 0) {
			String ring = sc.next();
			ring += ring.substring(0, word.length() - 1);
			if (ring.contains(word))
				count++;
		}
		System.out.print(count);
	}
}
