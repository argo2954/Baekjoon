#include <iostream>

using namespace std;
int main() {
	int n, k;//동전개수, 가치
	int cnt = 0;//동전개수의 최소값
    int arr[10]={0, };

	cin >> n >> k;

	//arr[n] : 동전의 가치 저장
	for (int i = 0; i < n; i++)
		cin >> arr[i];

    //동전개수 구하기
	for (int i = n-1; i >= 0; i--) {
        if(arr[i]>k) continue;//동전이 가치보다 크면 다음 동전으로
        if(k==0) break;//가치가 0이면 빠져나오기
        
        cnt=cnt + (k/arr[i]);//동전개수 = 가치/동전의 몫
        k=k%arr[i];//가치 = 가치/동전의 나머지
	}

	cout << cnt;//동전개수 출력
    
	return 0;
}
