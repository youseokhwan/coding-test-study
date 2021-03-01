#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <queue>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N, K;
	cin >> N >> K;
	vector<pair<int, int>> jewel(N);
	vector <int> knapsack(K);
	priority_queue<int> pq;
	// 보석 입력
	for (int i = 0; i < N; i++) {
		cin >> jewel[i].first >> jewel[i].second;
	}
	// 가방 무게 입력
	for (int i = 0; i < K; i++) {
		cin >> knapsack[i];
	}
	// 무게를 오름차순으로 정렬
	sort(jewel.begin(), jewel.end());
	sort(knapsack.begin(), knapsack.end());
	long long sum = 0;
	int size = 0;
	// 가방의 개수대로
	for (int i = 0; i < K; i++) {
		// 가방의무게가 보석의 무게보다 크거나 같고 임의의 변수 size가 보석의 개수보다 작을경우에 우선순위 큐에 enque
		while (size < N && jewel[size].first <= knapsack[i]) {
			pq.push(jewel[size++].second);
		}
		// pq에는 항상 큰 보석만 남아있으므로 비어있지 않으면 sum에 더하고 pop
		if (!pq.empty()) {
			sum += pq.top();
			pq.pop();
		}
	}
	cout << sum;
}