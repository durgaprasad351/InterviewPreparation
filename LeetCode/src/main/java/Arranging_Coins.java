public class Arranging_Coins {
    public static void main(String[] args) {
        System.out.println( new Arranging_Coins().arrangeCoins(8));
    }

    public int arrangeCoins(int n) {
        int ld =0;
        while(n-(ld+1) >= 0){
            n=n-(ld+1);
            ld++;
        }
        return ld;
    }
}
