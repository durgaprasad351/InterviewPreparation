public class _7_Reverse_Integer {

    public static void main(String[] args) {
        System.out.println( reverse(1234567899));
    }


    public static int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int res = 0;
        x= x*sign;
        while(x >0){
            if((res *10)/10 != res){
                return 0;
            }
            int t = res * 10 + x%10;
            res =t;
            x= x/10;
        }
        return res * sign;
    }
}
