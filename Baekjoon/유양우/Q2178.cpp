//#include <iostream>
//#include <algorithm>
//#include <math.h>
//#include <vector>
//#include <queue>
//#include <stack>
//#include <cstdio>
//#include <string>
//using namespace std;
//int N, T, M, K;
//// 정점을 방문했는지 확인하는 check 배열
//vector<vector<int>> check;
//vector<vector<int>> v;
//// 2차원 배열 상하좌우를 확인하기 위한 direction x, y
//int dx[4] = { 0,0,-1,1 };
//int dy[4] = { 1,-1,0,0 };
//
//void bfs(int a, int b) {
//	queue <pair<int, int>> q;
//	q.push(make_pair(a, b));
//	check[a][b] = 1; //시작점 방문체크
//	while (!q.empty()) {
//		// queue의 값 x,y에 대입 후 deque
//		int x = q.front().first;
//		int y = q.front().second;
//		q.pop();
//		// 상하좌우 탐색을 위해 for문
//		for (int i = 0; i < 4; i++) {
//			// vx,vy에 x,y에 direction을 더한 값 대입
//			int vx = x + dx[i];
//			int vy = y + dy[i];
//			// 아래 조건은 vx, vy는 0보다 크고 N보다 작아야하므로 이때만 수행하게끔 한다.
//			if (vx >= 0 && vy >= 0 && vy < M && vx < N) { //m 10 n 8
//				// 간선이 있고 방문하지 않았으면
//				if (v[vx][vy] == 1 && check[vx][vy] == 0) {
//					q.push(make_pair(vx, vy)); 	// enque
//					check[vx][vy] = 1; //방문체크
//					v[vx][vy] = v[x][y] + 1; // 계속해서 탐색할 수 있으면 원래 map(v) +1을 해 마지막까지 탐색한다.
//				}
//			}
//		}
//	}
//
//}
//
//int main() {
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
//	cin >> N >> M;
//	check.clear();
//	v.clear();
//	check.resize(N, vector<int>(M, 0));
//	v.resize(N, vector<int>(M, 0));
//
//	// 인접행렬
//	for (int i = 0; i < N; i++) {
//		string temp;
//		cin >> temp;
//		for (int j = 0; j < M; j++) {
//			v[i][j] = temp[j] - '0';
//		}
//	}
//
//	bfs(0, 0);
//	cout << v[N - 1][M - 1];
//}