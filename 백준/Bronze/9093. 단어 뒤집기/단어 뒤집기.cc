#include <iostream>
#include <stack>
#include <string>
using namespace std;

void top_pop(stack<char>& st) //stack 마지막 원소 출력/삭제
{
    while(!st.empty())
    {
        cout<<st.top(); //stack 마지막 원소 반환
        st.pop(); //stack 마지막 원소 삭제
    }
    cout<<' ';
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    stack<char> st;
    string str;
    int index;

    cin>>index;
    cin.ignore(); // 다음 반복문에서 getline작동 시 이전 index가 '\'를 받아 오류남을 방지

    for(int i=0; i<index; i++)
    {
        getline(cin, str);
        str+=' ';

        for(int j=0; j<str.size(); j++)
        {
                if(str[j]!=' ') //문자이면 push
                    st.push(str[j]);
                else
                   top_pop(st); //' '이라면 top_pop함수 호출
        }
        
        cout<<'\n';
    }
    

}