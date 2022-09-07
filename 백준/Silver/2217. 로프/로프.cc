/*
1. N개의 로프 내림차순
2. arr[i]번째 로프 중량 * (i+1) > arr[i-1]번째 로프 중량 * (i) 비교
*/

#include <iostream>
#include <algorithm>


bool cmp(int a, int b){
    return a>b;
}
using namespace std;
int main(){
    int N;
    int weight;

    cin>>N;

    int* arr = new int[N];
    
    for(int i=0; i<N; i++) cin>>arr[i];

    sort(arr, arr+N, cmp);
    weight=arr[0];

    for(int i=1; i<N; i++){
        if(weight<(arr[i]*(i+1))) weight=(arr[i]*(i+1));
    }

    cout<<weight;
}