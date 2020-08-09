package strings;

public class IntegerToString {

    public static void main(String[] args) {
        System.out.println(intToString(-11234));
        System.out.println(intToString(0));
        System.out.println(intToString(-111));

        System.out.println(stringToInt( "-1234" ));
    }

    public  static String intToString(int i){
        StringBuilder b = new StringBuilder();
        boolean isNegative = i <0;
        i = Math.abs(i);
        do{
            b.append( (char) ('0' + ( i%10 ) ));
            i = i/10;
        }while(i !=0);
        if(isNegative){
            b.append("-");
        }
        return b.reverse().toString();
    }

    public static int stringToInt(String s){
        int res = 0;
        boolean isNegative = s.startsWith("-");
        int i =0;
        if(isNegative){
            i =1;
        }
        for(; i<s.length(); i++){
            res  += (int) ((s.charAt(i) - '0') * Math.pow(10, s.length() - i -1));
        }

        return isNegative ?  -1 * res : res;
    }

}
