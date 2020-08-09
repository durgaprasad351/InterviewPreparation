package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidIpAddresses {

    public static void main(String[] args) {
        System.out.println( validIpAddress("19216811") );
    }

    public static List<String> validIpAddress(String ipAddress){
        return generateIps(ipAddress, 0, 4, "");
    }

    public static List<String> generateIps(String ip, int start, int cnt, String prefix){
        if(cnt ==0  && start == ip.length()){
            return Arrays.asList(prefix);
        }
        if( (cnt ==0 && start != ip.length()) ){
            return Arrays.asList();
        }

        List<String> ips = new ArrayList<String>();

        for(int i=0; i< 3; i++){
            if(start +i > ip.length() -1 )
                continue;
            String val = ip.substring( start,  start+i+1 );
            if(Integer.valueOf( val ) > 255 || Integer.valueOf(val) < 1){
                continue;
            }
            if(start ==0) {
                ips.addAll(generateIps(ip, start + i + 1, cnt - 1,  val));
            }else{
                ips.addAll(generateIps(ip, start + i + 1, cnt - 1,  prefix + "." +  val));
            }
        }
        return ips;
    }

}
