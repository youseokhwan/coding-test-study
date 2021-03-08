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
//// 지도
//int map[51][51];
//// 2차원 배열 상하좌우를 확인하기 위한 direction x, y
//int dx[4] = { 0,0,-1,1 };
//int dy[4] = { 1,-1,0,0 };
//// 단지 카운팅 변수
//int cnt = 0;
//// 각 단지별 몇단지인지 나타내는 cntArr
//vector<int> cntArr;
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
//
//	cin >> T;
//	for (int z = 0; z < T; z++) {
//		cnt = 0;
//		cin >> M >> N >> K;
//		check.clear();
//		v.clear();
//		check.resize(51, vector<int>(51, 0));
//		v.resize(51, vector<int>(51, 0));
//	
//		// 인접행렬
//		for (int i = 0; i < K; i++) {
//			int a, b;
//			cin >> b >> a;
//			v[a][b] = 1;
//		}
//
//		// 간선이 있고 방문하지않았으면
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if (v[i][j] == 1 && check[i][j] == 0) {
//					bfs(i, j);
//
//					cnt++;
//
//				}
//			}
//
//		}
//
//		cout << cnt<<"\n";
//	}
//
//}