//#include <iostream>
//#include <algorithm>
//#include <math.h>
//#include <vector>
//#include <queue>
//#include <string>
//using namespace std;
//
//bool cmp(string a, string b)
//{
//	if (a.size() == b.size()) { // 길이가 같으면 사전순으로
//		return a < b;
//	}
//	return a.size() < b.size(); // 다르면 크기가 다른게 앞으로
//}
//
//
//int main() {
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
//	int N;
//	cin >> N;
//	vector<string> v(N);
//	for (int i = 0; i < N; i++) {
//		cin >> v[i];
//		
//	}
//	sort(v.begin(), v.end(), cmp);
//
//	v.erase(unique(v.begin(), v.end()), v.end());
//	for (int i = 0; i < v.size(); i++) {
//		cout << v[i]<<"\n";
//	}
//}