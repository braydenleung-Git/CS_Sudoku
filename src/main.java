public class main {
    public static void main(String[] args) {
        grid testGrid = new grid();
        testGrid.printGrid();
        int[][] sampleGrid1 = {
            {4, 3, 5, 2, 6, 9, 7, 8, 1},
            {6, 8, 2, 5, 7, 1, 4, 9, 3},
            {1, 9, 7, 8, 3, 4, 5, 6, 2},
            {8, 2, 6, 1, 9, 5, 3, 4, 7},
            {3, 7, 4, 6, 8, 2, 9, 1, 5},
            {9, 5, 1, 7, 4, 3, 6, 2, 8},
            {5, 1, 9, 3, 2, 6, 8, 7, 4},
            {2, 4, 8, 9, 5, 7, 1, 3, 6},
            {7, 6, 3, 4, 1, 8, 2, 5, 9}
        };
        testGrid.arrayToGrid(sampleGrid1);

        grid jsonTest = new grid();
        System.out.println("Easy");
        jsonTest.arrayToGrid(grid.difficultySelect("Easy",1));
        jsonTest.printGrid();
        System.out.println();
        jsonTest.arrayToGrid(grid.difficultySelect("Easy",2));
        jsonTest.printGrid();
        System.out.println();
        jsonTest.arrayToGrid(grid.difficultySelect("Easy",3));
        jsonTest.printGrid();
        System.out.println();
        jsonTest.arrayToGrid(grid.difficultySelect("Easy"));//Random for "Easy"
        jsonTest.printGrid();
        System.out.println();
        System.out.println();

        System.out.println("Medium");
        jsonTest.arrayToGrid(grid.difficultySelect("Medium",1));
        jsonTest.printGrid();
        System.out.println();
        jsonTest.arrayToGrid(grid.difficultySelect("Medium",2));
        jsonTest.printGrid();
        System.out.println();
        jsonTest.arrayToGrid(grid.difficultySelect("Medium",3));
        jsonTest.printGrid();
        System.out.println();
        jsonTest.arrayToGrid(grid.difficultySelect("Medium"));//Random for "Medium"
        jsonTest.printGrid();
        System.out.println();
        System.out.println();

        System.out.println("Hard");
        jsonTest.arrayToGrid(grid.difficultySelect("Hard",1));
        jsonTest.printGrid();
        System.out.println();
        jsonTest.arrayToGrid(grid.difficultySelect("Hard",2));
        jsonTest.printGrid();
        System.out.println();
        jsonTest.arrayToGrid(grid.difficultySelect("Hard",3));
        jsonTest.printGrid();
        System.out.println();
        jsonTest.arrayToGrid(grid.difficultySelect("Hard")); //Random for "Hard"
        jsonTest.printGrid();
        System.out.println();


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
    }
}

