import java.io.File;
import java.io.IOException;
import java.util.Random;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    /**
     * This method is used to select the type of puzzle based on the difficulty
     * @param difficulty expected difficulty
     * @return
     */
    public int[][] difficultySelect(String difficulty){
        int[][] output = new int[9][9];
        JsonNode selectedNode = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode rootNode = objectMapper.readTree(map);
            for (JsonNode difficultyNode : rootNode) {
                //if the current difficulty node is what we are looking for, then select the corrisponding "Puzzle" node
                if(difficultyNode.get("Difficulty").asText().equals(difficulty)){
                    selectedNode = difficultyNode.get("Puzzle");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedNode= selectedNode.get(new Random().nextInt(selectedNode.size()));
        try{
            for (int i = 0; i < 9; i++) {
                int[] row = objectMapper.treeToValue(selectedNode.get(String.valueOf(i)),int[].class);
                System.arraycopy(row, 0, output[i], 0, 9);//cleanest line ever, i did not even know this method exist
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    /**
     * This method is an overload method to difficultySelect
     * @param difficulty
     * @param puzzleID
     * @return
     */
    public int[][] difficultySelect(String difficulty, int puzzleID){
        int[][] output = new int[9][9];
        JsonNode selectedNode = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode rootNode = objectMapper.readTree(map);
            for (JsonNode difficultyNode : rootNode) {
                //if the current difficulty node is what we are looking for, then select the corrisponding "Puzzle" node
                if(difficultyNode.get("Difficulty").asText().equals(difficulty)){
                    selectedNode = difficultyNode.get("Puzzle");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedNode= selectedNode.get(puzzleID-1);
        try{
            for (int i = 0; i < 9; i++) {
                int[] row = objectMapper.treeToValue(selectedNode.get(String.valueOf(i)),int[].class);
                System.arraycopy(row, 0, output[i], 0, 9);//cleanest line ever, i did not even know this method exist
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public location[][] getGameGrid(){
        return gameGrid;
    }
    public void resetGrid(){
        for (int i = 0; i < 9; i++) {
            System.arraycopy(puzzleGrid[i],0,gameGrid[i],0,9);
        }
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
