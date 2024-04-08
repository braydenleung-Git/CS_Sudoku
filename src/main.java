/* Expected order of operations:
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

public class main {
    public static void main(String[] args) {
        grid testGrid = new grid();
        testGrid.difficultySelect("Solved",1);
        coordinate testCords = new coordinate(0,0);
        testGrid.printGrid();
        testGrid.setNum(testCords);
        testGrid.printGrid();
        testJsonToGrid();
        interfacing.flush();
        if (!gcheck.parser(testGrid.gameGrid)){
            System.out.println("Invalid grid");
        }
        else{
            System.out.println("Valid grid");
        }
        interfacing.validateInput("r", 1);
    }

    private static void testJsonToGrid(){
        grid jsonTest = new grid();
        System.out.println("Easy");
        jsonTest.difficultySelect("Easy",1);
        jsonTest.printGrid();
        System.out.println();
        jsonTest.difficultySelect("Easy",2);
        jsonTest.printGrid();
        System.out.println();
        jsonTest.difficultySelect("Easy",3);
        jsonTest.printGrid();
        System.out.println();
        jsonTest.difficultySelect("Easy");//Random for "Easy"
        jsonTest.printGrid();
        System.out.println();
        System.out.println();

        System.out.println("Medium");
        jsonTest.difficultySelect("Medium",1);
        jsonTest.printGrid();
        System.out.println();
        jsonTest.difficultySelect("Medium",2);
        jsonTest.printGrid();
        System.out.println();
        jsonTest.difficultySelect("Medium",3);
        jsonTest.printGrid();
        System.out.println();
        jsonTest.difficultySelect("Medium");//Random for "Medium"
        jsonTest.printGrid();
        System.out.println();
        System.out.println();

        System.out.println("Hard");
        jsonTest.difficultySelect("Hard",1);
        jsonTest.printGrid();
        System.out.println();
        jsonTest.difficultySelect("Hard",2);
        jsonTest.printGrid();
        System.out.println();
        jsonTest.difficultySelect("Hard",3);
        jsonTest.printGrid();
        System.out.println();
        jsonTest.difficultySelect("Hard"); //Random for "Hard"
        jsonTest.printGrid();
        System.out.println();
    }
}

