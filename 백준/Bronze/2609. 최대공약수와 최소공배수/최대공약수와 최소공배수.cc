//유클리드 호제법으로 풀이 가능
//https://sectumsempra.tistory.com/77

#include <iostream>

using namespace std;

int Euclidean(int a, int b){
    int c = a % b;
    while(c!=0){
       a = b;
       b = c;
       c = a % b;
    }
    return b;
}

int main(){
    int a, b;
    cin>>a>>b;

    int greater; //큰 수 찾기
    int least; //작은 수 찾기
    if(a>b){ greater = a; least = b;}
    else{greater = b; least = a;}

    // greatest common factor
    int gcf = Euclidean(greater, least);

    //least common multiple
    int lcm=(a*b)/gcf;

    cout<<gcf<<'\n'<<lcm;
}