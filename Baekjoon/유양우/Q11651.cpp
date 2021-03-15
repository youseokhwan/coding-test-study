//#include <iostream>
//#include <algorithm>
//#include <math.h>
//#include <vector>
//#include <queue>
//#include <string>
//using namespace std;
//
//bool cmp(pair<int, int> a, pair<int, int> b)
//{
//	// y좌표를 기준으로
//
//	if (a.second < b.second)
//
//		return true;
//
//	else if (a.second == b.second)
//
//		if (a.first < b.first)
//
//			return true;
//
//	return false;
//}
//
//int main() {
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
//	int N;
//	cin >> N;
//	vector <pair<int, int>> v(N);
//	for (int i = 0; i < N; i++) {
//		cin >> v[i].first >> v[i].second;
//	}
//	sort(v.begin(), v.end(), cmp);
//	for (int i = 0; i < N; i++) {
//		cout << v[i].first << " " << v[i].second;
//		cout << "\n";
//	}
//}