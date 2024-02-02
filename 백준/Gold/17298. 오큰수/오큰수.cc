//O(n)의 시간복잡도로 풀어야함!!!!!!
//단일 스택 이해하고 사용하기
//https://gluon.tistory.com/entry/%EB%B0%B1%EC%A4%80-17298-%EC%98%A4%ED%81%B0%EC%88%98
//https://hayden-archive.tistory.com/271
// [4 3 2 1] 4개의 순열이 있을 때 
// 해당 원소와 오른쪽 원소 비교 시 오른쪽 원소가 작다면
// 오른쪽 원소가 그 이후의 원소보다 크다면 해당원소와 그 이후의 원소를
// 비교할 필요가 없음.
// ex ) 4>3, 3>2 이기 때문에 첫번째(4)와 세번째(2)를 비교하지 않아도 됨

#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main(){
    int N;//수열의 크기
    vector<int> v(1000000); // 입력 수열
    stack<int> st;

    cin>>N;
    for(int i=0; i<N; i++) cin>>v[i]; //수열 입력

    vector<int> ans(N, -1); // 정답 수열(-1로 채움)
    st.push(0); // 스택에 0번째 수열 PUSH
    for(int i=1; i<N; i++)
    {
        while(!st.empty()&&v[st.top()]<v[i]){
            ans[st.top()]=v[i];
            st.pop();
        }
        st.push(i);
    }
    
    for(int ele : ans)
        cout<<ele<<" ";

    return 0;
}