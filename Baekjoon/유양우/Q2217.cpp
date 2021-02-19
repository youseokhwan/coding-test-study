#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	// 로프의 개수를 받을 N선언
	int N;
	// 로프가 견딜 수 있는 무게를 담을 vector v선언
	vector<int> v;
	// 최고 무게를 담을 answer선언
	int answer = 0;
	// 로프의 개수 입력 받기
	cin >> N;
	// 가장 적게 버틸 수 있는 중량이면 모든 로프들이 그 만큼 씩 버틸 수 있기 때문에 효율이 안좋은 로프부터 계산하여 하나씩 줄여나가는 변수 a 선언
	int a = N;
	// 로프가 버틸 수 있는 중량을 v에 대입
	for (int i = 0; i < N; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	// 가장 적게 버틸 수 있는 중량의 로프 부터 계산하기 위해 오름차순 정렬
	sort(v.begin(), v.end());
	// N의 개수에 따라 가장 적게 버틸 수 있는 로프의 중량에 맞춰서 다른 로프들도 
	// 그 만큼만 들 수 있기 때문에 그 중량에 * a(최고 중량을 구해야 하기 때문에 작은 것부터 줄여나간다)를 answer에 대입 후 answer보다 큰 값이면 대입한다.
	for (int i = 0; i < N; i++) {
		if (answer < v[i] * (N - i)) answer = v[i] * (N - i);
	}

	// 최고중량 answer Print
	cout << answer;
}