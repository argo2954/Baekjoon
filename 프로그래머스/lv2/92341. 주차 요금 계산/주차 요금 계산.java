import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedList;
import java.lang.Math;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        LinkedList<Integer> answer = new LinkedList<>();
        
        // TreeMap에 <차량번호, 입.출차기록리스트> 저장
        // TreeMap은 정렬됨
        Map<String, LinkedList<String>> map = new TreeMap<>();
        for(String record: records){
            String r = record.substring(6, 10);
            String time = record.substring(0, 5);
            
            if(map.containsKey(r)){
                map.get(r).add(time);
            }
            else{
                map.put(r, new LinkedList<String>());
                map.get(r).add(time);
            }
        }
        
        // 요금표 정리
        int d_time = fees[0];   // 기본 시간
        int d_fee = fees[1];    // 기본 요금
        int u_time = fees[2];   // 단위 시간
        int u_fee = fees[3];    // 단위 요금
        
        // 차번호를 기준으로 요금 계산
        for(String key : map.keySet()) {
            LinkedList<String> values = map.get(key);
            if(values.size()%2 == 1) //입출차기록 짝수로 맞추기
                values.add("23:59");
            
            int time = -d_time;
            int size = values.size();
            for(int i=0; i<size; i+=2){
                String inTime = values.get(i);  // 입차 시간(hh:mm)
                String outTime = values.get(i+1);// 출차 시간(hh:mm)
                
                // 입 출차 시간 분으로 환산
                int in = 60*Integer.parseInt(inTime.substring(0,2))
                        + Integer.parseInt(inTime.substring(3));
                int out = 60*Integer.parseInt(outTime.substring(0,2))
                        + Integer.parseInt(outTime.substring(3));
                
                time += out-in; 
            }
            // 최종 요금 구하기
            int fee = d_fee;
            System.out.print(time + " ");
            if(time>0){
                fee += (time/u_time) * u_fee;
                if(time%u_time > 0)
                    fee += u_fee;
            }
            answer.add(fee);
        }
        
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}