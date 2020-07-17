public class Prison_Cells_After_N_Days {

    public static void main(String[] args) {

       int[] out =  prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1},
        7);

    }

    public static  int[] prisonAfterNDays(int[] cells, int N) {
        int[] tmp = new int[cells.length];
        for(int i =0; i< N; i++){
            System.arraycopy(cells,0, tmp, 0, cells.length);
            for(int j=1; j< cells.length -1; j++){
                if(cells[j-1] == 1 && cells[j+1] ==1){
                    cells[j] = 1;
                }else if(cells[j-1] ==0 && cells[j+1] == 0) {
                    cells[j] = 1;
                }else{
                    cells[j] =0;
                }
            }

        }
        return  cells;
    }
}
