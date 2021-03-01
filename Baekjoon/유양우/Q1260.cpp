#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <queue>
#include <stack>
using namespace std;
int N, M, V;
vector<int> check;
vector<vector<int>> adjacent;
void bfs(int start) {
	queue<int> q;
	q.push(start);
	check.resize(N + 1);
	check[start] = 1;
	while (!q.empty()) {
		int empty = q.front();
		q.pop();
		cout << empty << " ";;
		for (int i = 1; i < adjacent[empty].size(); i++) {
			if (adjacent[empty][i] == 1 && check[i] == 0) {
				q.push(i);
				check[i] = 1;
			}
		}
	}
}

void dfs(int start) {
	stack<int>s;
	s.push(start);
	check.resize(N + 1);
	check[start] = 1;
	cout << start << " ";;
	while (!s.empty()) {
		int node = s.top();
		for (int i = 1; i < adjacent[node].size(); i++) {
			if (adjacent[node][i] == 1 && check[i] == 0) {
				node = i;
				s.push(node);
				check[node] = 1;
				cout << node << " ";
				break;
			}
			else if (i == (adjacent[node].size() - 1)) {
				s.pop();
			}

		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N >> M >> V;

	check.resize(N + 1);
	adjacent.resize(N + 1, vector<int>(N + 1, 0));
	int a, b;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		adjacent[a][b] = 1;
		adjacent[b][a] = 1;
	}

	dfs(V);
	check.clear();
	cout << "\n";
	bfs(V);
}