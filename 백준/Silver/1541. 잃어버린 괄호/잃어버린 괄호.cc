#include <iostream>
#include <string>
 
using namespace std;
 
/*
    ex) (50 + 30 + 10) - (6 + 4 + 35 + 13) - (35 + 1 + 0 + 2) - (15 + 57)
 
    알고리즘 : '-'문자 이후의 모든 숫자들을 빼면 된다.
 
    연산자의 다음부터 0이 아닌 숫자 이전에 0이 존재한다면 무시한다.
*/
 
string input_str;
int answer = 0;
 
void solve(){
 
    // 빼야하는지 여부 체크 변수
    bool is_minus = false;
    // 숫자 문자열 임시 저장 변수
    string tmp_num_str = "";
 
    // 입력받은 문자열을 한 문자씩 검사
    for(int i = 0; i < input_str.length(); i++){
 
        // 문자가 연산자 문자인 경우와, 숫자 문자인 경우로 나눔.
        if(input_str[i] == '+' || input_str[i] == '-'){
            
            // 연산자 문자인 경우
            // 연산자 문자의 앞 문자까지가 한 숫자이다.
            // is_minus 값에 따라 answer값에 덧셈 또는 뺄셈을 한다.
            if(is_minus){
                answer -= stoi(tmp_num_str);
            }else{
                answer += stoi(tmp_num_str);
            }
 
            // 만약 '-'가 처음으로 나오면, is_minus를 true로 초기화 한다.
            if(input_str[i] == '-')
                is_minus = true;
            
            // tmp_num_str의 값을 ""로 초기화한다.
            tmp_num_str = "";
 
        }else{
            // 숫자 문자인 경우
            // 만약 숫자가 0이고 tmp_num_str == ""  경우, 숫자 맨 앞에 나온 0이므로 무시
//            if(input_str[i] == '0' && tmp_num_str == "")
//                continue;
 
            // 그 외의 경우는 모두 tmp_num_str 맨 뒤에 이어붙임
            tmp_num_str += input_str[i];
        }
    }
    // for문을 빠져나와서, is_minus값에 따라 마지막 숫자값의 계산을 처리한다.
    if(is_minus){
        answer -= stoi(tmp_num_str);
    }else{
        answer += stoi(tmp_num_str);
    }
 
    cout<<answer;
}
 
void input(){
    cin>>input_str;
}
 
int main(void){
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); //속도향상
    cout.tie(NULL);
    
    input();
    solve();
 
    return 0;
}