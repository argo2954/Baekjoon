#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
  int answer = 0;
  int N = 0;
  cin>>N;

  while(N--){
    vector<bool> arr(26, false);
    string s;
    bool check = true;
    cin>>s;

    arr[s[0]-'a'] = true;
    for(int i=1; i<s.size(); i++){
      if(arr[s[i]-'a'] && (s[i]!=s[i-1])){
        check = false;
        break;
      }
      else
        arr[s[i]-'a'] = true;
    }
    if(check) answer++;
  }
  cout<<answer;
}