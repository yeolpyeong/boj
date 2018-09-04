/*
 * 영역 구하기
 * https://www.acmicpc.net/problem/2583
 */

package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj2583 {
	static int M, N, S;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Integer> areaList = new ArrayList();
	static int[][] area;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		area = new int[M][N];
		int K = sc.nextInt();
		while (K-- > 0) {
			int y1 = sc.nextInt();
			int x1 = sc.nextInt();
			int y2 = sc.nextInt();
			int x2 = sc.nextInt();
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					area[x][y] = 1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (area[i][j] == 0) {
					S = 0;
					dfs(i, j);
					areaList.add(S);
				}
			}
		}

		Collections.sort(areaList);
		System.out.println(areaList.size());
		for (int s : areaList) {
			System.out.print(s + " ");
		}
	}

	public static void dfs(int x, int y) {
		S++;
		area[x][y] = 4;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!checkRange(nx, ny))
				continue;
			if (area[nx][ny] == 0) {
				dfs(nx, ny);
			}
		}
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}
}
