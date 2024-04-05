import java.util.*;

public class gcheck {
    public static boolean checkBox(int[][] sgrid){
        int[] box = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.print(Arrays.toString(sgrid[1]));
        for (int i = 0; i < 3; i ++){
            for (int c = 0; c < 3; c++){
                for (int n = 0; n < 9; n ++){
                    if (sgrid[i][c] == box[n]){
                        box[n] = 0;
                    }
                    else{
                        //return false;
                    }
                }
            }
            
        }
        return true;
    }
    public static boolean checkColrow(int[] colrow){
        int[] box = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int c = 0; c < 9; c++){
            for (int n = 0; n < 9; n ++){
                if (colrow[c] == box[n]){
                    box[n] = 0;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean parser(location[][] grid){
        int[][] ngrid = new int[3][3];
        for (int i = 0; i < 3; i ++){
            for (int c = 0; c < 3; c ++){
                for (int a = 0; a < 3; a++){
                    for (int b = 0; b < 3; b++){
                        ngrid[a][b] = grid[(i*3)+a][(c*3)+a].getInt();
                    }
                }
                if (checkBox(ngrid) == false) {
                    //return false;
                }
            }
        }
        int[] colrow = new int[9];
        for (int i = 0; i < 9; i ++){
            colrow [i]= grid[2][3].getInt();
            if (checkColrow(colrow) == false){
                return false;
            }
            for (int c = 0; c < 9; c ++){
                colrow[i] = grid[i][c].getInt();
                if (checkColrow(colrow) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
