/*
 * 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */

package boj;

import java.util.Scanner;
import java.util.Stack;

public class boj15686 {
	static int N, M, nChickenRestaurant, min = Integer.MAX_VALUE;
	static int[][] map, chickenMap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		findChickenRestaurant();
		Stack<Integer> storage = new Stack();
		dfs(storage, 1);
		System.out.print(min);
	}

	public static void findChickenRestaurant() {
		chickenMap = new int[14][2];
		int temp = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 2) {
					chickenMap[temp][0] = i;
					chickenMap[temp][1] = j;
					temp++;
				}
			}
		}
		nChickenRestaurant = temp - 1;
	}

	public static void dfs(Stack<Integer> storage, int index) {
		if (storage.size() == M) {
			int distance = calculateDistance(map, storage);
			min = Math.min(min, distance);
			return;
		}

		if (index > nChickenRestaurant)
			return;

		storage.push(index);
		dfs(storage, index + 1);
		storage.pop();
		dfs(storage, index + 1);
	}

	public static int calculateDistance(int[][] map, Stack<Integer> storage) {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					int min = Integer.MAX_VALUE;
					for (int s : storage) {
						int xd = Math.abs(i - chickenMap[s][0]);
						int yd = Math.abs(j - chickenMap[s][1]);
						min = Math.min(min, xd + yd);
					}
					sum += min;
				}
			}
		}
		return sum;
	}
}
