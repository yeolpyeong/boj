/*
 * »ï°¢ ±è¹ä
 * https://www.acmicpc.net/problem/2783 
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj2783 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float X = sc.nextFloat();
		float Y = sc.nextFloat();
		int N = sc.nextInt();
		float[] price = new float[N + 1];
		price[0] = X * 1000 / Y;
		for (int i = 1; i <= N; i++) {
			price[i] = sc.nextFloat() * 1000 / sc.nextFloat();
		}
		Arrays.sort(price);
		System.out.print(price[0]);
	}
}
