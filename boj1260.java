/*
 * DFS¿Í BFS
 * https://www.acmicpc.net/problem/1260
 */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class boj1260 {
	static int N, V;
	static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		V = sc.nextInt();
		int[][] adj = new int[N + 1][N + 1];
		while (M-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A][B] = 1;
			adj[B][A] = 1;
		}

		dfs(adj);
		System.out.println();
		bfs(adj);
	}

	public static void dfs(int[][] adj) {
		Stack<Integer> s = new Stack();
		visited = new int[N + 1];
		s.push(V);
		visited[V] = 1;
		System.out.print(V + " ");

		while (!s.isEmpty()) {
			int next = s.peek();
			boolean flag = false;
			for (int i = 1; i <= N; i++) {
				if (adj[next][i] == 1 && visited[i] == 0) {
					s.push(i);
					visited[i] = 1;
					System.out.print(i + " ");
					flag = true;
					break;
				}
			}

			if (!flag)
				s.pop();
		}
	}

	public static void bfs(int[][] adj) {
		Queue<Integer> q = new LinkedList();
		visited = new int[N + 1];
		q.add(V);
		visited[V] = 1;
		System.out.print(V + " ");

		while (!q.isEmpty()) {
			int next = q.poll();
			for (int i = 1; i <= N; i++) {
				if (adj[next][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = 1;
					System.out.print(i + " ");
				}
			}
		}
	}
}
