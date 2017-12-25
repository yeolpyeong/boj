/*
 * 직각삼각형 
 * https://www.acmicpc.net/problem/4153
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj4153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] length = new int[3];
		while (true) {
			length[0] = sc.nextInt();
			length[1] = sc.nextInt();
			length[2] = sc.nextInt();
			if (length[0] + length[1] + length[2] == 0)
				break;

			Arrays.sort(length);
			System.out.println(
					length[0] * length[0] + length[1] * length[1] == length[2] * length[2] ? "right" : "wrong");
		}
	}
}
