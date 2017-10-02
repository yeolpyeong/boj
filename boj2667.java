/*
 * 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 */

package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj2667 {
	static int N, c;
	static int[][] map = new int[26][26];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			char[] line = str.toCharArray();
			for (int j = 1; j <= N; j++) {
				map[i][j] = Character.getNumericValue(line[j - 1]);
			}
		}

		boj2667();
	}

	public static void boj2667() {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				c = 0;
				check(i, j);
				if (c != 0)
					res.add(c);
			}
		}

		System.out.println(res.size());
		Collections.sort(res);
		for (int i : res)
			System.out.println(i);
	}

	public static void check(int x, int y) {
		if (map[x][y] != 1)
			return;

		c++;
		map[x][y] = -1;
		if (inRange(x - 1, y))
			check(x - 1, y);
		if (inRange(x + 1, y))
			check(x + 1, y);
		if (inRange(x, y - 1))
			check(x, y - 1);
		if (inRange(x, y + 1))
			check(x, y + 1);
	}

	public static boolean inRange(int x, int y) {
		if (x < 1 || y < 1 || x > N || y > N)
			return false;
		return true;
	}
}