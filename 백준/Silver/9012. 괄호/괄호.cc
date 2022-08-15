#include <iostream>
#include <string>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string str;
    int index;
    int cnt;

    cin>>index;

    while(index--){
        cin>>str;
        cnt=0;
        for(auto ele:str)
        {
            if(ele=='(')
            {
               cnt+=1; 
            }
            else if(ele==')')
            {
                cnt-=1;
                if(cnt<0) break;
            }
        }
        cnt==0? cout<<"YES" : cout<<"NO";
        cout<<'\n';
    }
    
    
}