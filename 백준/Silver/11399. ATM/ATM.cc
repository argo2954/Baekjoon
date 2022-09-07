#include <iostream>
#include <algorithm>
#define MAX 1000

using namespace std;

int main(){
    int N[MAX]={0, };
    int n;
    int cnt=0;

    cin>>n;
    for(int i=0; i<n; i++)
        cin>>N[i];

    sort(N, N+n);
    

    for(int i=n; i>=0; i--){
        cnt+=(N[n-i]*i);
    }

    cout<<cnt;

    return 0;
}