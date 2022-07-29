//22/01/21 2점
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    queue<pair<int, bool>> q;
    for(int i=0; i<priorities.size(); i++){
        if(i==location)
            q.push(make_pair(priorities[i], 1));
        else
            q.push(make_pair(priorities[i], 0));
    }
    
    sort(priorities.begin(), priorities.end(), greater<>());
    for(int i : priorities){
        while(1){
            if(q.front().first==i){
                answer++;
                break;
            }
            else{
                q.push(q.front());
                q.pop();
            }
        }
        if(q.front().second==1){
            break;
        }
        q.pop();
    }
    
    
    return answer;
}