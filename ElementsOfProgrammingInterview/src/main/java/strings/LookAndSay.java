package strings;

public class LookAndSay {

    public static void main(String[] args) {
        System.out.println( encode("1223334444"));
        System.out.println( decode("3e4f2e"));
    }

    private static String decode(String encoded) {
        StringBuilder builder = new StringBuilder();
        int p =0;

        while(p< encoded.length()){
            int d = 0;
            while(Character.isDigit( encoded.charAt(p))){
                d += d * 10 + Integer.valueOf(encoded.charAt(p)- '0');
                p++;
            }
            for(int i=0; i< d; i++){
                builder.append( encoded.charAt(p));
            }
            p++;
        }
        return builder.toString();
    }

    public static String encode(String str){
        StringBuilder result = new StringBuilder();
        for(int i=0; i< str.length(); i++){
            int seen =1;
            while(i< str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                i++;
                seen++;
            }
            result.append(seen).append(str.charAt(i));
        }
        return  result.toString();
    }

}
