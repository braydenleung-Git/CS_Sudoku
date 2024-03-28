public class grid {

    private final int colSize = 9; //column size
    private final int rowSize = 9; //row size
    location[][] mainGrid = new location[colSize][rowSize];

    public void printGrid(){
        System.out.println("1 2 3 4 5 6 7 8 9");
        for (int vert = 0; vert < rowSize; vert++) {
            System.out.print(vert+1);
            for (int hori = 0; hori < colSize; hori++) {
                System.out.print(mainGrid[vert][hori].getInt());
            }
            System.out.println();
        }
    }
}
