public class _200_Number_of_Islands {

    public static void main(String[] args) {

        System.out.println(  numIslands( new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int row =0 ; row < grid.length; row++){
            for(int col =0; col < grid[row].length; col++){
                if(grid[row][col] == '1'){
                    count++;
                    traverse(grid, row,col);
                }
            }
        }
        return count;
    }

    public static void traverse(char[][] grid, int row, int col){
        if(row < 0 || row == grid.length  ) return;
        if(col < 0 || col == grid[row].length) return;
        if(grid[row][col] != '1') return;
        grid[row][col] = '2';
        traverse(grid, row-1, col);
        traverse(grid, row+1, col);
        traverse(grid, row, col-1);
        traverse(grid, row, col+1);
    }
}
