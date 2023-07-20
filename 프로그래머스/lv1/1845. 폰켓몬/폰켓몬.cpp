#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    int count = nums.size()/2;
    sort(nums.begin(), nums.end());
    //중복제거
    nums.erase(unique(nums.begin(),nums.end()),nums.end());
    
    if(count<nums.size()) answer=count;
    else answer=nums.size();
    
    return answer;
}