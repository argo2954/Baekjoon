// 첫 번째
//1. string input을 오름차순으로 정렬
//2. 범위기반 for문을 이요해
//   비교대상 cmp = 'a'와 비교 ASCII 'a' = 97
//3. cmp보다 크면 cmp+=1하고 비교

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    string input;
    vector<int> output(26);
    char cmp = 'a'; //97
    
    cin>>input;//입력
    sort(input.begin(), input.end()); //오름차순


    for(auto ele : input){
        while(ele!=cmp) cmp+=1;
        if(ele==cmp) output[ele-97] += 1;
    }

    for(auto ele : output) cout<<ele<<' ';
}