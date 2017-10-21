/*
 * 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj2667 {
	static int N, nHouse;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map = new int[26][26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(line[j - 1]);
			}
		}

		boj2667();
	}

	public static void boj2667() {
		ArrayList<Integer> group = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				nHouse = 0;
				checkSizeOfGroup(i, j);
				if (nHouse != 0)
					group.add(nHouse);
			}
		}

		System.out.println(group.size());
		Collections.sort(group);
		for (int i : group)
			System.out.println(i);
	}

	public static void checkSizeOfGroup(int x, int y) {
		if (map[x][y] != 1)
			return;

		nHouse++;
		map[x][y] = -1;

		for (int i = 0; i < 4; i++) {
			if (checkRange(x + dx[i], y + dy[i]))
				checkSizeOfGroup(x + dx[i], y + dy[i]);
		}
	}

	public static boolean checkRange(int x, int y) {
		return x >= 1 && y >= 1 && x <= N && y <= N;
	}
}
