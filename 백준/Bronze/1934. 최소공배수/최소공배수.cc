#include <iostream>

using namespace std;

int EuclideanAlgorithm(int a, int b){
    int c = a % b;
    while(c!=0){
        a = b;
        b = c;
        c = a % b;
    }
    return b;
}

int main(){
    int t;
    int a, b;
    cin>>t;
    while(t--){ 
        cin>> a >> b;
        
        int greater; //큰 수 찾기
        int least; //작은 수 찾기
        if(a>b){ greater = a; least = b;}
        else{greater = b; least = a;}

        cout<<(a*b)/EuclideanAlgorithm(greater, least)<<endl;
    }

}