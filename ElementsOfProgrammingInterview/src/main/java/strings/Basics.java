package strings;

public class Basics {

    public static void main(String args[]){
        //Generate Captial letters
        for(int i=0; i< 26; i++){
            System.out.println( (char) ('A' + i) );
        }
        //Generate lower case letters;
        for(int i=0; i< 26; i++){
            System.out.println( (char) ('a' + i) );
        }
        //Convert char to number;
        for(int i=0; i< 10; i++){
            System.out.println( (char) ('0' + i) );
        }

        String str = "123456789";

        System.out.println(str.substring(2));
        System.out.println(str.substring(2, 2+3));
        System.out.println(str.substring(8, 8+1));
    }
}
