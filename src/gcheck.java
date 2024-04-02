public class gcheck {
    public static boolean checkBox(int[][] sgrid){
        int[] box = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 3; i ++){
            for (int c = 0; c < 3; c++){
                for (int n = 0; n < 9; n ++){
                    if (sgrid[i][c] == box[n]){
                        box[n] = 0;
                    }
                    else{
                        return False;
                    }
                }
            }
            
        }
        return True;
    }
    public static boolean checkColrow(int[] colrow){
        int[] box = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int c = 0; c < 9; c++){
            for (int n = 0; n < 9; n ++){
                if (colrow[c] == box[n]){
                    box[n] = 0;
                }
                else{
                    return False;
                }
            }
        }
        return True;
    }
    public static boolean parser(int[][] grid){
        int[][] ngrid = new int[3][3];
        for (int i = 0; i < 3; i ++){
            for (int c = 0; c < 3; c ++){
                ngrid[i][c] = grid[i*3][c*3];
                if (checkBox(ngrid) == False){
                    return False;
                }
            }
        }
        int[] colrow = new int[9];
        for (int i = 0; i < 9; i ++){
            colrow = grid[i];
            if (checkColrow(colrow) == False){
                return False;
            }
            for (int c = 0; c < 9; c ++){
                colrow[i] = grid[i][c];
                if (checkColrow(colrow) == False){
                    return False;
                }
            }
        }
        return True;
    }
}
