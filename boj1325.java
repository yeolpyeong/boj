
/*
 * 효율적인 해킹
 * https://www.acmicpc.net/problem/1325 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj1325 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}
		int A, B;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			adj.get(B).add(A);
		}

		int max = -1;
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[N + 1];
			q.add(i);
			visited[i] = true;
			int count = 1;
			while (!q.isEmpty()) {
				int here = q.poll();

				for (int j : adj.get(here)) {
					if (!visited[j]) {
						q.add(j);
						visited[j] = true;
						count++;
					}
				}
			}

			if (count == max) {
				res.add(i);
			} else if (count > max) {
				max = count;
				res.clear();
				res.add(i);
			}
		}

		for (int i : res) {
			System.out.printf("%d ", i);
		}
	}
}
