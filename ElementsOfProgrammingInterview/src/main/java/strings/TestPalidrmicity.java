package strings;

public class TestPalidrmicity {

    public static void main(String[] args) {
        System.out.println(isValidChar('a'));
        System.out.println( isPalindrome( "a man, a plan, a canal, Panama." ) );
    }

    public static boolean isValidChar(char c){
        return Character.isLetterOrDigit(c);
    }

    public static boolean isPalindrome(String str){
        boolean isPalindrom = true;
        int start =0;
        int end = str.length() -1;
        str = str.toLowerCase();
        while(start < end){
            while(! isValidChar(str.charAt(start))){
                start++;
            }
            while(! isValidChar(str.charAt(end))){
                end--;
            }

            if(str.charAt(start) != str.charAt(end)){
                isPalindrom = false;
                break;
            }
            start++;
            end--;
        }
        return isPalindrom;
    }
}
