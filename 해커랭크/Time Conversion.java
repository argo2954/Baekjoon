import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        String AMorPM = s.substring(8);
        int hour = Integer.parseInt(s.substring(0, 2));
        
        if(AMorPM.equals("PM")){
            if(hour==12)    // type, 12:??:??PM
                return s.substring(0, 8);
                
            return (hour+12) + s.substring(2, 8); //type, 07:??:??PM
        }

        if(hour==12)   // type, 12:??:??AM
            return "00" + s.substring(2, 8);
            
        return s.substring(0, 8);  //type, 07:??:??AM

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
