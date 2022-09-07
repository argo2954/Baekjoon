#include <stdio.h>

int main(void) {
  int n1, N1;
  int cycle = 0;

  scanf("%d", &N1);
  n1 = N1;
  
  while(1){
    int n2 = (n1/10) + (n1%10);
    n1 = (n1%10) * 10 + (n2%10);
    cycle++;

    if(N1 == n1) break;
  }

  printf("%d", cycle);
  
  return 0;
}