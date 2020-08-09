package strings;

public class RobinKarp_SubString_Match {

    public static void main(String[] args) {
        System.out.println( isSubString( "123456" , "456") );
        System.out.println( isSubString( "My name is a really comples string with lot of " , " lot of ") );
    }

    public static boolean isSubString( String str,  String target ){
        long targetHash = hash( target, target.length());
        long matchHash = hash( str.substring(0, target.length()), target.length());
        for(int i=0; i< str.length() - target.length() +1; i++){
            if(targetHash == matchHash){
                if(str.substring(i, i+target.length()).equals(target)){
                    return true;
                }
            }
            if(i+ target.length() < str.length()) {
                matchHash = rollingHash(str, matchHash, target.length(), i);
            }
        }
        return false;
    }

    public static long rollingHash(String str,  long previousHash, int rolling, int start){
        return (previousHash -  str.charAt( start ) )  + str.charAt( start + rolling );
    }

    public static long hash(String str, int rolling ){
        long hash = 0;
        for(int i=0; i< rolling; i++){
            hash +=  str.charAt(i);
        }
        return hash;
    }
}
