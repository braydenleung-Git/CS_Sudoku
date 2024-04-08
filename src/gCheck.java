public class gCheck {
    /**
     *
     * @param sGrid
     * @return
     */
    private static boolean checkBox(int[][] sGrid){
        int[] box = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 3; i ++){
            for (int c = 0; c < 3; c++) {
                for (int n = 0; n < 9; n++) {
                    if (sGrid[i][c] == box[n]) {
                        box[n] = 0;
                    }
                }
            }
        }
        for (int i : box){
            if (i > 0){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param colRow
     * @return
     */
    private static boolean checkColRow(int[] colRow){
        int[] box = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int c = 0; c < 9; c++){
            for (int n = 0; n < 9; n ++){
                if (colRow[c] == box[n]){
                    box[n] = 0;
                }
            }
        }
        for (int i : box){
            if (i > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * This method is used to validate the grid that the user put in
     * @param grid
     * @return
     */
    public static boolean checkGrid(location[][] grid){
        int[][] ngrid = new int[3][3];
        for (int i = 0; i < 3; i ++){
            for (int c = 0; c < 3; c ++){
                for (int a = 0; a < 3; a++){
                    for (int b = 0; b < 3; b++){
                        ngrid[a][b] = grid[(i*3)+a][(c*3)+b].getInt();
                    }
                }
                if (!checkBox(ngrid)) {
                    return false;
                }
            }
        }
        int[] colrow = new int[9];
        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < 9; j ++){
                colrow[j] = grid[i][j].getInt();
            }
            if (!checkColRow(colrow)){
                return false;
            }
            for (int c = 0; c < 9; c ++){
                colrow[c] = grid[c][i].getInt();
            }
            if (!checkColRow(colrow)){
                return false;
            }
        }
        return true;
    }
}
