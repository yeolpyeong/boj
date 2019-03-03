/*
 * Maaaaaaaaaze
 * https://www.acmicpc.net/problem/16985
 */

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

class boj16985 {
	static final int size = 5, side = 4;
	static final int[] dx = { 1, -1, 0, 0, 0, 0 }, dy = { 0, 0, 1, -1, 0, 0 }, dz = { 0, 0, 0, 0, 1, -1 };

	static class Point {
		int x, y, z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int min = Integer.MAX_VALUE;
	static int[][][][] rotated;

	static void generateRotated(int[][][] maze) {
		rotated = new int[size][side][size][size];
		for (int x = 0; x < size; x++) {
			rotated[x][0] = maze[x];
			for (int d = 1; d < side; d++) {
				for (int y = 0; y < size; y++) {
					for (int z = 0; z < size; z++) {
						rotated[x][d][y][z] = rotated[x][d - 1][z][size - y - 1];
					}
				}
			}
		}
	}

	static int escape(int[][][] maze) {
		Queue<Point> q = new LinkedList<>();
		int[][][] visited = new int[size][size][size];
		int x = 0, y = 0, z = 0;
		q.add(new Point(x, y, z));
		while (!q.isEmpty()) {
			int cx = q.peek().x, cy = q.peek().y, cz = q.peek().z;
			q.poll();

			for (int d = 0; d < 6; d++) {
				int nx = cx + dx[d], ny = cy + dy[d], nz = cz + dz[d];

				if (nx < 0 || ny < 0 || nz < 0 || nx >= size || ny >= size || nz >= size) {
					continue;
				}

				if (maze[nx][ny][nz] == 0 || visited[nx][ny][nz] != 0) {
					continue;
				}

				visited[nx][ny][nz] = visited[cx][cy][cz] + 1;
				q.add(new Point(nx, ny, nz));
			}
		}

		if (visited[size - 1][size - 1][size - 1] != 0) {
			return visited[size - 1][size - 1][size - 1];
		} else {
			return Integer.MAX_VALUE;
		}
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static void perm(int[] numbers, int pivot) {
		if (pivot == size - 1) {
			int[][][] copy = new int[size][size][size];

			for (int a = 0; a < side; a++) {
				copy[0] = rotated[numbers[0]][a];
				for (int b = 0; b < side; b++) {
					copy[1] = rotated[numbers[1]][b];
					for (int c = 0; c < side; c++) {
						copy[2] = rotated[numbers[2]][c];
						for (int d = 0; d < side; d++) {
							copy[3] = rotated[numbers[3]][d];
							for (int e = 0; e < side; e++) {
								copy[4] = rotated[numbers[4]][e];
								if (copy[0][0][0] == 1) {
									min = Math.min(min, escape(copy));
								}
							}
						}
					}
				}
			}
			return;
		}

		for (int i = pivot; i < size; i++) {
			swap(numbers, i, pivot);
			perm(numbers, pivot + 1);
			swap(numbers, i, pivot);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][][] maze = new int[size][size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				st = new StringTokenizer(br.readLine());
				for (int z = 0; z < size; z++) {
					maze[x][y][z] = Integer.parseInt(st.nextToken());
				}
			}
		}

		generateRotated(maze);
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = i;
		}
		perm(numbers, 0);

		System.out.print(min != Integer.MAX_VALUE ? min : -1);
	}
}
