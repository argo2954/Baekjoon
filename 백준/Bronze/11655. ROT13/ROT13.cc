#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main(){
    string st;
    
    getline(cin, st);

    for(auto ele:st){
        if(('A'<=ele && ele<='Z'))
            ele = (ele-'A')>=13? ele-13 : ele+13;
        else if(('a'<=ele && ele<='z'))
            ele = (ele-'a')>=13? ele-13 : ele+13;

        cout<<ele;
    }
}
