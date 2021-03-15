//#include <iostream>
//#include <algorithm>
//#include <math.h>
//#include <vector>
//#include <queue>
//#include <stack>
//#include <cstdio>
//#include <string>
//using namespace std;
//int N, M, V;
//// 정점을 방문했는지 확인하는 check 배열
//vector<vector<int>> check;
//// 지도
//int map[26][26];
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
//	cnt = 1; // 단지하나 ++
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
//			if (vx >= 0 && vy >= 0 && vy < N && vx < N) {
//				// 간선이 있고 방문하지 않았으면
//				if (map[vx][vy] == 1 && check[vx][vy] == 0) {
//					q.push(make_pair(vx, vy)); 	// enque
//					check[vx][vy] = 1; //방문체크
//					cnt++; // 단지하나 ++
//				}
//			}
//		}
//	}
//	cntArr.push_back(cnt); // 한 단지가 끝나면 cntArr에 push
//}
//
//int main() {
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
//	cin >> N;
//	check.resize(N + 1, vector<int>(N + 1, 0));
//
//	// string으로 받은 후 map초기화
//	for (int i = 0; i < N; i++) {
//		string temp;
//		cin >> temp;
//		for (int j = 0; j < N; j++) {
//			map[i][j] = temp[j] - '0';
//
//		}
//	}
//
//	// 단지의 총개수
//	int c = 0;
//	// 만약 지도 값이 1(연결된 경우)이고 방문하지 않았으면
//	for (int i = 0; i < N; i++) {
//		for (int j = 0; j < N; j++) {
//			// 간선이1이고 방문하지 않았으면
//			if (map[i][j] == 1 && check[i][j] == 0) {
//				c++; // 단지의 총개수를 하나 늘린다. -> 각 단지별로 딱 한 번씩 수행되기 때문에 여기서 c++
//				bfs(i, j); // bfs 수행
//			}
//		}
//	}
//	// 총단지 출력
//	cout << c << "\n";
//	// Arr Sort
//	sort(cntArr.begin(), cntArr.end());
//	// 단지당 단지개수 출력
//	for (int i = 0; i < cntArr.size(); i++) {
//		cout << cntArr[i];
//		cout << "\n";
//	}
//}