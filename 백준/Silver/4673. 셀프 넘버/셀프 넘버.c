#include <stdio.h>
#define MAX 10001

int main(){
    int i, sum, idx;
    int arr[MAX] = {1,0 }; //셀프 넘버 = 0 
    
    for(i=1; i<=MAX; i++){
        idx = sum = i;
        while(idx){
            sum += idx%10;
            idx /= 10;
        }
        if(sum<=MAX) arr[sum] = 1;
    }
    
    for(i=0; i<=MAX; i++)
        if(arr[i]==0)
            printf("%d\n", i);
            
    return 0;
}