import java.io.File;
import java.io.IOException;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class grid {
    private static final int colSize = 9; //column size
    private static final int rowSize = 9; //row size
    public final static File map = new File("./src/sudokuMaps.json");
    static final location[][] gameGrid = new location[colSize][rowSize];
    static final location[][] puzzleGrid = new location[colSize][rowSize];

    /**
     * dependency: string input must be valid
     * @param input user input
     * @return interpreted coordinate
     */
    public static coordinate stringToCoordinate(String input){
        return new coordinate(65-input.charAt(0),Character.getNumericValue(input.charAt(1))-1);
    }

    public static void setNum(coordinate cords){
        int input;
        while(true){
            input = interfacing.readInt("Insert number that you would like to set: ");
            if(input>9 || input < 0){
                interfacing.readLine("Invalid input, please try again [Enter]");
            }
            else{
                gameGrid[cords.getVerticalCoordinate()][cords.getHorizontalCoordinate()].setInt(input);
                interfacing.readLine("You have set "+input+ " at "+cords+" [Enter]",true);
                break;
            }
        }
    }

    /**
     * This method is used to mark a specific location on the game grid
     * @param cords The coordinate of the location to be marked
     */
    public static void mark(coordinate cords){
        location object = gameGrid[cords.getVerticalCoordinate()][cords.getHorizontalCoordinate()];
        coordinate markCoords;
        String input;
        String prompt;
        while(true) {
            prompt = "[E]dit, [V]iew";
            interfacing.uiLine(prompt);
            System.out.println(prompt);
            input = interfacing.readLine("Which Action would you like to proceed with? ");
            if(interfacing.validateInput(input,false)) {
                switch (input.charAt(0)) {
                    case 'E':
                        while (true) {
                            System.out.println(object.markGridToString());
                            input = interfacing.readLine("Location of potential marking[e.g A1]: ", true);
                            if (interfacing.validateInput(input, true)) {
                                if (Character.getNumericValue(input.charAt(1)) > 3 || Character.getNumericValue(input.charAt(1)) < 0) {
                                    interfacing.readLine("Input format invalid. [Enter]");
                                    interfacing.flush();
                                } else {
                                    markCoords = stringToCoordinate(input);
                                    break;
                                }
                            } else {
                                interfacing.flush();
                            }
                        }
                        while (true) {
                            input = interfacing.readLine("Insert number that you would like to mark: ", true);
                            if (interfacing.validateInput(input, false)) {
                                if (!Character.isDigit(input.charAt(0)) || Integer.parseInt(input) > 9 || Integer.parseInt(input) < 0) {
                                    interfacing.readLine("Invalid input, please try again [Enter]");
                                    interfacing.flush();
                                    System.out.println(object.markGridToString());
                                } else {
                                    object.setMarkGrid(markCoords.getVerticalCoordinate(), markCoords.getHorizontalCoordinate(), Integer.parseInt(input));
                                    break;
                                }
                            }
                        }
                        interfacing.flush();
                        prompt = "You have marked on your grid, this is the current marking on this location: ";
                        interfacing.uiLine(prompt);
                        System.out.println(prompt);
                        System.out.println(object.markGridToString());
                        interfacing.readLine("Press [Enter] to continue.", true);
                        break;
                    case 'V':
                        interfacing.flush();
                        System.out.println(object.markGridToString());
                        interfacing.readLine("Press [Enter] to continue.",true);
                        break;
                    default:
                        interfacing.flush();
                        interfacing.readLine("Invalid action, please try again [Enter]",true);
                        break;
                }
                break;
            }
        }
    }

    /**
     * This method converts an int 2D Array to a location class object grid
     * @param array expected array
     */
    private static void arrayToGrid(int[][] array){
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                gameGrid[i][j] = new location();
                puzzleGrid[i][j] = new location();
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                gameGrid[i][j].setInt(array[i][j]);
                puzzleGrid[i][j].setInt(array[i][j]);
            }
        }
    }

    public static boolean validatePlacement(coordinate cords) {
        location[][] puzzle = getPuzzleGrid();
        return puzzle[cords.getVerticalCoordinate()][cords.getHorizontalCoordinate()].getInt() == 0;
    }

    /**
     * This method is an overload method to grid.difficultySelect()
     * Available options: Hard, Medium, Easy, Solved
     * @param difficulty expected difficulty
     */
    public static void difficultySelect(String difficulty){
        difficultySelect(difficulty,0);
    }

    /**
     * This method is used to select the type of puzzle based on the difficulty.
     * Available options: Hard, Medium, Easy, Solved
     * @param difficulty expected difficulty
     * @param puzzleID puzzleID
     */
    public static void difficultySelect(String difficulty, int puzzleID){
        int[][] output = new int[9][9];
        try {
            JsonNode rootNode = new ObjectMapper().readTree(map);
            for (JsonNode difficultyNode : rootNode) {
                //if the current difficulty node is what we are looking for, then select the corresponding "Puzzle" node
                if (difficultyNode.get("Difficulty").asText().equals(difficulty)) {
                    JsonNode selectedNode = difficultyNode.get("Puzzle");
                    if(puzzleID == 0){
                        int randomID = 1 + new Random().nextInt(selectedNode.size());
                        selectedNode = selectedNode.get(Integer.toString(randomID));
                    } else {
                        selectedNode = selectedNode.get(Integer.toString(puzzleID));
                    }
                    for (int i = 1; i <= 9; i++) {
                        int[] row = new ObjectMapper().treeToValue(selectedNode.get(String.valueOf(i)), int[].class);
                        System.arraycopy(row, 0, output[i-1], 0, 9);//cleanest line ever, i did not even know this method exist
                    }
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        arrayToGrid(output);
    }
    //getting methods
    public static location[][] getGameGrid(){
        return gameGrid;
    }

    public static location[][] getPuzzleGrid(){
        return puzzleGrid;
    }

    public static void resetGrid(){
        for (int i = 0; i < 9; i++) {
            System.arraycopy(puzzleGrid[i],0,gameGrid[i],0,9);
        }
    }

    public static void printGrid(){
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
                    System.out.print("▢ ");
                }
                else{
                    System.out.print(current+" ");
                }
            }
        }
        System.out.println();
    }
}