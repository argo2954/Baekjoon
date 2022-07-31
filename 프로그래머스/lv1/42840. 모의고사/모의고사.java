import java.util.*;
class Solution {
    public int[] solution(int[] answers) {       
        int[] arr1 = {1, 2, 3, 4, 5}; //1번 수포자 루틴
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5}; //2번 수포자 루틴
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //3번 수포자 루틴

        int alen = answers.length; //answers의 length 
        int[] score = new int[3];
        for(int i=0; i<alen; i++){
            if(arr1[i%5] == answers[i]) score[0]++;
            if(arr2[i%8] == answers[i]) score[1]++;
            if(arr3[i%10] == answers[i]) score[2]++;
        }
      
        int max = Arrays.stream(score).max().getAsInt();//tmp배열에서 최대값 찾기
        ArrayList<Integer> list = new ArrayList<>(); //Alist생성
        for(int i=0; i<3; i++)
            if(score[i]==max)
                list.add(i+1);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}