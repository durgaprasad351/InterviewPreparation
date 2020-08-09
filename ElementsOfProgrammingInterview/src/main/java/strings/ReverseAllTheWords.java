package strings;

public class ReverseAllTheWords {

    public static void main(String[] args) {
        System.out.println( reverseAllWords("Alice likes Bob"));
    }

    public static String reverseAllWords(String str){

        char[] arr = str.toCharArray();
        int start =0;
        int end = arr.length -1;
        reverse(arr, 0, arr.length -1);
        int last =0;
        for(int i =0; i< arr.length; i++){
            if(arr[i] == ' ' ){
                reverse(arr, last, i-1);
                last = i+1;
            }else if(i == arr.length -1){
                reverse(arr, last, i);
            }
        }
        return new String(arr);
    }

    private static void reverse(char[] arr, int start, int end) {
        while(start < end){
            char t = arr[start];
            arr[start] = arr[end];
            arr[end]  = t;
            start++;
            end--;
        }
    }
}
