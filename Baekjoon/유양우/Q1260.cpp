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
//void bfs(int start) {
//	// Queue q 선언
//	queue<int> q;
//	// 탐색을 시작하는 초기점 start를 enque
//	q.push(start);
//	// vector resize
//	check.resize(N + 1);
//	// start부터 탐색하므로 방문했다고 체크.
//	check[start] = 1;
//	// q가 비어있을 때 까지
//	while (!q.empty()) {
//		// queue front에 있는 값을 node에 대입.
//		int node = q.front();
//		// queue front값을 지운다
//		q.pop();
//		// queue front값을 출력
//		cout << node << " ";
//		// 인접행렬의 node행의 size만큼 돌아간다.
//		for (int i = 1; i < adjacent[node].size(); i++) {
//			// node행에 간선이 있고 방문하지 않았으면 queue에 enque하고 방문표시
//			if (adjacent[node][i] == 1 && check[i] == 0) {
//				q.push(i);
//				check[i] = 1;
//			}
//		}
//	}
//}
//
//void dfs(int start) {
//	// stack s선언
//	stack<int>s;
//	// 초기 탐색값을 stack에 push
//	s.push(start);
//	// check vector resize
//	check.resize(N + 1);
//	// 시작점 방문체크
//	check[start] = 1;
//	// 시작점 출력
//	cout << start << " ";;
//	// 스택이 비어있을 때 까지
//	while (!s.empty()) {
//		// stack의 최상위 원소를 삽입
//		int node = s.top();
//		// 인접행렬의 크기만큼
//		for (int i = 1; i < adjacent[node].size(); i++) {
//			// node행에 간선이 있고 방문하지 않았으면 push, 방문처리 후 출력 후 break(새로운 정점의 인접한 점을 탐색하기 위해)
//			if (adjacent[node][i] == 1 && check[i] == 0) {
//				s.push(i);
//				check[i] = 1;
//				cout << i << " ";
//				break;
//			}
//			// 더 탐색할 점이 없을 경우에 pop
//			else if (i == (adjacent[node].size() - 1)) {
//				s.pop();
//			}
//
//		}
//	}
//}
//
//int main() {
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
//	// 입력받기
//	cin >> N >> M >> V;
//	// 인덱스 접근을 위한 vector 배열 리사이즈
//	check.resize(N + 1);
//	adjacent.resize(N + 1, vector<int>(N + 1, 0));
//	int a, b;
//	// 인접행렬 간선이 있다면 1로 초기화
//	for (int i = 0; i < M; i++) {
//		cin >> a >> b;
//		adjacent[a][b] = 1;
//		adjacent[b][a] = 1;
//	}
//	// DFS 수행
//	dfs(V);
//	// 방문했는지 확인하는 배열 check 초기화
//	check.clear();
//	cout << "\n";
//	// BFS 수행
//	bfs(V);
//}