//#include <iostream>
//#include <algorithm>
//#include <math.h>
//#include <vector>
//#include <queue>
//#include <stack>
//using namespace std;
//int N, M, V;
//// 정점을 방문했는지 확인하는 check 배열
//vector<int> check;
//// 2차원 인접행렬
//vector<vector<int>> adjacent;
//
//// BFS를 사용한 이유 : BFS는 정점으로 부터 탐색을 시작하면 탐색하는 정점이 queue에 한 번씩 담기기 때문에 BFS를 사용
//int bfs(int start) {
//	queue <int> q;
//	// 시작점 enque
//	q.push(start);
//	// check배열에 시작 정점 방문 체크
//	check[start] = 1;
//	// 1번 컴퓨터로 인해 바이러스가 걸리는 컴퓨터 개수 카운팅
//	int cnt = 0;
//	// queue가 빌 때 까지
//	while (!q.empty()) {
//		// node에 queue front에 있는 정점 대입
//		int node = q.front();
//		// queue deque
//		q.pop();
//		// 시작점의 node의 행 사이즈만큼 반복 
//		for (int i = 1; i < adjacent[node].size(); i++) {
//			// 인접행렬node행을 탐색하는데 간선이 이어져있고 방문하지 않았으면 enque 후 컴퓨터의 개수 증가 후 방문 체크 
//			if (adjacent[node][i] == 1 && check[i] == 0) {
//				q.push(i);
//				cnt++;
//				check[i] = 1;
//			}
//		}
//
//	}
//	return cnt;
//}
//int main() {
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
//	// 입력받기
//	int N, computer; cin >> N >> computer;
//	// vector size resize
//	adjacent.resize(N + 1, vector<int>(N + 1, 0));
//	check.resize(N + 1);
//	// 간선의 개수 입력받고 행과열을 1로 초기화
//	for (int i = 0; i < computer; i++) {
//		int a, b; cin >> a >> b;
//		adjacent[a][b] = adjacent[b][a] = 1;
//	}
//	// bfs실행후 나온 값 출력
//	cout << bfs(1);
//}