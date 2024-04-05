public class location {
    int value = 0;
    int[][] markGrid = new int[3][3];
    public void setMarkGrid(int v, int h,int input){
        this.markGrid[v][h] = input;
    }

    public int getInt(){
        return value;
    }

    public void setInt(int value){
        this.value = value;
    }

    public String markGridToString(){
        String output = "  1 2 3\n";
        for (int i = 0; i < 3; i++) {
            output +=  (char)(65+i) + " ";
            for (int j = 0; j < 3; j++) {
                output += markGrid[i][j]+" ";
            }
            output += "\n";
        }
        return output;
    }
}
