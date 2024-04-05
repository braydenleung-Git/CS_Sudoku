import java.io.File;
public class grid {

    private final int colSize = 9; //column size
    private final int rowSize = 9; //row size

    private final File map = new File("sudokuMaps.json");
    location[][] gameGrid = new location[colSize][rowSize];
    location[][] puzzleGrid = new location[colSize][rowSize];

    public grid(){
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                gameGrid[i][j] = new location();
                puzzleGrid[i][j] = new location();
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
     * @param array expected array
     */
    public void arrayToGrid(int[][] array){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                gameGrid[i][j].setInt(array[i][j]);
                puzzleGrid[i][j].setInt(array[i][j]);
            }
        }
    }


    //This relies on a library that is not internal, suggest to find alt option
    public int[][] jsonto2dArray(String difficulty){
        String currentPuzzleLevel;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode rootNode = objectMapper.readTree(map);
            for(JsonNode puzzleLevel : rootNode){
                 currentPuzzleLevel = puzzleLevel.get("Difficulty").asText();
                 if(currentPuzzleLevel.equals(difficulty)){
                     JsonNode puzzleNodes = puzzleLevel.get("Puzzle");

                 }
            }

        }
        return
    }

    /*
    import com.fasterxml.jackson.databind.JsonNode;
    import com.fasterxml.jackson.databind.ObjectMapper;

    import java.io.File;
    import java.io.IOException;

    public class SudokuPuzzleReader {
        public static void main(String[] args) {
            // Load JSON file
            File jsonFile = new File("puzzles.json");

            // Parse JSON
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode rootNode = objectMapper.readTree(jsonFile);

                // Access puzzles
                for (JsonNode puzzleNode : rootNode) {
                    String puzzleName = puzzleNode.get("name").asText();
                    JsonNode puzzleDataNode = puzzleNode.get("data");
                    System.out.println("Puzzle: " + puzzleName);

                    // Access individual rows in the puzzle
                    for (int i = 1; i <= 9; i++) {
                        String rowString = puzzleDataNode.get(String.valueOf(i)).asText();
                        int[] row = parseRow(rowString);
                        for (int j = 0; j < row.length; j++) {
                            System.out.print(row[j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Method to parse a row string into an array of integers
        private static int[] parseRow(String rowString) {
            String[] tokens = rowString.split(",");
            int[] row = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Integer.parseInt(tokens[i].trim());
            }
            return row;
        }
    }

    //Reference json
    {
      "name": "Easy 1",
      "data": {
        "1": [9,0,0,6,0,0,0,0,0],
        "2": [0,8,0,0,3,2,1,5,9],
        "3": [0,0,0,9,1,7,8,0,6],
        "4": [0,7,0,0,6,0,0,2,1],
        "5": [0,6,0,3,0,4,9,0,0],
        "6": [5,3,0,0,2,0,6,0,7],
        "7": [0,0,1,7,0,3,0,0,2],
        "8": [0,0,6,5,0,1,4,0,0],
        "9": [3,4,0,2,0,0,0,1,0]
      }
    }
    */
    public location[][] getGameGrid(){
        return gameGrid;
    }
    public void resetGrid(){
    //might not implement
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
    /**
     * dependency: string input must be valid
     * @param input
     * @return
     */
    public coordinate stringToCoordinate(String input){
        return new coordinate(65-input.charAt(0),Character.getNumericValue(input.charAt(1)));
    }
}
