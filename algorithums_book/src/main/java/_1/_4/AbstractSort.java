package _1._4;

public abstract class AbstractSort {

    int exchanges;

    abstract void sort(int[] arr);

    public void print(int[] input){
        for(int i : input){
            System.out.print( i + " ");
        }
        System.out.println(" Exchanges : " + exchanges);
    }

    public void swap(int[] input, int i , int j){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
        exchanges ++;
    }
}
