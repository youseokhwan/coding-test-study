//#include <iostream>
//#include <algorithm>
//#include <math.h>
//#include <vector>
//#include <queue>
//using namespace std;
//
//int main() {
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
//	int N;
//	cin >> N;
//	vector<int> array(N);
//	vector<int> answer(4);
//	vector<int> cnt(8001, 0);
//	int sum = 0;
//	int max = 0;
//	int temp;
//	int mode;
//	bool isSecond = false;
//	for (int i = 0; i < N; i++) {
//		cin >> array[i];
//		sum += array[i];
//		temp = (array[i] <= 0) ? abs(array[i]) : array[i] + 4000;
//		cnt[temp]++;
//		if (cnt[temp] > max)
//			max = cnt[temp];
//	}
//
//	// 산술평균
//	answer.push_back(sum / N);
//
//	// 중앙값
//	sort(array.begin(), array.end());
//	answer.push_back(array[N / 2]);
//
//	// 최빈값 
//	for (int i = -4000; i < 4001; i++) {
//		temp = i <= 0 ? abs(i) : i + 4000;
//		// 완전탐색으로 max값과 비교해서 찾음
//		if (cnt[temp] == max) {
//			mode = i;
//
//			// 같은 값이 있으면 그 2번쨰 max값을 넣고 break;
//			if (isSecond)break;
//
//			isSecond = true;
//		}
//	}
//
//	answer.push_back(mode);
//	// 범위
//	answer.push_back(array[array.size() - 1] - array[0]);
//
//	cout << round(sum / (double)N) << "\n";
//	cout << array[N / 2] << "\n";
//	cout << mode << "\n";
//	cout << array[array.size() - 1] - array[0] << "\n";
//}