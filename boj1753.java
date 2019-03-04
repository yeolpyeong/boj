
/*
 * 최단경로
 * https://www.acmicpc.net/problem/1753
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class boj1753 {
	static final int INF = Integer.MAX_VALUE;

	static class Edge implements Comparable<Edge> {
		int v, c;

		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(Edge e) {
			if (this.c > e.c) {
				return 1;
			} else if (this.c < e.c) {
				return -1;
			}
			return 0;
		}
	}

	static int V;
	static ArrayList<ArrayList<Edge>> adj;

	static int[] dijkstra(int src) {
		int[] dist = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			dist[i] = i == src ? 0 : INF;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(src, dist[src]));
		while (!pq.isEmpty()) {
			int here = pq.peek().v;
			int cost = pq.peek().c;
			pq.poll();

			if (dist[here] < cost) {
				continue;
			}

			for (Edge e : adj.get(here)) {
				int there = e.v;
				int nextDist = cost + e.c;
				if (nextDist < dist[there]) {
					dist[there] = nextDist;
					pq.add(new Edge(there, nextDist));
				}
			}
		}

		return dist;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		adj = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj.get(u).add(new Edge(v, w));
		}

		int[] dist = dijkstra(K);
		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i] == INF ? "INF" : dist[i]);
		}
	}
}
