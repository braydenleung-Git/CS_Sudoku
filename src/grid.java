
public class grid {

    private final int colSize = 9; //column size
    private final int rowSize = 9; //row size
    location[][] gameGrid = new location[colSize][rowSize];

    public grid(){
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                gameGrid[i][j] = new location();
            }
        }
    }
    /*
    Start menu
    smth
    flush
    print grid
    action options
    action prompt(mark, set, remove)
    set location
    check grid
    flush
    cycle if not finished
    end menu
    */

    /**
     * This method is used to mark a specific location on the main grid
     * @param coords The coordinate of the location to be marked
     */
    public void mark(coordinate coords){
        location object = gameGrid[coords.getVerticalCoordinate()][coords.getHorizontalCoordinate()];
        coordinate markCoords;
        System.out.println(object.markGridToString());
        String input;
        while (true) {
            input = interfacing.readLine("Location of potential marking[e.g A1]: ");
            if((65-input.charAt(0)) > 3 || Character.getNumericValue(input.charAt(1)) > 3 ){
                interfacing.readLine("Invalid input, please try again [Enter]");
            }
            else{
                markCoords = stringToCoordinate(input);
                break;
            }
        }
        while (true){
            input = interfacing.readLine("Insert number that you would like to mark: ");
            if(Integer.getInteger(input)>9 || Integer.getInteger(input)<0){
                interfacing.readLine("Invalid input, please try again [Enter]");
            }
            else{
                object.setMarkGrid(markCoords.getVerticalCoordinate(), markCoords.getHorizontalCoordinate(), Integer.getInteger(input));
                break;
            }
        }
        //flush
        System.out.println("You have marked on your grid, this is the current marking on this location");
        System.out.println(object.markGridToString());
        interfacing.readLine("[Enter]");
    }
    public void setNum(coordinate coords){
        int input;
        while(true){
            input = interfacing.readInt("Insert number that you would like to set: ");
            if(input>9 || input < 0){
                interfacing.readLine("Invalid input, please try again [Enter]");
            }
            else{
                gameGrid[coords.getVerticalCoordinate()][coords.getHorizontalCoordinate()].setInt(input);
                break;
            }
        }
    }

    /**
     * This method converts an int 2D Array to a readable location class object grid
     * @param array
     */
    public void arrayToGrid(int[][] array){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                gameGrid[i][j].setInt(array[i][j]);
            }
        }
    }
    public void resetGrid(){
    //might not implement
    }

    /**
     * dependency: string input must be valid
     * @param input
     * @return
     */
    public coordinate stringToCoordinate(String input){
        return new coordinate(65-input.charAt(0),Character.getNumericValue(input.charAt(1)));
    }
    public void printGrid(){
        System.out.print(" ");
        int current;
        for (int i = 1; i <= colSize; i++) {
            System.out.print(" "+i);
        }
        for (int vert = 0; vert < rowSize; vert++) {
            System.out.println();
            System.out.print((char)(65+vert)+ " ");
            for (int hori = 0; hori < colSize; hori++) {
                current = gameGrid[vert][hori].getInt();
                if(current == 0){
                    System.out.print("  ");
                }
                else{
                    System.out.print(current+" ");
                }
            }
        }
    }


    public void arrayToGrid(int[][]){

    }
}
