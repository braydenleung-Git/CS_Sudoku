import java.util.Scanner;

public class interfacing {
    static int count = 1;
    public static void introduction() {
        String input = "";
        flush();
        System.out.println("Hello and welcome to the world of sudoku!");
        if (count > 0) {
            while(true) {
                input = readLine("Do you wish to skip the tutorial? [Y/N]", true);
                if(validateInput(input,false)){
                    if(!(input.equals("Y")||input.equals("N"))){
                        readLine("Invalid input [Enter]");
                    }
                    else{
                        break;
                    }
                }
            }
        }
        if(input.equals("N") || count < 1){
            String prompt = "In this game, there is a 9x9 grid with some numbers already filled in and some that are empty.";
            uiLine(prompt);
            System.out.println(prompt);
            System.out.println("Your job is to find out what belongs in the empty grids and fill them in!");
            System.out.println("Each 3x3 box should contain all of the numbers from 1-9 with no duplicates.");
            System.out.println("Therefore, if you type a '9' in a box that already contains a '9', you won't be able to complete the grid!");
            System.out.println("Each horizontal and vertical line should also have all numbers from 1-9 with no duplicates.");
            prompt = "Use these important info in your play! Have fun in navigating the world of numbers and logic!";
            System.out.println(prompt);
            uiLine(prompt);
            readLine("Press [Enter] to continue");
        }
        System.out.println();
        int exitStatus = 0;
        while(exitStatus == 0){
            flush();
            String prompt = "Easy[E] --> just right for beginners";
            uiLine(prompt);
            System.out.println(prompt);
            System.out.println("Medium[M] --> slightly more challenging");
            System.out.println("Hard[H] --> sudoku nightmare :)");
            input = readLine("Please select the difficulty: ",true);
            if(validateInput(input,false)){
                switch(input.charAt(0)){
                    //Test the program
                    case 'T':
                        int i = 1;
                        while(i == 1){
                            input = readLine("Which difficulty?",true);
                            int puzzleID = readInt("Which puzzle?");
                            while(puzzleID>3 || puzzleID < 0){
                                readLine("Invalid input [Enter]");
                                puzzleID = readInt("Which puzzle?",true);
                            }
                            switch(input.charAt(0)){
                                case 'E':
                                    grid.difficultySelect("Easy",puzzleID);
                                    i = 0;
                                    break;
                                case 'M':
                                    grid.difficultySelect("Medium",puzzleID);
                                    i = 0;
                                    break;
                                case'H':
                                    grid.difficultySelect("Hard",puzzleID);
                                    i = 0;
                                    break;
                                default:
                                    readLine("Invalid input [Enter]");
                            }
                        }
                        exitStatus = 1;
                        break;
                    case'E':
                        grid.difficultySelect("Easy");
                        exitStatus = 1;
                        break;
                    case'M':
                        grid.difficultySelect("Medium");
                        exitStatus = 1;
                        break;
                    case'H':
                        grid.difficultySelect("Hard");
                        exitStatus = 1;
                        break;
                    default:
                        readLine("Invalid input [Enter]");
                        flush();
                }
            }
        }
    }

