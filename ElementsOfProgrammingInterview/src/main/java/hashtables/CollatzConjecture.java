package hashtables;

public class CollatzConjecture {
    public static void main(String[] args) {
        collatzConjecture(11);
    }

    public static void collatzConjecture(int start){

        while(start != 1){
            System.out.print("  " + start);
            if(start % 2 == 0){
                start = start /2;
            }else{
                start = 3* start +1;
            }
        }

    }

}