    /**
     * This method runs every round
     * @return status of this round (0 = in-game, 1 = finish/exit)
     */
    public static int round(){
        while(true){
            flush();
            grid.printGrid();
            String prompt = "[S]et, [M]ark, [Q]uit, [F]inish, [R]eset ";
            uiLine(prompt);
            System.out.println(prompt);
            String input = readLine("Select one action: ");
            if(validateInput(input,false)){
                switch(input.charAt(0)){
                    case 'S':
                        while(true){
                            flush();
                            grid.printGrid();
                            input = readLine("Place down the coordinate that you would like to set: ",true);
                            if(validateInput(input,true)){
                                if(grid.validatePlacement(grid.stringToCoordinate(input))){
                                    grid.setNum(grid.stringToCoordinate(input));
                                    break;
                                }
                                else{
                                    readLine("Invalid placement, please try again. [Enter]");
                                }
                            }
                        }
                        return 0;
                    case 'M':
                        while(true){
                            flush();
                            grid.printGrid();
                            input = readLine("Place down the coordinate that you would like to mark: ",true);
                            if(validateInput(input,true)){
                                grid.mark(grid.stringToCoordinate(input));
                                break;
                            }
                        }
                        return 0;
                    case 'Q':
                        while(true){
                            flush();
                            input = readLine("Confirm quit?[Y/N] ");
                            if(validateInput(input,false)){
                                if(input.charAt(0) == 'Y'){
                                    game.replay = false;
                                    break;
                                }
                                else if(input.charAt(0) == 'N'){
                                    return 0;
                                }
                            }
                        }
                        return 1;
                    case 'F':
                        flush();
                        if(gCheck.checkGrid(grid.getGameGrid())){
                            System.out.println("Good job! You solved the sudoku puzzle!");
                            while(true){
                                input = readLine("Would you like to play again? [Y/N] ", true);
                                if (validateInput(input, false)) {
                                    switch (input.charAt(0)) {
                                        case 'Y':
                                            game.replay = true;
                                            count++;
                                            break;
                                        case 'N':
                                            game.replay = false;
                                            count++;
                                            return 1;
                                        default:
                                            readLine("Invalid input. [Enter]");
                                            break;
                                    }
                                    break;
                                }
                            }
                        }
                        else{
                            readLine("You sudoku is incomplete/invalid, press [Enter] to continue.");
                        }
                        return 0;
                    case 'R':
                        flush();
                        input = readLine("Confirm reset?[Y/N]");
                        while(true) {
                            if (validateInput(input, false)) {
                                if (input.charAt(0) == 'Y') {
                                    grid.resetGrid();
                                    flush();
                                    readLine("You have reset your grid. Press [Enter] to continue",true);
                                    return 0;
                                } else if (input.charAt(0) == 'N') {
                                    return 0;
                                } else {
                                    input = readLine("Invalid input, Confirm reset? [Y/N] ",true);
                                }
                            }
                            else{
                                input = readLine("Confirm reset?[Y/N]");
                            }
                        }
                    default:
                        readLine("Invalid input. [Enter]");
                        return 0;
                }
            }
        }
    }

    /**
     * This method takes in an input, and the format of the expected input, and returns whether it is in the correct format or not
     * @param input user input
     * @param isCoordinate expected format
     * @return wether the input is valid or not
     */
    public static boolean validateInput(String input, boolean isCoordinate){
        boolean probe;
        if (isCoordinate){
            if (input.length() != 2){
                readLine("Input format invalid. [Enter]",true);
                return false;
            }
            /*
                case 1, incorrect format
                case 2, out of bound(lower end)
                case 3, out of bound in the vertical axis(higher end)
                case 4, out of bound in the horizontal axis(higher end)
             */
            probe = !Character.isDigit(input.charAt(1));//false
            int test = grid.stringToCoordinate(input).getVerticalCoordinate();
            probe = grid.stringToCoordinate(input).getVerticalCoordinate()<0;//true
            probe = grid.stringToCoordinate(input).getVerticalCoordinate()>9;//false
            probe = grid.stringToCoordinate(input).getHorizontalCoordinate()>9;//false
            if(
                !Character.isDigit(input.charAt(1))
                || grid.stringToCoordinate(input).getVerticalCoordinate()<0
                || grid.stringToCoordinate(input).getVerticalCoordinate()>9
                || grid.stringToCoordinate(input).getHorizontalCoordinate()>9
            ){
                readLine("Coordinate is invalid [Enter]",true);
                return false;
            }
        }
        else{
            if(input.length()!=1){
                readLine("Input format invalid. [Enter]",true);
                return false;
            }
        }
        return true;
    }

    public static String readLine(String prompt){
        return readLine(prompt,false);
    }
    public static String readLine(String prompt,boolean uiLine){
        if(uiLine){
            uiLine(prompt);
        }
        Scanner obj = new Scanner(System.in);
        System.out.print(prompt);
        return obj.nextLine().toUpperCase();
    }

    public static int readInt(String prompt){
        return readInt(prompt,false);
    }
    public static int readInt(String prompt,boolean uiLine) {
        while(true){
            String input = readLine(prompt,uiLine);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ignored){

            }
        }
    }

    public static void flush() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void uiLine(String prompt){
        for (int i = 0; i < prompt.length(); i++) {
            System.out.print('═');
        }
        System.out.println();
    }
}
